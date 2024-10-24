/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Model.QuanLyBacLuongModel;
import com.mycompany.Model.QuanLyHoSoModel;
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
public class QuanLyBacLuongController {
    private pQuanLyBacLuong form ;
    private QuanLyBacLuongModel quanLyBacLuongModel;
    private DefaultTableModel tableQLBL;

    public QuanLyBacLuongController() {
    }

    public QuanLyBacLuongController(pQuanLyBacLuong form) {
        this.form = form;
        this.quanLyBacLuongModel = new QuanLyBacLuongModel();
        createTableQLBL();
        refreshDataTable();
        themBacLuong();
        suaBacLuong();
        xoaBacLuong();
    }
    
    private void createTableQLBL() {
    tableQLBL = new DefaultTableModel(); 
    // Thêm các cột vào mô hình bảng
    tableQLBL.addColumn("Mã Bậc lương"); 
    tableQLBL.addColumn("Lương cơ bản"); 
    tableQLBL.addColumn("HS lương");
    tableQLBL.addColumn("HS phụ cấp");
    }
    
    private void refreshDataTable() {
         List<Object[]> dsBacLuong = quanLyBacLuongModel.danhSachBacLuong(); 
            tableQLBL.setRowCount(0);
            for (Object[] nv : dsBacLuong) {
                tableQLBL.addRow(nv);
               
            }
            form.getjTable_QLBacLuong().setModel(tableQLBL);
    }
    
    private void themBacLuong() {
    form.getjButton_ThemBL().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String maBL = form.getMBL();
            String luongCBStr = form.getLuongCB();
            String hsLuongStr = form.getHSL();
            String hsPhucapStr = form.getHSPC();
           
            // Kiểm tra xem các trường có rỗng hay không
            if (!maBL.isEmpty() && !luongCBStr.isEmpty() && !hsLuongStr.isEmpty() && !hsPhucapStr.isEmpty()) {
                try {
                    // Chuyển đổi các giá trị sang kiểu int
                    int luongCB = Integer.parseInt(luongCBStr);
                    int hsLuong = Integer.parseInt(hsLuongStr);
                    int hsPhucap = Integer.parseInt(hsPhucapStr);

                    // Thêm bậc lương vào cơ sở dữ liệu
                    boolean isAdded = quanLyBacLuongModel.addBacLuong(maBL, luongCB, hsLuong, hsPhucap);
                    
                    // Kiểm tra kết quả thêm
                    if (isAdded) {
                        JOptionPane.showMessageDialog(form, "Thêm thành công!");
                        refreshDataTable(); // Làm mới bảng dữ liệu nếu cần
                    } else {
                        JOptionPane.showMessageDialog(form, "Thêm không thành công. Vui lòng thử lại.");
                    }
                } catch (NumberFormatException ex) {
                    // Hiển thị thông báo nếu có lỗi chuyển đổi dữ liệu
                    JOptionPane.showMessageDialog(form, "Vui lòng nhập các giá trị số hợp lệ cho Lương cơ bản, Hệ số lương và Hệ số phụ cấp.");
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường.");
            }
        }
    });
}

    private void suaBacLuong() {
    form.getjButton_SuaBL().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           
            String maBL = form.getMBL();
            String luongCBStr = form.getLuongCB();
            String hsLuongStr = form.getHSL();
            String hsPhucapStr = form.getHSPC();
           
           
            if (!maBL.isEmpty() && !luongCBStr.isEmpty() && !hsLuongStr.isEmpty() && !hsPhucapStr.isEmpty()) {
                try {
                    int luongCB = Integer.parseInt(luongCBStr);
                    int hsLuong = Integer.parseInt(hsLuongStr);
                    int hsPhucap = Integer.parseInt(hsPhucapStr);

                    boolean isUpdated = quanLyBacLuongModel.updateBacLuong(maBL, luongCB, hsLuong, hsPhucap);
                    
                    // Kiểm tra kết quả cập nhật
                    if (isUpdated) {
                        JOptionPane.showMessageDialog(form, "Cập nhật thành công!");
                        refreshDataTable(); 
                    } else {
                        JOptionPane.showMessageDialog(form, "Cập nhật không thành công. Vui lòng thử lại.");
                    }
                } catch (NumberFormatException ex) {
                    // Hiển thị thông báo nếu có lỗi chuyển đổi dữ liệu
                    JOptionPane.showMessageDialog(form, "Vui lòng nhập các giá trị số hợp lệ cho Lương cơ bản, Hệ số lương và Hệ số phụ cấp.");
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường.");
            }
        }
    });
}
    
    private void xoaBacLuong() {
    form.getjButton_XoaBL().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String maBL = form.getMBL();
           
            if (!maBL.isEmpty()) {
                boolean isDeleted = quanLyBacLuongModel.deleteBacLuong(maBL);
                
                if (isDeleted) {
                    JOptionPane.showMessageDialog(form, "Xóa thành công!");
                    refreshDataTable(); // Làm mới bảng dữ liệu nếu cần
                } else {
                    JOptionPane.showMessageDialog(form, "Xóa không thành công. Vui lòng thử lại.");
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập mã bậc lương để xóa.");
            }
        }
    });
}


    
    
}
