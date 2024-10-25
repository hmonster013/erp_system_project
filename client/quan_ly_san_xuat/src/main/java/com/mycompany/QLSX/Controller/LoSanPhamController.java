/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLSX.Controller;

import com.mycompany.QLSX.API.CtPhieuYcsxService;
import com.mycompany.QLSX.API.LoSanPhamService;
import com.mycompany.QLSX.API.PhieuYcsxService;
import com.mycompany.QLSX.API.SanPhamService;
import com.mycompany.QLSX.Entity.CtPhieuYcsx;
import com.mycompany.QLSX.Entity.LoSanPham;
import com.mycompany.QLSX.Entity.PhieuYcsx;
import com.mycompany.Validate.ValidateJTextField;
import com.mycompany.QLSX.View.pQuanLyLoSP;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
public class LoSanPhamController {
    private pQuanLyLoSP form;
    private PhieuYcsxService phieuYcsxService;
    private CtPhieuYcsxService ctPhieuYcsxService;
    private LoSanPhamService loSanPhamService;
    private SanPhamService sanPhamService;
    private DefaultTableModel tableModelSp;
    private DefaultTableModel tableModelLoSp;
    
    public LoSanPhamController() {}
    
    public LoSanPhamController(pQuanLyLoSP form) {
        this.form = form;
        this.phieuYcsxService = new PhieuYcsxService();
        this.ctPhieuYcsxService = new CtPhieuYcsxService();
        this.loSanPhamService = new LoSanPhamService();
        this.sanPhamService = new SanPhamService();
        createTable("Sp");
        createTable("LoSp");
        showSpByMaYc();
        showLoSp();
        showComboBox();
        showCtLoSp();
        showCtSp();
        themLoSp();
        xoaLoSanPham();
        suaLoSp();
    }
    
    private void createTable(String tableName) {
        if(tableName.equals("Sp")) {
            tableModelSp = new DefaultTableModel();
            tableModelSp.addColumn("Mã SP");
            tableModelSp.addColumn("Tên sản phẩm");
            tableModelSp.addColumn("Số lượng sản xuất");
        } else {   
            tableModelLoSp = new DefaultTableModel();
            tableModelLoSp.addColumn("Mã Ycsx");
            tableModelLoSp.addColumn("Số lô");
            tableModelLoSp.addColumn("Mã sản phẩm");
            tableModelLoSp.addColumn("Tên sản phẩm");
            tableModelLoSp.addColumn("Số lượng Sp");
            tableModelLoSp.addColumn("NSX");
            tableModelLoSp.addColumn("HSD");
            tableModelLoSp.addColumn("Tình trạng");
        } 
    }
    
