/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.API.NguyenVatLieuService;
import com.mycompany.Entity.NguyenVatLieu;
import com.mycompany.Validate.ValidateJTextField;
import com.mycompany.View.pDanhSachNVL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
    private pDanhSachNVL form;
    private NguyenVatLieuService nguyenVatLieuService;
    private DefaultTableModel tableModelNvl;
    
    public NguyenVatLieuController() {}
    
    public NguyenVatLieuController(pDanhSachNVL form) {
        this.form = form;
        this.nguyenVatLieuService = new NguyenVatLieuService();
        createTable();
        showDuLieuTable(); 
        capNhatNVL();
        taoNguyenVatLieu();
        updateNguyenVatLieu();
        xoaNguyenVatLieu();
        searchNguyenVatLieu();
        quayLai();
    }
    
    private void createTable() {
        tableModelNvl = new DefaultTableModel();
        tableModelNvl.addColumn("Mã nguyên vật liệu");
        tableModelNvl.addColumn("Tên nguyên vật liệu");
        tableModelNvl.addColumn("Ghi chú");
    }
    
    private void showDuLieuTable() {
        try {
               List<NguyenVatLieu> listNguyenVatLieu = nguyenVatLieuService.getAllNguyenVatLieu();
                if(listNguyenVatLieu != null) {
                    JTable tableNVL= form.getjTable_danhSachNVL();
                    for(NguyenVatLieu nguyenVatLieu : listNguyenVatLieu) {
                        Object[] row = {nguyenVatLieu.getMaNvl(), nguyenVatLieu.getTenNvl(), nguyenVatLieu.getGhiChu()};
                        tableModelNvl.addRow(row);
                    }
                    tableNVL.setModel(tableModelNvl);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
   
    private void capNhatNVL() {
            form.getjTable_danhSachNVL().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                      int selectedRow = form.getjTable_danhSachNVL().getSelectedRow();
                       if(selectedRow != -1) {
                            form.setMaNVL(form.getjTable_danhSachNVL().getValueAt(selectedRow, 0).toString());
                            form.setTenNVL(form.getjTable_danhSachNVL().getValueAt(selectedRow, 1).toString());
                            form.setGhiChu(form.getjTable_danhSachNVL().getValueAt(selectedRow, 2).toString());
                        }
                }            
            });          
        }
    
    private void taoNguyenVatLieu() {
        form.getjButton_them().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String maNvl = form.getMaNVL();
                    String tenNvl = form.getTenNVL();
                    String ghiChu = form.getGhiChu(); 

                    if(ValidateJTextField.validateFields(maNvl, tenNvl, ghiChu)) {
                            if(nguyenVatLieuService.getNguyenVatLieuByMaNvl(maNvl) == null) {
                                NguyenVatLieu nguyenVatLieu = new NguyenVatLieu(maNvl, tenNvl, ghiChu);
                                nguyenVatLieuService.createNguyenVatLieu(nguyenVatLieu);
                                refreshDataTable();
                                JOptionPane.showMessageDialog(form, "Thêm thành công!");
                            } else {
                                JOptionPane.showMessageDialog(form, "Nguyên vật liệu đã tồn tại!");
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
    
    private void updateNguyenVatLieu() {
        form.getjButton_sua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String maNvl = form.getMaNVL();
                    String tenNvl = form.getTenNVL();
                    String ghiChu = form.getGhiChu(); 

                    if(ValidateJTextField.validateFields(maNvl, tenNvl, ghiChu)) {
                                NguyenVatLieu nguyenVatLieu = nguyenVatLieuService.getNguyenVatLieuByMaNvl(maNvl);
                                nguyenVatLieu.setTenNvl(tenNvl);
                                nguyenVatLieu.setGhiChu(ghiChu);
                                nguyenVatLieuService.updateNguyenVatLieu(maNvl, nguyenVatLieu);
                                refreshDataTable();
                                JOptionPane.showMessageDialog(form, "Sửa thành công!");
                    } else {
                        JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                    }
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }       
        });
    }
    
    private void xoaNguyenVatLieu() {
        form.getjButton_xoa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 try {
                    String maNvl = form.getMaNVL();
                    if(ValidateJTextField.validateFields(maNvl)) {
                        int dialogResult = JOptionPane.showConfirmDialog(form, "Bạn có đồng ý xóa không?", "Xoá nguyên vật liệu", JOptionPane.YES_NO_OPTION);
                        if(dialogResult == JOptionPane.YES_OPTION) {
                            if(nguyenVatLieuService.deleteNguyenVatLieu(maNvl)) {
                                refreshDataTable();
                                JOptionPane.showMessageDialog(form, "Xóa thành công!");
                            } else {
                                JOptionPane.showMessageDialog(form, "Không thể xóa nguyên vật liệu!", "Error", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            return;
                        }        
                    } else {
                        JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                    }
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        } );
    }
    
    private void searchNguyenVatLieu() {
        form.getjButton_timkiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String keyword = form.getTimKiem();
                    JTable tableNVL= form.getjTable_danhSachNVL();
                    if(ValidateJTextField.validateFields(keyword)) {
                           NguyenVatLieu nguyenVatLieu = nguyenVatLieuService.getNguyenVatLieuByMaNvl(keyword);
                           if(nguyenVatLieu != null) {
                               tableModelNvl.setRowCount(0);
                               Object[] row = {nguyenVatLieu.getMaNvl(), nguyenVatLieu.getTenNvl(), nguyenVatLieu.getGhiChu()};
                                tableModelNvl.addRow(row);
                                tableNVL.setModel(tableModelNvl);
                           } else {
                                tableModelNvl.setRowCount(0);
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
    
    private void quayLai() {
        form.getjButton_quaylai().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshDataTable();
            }         
        });
    }
    
    private void refreshDataTable() {
        tableModelNvl.setRowCount(0);
        showDuLieuTable();
    }
}
