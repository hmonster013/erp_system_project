package com.mycompany.Model;

import com.mycompany.Connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class QuanLyHopDongModel {
    
    // Phương thức thêm hợp đồng
    public boolean addHopDong(String maHopDong, String tenHopDong, String maNV, java.sql.Date ngayBatDau, java.sql.Date ngayKetThuc, String vanBan) {
        Connection conn = null;
        try {
            conn = new DBconnection().getConnection(); 
            if (conn != null) {
                String query = "INSERT INTO HopDong (MaHopDong, TenHopDong, MaNV, NgayBatDau, NgatKetThuc, VanBan) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query); // Chuẩn bị câu truy vấn
                
                // Set các tham số cho câu truy vấn
                stmt.setString(1, maHopDong);
                stmt.setString(2, tenHopDong);
                stmt.setString(3, maNV);
                stmt.setDate(4, ngayBatDau);
                stmt.setDate(5, ngayKetThuc);
                stmt.setString(6, vanBan);
                
                int row = stmt.executeUpdate(); // Thực hiện cập nhật
                return row > 0; // Kiểm tra xem có thêm thành công không
            }
        } catch (Exception e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        } finally {
            if (conn != null) {
                try {
                    conn.close(); // Đóng kết nối khi hoàn thành
                } catch (Exception e) {
                    e.printStackTrace(); // Xử lý lỗi khi đóng kết nối
                }
            }
        }
        return false; 
    }
    
   // Phương thức lấy danh sách hợp đồng
public List<Object[]> danhSachHopDong() {
    Connection conn = null;
    List<Object[]> listHopDong = new ArrayList<>();
    try {
        conn = new DBconnection().getConnection();  // Kết nối với CSDL
        if (conn != null) {
            String query = "SELECT MaHopDong, TenHopDong, MaNV, NgayBatDau, NgatKetThuc, VanBan FROM HopDong";
            PreparedStatement stmt = conn.prepareStatement(query);  // Chuẩn bị câu truy vấn
            ResultSet rs = stmt.executeQuery();  // Thực hiện truy vấn và nhận kết quả
            
            // Lặp qua từng kết quả
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("MaHopDong"),
                    rs.getString("TenHopDong"),
                    rs.getString("MaNV"),
                    rs.getDate("NgayBatDau"),
                    rs.getDate("NgatKetThuc"),
                    rs.getString("VanBan"),      
                };
                listHopDong.add(row);  // Thêm mỗi hàng vào danh sách
            }
        }
    } catch (Exception e) {
        e.printStackTrace(); 
    } finally {
        if (conn != null) {
            try {
                conn.close();  
            } catch (Exception e) {
                e.printStackTrace();  
            }
        }
    }
    return listHopDong;  
}

    
    // Phương thức cập nhật hợp đồng
//    public boolean updateHopDong(String maHopDong, String tenHopDong, String maNV, java.sql.Date ngayBatDau, java.sql.Date ngayKetThuc, String vanBan) {
//        Connection conn = null;
//        try {
//            conn = new DBconnection().getConnection(); 
//            if (conn != null) {
//                String query = "UPDATE HopDong SET TenHopDong = ?, MaNV = ?, NgayBatDau = ?, NgayKetThuc = ?, VanBan = ? WHERE MaHopDong = ?";
//                PreparedStatement stmt = conn.prepareStatement(query); 
//                
//                // Set các tham số cho câu truy vấn
//                stmt.setString(1, tenHopDong);
//                stmt.setString(2, maNV);
//                stmt.setDate(3, ngayBatDau);
//                stmt.setDate(4, ngayKetThuc);
//                stmt.setString(5, vanBan);
//                stmt.setString(6, maHopDong);
//                
//                int row = stmt.executeUpdate(); 
//                return row > 0; // Kiểm tra xem có cập nhật thành công không
//            }
//        } catch (Exception e) {
//            e.printStackTrace(); 
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close(); 
//                } catch (Exception e) {
//                    e.printStackTrace(); 
//                }
//            }
//        }
//        return false; 
//    }
//    
//    // Phương thức xóa hợp đồng
//    public boolean deleteHopDong(String maHopDong) {
//        Connection conn = null;
//        try {
//            conn = new DBconnection().getConnection(); 
//            if (conn != null) {
//                String query = "DELETE FROM HopDong WHERE MaHopDong = ?";
//                PreparedStatement stmt = conn.prepareStatement(query);
//                
//                // Set tham số cho câu truy vấn
//                stmt.setString(1, maHopDong);
//                
//                int row = stmt.executeUpdate(); 
//                return row > 0; // Kiểm tra xem có xóa thành công không
//            }
//        } catch (Exception e) {
//            e.printStackTrace(); 
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close(); 
//                } catch (Exception e) {
//                    e.printStackTrace(); 
//                }
//            }
//        }
//        return false; 
//    }
}
