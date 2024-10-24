/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Model.DanhSachBaoHiemModel;
import com.mycompany.Model.QuanLyBacLuongModel;
import com.mycompany.View.pDanhSachBaoHiem;
import com.mycompany.View.pQuanLyBacLuong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class DanhSachBaoHiemController {
    private pDanhSachBaoHiem form ;
    private DanhSachBaoHiemModel danhSachBaoHiemModel;
    private DefaultTableModel tableBH;

    public DanhSachBaoHiemController() {
    }

    public DanhSachBaoHiemController(pDanhSachBaoHiem form) {
        this.form = form;
        this.danhSachBaoHiemModel = new DanhSachBaoHiemModel();
         createTableQLBL();
        refreshDataTable();
        themBaoHiem(); 
        suaBaoHiem(); 
        xoaBaoHiem(); 
    }
    
     private void createTableQLBL() {
    tableBH = new DefaultTableModel(); 
    // Thêm các cột vào mô hình bảng
    tableBH.addColumn("Mã Bảo Hiểm"); 
    tableBH.addColumn("Tên bảo hiểm"); 
    tableBH.addColumn("Nội dung");
    }
    
    private void refreshDataTable() {
         List<Object[]> dsBacLuong = danhSachBaoHiemModel.danhSachBaoHiem(); 
            tableBH.setRowCount(0);
            for (Object[] nv : dsBacLuong) {
                tableBH.addRow(nv);
               
            }
            form.getjTable_dsbh().setModel(tableBH);
    }
    
 private void themBaoHiem() {
    form.getjButton1().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String maBH = form.getMaBH(); 
            String tenBH = form.getTenBH();
            String noidung = form.getNoiDungBH();
           
            if (!maBH.isEmpty() && !tenBH.isEmpty() && !noidung.isEmpty()) {
//                quanLyHoSoModel.addHoSo(maNV, tenNV, gioiTinh, ngaySinh, queQuan, sdt, tdHv);
                boolean isAdded = danhSachBaoHiemModel.addBaoHiem(maBH, tenBH, noidung);
                
                // Kiểm tra kết quả thêm
                if (isAdded) {
                    JOptionPane.showMessageDialog(form, "Thêm hồ sơ thành công!");
                    refreshDataTable(); // Làm mới bảng dữ liệu nếu cần
                } else {
                    JOptionPane.showMessageDialog(form, "Thêm hồ sơ không thành công. Vui lòng thử lại.");
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường.");
            }
        }
    });
}
 // Hàm sửa bảo hiểm
    private void suaBaoHiem() {
        form.getjButton2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maBH = form.getMaBH(); 
                String tenBH = form.getTenBH();
                String noiDung = form.getNoiDungBH();

                if (!maBH.isEmpty() && !tenBH.isEmpty() && !noiDung.isEmpty()) {
                    boolean isUpdated = danhSachBaoHiemModel.updateBaoHiem(maBH, tenBH, noiDung);

                    if (isUpdated) {
                        JOptionPane.showMessageDialog(form, "Cập nhật bảo hiểm thành công!");
                        refreshDataTable();
                    } else {
                        JOptionPane.showMessageDialog(form, "Cập nhật bảo hiểm không thành công. Vui lòng thử lại.");
                    }
                } else {
                    JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ thông tin.");
                }
            }
        });
    }
    
    // Hàm xóa bảo hiểm
    private void xoaBaoHiem() {
        form.getjButton3().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maBH = form.getMaBH();

                if (!maBH.isEmpty()) {
                    boolean isDeleted = danhSachBaoHiemModel.deleteBaoHiem(maBH);

                    if (isDeleted) {
                        JOptionPane.showMessageDialog(form, "Xóa bảo hiểm thành công!");
                        refreshDataTable();
                    } else {
                        JOptionPane.showMessageDialog(form, "Xóa bảo hiểm không thành công. Vui lòng thử lại.");
                    }
                } else {
                    JOptionPane.showMessageDialog(form, "Vui lòng nhập mã bảo hiểm để xóa.");
                }
            }
        });
    }
}
    
    
   
