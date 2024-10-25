/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLSX.Controller;

import com.mycompany.QLSX.API.CtPhieuNghiemThuService;
import com.mycompany.QLSX.API.CtPhieuYcsxService;
import com.mycompany.QLSX.API.LoSanPhamService;
import com.mycompany.QLSX.API.PhieuNghiemThuService;
import com.mycompany.QLSX.API.PhieuYcsxService;
import com.mycompany.QLSX.API.SanPhamService;
import com.mycompany.QLSX.Entity.CtPhieuNghiemThu;
import com.mycompany.QLSX.Entity.CtPhieuYcsx;
import com.mycompany.QLSX.Entity.LoSanPham;
import com.mycompany.QLSX.Entity.PhieuNghiemThu;
import com.mycompany.QLSX.Entity.PhieuYcsx;
import com.mycompany.Validate.ValidateJTextField;
import com.mycompany.QLSX.View.pTaoPhieuNghiemTHu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
public class PhieuNghiemThuController {
    private pTaoPhieuNghiemTHu form;
    private PhieuNghiemThuService phieuNghiemThuService;
    private CtPhieuNghiemThuService ctPhieuNghiemThuService;
    private SanPhamService sanPhamService;
    private LoSanPhamService loSanPhamService;
    private CtPhieuYcsxService ctPhieuYcsxService;
    private PhieuYcsxService phieuYcsxService;
    private DefaultTableModel tableModelYcsx;
    private DefaultTableModel tableModelLoCanNt;
    private DefaultTableModel tableModelLoDaNt;
    private String maNv;

    public PhieuNghiemThuController() {}

    public PhieuNghiemThuController(pTaoPhieuNghiemTHu form, String maNv) {
        this.form = form;
        this.maNv = maNv;
        this.phieuNghiemThuService = new PhieuNghiemThuService();
        this.ctPhieuNghiemThuService = new CtPhieuNghiemThuService();
        this.sanPhamService = new SanPhamService();
        this.ctPhieuYcsxService = new CtPhieuYcsxService();
        this.loSanPhamService = new LoSanPhamService();
        this.phieuYcsxService = new PhieuYcsxService();
        createTable("Ycsx");
        createTable("need");
        createTable("done");
        showComboBox();
        showSpByMaYc();
        taoPhieuNt();
        nghiemThu();
        showCtSp();
    }
    
    private void createTable(String tableName) {
        if(tableName.equals("Ycsx")) {
            tableModelYcsx = new DefaultTableModel();
            tableModelYcsx.addColumn("Mã sản phẩm");
            tableModelYcsx.addColumn("Tên sản phẩm");
            tableModelYcsx.addColumn("Sl cần sản xuất");
        } else if(tableName.equals("need")){   
            tableModelLoCanNt = new DefaultTableModel();
            tableModelLoCanNt.addColumn("Số lô");
            tableModelLoCanNt.addColumn("Mã sp");
            tableModelLoCanNt.addColumn("SL sản phẩm");
            tableModelLoCanNt.addColumn("NSX");
            tableModelLoCanNt.addColumn("Tình trạng");
        } else {
            tableModelLoDaNt = new DefaultTableModel();
            tableModelLoDaNt.addColumn("YCSX");
            tableModelLoDaNt.addColumn("Số lô");
            tableModelLoDaNt.addColumn("Tên sản phẩm");
            tableModelLoDaNt.addColumn("Kết quả NT");
        }
    }
    
    private void showComboBox() {
            try {
                List<PhieuYcsx> listPhieuYcsx = phieuYcsxService.getAllPhieuYcsxByUrl("");    
                if(listPhieuYcsx != null) {
                    for(PhieuYcsx phieuYcsx : listPhieuYcsx) {
                        form.getjComboBox_phieuyeucau().addItem(phieuYcsx.getMaYc());
                    }
                }
            } catch (IOException ex){
                ex.printStackTrace();
            }
        } 
    
     private void showCtYcsx(String maYc) {
        try {       
                List<CtPhieuYcsx> listCtPhieuYcsx = ctPhieuYcsxService.getCtPhieuYcsxByMaYc(maYc);
                String tenSp = "";
                if(listCtPhieuYcsx != null) {
                    JTable tableDsSanPham = form.getjTable1();           
                    for(CtPhieuYcsx ctPhieuYcsx : listCtPhieuYcsx) {
                        tenSp = sanPhamService.getTenSpByMaSp(ctPhieuYcsx.getMaSp());
                        Object[] row = {ctPhieuYcsx.getMaSp(), tenSp, ctPhieuYcsx.getSoLuongSx()};
                        tableModelYcsx.addRow(row);
                    }
                    tableDsSanPham.setModel(tableModelYcsx);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     
    private boolean enableComboBoxEvent = true;
    private void showSpByMaYc() {
         form.getjComboBox_phieuyeucau().addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent e) {
                 if(enableComboBoxEvent && e.getStateChange() == ItemEvent.SELECTED) {
                         String maYc = (String)form.getjComboBox_phieuyeucau().getSelectedItem();
                         tableModelYcsx.setRowCount(0);
                         tableModelLoCanNt.setRowCount(0);
                         tableModelLoDaNt.setRowCount(0);
                          showCtYcsx(maYc);
                          showDsSpCanNt(maYc);
                          showDsSpDaNt(maYc);
                 }
             }            
         });
     }
    
