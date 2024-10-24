package com.mycompany.Model;

import com.mycompany.Connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuanLyChucVuModel {

    // Phương thức lấy danh sách chức vụ
    public List<Object[]> danhSachChucVu() {
        Connection conn = null;
        List<Object[]> listChucVu = new ArrayList<>();
        try {
            // Kết nối đến cơ sở dữ liệu
            conn = new DBconnection().getConnection();
            if (conn != null) {
                String query = "SELECT MaCV, TenCV, MaBL FROM ChucVu";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                
                // Lặp qua từng kết quả
                while (rs.next()) {
                    Object[] row = new Object[]{
                        rs.getString("MaCV"),      // Mã Chức Vụ
                        rs.getString("TenCV"),     // Tên Chức Vụ
                        rs.getString("MaBL")       // Mã Bậc Lương (liên kết khóa ngoại)
                    };
                    listChucVu.add(row);  // Thêm mỗi hàng vào danh sách
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();  // Đóng kết nối
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return listChucVu;  // Trả về danh sách chức vụ
    }

    // Phương thức thêm mới chức vụ
    public boolean addChucVu(String maCV, String tenCV, String maBL) {
        Connection conn = null;
        try {
            // Kết nối đến cơ sở dữ liệu
            conn = new DBconnection().getConnection();
            if (conn != null) {
                String query = "INSERT INTO ChucVu (MaCV, TenCV, MaBL) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                
                // Set các tham số cho câu truy vấn
                stmt.setString(1, maCV);
                stmt.setString(2, tenCV);
                stmt.setString(3, maBL);
                
                int row = stmt.executeUpdate();  // Thực hiện cập nhật
                return row > 0;  // Kiểm tra xem có thêm thành công không
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();  // Đóng kết nối
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;  // Trả về false nếu thêm không thành công
    }

    // Phương thức cập nhật thông tin chức vụ
    public boolean updateChucVu(String maCV, String tenCV, String maBL) {
        Connection conn = null;
        try {
            // Kết nối đến cơ sở dữ liệu
            conn = new DBconnection().getConnection();
            if (conn != null) {
                String query = "UPDATE ChucVu SET TenCV = ?, MaBL = ? WHERE MaCV = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                
                // Set các tham số cho câu truy vấn
                stmt.setString(1, tenCV);
                stmt.setString(2, maBL);
                stmt.setString(3, maCV);
                
                int row = stmt.executeUpdate();  // Thực hiện cập nhật
                return row > 0;  // Kiểm tra xem có cập nhật thành công không
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();  // Đóng kết nối
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;  // Trả về false nếu cập nhật không thành công
    }

    // Phương thức xóa chức vụ
    public boolean deleteChucVu(String maCV) {
        Connection conn = null;
        try {
            // Kết nối đến cơ sở dữ liệu
            conn = new DBconnection().getConnection();
            if (conn != null) {
                String query = "DELETE FROM ChucVu WHERE MaCV = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                
                // Set tham số cho câu truy vấn
                stmt.setString(1, maCV);
                
                int row = stmt.executeUpdate();  // Thực hiện xóa
                return row > 0;  // Kiểm tra xem có xóa thành công không
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();  // Đóng kết nối
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;  // Trả về false nếu xóa không thành công
    }
}
