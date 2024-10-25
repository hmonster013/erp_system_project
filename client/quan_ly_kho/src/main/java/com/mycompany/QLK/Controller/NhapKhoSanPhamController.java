/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLK.Controller;

import com.mycompany.QLK.API.ChiTietPnspService;
import com.mycompany.QLK.API.LoSanPhamService;
import com.mycompany.QLK.API.PnspService;
import com.mycompany.QLK.API.SanPhamService;
import com.mycompany.Entity.ChiTietPhieuNhapSp;
import com.mycompany.Entity.LoSanPham;
import com.mycompany.Entity.PhieuNhapSp;
import com.mycompany.Entity.SanPham;
import com.mycompany.Validate.ValidateJTextField;
import com.mycompany.View.pNhapSanPham;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOError;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khoahihi79
 */
public class NhapKhoSanPhamController {
    private pNhapSanPham form;
    private SanPhamService sanPhamService;
    private PnspService pnspService;
    private LoSanPhamService loSanPhamService;
    private ChiTietPnspService chiTietPnspService;
    private DefaultTableModel tableModelTonKho;
    private DefaultTableModel tableModelLoSp;
    private String maNv;
     private   String tenSp;
    
    public NhapKhoSanPhamController() {}
    
    public NhapKhoSanPhamController(pNhapSanPham form, String maNv) {
        this.form = form;
        this.maNv = maNv;
        this.sanPhamService = new SanPhamService();
        this.chiTietPnspService = new ChiTietPnspService();
        this.pnspService = new PnspService();
        this.loSanPhamService = new LoSanPhamService();
        createTable("TonKho");
        createTable("LoSP");
        showDanhSachTable();
       // showDanhSachTable1();
        taoPhieuNhapSanPham();
        nhapKhoSanPham();
        capNhatLoSp();
         // updateHangTonKho();
        capNhatTonKho();
      //  buttonHuy();
    }
    
    private void createTable(String tableName) {
        if(tableName.equals("TonKho")) {
            tableModelTonKho = new DefaultTableModel();
            tableModelTonKho.addColumn("Mã SP");
            tableModelTonKho.addColumn("Tên sản phẩm");
            tableModelTonKho.addColumn("Số lượng tồn kho");
        } else {   
            tableModelLoSp = new DefaultTableModel();
            tableModelLoSp.addColumn("Số lô");
            tableModelLoSp.addColumn("Tên sản phẩm");
            tableModelLoSp.addColumn("Số lượng Sp");
        }
    }
    
