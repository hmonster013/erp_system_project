/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.API.CtPhieuYcsxService;
import com.mycompany.API.PhieuYcsxService;
import com.mycompany.API.SanPhamService;
import com.mycompany.Entity.CtPhieuYcsx;
import com.mycompany.Entity.PhieuYcsx;
import com.mycompany.Entity.SanPham;
import com.mycompany.Validate.ValidateJTextField;
import com.mycompany.View.pTaoYeuCauSX;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khoahihi79
 */
public class ChiTietYeuCauController {
    private pTaoYeuCauSX form;
    private CtPhieuYcsxService ctPhieuYcsxService;
    private PhieuYcsxService phieuYcsxService;
    private SanPhamService sanPhamSerivce;
    private DefaultTableModel tableModelSanPham;
    private DefaultTableModel tableModelDsSp;
    
    public ChiTietYeuCauController() {}
    
    public ChiTietYeuCauController(pTaoYeuCauSX form) {
        this.form = form;
        this.ctPhieuYcsxService = new CtPhieuYcsxService();
        this.phieuYcsxService = new PhieuYcsxService();
        this.sanPhamSerivce = new SanPhamService();
        createTable("Sp");
        createTable("CtSp");
        showDanhSachTable();
        taoYcsx();
        showChiTietSp();
        searchSanPham();
        filterSp();
        themSp();
        showChiTietSp();
    }
    
    private void createTable(String tableName) {
        if(tableName.equals("Sp")) {
            tableModelSanPham = new DefaultTableModel();
            tableModelSanPham.addColumn("Mã sản phẩm");
            tableModelSanPham.addColumn("Tên sản phẩm");
            tableModelSanPham.addColumn("SL tồn");
        } else {   
            tableModelDsSp = new DefaultTableModel();
            tableModelDsSp.addColumn("Mã sản phẩm");
            tableModelDsSp.addColumn("Tên sản phẩm");
            tableModelDsSp.addColumn("Số lượng cần sản xuất");
        }
    }
    
    private void showDanhSachTable() {
        try {       
                List<SanPham> listSanPham = sanPhamSerivce.getAllSanPham();
                if(listSanPham != null) {
                    JTable tableSanPham = form.getjTable_duoi();           
                    for(SanPham sanPham : listSanPham) {
                        Object[] row = {sanPham.getMaSp(), sanPham.getTenSp(), sanPham.getSoLuongTon()};
                        tableModelSanPham.addRow(row);
                    }
                    tableSanPham.setModel(tableModelSanPham);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void taoYcsx() {
        form.getjButton_taoyeucau().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maPhieu = form.getMaPhieu();
                 Date ngayBd = form.getValueJDateChooserNBD();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate1 = dateFormat.format(ngayBd);
                Date ngayKt = form.getValueJDateChooserNKT();
                String formatttedDate2  = dateFormat.format(ngayKt);
                
                 try {
                         if(ValidateJTextField.validateFields(maPhieu)) {
                            if(phieuYcsxService.getPhieuYcsxByMaYc(maPhieu) == null) {
                                PhieuYcsx phieuYcsx = new PhieuYcsx(maPhieu, formattedDate1, formatttedDate2);
                                phieuYcsxService.createPhieuYcsx(phieuYcsx);
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
    
    private void showChiTietSp() {
        form.getjTable_duoi().getSelectionModel().addListSelectionListener(new ListSelectionListener() { 
            @Override
            public void valueChanged(ListSelectionEvent e) {
                  int selectedRow = form.getjTable_duoi().getSelectedRow();
                        if(selectedRow != -1) {
                            form.setMaSP(form.getjTable_duoi().getValueAt(selectedRow, 0).toString());
                            form.setTenSP(form.getjTable_duoi().getValueAt(selectedRow, 1).toString());
                            form.setValueJSpinnerSoLuong(Integer.parseInt(form.getjTable_duoi().getValueAt(selectedRow, 2).toString()));
                        }
            }           
        });
    }
    
    private void searchSanPham() {
        form.getjButton_tim().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String keyword = form.getTimKiem();
                    JTable tableSP= form.getjTable_duoi();
                    if(ValidateJTextField.validateFields(keyword)) {
                           SanPham sanPham = sanPhamSerivce.getSanPhamByMaSp(keyword);
                           if(sanPham != null) {
                               tableModelSanPham.setRowCount(0);
                               Object[] row = { sanPham.getMaSp(), sanPham.getTenSp(),  sanPham.getKlt()};
                                tableModelSanPham.addRow(row);
                                tableSP.setModel(tableModelSanPham);
                           } else {
                                tableModelSanPham.setRowCount(0);
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
    
    private void filterSp() {
        form.getjTextField_timkiem().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                    showAllSp();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                    showAllSp();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                    showAllSp();
            }
            
        });
    }
    
    private void showAllSp() {
        String searchText = form.getTimKiem().toString();
        if(searchText.equals("")) {
            tableModelSanPham.setRowCount(0);
            showDanhSachTable();
        }
    }
    
    private void themSp() {
        form.getjButton_them().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maSanPham = form.getMaSP();
                String maYeuCau = form.getMaPhieu();
                int soLuongSx = Integer.parseInt(form.getValueJSpinnerSoLuong().toString());
                
                try {
                         if(ValidateJTextField.validateFields(maSanPham)) {
                             if(!(soLuongSx <= 0)) {
                                CtPhieuYcsx ctPhieuYcsx = new CtPhieuYcsx(maYeuCau, maSanPham, soLuongSx);
                                ctPhieuYcsxService.createCtPhieuYcsx(ctPhieuYcsx);
                                refreshDataTable(maYeuCau);
                                JOptionPane.showMessageDialog(form, "Thêm thành công!");
                             } else {
                                 JOptionPane.showMessageDialog(form, "Vui lòng nhập số lượng thích hợp!");
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
    
    private void refreshDataTable(String maYc) {
        tableModelDsSp.setRowCount(0);
        showCtYcsx(maYc);
    }
    
    private void showCtYcsx(String maYc) {
        try {       
                List<CtPhieuYcsx> listCtPhieuYcsx = ctPhieuYcsxService.getCtPhieuYcsxByMaYc(maYc);
                String tenSp = "";
                if(listCtPhieuYcsx != null) {
                    JTable tableDsSanPham = form.getjTable_tren();           
                    for(CtPhieuYcsx ctPhieuYcsx : listCtPhieuYcsx) {
                        tenSp = sanPhamSerivce.getTenSpByMaSp(ctPhieuYcsx.getMaSp());
                        Object[] row = {ctPhieuYcsx.getMaSp(), tenSp, ctPhieuYcsx.getSoLuongSx()};
                        tableModelDsSp.addRow(row);
                    }
                    tableDsSanPham.setModel(tableModelDsSp);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
