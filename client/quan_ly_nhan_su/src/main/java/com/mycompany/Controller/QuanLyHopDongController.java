/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Model.DanhSachBaoHiemModel;
import com.mycompany.Model.QuanLyHopDongModel;
import com.mycompany.View.pDanhSachBaoHiem;
import com.mycompany.View.pQuanLyHopDong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyHopDongController {
    private pQuanLyHopDong form ;
    private QuanLyHopDongModel quanLyHopDongModel;
    private DefaultTableModel tableHopDong;

    public QuanLyHopDongController() {
    }

    public QuanLyHopDongController(pQuanLyHopDong form) {
        this.form = form;
        this.quanLyHopDongModel= new QuanLyHopDongModel();
        createTableQLHD();
        refreshDataTable();
        themHopDong();
    }
    
    

    
     private void createTableQLHD() {
    tableHopDong = new DefaultTableModel(); 
    // Thêm các cột vào mô hình bảng
    tableHopDong.addColumn("Mã hợp đồng"); 
    tableHopDong.addColumn("Tên hợp đồng"); 
    tableHopDong.addColumn("Mã nhân viên");
    tableHopDong.addColumn("Ngày bắt đầu ");
    tableHopDong.addColumn("Ngày kết thúc");
    tableHopDong.addColumn("Văn bản");
    }
    
    private void refreshDataTable() {
         List<Object[]> dsBacLuong = quanLyHopDongModel.danhSachHopDong(); 
            tableHopDong.setRowCount(0);
            for (Object[] nv : dsBacLuong) {
                tableHopDong.addRow(nv);
               
            }
            form.getjTable_HopDong().setModel(tableHopDong);
    }
    
    private void themHopDong() {
    form.getButton_ThemHD().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String maHD = form.getMHD(); // Mã hợp đồng
            String tenHD = form.getTenHD(); // Tên hợp đồng
            String maNV = form.getMNV(); // Mã nhân viên
            java.util.Date ngayBatDau = form.getStartDate(); // Ngày bắt đầu
            java.util.Date ngayKetThuc = form.getEndDate(); // Ngày kết thúc
            String vanBan = form.getVanBan(); // Văn bản hợp đồng

            if (!maHD.isEmpty() && !tenHD.isEmpty() && maNV != null && ngayBatDau != null && ngayKetThuc != null && !vanBan.isEmpty()) {
                // Thêm hợp đồng
                boolean isAdded = quanLyHopDongModel.addHopDong(maHD, tenHD, maNV, new java.sql.Date(ngayBatDau.getTime()), new java.sql.Date(ngayKetThuc.getTime()), vanBan);
                
                // Kiểm tra kết quả thêm
                if (isAdded) {
                    JOptionPane.showMessageDialog(form, "Thêm hợp đồng thành công!");
                    refreshDataTable(); // Làm mới bảng dữ liệu
                } else {
                    JOptionPane.showMessageDialog(form, "Thêm hợp đồng không thành công. Vui lòng thử lại.");
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường.");
            }
        }
    });
}

    
}