    public void showDanhSachTable() {
        try {     
                List<SanPham> listSanPham = sanPhamService.getAllSanPham();
                if(listSanPham != null) {
                    JTable tableTonKho = form.getTableTonKho();           
                    for(SanPham sanPham : listSanPham) {
                        Object[] row = {sanPham.getMaSp(), sanPham.getTenSp(), sanPham.getSoLuongTon()};
                        tableModelTonKho.addRow(row);
                    }
                    tableTonKho.setModel(tableModelTonKho);
            } 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void showDanhSachTable1(String tenSp) {
        try {
                    List<LoSanPham> listLoSanPham = loSanPhamService.getAllLoSanPham();
                                if(listLoSanPham != null) {
                                    JTable tableLoSp = form.getTableSanPham();
                                    String tenSanPham = "";
                                    String tenSanPham1 = form.getTenSP();
                                    for(LoSanPham loSanPham : listLoSanPham) {
                                        tenSanPham = sanPhamService.getTenSpByMaSp(loSanPham.getMaSp());
                                        Object[] row = {loSanPham.getSoLo(), tenSanPham,  loSanPham.getSoLuongSp()};
                                        if(loSanPham.getTinhTrang().equals("Da nghiem thu") && tenSanPham.equals(tenSp)) {
                                            tableModelLoSp.addRow(row);
                                        }
                                    }
                        tableLoSp.setModel(tableModelLoSp);
                        }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
 
    private void taoPhieuNhapSanPham() {
        form.getButtonTaoPhieu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String maPnsp = form.getMaPhieuNhap();
                    Date ngayNhap = form.getValueJDateChooser();
                    String soLo = form.getSoLo();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng chỉ lấy ngày
                    String formattedDate = dateFormat.format(ngayNhap); // Lấy giá trị ngày đã định dạng
                    if(ValidateJTextField.validateFields(maPnsp)) {
                        if(pnspService.getPhieuNhapByMaPhieu(maPnsp) == null) {
                            PhieuNhapSp phieuNhapSp = new PhieuNhapSp(maPnsp, formattedDate, maNv);
                            pnspService.createPhieuNhapSanPham(phieuNhapSp);               
                           JOptionPane.showMessageDialog(form, "Tạo phiếu thành công!");
                           form.getButtonNhapKho().setEnabled(true);
                        } else {
                            JOptionPane.showMessageDialog(form, "Phiếu đã tồn tại!");
                        }
                    } else {
                       JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
    
    private void nhapKhoSanPham() {
        form.getButtonNhapKho().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRowTonKho = form.getTableTonKho().getSelectedRow();
                    int selectedRowLoSp = form.getTableSanPham().getSelectedRow();

                        if(selectedRowLoSp != -1 && selectedRowTonKho != -1) {
                            String maSp = form.getTableTonKho().getValueAt(selectedRowTonKho, 0).toString();
                            String soLo = form.getTableSanPham().getValueAt(selectedRowLoSp, 0).toString();
                            String maPnsp = form.getMaPhieuNhap();

                            int soLuongSpNhapKho = Integer.parseInt(form.getValueJSpinnerSoLuong());
                            int soLuongTonKho = Integer.parseInt(form.getTableTonKho().getValueAt(selectedRowTonKho, 2).toString());
                            int soLuongSpLo =  Integer.parseInt(form.getTableSanPham().getValueAt(selectedRowLoSp, 2).toString());
                           if (soLuongSpNhapKho > soLuongSpLo) {
                                JOptionPane.showMessageDialog(form, "Số lượng sản phẩm trong lô không đủ!");
                            } 

                            else if (soLuongSpNhapKho <= 0) {
                                JOptionPane.showMessageDialog(form, "Vui lòng nhập số lượng sản phẩm hợp lệ!");
                            } 

                           else {
                                soLuongTonKho += soLuongSpNhapKho;
                                soLuongSpLo -= soLuongSpNhapKho;

                                SanPham sanPham = sanPhamService.getSanPhamByMaSp(maSp);
                                sanPham.setSoLuongTon(soLuongTonKho);

                                LoSanPham loSanPham = loSanPhamService.getLoSpBySoLo(soLo);
                                loSanPham.setSoLuongSp(soLuongSpLo); 

                                ChiTietPhieuNhapSp chiTietPhieuNhapSp = new ChiTietPhieuNhapSp(maPnsp, soLo);
                                chiTietPnspService.createChiTietPhieuNhapSanPham(chiTietPhieuNhapSp);     
                                
                                sanPhamService.updateSanPham(maSp, sanPham);
                                loSanPhamService.updateLoSanPham(soLo, loSanPham);

                                refreshDataTable("Tồn Kho");
                                refreshDataTable("Lô");

                                JOptionPane.showMessageDialog(form, "Nhập kho thành công!");
                            }
                         }
                  } catch (IOException ex) {
                   ex.printStackTrace();
                  }
            }          
        });
    }
    
    
    public void refreshDataTable(String tableName)  {
            if(tableName.equals("Tồn Kho")) {        
                tableModelTonKho.setRowCount(0);
                showDanhSachTable();
            } else {
                tableModelLoSp.setRowCount(0);
                showDanhSachTable1(tenSp);
           } 
    }
    
    
        private boolean enableComboBoxEvent = true;
        private void capNhatTonKho() {
        form.getButtonCNTK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //Enable Button Luu va Huy
               // form.getButtonLuu().setEnabled(true);
               // form.getButtonHuy().setEnabled(true); 

                    int selectedRow = form.getTableTonKho().getSelectedRow();
                    if(selectedRow != -1) {
                            enableComboBoxEvent = false;
                            form.setMaSP(form.getTableTonKho().getValueAt(selectedRow, 0).toString());
                            tenSp = form.getTableTonKho().getValueAt(selectedRow, 1).toString();
                            form.setTenSP(tenSp);
                            form.setSLTK(form.getTableTonKho().getValueAt(selectedRow, 2).toString());
                            enableComboBoxEvent = true; 
                            tableModelLoSp.setRowCount(0);
                            showDanhSachTable1(tenSp);
                }
            }
            });
         } 
        

        
        private void capNhatLoSp() {
            form.getTableSanPham().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int selectedRow = form.getTableSanPham().getSelectedRow();
                       if(selectedRow != -1) {
                            enableComboBoxEvent = false;
                            form.setSoLo(form.getTableSanPham().getValueAt(selectedRow, 0).toString());
                            form.setTenSP1(form.getTableSanPham().getValueAt(selectedRow, 1).toString());
                            form.setValueJSpinnerSoLuong(Integer.parseInt(form.getTableSanPham().getValueAt(selectedRow, 2).toString()));
                            enableComboBoxEvent = true; 
                            
                       }

                }
            });          
        }
       
   /* private void updateHangTonKho() {
        form.getButtonLuu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                String maSP = form.getMaSP();
                String tenSP = form.getTenSP();
                String soLuongTon = form.getSLTK();
                if(ValidateJTextField.validateFields(maSP, tenSP, soLuongTon)) {
                    SanPham sanPham = new SanPham();
                    sanPham.setTenSp(tenSP);
                    sanPham.setSoLuongTon(Integer.parseInt(soLuongTon));
                    if(sanPhamService.updateSanPham(maSP, sanPham) != null) {
                            refreshDataTable();
                            JOptionPane.showMessageDialog(form, "Cập nhật tồn kho thành công!");
                        } else {
                            JOptionPane.showMessageDialog(form, "Lỗi không thể cập nhật tồn kho!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }) ;
    } */
    
   /* private void buttonHuy() {
        form.getButtonHuy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 form.getButtonLuu().setEnabled(false);
                form.getButtonHuy().setEnabled(false); 
            }
        });
    } */
}