    private void showDsSpCanNt(String maYc) {
        try {
            List<LoSanPham> listLoSanPham = loSanPhamService.getAllLoSanPhamByMaYc(maYc);
                if(listLoSanPham != null) {
                    JTable tableLoSp = form.getjTable2();
                    String tenSanPham = "";
                    for(LoSanPham loSanPham : listLoSanPham) {
                        tenSanPham = sanPhamService.getTenSpByMaSp(loSanPham.getMaSp());
                        Object[] row = { loSanPham.getSoLo(), loSanPham.getMaSp(),  loSanPham.getSoLuongSp(), loSanPham.getNsx(),  loSanPham.getTinhTrang()};
                        if(loSanPham.getTinhTrang().equals("Chua nghiem thu")) {
                            tableModelLoCanNt.addRow(row);
                        }
                    }
                    tableLoSp.setModel(tableModelLoCanNt);
                }  
        } catch (IOException ex) {
            
        }
    }
    
    private void showDsSpDaNt(String maYc) {
        try {
            List<CtPhieuNghiemThu> listPhieuNghiemThu = ctPhieuNghiemThuService.getAllCtPhieuNghiemThuByUrl("");
                if(listPhieuNghiemThu != null) {
                    JTable tableLoSp = form.getjTable3();
                    String tenSanPham = "";
                    String maYcsx = "";
                    String maSp = "";
                    for(CtPhieuNghiemThu phieuNghiemThu : listPhieuNghiemThu) {
                        maSp = loSanPhamService.getLoSpBySoLo(phieuNghiemThu.getSoLo()).getMaSp();
                        maYcsx = loSanPhamService.getLoSpBySoLo(phieuNghiemThu.getSoLo()).getMaYc();
                        tenSanPham = sanPhamService.getTenSpByMaSp(maSp);
                        Object[] row ={  maYcsx, phieuNghiemThu.getSoLo(), tenSanPham, phieuNghiemThu.getKetQuaNt() };
                        if(maYcsx.equals(maYc)) {
                            tableModelLoDaNt.addRow(row);
                        }
                    }
                    tableLoSp.setModel(tableModelLoDaNt);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void taoPhieuNt() {
        form.getjButton_taophieu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maYc = form.getMaPhieuYeuCau();
                String maPhieu = form.getMaPhieuNghiemThu();
                String noiDung = form.getNoiDung();
                 Date ngayNt = form.getValueJDateChooser();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate1 = dateFormat.format(ngayNt);
                try {
                         if(ValidateJTextField.validateFields(maYc, maPhieu, noiDung)) {
                            if(phieuNghiemThuService.getPhieuNghiemThuByMaPhieu(maPhieu) == null) {
                                PhieuNghiemThu phieuNghiemThu = new PhieuNghiemThu(maPhieu, maYc, formattedDate1, noiDung, maNv);
                                phieuNghiemThuService.createPhieuNghiemThu(phieuNghiemThu);
                                JOptionPane.showMessageDialog(form, "Thêm thành công!");
                            } else {
                                JOptionPane.showMessageDialog(form, "Phiếu đã tồn tại!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                        }
                     } catch(IOException ex) {
                         ex.printStackTrace();
                     }
            }      
        });
    }
    
    private void nghiemThu() {
        form.getjButton_nghiemthu().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  String soLo = form.getSoLo();
                  String kqNt = form.getKetQuaNghiemThu();
                  String maPhieu = form.getMaPhieuNghiemThu();
                  String maYc = form.getjComboBox_phieuyeucau().getSelectedItem().toString();
                  
                  try {
                         if(ValidateJTextField.validateFields(soLo, maPhieu, kqNt)) {
                                CtPhieuNghiemThu ctPhieuNghiemThu = new CtPhieuNghiemThu(maPhieu, soLo, kqNt);
                                ctPhieuNghiemThuService.createCtPhieuNghiemThu(ctPhieuNghiemThu);
                                LoSanPham loSanPham = loSanPhamService.getLoSpBySoLo(soLo);
                                loSanPham.setTinhTrang("Da nghiem thu");
                                loSanPhamService.updateLoSanPham(soLo, loSanPham);
                                refrestDataTable("CanNt", maYc);
                                refrestDataTable("DaNt", maYc);
                                JOptionPane.showMessageDialog(form, "Nghiệm thu thành công!");
                        } else {
                            JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                        }
                     } catch(IOException ex) {
                         ex.printStackTrace();
                     }
            }   
        });
    }
    
    private void showCtSp() {
        form.getjTable2().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = form.getjTable2().getSelectedRow();
                if(selectedRow != -1) {
                    form.setSoLo(form.getjTable2().getValueAt(selectedRow, 0).toString());
                }
            }     
        });
    }
    
    private void refrestDataTable(String tableName, String maYc) {
        if(tableName.equals("CanNt")) {
            tableModelLoCanNt.setRowCount(0);
            showDsSpCanNt(maYc);
        } else {
            tableModelLoDaNt.setRowCount(0);
            showDsSpDaNt(maYc);
        }
    }
    
}
