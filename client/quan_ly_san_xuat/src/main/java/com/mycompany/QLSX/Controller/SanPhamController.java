/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLSX.Controller;

import com.mycompany.QLSX.API.LoaiSpService;
import com.mycompany.QLSX.API.SanPhamService;
import com.mycompany.QLSX.Entity.LoaiSanPham;
import com.mycompany.QLSX.Entity.SanPham;
import com.mycompany.Validate.ValidateJTextField;
import com.mycompany.QLSX.View.pDanhSachSP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
public class SanPhamController {
    private pDanhSachSP form;
    private SanPhamService sanPhamService;
    private LoaiSpService loaiSpService;
    private DefaultTableModel tableModelSanPham;
    
         public SanPhamController() {}

         public SanPhamController(pDanhSachSP form) {
            this.form = form;
            this.sanPhamService = new SanPhamService();
            this.loaiSpService = new LoaiSpService();
            createTable();
            showDuLieuTable();
            showComboBox();
            showSpByMaLoai();
            hienThiSpWithJTextField();
            themSanPham();
            suaSanPham();
            xoaSanPham();
            searchSanPham();
            quayLai(); 
        }
         private void createTable() {
            tableModelSanPham = new DefaultTableModel();
            tableModelSanPham.addColumn("Loại SP");
            tableModelSanPham.addColumn("Mã SP");
            tableModelSanPham.addColumn("Tên SP");
            tableModelSanPham.addColumn("Thành phần");
            tableModelSanPham.addColumn("Giá");
            tableModelSanPham.addColumn("KTL");
        }

