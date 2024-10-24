package com.mycompany.Controller;

import com.mycompany.Model.QuanLyChucVuModel;
import com.mycompany.View.pQuanLyChucVu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QuanLyChucVuController {
    private pQuanLyChucVu form;
    private QuanLyChucVuModel quanLyChucVuModel;
    private DefaultTableModel tableChucVu;

    public QuanLyChucVuController() {
    }

    public QuanLyChucVuController(pQuanLyChucVu form) {
        this.form = form;
        this.quanLyChucVuModel = new QuanLyChucVuModel();
        createTableQLCV();
        refreshDataTable();
        themChucVu();
        suaChucVu();
        xoaChucVu();
    }
    
    // Tạo bảng chức vụ
    private void createTableQLCV() {
        tableChucVu = new DefaultTableModel(); 
        // Thêm các cột vào mô hình bảng
        tableChucVu.addColumn("Mã chức vụ"); 
        tableChucVu.addColumn("Tên chức vụ"); 
        tableChucVu.addColumn("Mã bậc lương"); 
    }
    
    // Làm mới bảng dữ liệu
    private void refreshDataTable() {
        List<Object[]> dsChucVu = quanLyChucVuModel.danhSachChucVu();
        tableChucVu.setRowCount(0);
        for (Object[] cv : dsChucVu) {
            tableChucVu.addRow(cv);  // Thêm mỗi hàng vào bảng
        }
        form.getjTable_QLChucVu().setModel(tableChucVu);  // Cập nhật lại bảng
    }
    
     private void themChucVu() {
    form.getjButton_ThemCV().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String maCV = form.getMCV(); 
            String tenCV = form.getTenCV();
            String maBL = form.getMaBL();
           
            if (!maCV.isEmpty() && !tenCV.isEmpty() && !maBL.isEmpty()) {
//                quanLyHoSoModel.addHoSo(maNV, tenNV, gioiTinh, ngaySinh, queQuan, sdt, tdHv);
                boolean isAdded = quanLyChucVuModel.addChucVu(maCV, tenCV, maBL);
                
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
    
     private void suaChucVu() {
    form.getjButton_SuaCV().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy thông tin từ giao diện
            String maCV = form.getMCV(); 
            String tenCV = form.getTenCV();
            String maBL = form.getMaBL();

            if (!maCV.isEmpty() && !tenCV.isEmpty() && !maBL.isEmpty()) {
                // Gọi model để cập nhật dữ liệu
                boolean isUpdated = quanLyChucVuModel.updateChucVu(maCV, tenCV, maBL);

                // Kiểm tra kết quả sửa
                if (isUpdated) {
                    JOptionPane.showMessageDialog(form, "Sửa thông tin chức vụ thành công!");
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

     
     private void xoaChucVu() {
    form.getjButton_XoaCV().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy mã chức vụ từ giao diện
            String maCV = form.getMCV();

            if (!maCV.isEmpty()) {
                int confirm = JOptionPane.showConfirmDialog(form, "Bạn có chắc muốn xóa chức vụ này?", "Xác nhận", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    // Gọi model để xóa chức vụ
                    boolean isDeleted = quanLyChucVuModel.deleteChucVu(maCV);

                    // Kiểm tra kết quả xóa
                    if (isDeleted) {
                        JOptionPane.showMessageDialog(form, "Xóa chức vụ thành công!");
                        refreshDataTable(); // Cập nhật lại bảng dữ liệu
                    } else {
                        JOptionPane.showMessageDialog(form, "Xóa không thành công. Vui lòng thử lại.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(form, "Vui lòng chọn chức vụ để xóa.");
            }
        }
    });
}

   
    
   
}
