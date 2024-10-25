/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLK.Controller;

import com.mycompany.QLK.API.CtDonHangService;
import com.mycompany.QLK.API.CtPhieuXuatService;
import com.mycompany.QLK.API.PhieuXuatSpService;
import com.mycompany.QLK.API.DonHangService;
import com.mycompany.QLK.API.SanPhamService;
import com.mycompany.Entity.CtDonHang;
import com.mycompany.Entity.CtPhieuXuatSp;
import com.mycompany.Entity.DonHang;
import com.mycompany.Entity.PhieuXuatSp;
import com.mycompany.Entity.SanPham;
import com.mycompany.Validate.ValidateJSpinner;
import com.mycompany.Validate.ValidateJTextField;
import com.mycompany.View.pDonHang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class DonHangController {
         private pDonHang form;
         private DonHangService donHangService;
         private CtDonHangService ctDonHangService;
         private SanPhamService sanPhamService;
         private PhieuXuatSpService phieuXuatSpService;
         private CtPhieuXuatService ctPhieuXuatSpService;
         private DefaultTableModel tableModelDonHang;
         private DefaultTableModel tableModeCtlDonHang;
         private String tenSanPham = "";
         private String maDh = "";
         private String maNv;
    
         public DonHangController() {}
    
         public DonHangController(pDonHang form, String maNv) {
        this.form = form;
        this.maNv = maNv;
        this.donHangService = new DonHangService();
        this.ctDonHangService = new CtDonHangService();
        this.sanPhamService = new SanPhamService();
        this.phieuXuatSpService = new PhieuXuatSpService();
        this.ctPhieuXuatSpService = new CtPhieuXuatService();
        createTable("Đơn Hàng");
        createTable("CtDonHang");
        showDanhSachTable();
        showCtDonDh();
        taoPhieuXuat();
        showTtCtDonHang();
        xuatKhoSp();
        capNhatTtDh();
    }
    
         private void createTable(String tableName) {
        if(tableName.equals("Đơn Hàng")) {
            tableModelDonHang = new DefaultTableModel();
            tableModelDonHang.addColumn("Mã đơn");
            tableModelDonHang.addColumn("Tên KH");
            tableModelDonHang.addColumn("Ngày đặt");
            tableModelDonHang.addColumn("Ngày giao");
            tableModelDonHang.addColumn("Ngày trạng thái");
        } else {   
            tableModeCtlDonHang = new DefaultTableModel();
            tableModeCtlDonHang.addColumn("Mã mặt hàng");
            tableModeCtlDonHang.addColumn("Tên mặt hàng");
            tableModeCtlDonHang.addColumn("Số lượng đặt");
        }
    }
     
         private void showDanhSachTable() {
        try {      
                List<DonHang> listDonHang = donHangService.getAllDonHang();
                if(listDonHang != null) {
                    JTable tableDonHang = form.getjTable_donHang();           
                    for(DonHang donHang : listDonHang) {
                        Object[] row = {donHang.getMaDdh(), donHang.getMaKh(), donHang.getNgayLap(), donHang.getNgayGiao(), donHang.getTinhTrang()};
                        tableModelDonHang.addRow(row);
                    }
                    tableDonHang.setModel(tableModelDonHang);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
     
         private void showChiTietDonHang(String maDh) {
            try { 
                    tableModeCtlDonHang.setRowCount(0);
                    List<CtDonHang> listCtDonHang = ctDonHangService.getAllCtDonHangByMaDh(maDh);
                    if(listCtDonHang != null) {
                        JTable tableCtDonHang = form.getjTable_chiTietDH();        
                        for(CtDonHang ctDonHang : listCtDonHang) {
                            tenSanPham = sanPhamService.getTenSpByMaSp(ctDonHang.getMaSp());
                            Object[] row = {ctDonHang.getMaSp(), tenSanPham, ctDonHang.getSoLuong()};
                            tableModeCtlDonHang.addRow(row);
                        }
                        tableCtDonHang.setModel(tableModeCtlDonHang);
                    }  
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         }
     
         private void showCtDonDh() {
         form.getjTable_donHang().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
             @Override
             public void valueChanged(ListSelectionEvent e) {
                 int selectedRow = form.getjTable_donHang().getSelectedRow();
                 if(selectedRow != -1) {
                     maDh = form.getjTable_donHang().getValueAt(selectedRow, 0).toString();
                     form.setMaDH(maDh);
                     showChiTietDonHang(maDh);
                 }
             }       
         });
     }
     
         private void showTtCtDonHang() {
         form.getjTable_chiTietDH().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
             @Override
             public void valueChanged(ListSelectionEvent e) {
                 int selectedRow = form.getjTable_chiTietDH().getSelectedRow();
                 if(selectedRow != -1) {
                     form.setMaMH(form.getjTable_chiTietDH().getValueAt(selectedRow, 0).toString());
                     form.setTenMH(form.getjTable_chiTietDH().getValueAt(selectedRow, 1).toString());
                     form.setValueJSpinnerSoLuongXuat(Integer.parseInt(form.getjTable_chiTietDH().getValueAt(selectedRow, 2).toString()));
                 }
             }       
         });
     }
     
         private void taoPhieuXuat() {
         form.getjButton_taoPhieu().addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     
                   String maPx = form.getMaPX();
                   Date ngayXuat = form.getValueJDateChooserNgayXuat();
                   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                   String formattedDate = dateFormat.format(ngayXuat);
                   
                   if(!ValidateJTextField.validateFields(maPx)) {
                       JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường!");
                   }  else {
                       if(phieuXuatSpService.getPhieuXuatByMaPhieu(maPx) == null) {
                        PhieuXuatSp phieuXuatSp = new PhieuXuatSp(maPx, maDh, formattedDate, maNv);

                        phieuXuatSpService.createPhieuXuatSanPham(phieuXuatSp);

                        JOptionPane.showMessageDialog(form, "Tạo phiếu thành công!");
                        form.getjButton_xuatKho().setEnabled(true);
                       } else {
                           JOptionPane.showMessageDialog(form, "Phiếu đã tồn tại!");
                       }
                   }                                                  
                 } catch(IOException ex) {
                     ex.printStackTrace();
                 }
             }         
         });
     }
         
         private void xuatKhoSp() {
             form.getjButton_xuatKho().addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     try {
                                  
                         int selectedRow = form.getjTable_chiTietDH().getSelectedRow();
                         int soLuong = Integer.parseInt(form.getValueJSpinnerSoLuongXuat());
                         
                         if(selectedRow != -1) {
                           if(ValidateJSpinner.validateSpinners(soLuong)) {
                                String maPx = form.getMaPX();
                                String maMh = form.getMaMH();
                                                 
                                String maSp = form.getjTable_chiTietDH().getValueAt(selectedRow, 0).toString();
                                int soLuongXuat = Integer.parseInt(form.getValueJSpinnerSoLuongXuat());
                                int soLuongDat = Integer.parseInt(form.getjTable_chiTietDH().getValueAt(selectedRow, 2).toString());
                                int soLuongTonKho = sanPhamService.getSanPhamByMaSp(maSp).getSoLuongTon();

                               if(soLuongTonKho <= 0) {
                                   JOptionPane.showMessageDialog(form, "Số lượng sản phẩm trong kho đã hết!");
                               } else if(soLuongDat > soLuongTonKho) {
                                   JOptionPane.showMessageDialog(form, "Số lượng sản phẩm tồn kho không đủ!");
                               } else if(soLuongXuat > soLuongDat) {
                                   JOptionPane.showMessageDialog(form, "Số lượng xuất vượt quá số lượng dặt!");
                               }else {
                                  soLuongTonKho -= soLuongDat;

                                CtPhieuXuatSp ctPhieuXuatSp = new CtPhieuXuatSp(maPx, maMh, soLuong);
                                ctPhieuXuatSpService.createCtPhieuXuatSanPham(ctPhieuXuatSp);
                                   
                                 SanPham sanPham = sanPhamService.getSanPhamByMaSp(maSp);
                                 sanPham.setSoLuongTon(soLuongTonKho);

                                 sanPhamService.updateSanPham(maSp, sanPham);

                                  JOptionPane.showMessageDialog(form, "Xuất kho thành công!");
                                  form.getjButton_xuatKho().setEnabled(false);
                                  form.getjButton_capNhat().setEnabled(true);
                               }
                             } else {
                                 JOptionPane.showMessageDialog(form, "Vui lòng chọn số lượng xuất hợp lệ!");
                             }
                         }                        
                     } catch (IOException ex) {
                         ex.printStackTrace();
                     }
                 }              
             });
         }     
         
         private void capNhatTtDh() {
             form.getjButton_capNhat().addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     try {
                        DonHang donHang = donHangService.getDonHangByMaDh(maDh);
                        String trangThaiDh = "";
                        if(form.getjRadioButton_dangXuLy().isSelected()) {
                            trangThaiDh = "Đang xử lý";
                        } else {
                            trangThaiDh = "Đã xuất kho";
                        }
                        donHang.setTinhTrang(trangThaiDh);
                        donHangService.updateDonHang(maDh, donHang);
                        refreshDataTable();
                        JOptionPane.showMessageDialog(form, "Cập nhật trạng thái thành công!");
                     } catch(IOException ex) {
                         ex.printStackTrace();
                     }
                 }            
             });
         }
         
         private void refreshDataTable()  {     
                tableModelDonHang.setRowCount(0);
                showDanhSachTable();
        }
}
