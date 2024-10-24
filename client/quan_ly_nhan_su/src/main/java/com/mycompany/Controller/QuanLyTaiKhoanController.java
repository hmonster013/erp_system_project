/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Model.QuanLyTaiKhoanModel;
import com.mycompany.View.pQuanLyTaiKhoan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyTaiKhoanController {
    private  pQuanLyTaiKhoan form;
    private QuanLyTaiKhoanModel quanLyTaiKhoanModel;
    private DefaultTableModel tableQLTK;

    public QuanLyTaiKhoanController() {
    }

    public QuanLyTaiKhoanController(pQuanLyTaiKhoan form) {
        this.form = form;
        this.quanLyTaiKhoanModel = new QuanLyTaiKhoanModel();
        createTableQLTK();
        refreshDataTable();
        themTaiKhoan();
        suaTaiKhoan();
        xoaTaiKhoan();
    }
    
    private void createTableQLTK() {
    tableQLTK = new DefaultTableModel(); 
    // Thêm các cột vào mô hình bảng
    tableQLTK.addColumn("Username"); 
    tableQLTK.addColumn("Password"); 
    tableQLTK.addColumn("Mã nhân viên"); 
    }
    
     private void refreshDataTable() {
         List<Object[]> dsTaiKhoan = quanLyTaiKhoanModel.danhSachTaiKhoan(); 
            tableQLTK.setRowCount(0);
            for (Object[] nv : dsTaiKhoan) {
                tableQLTK.addRow(nv);
               
            }
            form.getjTable_QLTaiKhoan().setModel(tableQLTK);
    }
     
     private void themTaiKhoan() {
    form.getjButton_ThemTK().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String userName = form.getLogin(); 
            String passWord = form.getPassword();
            String maNV = form.getMNV();
           
            if (!userName.isEmpty() && !passWord.isEmpty() && !maNV.isEmpty()) {
//                quanLyHoSoModel.addHoSo(maNV, tenNV, gioiTinh, ngaySinh, queQuan, sdt, tdHv);
                boolean isAdded = quanLyTaiKhoanModel.addTaiKhoan(userName, passWord, maNV);
                
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
     
     private void suaTaiKhoan() {
    form.getjButton_SuaTK().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String userName = form.getLogin(); 
            String passWord = form.getPassword();
            String maNV = form.getMNV();
            
            if (!userName.isEmpty() && !passWord.isEmpty() && !maNV.isEmpty()) {
                boolean isUpdated = quanLyTaiKhoanModel.updateTaiKhoan(userName, passWord, maNV);
                
                // Kiểm tra kết quả cập nhật
                if (isUpdated) {
                    JOptionPane.showMessageDialog(form, "Cập nhật tài khoản thành công!");
                    refreshDataTable(); // Làm mới bảng dữ liệu nếu cần
                } else {
                    JOptionPane.showMessageDialog(form, "Cập nhật tài khoản không thành công. Vui lòng thử lại.");
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường.");
            }
        }
    });
}

    private void xoaTaiKhoan() {
    form.getjButton_XoaTK().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy tên đăng nhập từ giao diện
            String userName = form.getLogin(); 
            
            if (!userName.isEmpty()) {
                int confirm = JOptionPane.showConfirmDialog(form, "Bạn có chắc chắn muốn xóa tài khoản này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    boolean isDeleted = quanLyTaiKhoanModel.deleteTaiKhoan(userName);
                    
                    // Kiểm tra kết quả xóa
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(form, "Xóa tài khoản thành công!");
                        refreshDataTable(); // Làm mới bảng dữ liệu nếu cần
                    } else {
                        JOptionPane.showMessageDialog(form, "Xóa tài khoản không thành công. Vui lòng thử lại.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập tên đăng nhập cần xóa.");
            }
        }
    });
}

    
}