         private void showDuLieuTable() {
            try {
                   List<SanPham> listSanPham = sanPhamService.getAllSanPham();
                    if(listSanPham != null) {
                        JTable tableSp= form.getjTable_loaisp();
                        for(SanPham sanPham : listSanPham) {
                            Object[] row = {sanPham.getMaLoai(), sanPham.getMaSp(), sanPham.getTenSp(), sanPham.getThanhPhan(), sanPham.getGiaBan(), sanPham.getKlt()};
                            tableModelSanPham.addRow(row);
                        }
                        tableSp.setModel(tableModelSanPham);
                    }  
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } 

         private void showComboBox() {
            try {
                List<LoaiSanPham> listLoaiSanPham = loaiSpService.getAllLoaiSanPham();    
                if(listLoaiSanPham != null) {
                    for(LoaiSanPham loaiSanPham : listLoaiSanPham) {
                        form.getjComboBox_loaisp1().addItem(loaiSanPham.getMaLoai());
                    }
                }
            } catch (IOException ex){
                ex.printStackTrace();
            }
        } 

         private boolean enableComboBoxEvent = true;
         private void showSpByMaLoai() {
              form.getjComboBox_loaisp1().addItemListener(new ItemListener() {
                  @Override
                  public void itemStateChanged(ItemEvent e) {
                      if(enableComboBoxEvent && e.getStateChange() == ItemEvent.SELECTED) {
                          try {
                              String maLoai = (String)form.getjComboBox_loaisp1().getSelectedItem();
                              if(!maLoai.equals("--- Chọn loại sản phẩm ---")) {
                                List<SanPham> listSanPham = sanPhamService.getAllSanPhamByMaLoai(maLoai);
                                if(listSanPham != null) {
                                    tableModelSanPham.setRowCount(0);
                                    JTable tableSp= form.getjTable_loaisp();
                                    for(SanPham sanPham : listSanPham) {
                                        Object[] row = {sanPham.getMaLoai(), sanPham.getMaSp(), sanPham.getTenSp(), sanPham.getThanhPhan(), sanPham.getGiaBan(), sanPham.getKlt()};
                                        tableModelSanPham.addRow(row);
                                    }
                                    tableSp.setModel(tableModelSanPham);
                                }  
                              } else {
                                  refreshDataTable();
                              }
                          } catch(IOException ex) {
                              ex.printStackTrace();
                          }
                      }
                  }            
              });
          }

         private void hienThiSpWithJTextField() {
            form.getjTable_loaisp().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(!e.getValueIsAdjusting()) {
                        int selectedRow = form.getjTable_loaisp().getSelectedRow();
                        if(selectedRow != -1) {
                            enableComboBoxEvent = false;
                            form.setComboBoxMaLoai(form.getjTable_loaisp().getValueAt(selectedRow, 0).toString());
                            form.setMaSP(form.getjTable_loaisp().getValueAt(selectedRow, 1).toString());
                            form.setTenSP(form.getjTable_loaisp().getValueAt(selectedRow, 2).toString());
                            form.setThanhPhan(form.getjTable_loaisp().getValueAt(selectedRow, 3).toString());
                            form.setKLT(form.getjTable_loaisp().getValueAt(selectedRow, 5).toString());
                            form.setValueJSpinnerGiaBan(Integer.parseInt(form.getjTable_loaisp().getValueAt(selectedRow, 4).toString()));
                            enableComboBoxEvent = true; 
                        }
                    }
                }
            });
        }
         
         private void themSanPham() {
             form.getjButton_them().addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     String maLoai = (String)form.getjComboBox_loaisp1().getSelectedItem();
                     String maSanPham = form.getMaSP();
                     String tenSanPham = form.getTenSP();
                     String thanhPhan = form.getThanhPhan();
                     int giaSp = Integer.parseInt(form.getValueJSpinnerGiaBan().toString());
                     String klt = form.getKLT();
                     
                     try {
                         if(ValidateJTextField.validateFields(maSanPham, tenSanPham, thanhPhan,klt)) {
                            if(sanPhamService.getSanPhamByMaSp(maSanPham) == null) {
                                SanPham sanPham = new SanPham(maSanPham, maLoai, tenSanPham, giaSp, thanhPhan, klt);
                                sanPhamService.createSanPham(sanPham);
                                refreshDataTable();
                                JOptionPane.showMessageDialog(form, "Thêm thành công!");
                            } else {
                                JOptionPane.showMessageDialog(form, "Sản phẩm đã tồn tại!");
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
         
         private void suaSanPham() {
             form.getjButton_sua().addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     String maLoai = (String)form.getjComboBox_loaisp1().getSelectedItem();
                     String maSanPham = form.getMaSP();
                     String tenSanPham = form.getTenSP();
                     String thanhPhan = form.getThanhPhan();
                     int giaSp = Integer.parseInt(form.getValueJSpinnerGiaBan().toString());
                     String klt = form.getKLT();
                     
                     try {
                         if(ValidateJTextField.validateFields(maSanPham, tenSanPham, thanhPhan,klt)) {
                                SanPham sanPham = sanPhamService.getSanPhamByMaSp(maSanPham);
                                sanPham.setMaLoai(maLoai);
                                sanPham.setTenSp(tenSanPham);
                                sanPham.setThanhPhan(thanhPhan);
                                sanPham.setKlt(klt);
                                sanPham.setGiaBan(giaSp);
                                sanPhamService.updateSanPham(maSanPham, sanPham);
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
         
         private void xoaSanPham() {
             form.getjButton_xoa().addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                    
                     try {
                    String maSanPham = form.getMaSP();
                        if(ValidateJTextField.validateFields(maSanPham)) {
                            int dialogResult = JOptionPane.showConfirmDialog(form, "Bạn có đồng ý xóa không?", "Xoá sản phẩm", JOptionPane.YES_NO_OPTION);
                            if(dialogResult == JOptionPane.YES_OPTION) {
                                if(sanPhamService.deleteSanPham(maSanPham)) {
                                    refreshDataTable();
                                    JOptionPane.showMessageDialog(form, "Xóa thành công!");
                                } else {
                                    JOptionPane.showMessageDialog(form, "Không thể xóa sản phẩm!", "Error", JOptionPane.INFORMATION_MESSAGE);
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
             });
         }
         
         private void searchSanPham() {
        form.getjButton_timkiem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String keyword = form.getTimKiem();
                    JTable tableSP= form.getjTable_loaisp();
                    if(ValidateJTextField.validateFields(keyword)) {
                           SanPham sanPham = sanPhamService.getSanPhamByMaSp(keyword);
                           if(sanPham != null) {
                               tableModelSanPham.setRowCount(0);
                               Object[] row = {sanPham.getMaLoai(), sanPham.getMaSp(), sanPham.getTenSp(), sanPham.getThanhPhan(), sanPham.getGiaBan(), sanPham.getKlt()};
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

         private void quayLai() {
            form.getjButton_quaylai().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    refreshDataTable();
                }         
            });
        }

         private void refreshDataTable() {
            tableModelSanPham.setRowCount(0);
            showDuLieuTable();
        }
    
}
