/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Model.QuanLyBoPhanModel;
import com.mycompany.View.pQuanLyBoPhan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyBoPhanController {
    private pQuanLyBoPhan form;
    private QuanLyBoPhanModel quanLyBoPhanModel;
    private DefaultTableModel tableBoPhan;

    public QuanLyBoPhanController() {
    }

    public QuanLyBoPhanController(pQuanLyBoPhan form) {
        this.form = form;
        this.quanLyBoPhanModel = new QuanLyBoPhanModel();
        createTableQLBP();
        refreshDataTable();
        themBoPhan();
        suaBoPhan();
        xoaBoPhan();
    }
    
    private void createTableQLBP() {
    tableBoPhan = new DefaultTableModel(); 
    // Thêm các cột vào mô hình bảng
    tableBoPhan.addColumn("Mã bộ phận"); 
    tableBoPhan.addColumn("Tên bộ phận "); 
    tableBoPhan.addColumn("Số điện thoại"); 
    }
    
     private void refreshDataTable() {
         List<Object[]> dsBoPhan = quanLyBoPhanModel.danhSacBoPhan();
            tableBoPhan.setRowCount(0);
            for (Object[] nv : dsBoPhan) {
                tableBoPhan.addRow(nv);
               
            }
            form.getjTable_QLBoPhan().setModel(tableBoPhan);
    }
    
      private void themBoPhan() {
    form.getjButton_ThemBP().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String maBP = form.getMBP(); 
            String tenBP = form.getTenBP();
            String sdt = form.getSdt();
           
            if (!maBP.isEmpty() && !tenBP.isEmpty() && !sdt.isEmpty()) {
//                quanLyHoSoModel.addHoSo(maNV, tenNV, gioiTinh, ngaySinh, queQuan, sdt, tdHv);
                boolean isAdded = quanLyBoPhanModel.addTaiKhoan(maBP, tenBP, sdt);
                
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
      
      private void suaBoPhan() {
    form.getjButton_SuaBP().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String maBP = form.getMBP(); 
            String tenBP = form.getTenBP();
            String sdt = form.getSdt();

            if (!maBP.isEmpty() && !tenBP.isEmpty() && !sdt.isEmpty()) {
                boolean isUpdated = quanLyBoPhanModel.updateBoPhan(maBP, tenBP, sdt);
                
                // Kiểm tra kết quả sửa
                if (isUpdated) {
                    JOptionPane.showMessageDialog(form, "Sửa thông tin bộ phận thành công!");
                    refreshDataTable(); // Làm mới bảng dữ liệu
                } else {
                    JOptionPane.showMessageDialog(form, "Sửa không thành công. Vui lòng thử lại.");
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường.");
            }
        }
    });
}
      
      private void xoaBoPhan() {
    form.getjButton_XoaBP().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy mã bộ phận từ giao diện
            String maBP = form.getMBP();
            
            if (!maBP.isEmpty()) {
                int confirm = JOptionPane.showConfirmDialog(form, "Bạn có chắc muốn xóa bộ phận này?", "Xác nhận", JOptionPane.YES_NO_OPTION);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    boolean isDeleted = quanLyBoPhanModel.deleteBoPhan(maBP);
                    
                    // Kiểm tra kết quả xóa
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(form, "Xóa bộ phận thành công!");
                        refreshDataTable(); // Cập nhật lại bảng dữ liệu
                    } else {
                        JOptionPane.showMessageDialog(form, "Xóa không thành công. Vui lòng thử lại.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng chọn bộ phận để xóa.");
            }
        }
    });
}

    
}
