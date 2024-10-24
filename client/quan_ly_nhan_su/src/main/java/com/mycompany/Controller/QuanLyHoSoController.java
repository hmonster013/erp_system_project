/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Model.QuanLyHoSoModel;
import com.mycompany.View.pQuanLyHoSoNV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyHoSoController {
    private pQuanLyHoSoNV form;
    private QuanLyHoSoModel quanLyHoSoModel;
    private DefaultTableModel tableQLHS;
    
    public QuanLyHoSoController(){}
    
    public QuanLyHoSoController(pQuanLyHoSoNV form) {
        this.form = form;
        this.quanLyHoSoModel = new QuanLyHoSoModel(); 
        createTableQLHS();
        refreshDataTable();
        themHoSoNV();
        suaHoSoNV();
        xoaHoSoNV();
        timKiemHoSoNV();
    }
       
    private void createTableQLHS() {
    tableQLHS = new DefaultTableModel(); 
    // Thêm các cột vào mô hình bảng
    tableQLHS.addColumn("Mã NVL"); 
    tableQLHS.addColumn("Tên NVL"); 
    tableQLHS.addColumn("Giới Tính"); 
    tableQLHS.addColumn("Ngày Sinh"); 
    tableQLHS.addColumn("Quê Quán"); 
    tableQLHS.addColumn("Số Điện Thoại"); 
    tableQLHS.addColumn("Trình Độ Học Vấn"); 

}
    
    private void refreshDataTable() {
         List<Object[]> dsHoSoNV = quanLyHoSoModel.danhSachHoSoNV(); 
            tableQLHS.setRowCount(0);
            for (Object[] nv : dsHoSoNV) {
                tableQLHS.addRow(nv);
               
            }
            form.getjTable_NV().setModel(tableQLHS);
    }
    
    private void themHoSoNV() {
    form.getjButton_ThemNV().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String maNV = form.getMNV(); 
            String tenNV = form.getTenNV(); 
            String gioiTinh = form.getSex(); 
            java.sql.Date ngaySinh = new java.sql.Date(form.getNgaySinh().getTime()); 
            String queQuan = form.getQueQuan(); 
            String sdt = form.getSDT(); 
            String tdHv = form.getTDHV(); 

           
            if (!maNV.isEmpty() && !tenNV.isEmpty() && !gioiTinh.isEmpty() && ngaySinh != null && !queQuan.isEmpty() && !sdt.isEmpty() && !tdHv.isEmpty()) {
//                quanLyHoSoModel.addHoSo(maNV, tenNV, gioiTinh, ngaySinh, queQuan, sdt, tdHv);
                boolean isAdded = quanLyHoSoModel.addHoSo(maNV, tenNV, gioiTinh, ngaySinh, queQuan, sdt, tdHv);
                
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
    
    private void xoaHoSoNV() {
    form.getjButton_XoaNV().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy mã nhân viên từ giao diện để xóa
            String maNV = form.getMNV();
            
            // Kiểm tra xem mã nhân viên có được nhập hay không
            if (!maNV.isEmpty()) {
                // Gọi phương thức deleteHoSo từ model để xóa hồ sơ nhân viên
                boolean isDeleted = quanLyHoSoModel.deleteHoSo(maNV);
                
                // Kiểm tra kết quả xóa
                if (isDeleted) {
                    JOptionPane.showMessageDialog(form, "Xóa hồ sơ thành công!");
                    refreshDataTable(); // Làm mới bảng dữ liệu
                } else {
                    JOptionPane.showMessageDialog(form, "Xóa hồ sơ không thành công. Vui lòng thử lại.");
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập mã nhân viên để xóa.");
            }
        }
    });
}
    
    private void suaHoSoNV() {
    form.getjButton_SuaNV().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String maNV = form.getMNV(); 
            String tenNV = form.getTenNV(); 
            String gioiTinh = form.getSex(); 
            java.sql.Date ngaySinh = new java.sql.Date(form.getNgaySinh().getTime()); 
            String queQuan = form.getQueQuan(); 
            String sdt = form.getSDT(); 
            String tdHv = form.getTDHV(); 

            // Kiểm tra xem mã nhân viên có được nhập hay không
            if (!maNV.isEmpty()) {
                if (!tenNV.isEmpty() && !gioiTinh.isEmpty() && ngaySinh != null && !queQuan.isEmpty() && !sdt.isEmpty() && !tdHv.isEmpty()) {
                    // Gọi phương thức updateHoSo từ model để cập nhật hồ sơ nhân viên
                    boolean isUpdated = quanLyHoSoModel.updateHoSo(maNV, tenNV, gioiTinh, ngaySinh, queQuan, sdt, tdHv);
                    
                    // Kiểm tra kết quả cập nhật
                    if (isUpdated) {
                        JOptionPane.showMessageDialog(form, "Cập nhật hồ sơ thành công!");
                        refreshDataTable(); // Làm mới bảng dữ liệu
                    } else {
                        JOptionPane.showMessageDialog(form, "Cập nhật hồ sơ không thành công. Vui lòng thử lại.");
                    }
                } else {
                    JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ thông tin cần cập nhật.");
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập mã nhân viên để cập nhật.");
            }
        }
    });
}
    
    private void timKiemHoSoNV() {
    form.getjButton_timkiem().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            String tenNV = form.getTenNV();
            
            
            if (!tenNV.isEmpty()) {
                // Gọi phương thức searchHoSo từ model để tìm kiếm hồ sơ nhân viên
                List<Object[]> ketQuaTimKiem = quanLyHoSoModel.searchHoSo(tenNV);
                
                
                if (!ketQuaTimKiem.isEmpty()) {
                    // Xóa dữ liệu hiện tại trong bảng
                    tableQLHS.setRowCount(0);
                    // Thêm các kết quả tìm kiếm vào bảng
                    for (Object[] nv : ketQuaTimKiem) {
                        tableQLHS.addRow(nv);
                    }
                    form.getjTable_NV().setModel(tableQLHS); // Cập nhật bảng hiển thị
                } else {
                    JOptionPane.showMessageDialog(form, "Không tìm thấy hồ sơ nhân viên với mã đã nhập.");
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập mã nhân viên để tìm kiếm.");
            }
        }
    });
}

}
    