     private void showCtYcsx(String maYc) {
        try {       
                List<CtPhieuYcsx> listCtPhieuYcsx = ctPhieuYcsxService.getCtPhieuYcsxByMaYc(maYc);
                String tenSp = "";
                if(listCtPhieuYcsx != null) {
                    JTable tableDsSanPham = form.getjTable_trai();           
                    for(CtPhieuYcsx ctPhieuYcsx : listCtPhieuYcsx) {
                        tenSp = sanPhamService.getTenSpByMaSp(ctPhieuYcsx.getMaSp());
                        Object[] row = {ctPhieuYcsx.getMaSp(), tenSp, ctPhieuYcsx.getSoLuongSx()};
                        tableModelSp.addRow(row);
                    }
                    tableDsSanPham.setModel(tableModelSp);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     
     public void showComboBox() {
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
     
     public void refreshComboBox() {
         form.getjComboBox_phieuyeucau().removeAllItems();
         showComboBox();
     }
     
     private boolean enableComboBoxEvent = true;
    private void showSpByMaYc() {
         form.getjComboBox_phieuyeucau().addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent e) {
                 if(enableComboBoxEvent && e.getStateChange() == ItemEvent.SELECTED) {
                         String maYc = (String)form.getjComboBox_phieuyeucau().getSelectedItem();
                         tableModelSp.setRowCount(0);
                          showCtYcsx(maYc);
                 }
             }            
         });
     }
    
    private void showLoSp() {
        try {
        List<LoSanPham> listLoSanPham = loSanPhamService.getAllLoSanPham();
                if(listLoSanPham != null) {
                    JTable tableLoSp = form.getjTable_phai();
                    String tenSanPham = "";
                    for(LoSanPham loSanPham : listLoSanPham) {
                        tenSanPham = sanPhamService.getTenSpByMaSp(loSanPham.getMaSp());
                        Object[] row = {loSanPham.getMaYc(), loSanPham.getSoLo(), loSanPham.getMaSp(), tenSanPham,  loSanPham.getSoLuongSp(), loSanPham.getNsx(), loSanPham.getHsd(), loSanPham.getTinhTrang()};
                        tableModelLoSp.addRow(row);
                    }
                    tableLoSp.setModel(tableModelLoSp);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    String tinhTrang = "";
    private void showCtLoSp() {
        form.getjTable_phai().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = form.getjTable_phai().getSelectedRow();
                if(selectedRow != -1) {
                    form.setMaPhieu(form.getjTable_phai().getValueAt(selectedRow, 0).toString());
                    form.setMaSX(form.getjTable_phai().getValueAt(selectedRow, 2).toString());
                    form.setTenSP(form.getjTable_phai().getValueAt(selectedRow, 3).toString());
                    form.setSoLo(form.getjTable_phai().getValueAt(selectedRow, 1).toString());
                    form.setSLSP(form.getjTable_phai().getValueAt(selectedRow, 4).toString());
                    form.setValueJDateChooser1(Date.valueOf(form.getjTable_phai().getValueAt(selectedRow, 5).toString()));
                    form.setValueJDateChooser2(Date.valueOf(form.getjTable_phai().getValueAt(selectedRow, 6).toString()));
                    tinhTrang = form.getjTable_phai().getValueAt(selectedRow, 7).toString();
                    if(tinhTrang.equals("Chua nghiem thu")) {
                      form.getjTextField_slsp().setEnabled(true);
                    } else {
                        form.getjTextField_slsp().setEnabled(false);
                    }
                }
            }     
        });
    }
    
    private void showCtSp() {
        form.getjTable_trai().getSelectionModel().addListSelectionListener(new  ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = form.getjTable_trai().getSelectedRow();
                if(selectedRow != -1) {
                    form.setMaSX(form.getjTable_trai().getValueAt(selectedRow, 0).toString());
                    form.setTenSP(form.getjTable_trai().getValueAt(selectedRow, 1).toString());
                    form.setSLSP(form.getjTable_trai().getValueAt(selectedRow, 2).toString());
                }
            }     
        });
    }
    
    private void themLoSp() {
        form.getjButton_them().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  String maYc = form.getMaPhieu();
                  String maSp = form.getMaSX();
                  int soLuong = Integer.parseInt(form.getSLSP());
                  String soLo = form.getSoLo();
                   Date ngaySx = form.getValueJDateChooser1();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate1 = dateFormat.format(ngaySx);
                    Date hsd = form.getValueJDateChooser2();
                    String formattedDate2 = dateFormat.format(hsd);
                    
                    try {
                         if(ValidateJTextField.validateFields(maYc, maSp, soLo)) {
                            if(loSanPhamService.getLoSpBySoLo(soLo) == null) {
                                LoSanPham loSanPham = new LoSanPham(soLo, maYc, maSp, soLuong, formattedDate1, formattedDate2, "Chua nghiem thu");
                                loSanPhamService.createLoSanPham(loSanPham);
                                refreshDataTable();
                                JOptionPane.showMessageDialog(form, "Thêm thành công!");
                            } else {
                                JOptionPane.showMessageDialog(form, "Lô sản phẩm đã tồn tại!");
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
    
    private void suaLoSp() {
        form.getjButton_sua().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  String maYc = form.getMaPhieu();
                  String maSp = form.getMaSX();
                  int soLuong = Integer.parseInt(form.getSLSP());
                  String soLo = form.getSoLo();
                   Date ngaySx = form.getValueJDateChooser1();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String formattedDate1 = dateFormat.format(ngaySx);
                    Date hsd = form.getValueJDateChooser2();
                    String formattedDate2 = dateFormat.format(hsd);
                    
                    try {
                         if(ValidateJTextField.validateFields(maYc, maSp, soLo)) {
                                LoSanPham loSanPham = loSanPhamService.getLoSpBySoLo(soLo);
                                loSanPham.setMaSp(maSp);
                                loSanPham.setNsx(formattedDate1);
                                loSanPham.setHsd(formattedDate2);
                                loSanPham.setSoLuongSp(soLuong);
                                loSanPhamService.updateLoSanPham(soLo, loSanPham);
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
    
    private void xoaLoSanPham() {
             form.getjButton_xoa().addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                    
                     try {
                    String soLo = form.getSoLo();
                        if(ValidateJTextField.validateFields(soLo)) {
                            int dialogResult = JOptionPane.showConfirmDialog(form, "Bạn có đồng ý xóa không?", "Xoá lô sản phẩm", JOptionPane.YES_NO_OPTION);
                            if(dialogResult == JOptionPane.YES_OPTION) {
                                if(loSanPhamService.deleteLoSanPham(soLo)) {
                                    refreshDataTable();
                                    JOptionPane.showMessageDialog(form, "Xóa thành công!");
                                } else {
                                    JOptionPane.showMessageDialog(form, "Không thể xóa lô sản phẩm!", "Error", JOptionPane.INFORMATION_MESSAGE);
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
    
    private void refreshDataTable() {
        tableModelLoSp.setRowCount(0);
        showLoSp();
    }
}
