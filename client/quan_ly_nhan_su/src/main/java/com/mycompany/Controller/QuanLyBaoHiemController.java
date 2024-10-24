/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Model.QuanLyBaoHiemModel;
import com.mycompany.View.pQuanLyBaoHiem;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QuanLyBaoHiemController {
    private pQuanLyBaoHiem form;
    private QuanLyBaoHiemModel quanLyBaoHiemModel;
    private DefaultTableModel tableBaoHiem;

    public QuanLyBaoHiemController() {
    }

    public QuanLyBaoHiemController(pQuanLyBaoHiem form) {
        this.form = form;
        this.quanLyBaoHiemModel = new QuanLyBaoHiemModel();
        createTableQLBH();
        refreshDataTable();
    }
    
     private void createTableQLBH() {
    tableBaoHiem = new DefaultTableModel(); 
    // Thêm các cột vào mô hình bảng
    tableBaoHiem.addColumn("Mã nhân viên"); 
    tableBaoHiem.addColumn("Tên nhân viên"); 
    tableBaoHiem.addColumn("Mã bảo hiểm ");
    tableBaoHiem.addColumn("Tên bảo hiểm");
    tableBaoHiem.addColumn("Nội dung bảo hiểm");
    }
    
    public void refreshDataTable() {
         List<Object[]> dsBaoHiem = quanLyBaoHiemModel.getThongTinBaoHiemNhanVien(); 
            tableBaoHiem.setRowCount(0);
            for (Object[] nv : dsBaoHiem) {
                tableBaoHiem.addRow(nv);
               
            }
            form.getjTable_QLBaoHiem().setModel(tableBaoHiem);
    }
    
    public String addBaoHiem(String maNV, String maBH) {
        Boolean result = quanLyBaoHiemModel.addBaoHiem(maNV, maBH);
        if (result) {
            return "Đã thêm thành công";
        } else {
            return "Thất bại";
        }
    }
    
    public boolean deleteBaoHiem(String maNV, String maBH) {
    // Gọi phương thức xóa từ model để xóa bảo hiểm dựa trên mã nhân viên và mã bảo hiểm
    boolean result = quanLyBaoHiemModel.deleteBaoHiem(maNV, maBH);

    // Kiểm tra kết quả trả về từ model
    if (result) {
        // Làm mới lại bảng dữ liệu nếu xóa thành công
        refreshDataTable();
        return true;
    } else {
        return false;
    }
}

}
