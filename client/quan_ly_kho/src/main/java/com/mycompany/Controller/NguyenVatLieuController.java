/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.API.CtPnnvlService;
import com.mycompany.API.NguyenVatLieuService;
import com.mycompany.API.NhaCungCapService;
import com.mycompany.API.PnnvlService;
import com.mycompany.Entity.ChiTietPhieuNhapNvl;
import com.mycompany.Entity.NguyenVatLieu;
import com.mycompany.Entity.NhaCungCap;
import com.mycompany.Entity.PhieuNhapNvl;
import com.mycompany.Entity.PhieuNhapSp;
import com.mycompany.Validate.ValidateJTextField;
import com.mycompany.View.pNguyenVatLieu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class NguyenVatLieuController {
    private pNguyenVatLieu form;
    private NhaCungCapService nhaCungCapService;
    private NguyenVatLieuService nguyenVatLieuService;
    private PnnvlService pnnvlService;
    private CtPnnvlService ctPnnvlService;
    private DefaultTableModel tableModelTonKho;
    private DefaultTableModel tableModelNvl;
    
    
    public NguyenVatLieuController() {}
    
    public NguyenVatLieuController(pNguyenVatLieu form) {
        this.form = form;
        this.nguyenVatLieuService = new NguyenVatLieuService();
        this.nhaCungCapService = new NhaCungCapService();
        this.ctPnnvlService = new CtPnnvlService();
        this.pnnvlService = new PnnvlService();
        createTable("TonKho");
        createTable("NVL");
        showDanhSachTable("Tồn Kho");
        showDanhSachTable("NVL");
        showComboBox();
        capNhatTonKho();
        capNhatNVL();
        taoPhieuNhapNvl();
        nhapKhoNVl();
    }
    
    private void createTable(String tableName) {
        if(tableName.equals("TonKho")) {
            tableModelTonKho = new DefaultTableModel();
            tableModelTonKho.addColumn("Mã NVL");
            tableModelTonKho.addColumn("Tên nguyên vật liệu");
            tableModelTonKho.addColumn("Số lượng tồn kho");
        } else {   
            tableModelNvl = new DefaultTableModel();
            tableModelNvl.addColumn("Mã NVL");
            tableModelNvl.addColumn("Tên nguyên vật liệu");
            tableModelNvl.addColumn("Đơn vị tính");
        }
    }
    
    private void showDanhSachTable(String tableName) {
        try {
            if(tableName.equals("Tồn Kho")) {         
                List<NguyenVatLieu> listNguyenVatLieu = nguyenVatLieuService.getAllNguyenVatLieu();
                if(listNguyenVatLieu != null) {
                    JTable tableTonKho = form.getjTable_tonKhoNVL();           
                    for(NguyenVatLieu nguyenVatLieu : listNguyenVatLieu) {
                        Object[] row = {nguyenVatLieu.getMaNvl(), nguyenVatLieu.getTenNvl(), nguyenVatLieu.getSoLuongTon()};
                        tableModelTonKho.addRow(row);
                    }
                    tableTonKho.setModel(tableModelTonKho);
                }  
            } else {
               List<NguyenVatLieu> listNguyenVatLieu = nguyenVatLieuService.getAllNguyenVatLieu();
                if(listNguyenVatLieu != null) {
                    JTable tableNVL= form.getjTable_ttNVL();
                    for(NguyenVatLieu nguyenVatLieu : listNguyenVatLieu) {
                        Object[] row = {nguyenVatLieu.getMaNvl(), nguyenVatLieu.getTenNvl(), nguyenVatLieu.getGhiChu()};
                        tableModelNvl.addRow(row);
                    }
                    tableNVL.setModel(tableModelNvl);
                }  
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void showComboBox() {
        try {
            List<NhaCungCap> listNhaCungCap = nhaCungCapService.getAllNhaCungCap();    
            if(listNhaCungCap != null) {
                for(NhaCungCap nhaCungCap : listNhaCungCap) {
                    form.getjComboBox_nhaCungCap().addItem(nhaCungCap.getTenNcc());
                }
            }
        } catch (IOException ex){
            ex.printStackTrace();
        }
    } 
    
    
    private boolean enableComboBoxEvent = true;
    private void capNhatTonKho() {
    form.getjButton_CNTK().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            int selectedRow = form.getjTable_tonKhoNVL().getSelectedRow();
            if(selectedRow != -1) {
                    enableComboBoxEvent = false;
                    form.setMaNVL1(form.getjTable_tonKhoNVL().getValueAt(selectedRow, 0).toString());
                    form.setTenNVL1(form.getjTable_tonKhoNVL().getValueAt(selectedRow, 1).toString());
                    form.setSoLuongTon(form.getjTable_tonKhoNVL().getValueAt(selectedRow, 2).toString());
                    enableComboBoxEvent = true; 
                }
        }
        });
     } 
    
    String dVT = "";
    private void capNhatNVL() {
            form.getjTable_ttNVL().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                      int selectedRow = form.getjTable_ttNVL().getSelectedRow();
                       if(selectedRow != -1) {
                            enableComboBoxEvent = false;
                            form.setMaNVL2(form.getjTable_ttNVL().getValueAt(selectedRow, 0).toString());
                            form.setTenNVL2(form.getjTable_ttNVL().getValueAt(selectedRow, 1).toString());
                            dVT = form.getjTable_ttNVL().getValueAt(selectedRow, 2).toString();
                            enableComboBoxEvent = true; 
                        }
                }            
            });          
        }
    
    private void taoPhieuNhapNvl() {
        form.getjButton_taoPhieu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String maPnnvl = form.getMaPN();
                    Date ngayNhap = form.getValueJDateChooserNgayNhap();
                    String tenNcc = form.getjComboBox_nhaCungCap().getSelectedItem().toString();
                    String maNcc = nhaCungCapService.getMaNccByTenNcc(tenNcc);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng chỉ lấy ngày
                    String formattedDate = dateFormat.format(ngayNhap); // Lấy giá trị ngày đã định dạng
                    
                    String maNvl = form.getMaNVL2();
                    String tenNvl = form.getTenNVL2();
                    int soLuongNhap = Integer.parseInt(form.getValueJSpinnerSoLuong());
                    int giaNhap = Integer.parseInt(form.getValueJSpinnerGiaNhap());
                    Date nSX = form.getValueJDateChooserNSX();
                    Date hSD = form.getValueJDateChooserHSD();
                    String formattedDate1 = dateFormat.format(nSX);
                    String formattedDate2 = dateFormat.format(hSD);
                   
                    if(ValidateJTextField.validateFields(maNvl, maPnnvl, tenNvl)) {
                        PhieuNhapNvl phieuNhapNvl = new PhieuNhapNvl(maPnnvl, formattedDate, maNcc);
                        ChiTietPhieuNhapNvl chiTietPhieuNhapNvl = new ChiTietPhieuNhapNvl(maPnnvl, maNvl, soLuongNhap, dVT, giaNhap, formattedDate1, formattedDate2);
                        
                        pnnvlService.createPhieuNhapNvl(phieuNhapNvl);
                        ctPnnvlService.createChiTietPhieuNhapNvl(chiTietPhieuNhapNvl);
                        
                       JOptionPane.showMessageDialog(form, "Tạo phiếu thành công!");
                    } else {
                       JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } 
            } 
        });
    }
    
    private void nhapKhoNVl() {
        form.getjButton_nhapKho().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int selectedRowTonKho = form.getjTable_tonKhoNVL().getSelectedRow();
                    int selectedRowNvl = form.getjTable_ttNVL().getSelectedRow();

                        if(selectedRowTonKho != -1 && selectedRowNvl != -1) {
                            String maNvl1 = form.getjTable_tonKhoNVL().getValueAt(selectedRowTonKho, 0).toString();

                            int soLuongNvlNhapKho = Integer.parseInt(form.getValueJSpinnerSoLuong());
                            int soLuongTonKho = Integer.parseInt(form.getjTable_tonKhoNVL().getValueAt(selectedRowTonKho, 2).toString());
                            
                             if (soLuongNvlNhapKho <= 0) {
                                JOptionPane.showMessageDialog(form, "Vui lòng nhập số lượng sản phẩm hợp lệ!");
                            } 

                           else {
                                soLuongTonKho += soLuongNvlNhapKho;

                                NguyenVatLieu nguyenVatLieu = nguyenVatLieuService.getNguyenVatLieuByMaNvl(maNvl1);
                                nguyenVatLieu.setSoLuongTon(soLuongTonKho);

                                nguyenVatLieuService.updateNguyenVatLieu(maNvl1, nguyenVatLieu);

                                refreshDataTable("Tồn Kho");

                                JOptionPane.showMessageDialog(form, "Nhập kho thành công!");
                            }
                         }
                  } catch (IOException ex) {
                   ex.printStackTrace();
                  }
            }          
        });
    } 
    
    private void refreshDataTable(String tableName)  {     
                tableModelTonKho.setRowCount(0);
                showDanhSachTable(tableName);
    }
}
