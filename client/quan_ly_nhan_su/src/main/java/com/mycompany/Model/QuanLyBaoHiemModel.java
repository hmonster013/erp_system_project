package com.mycompany.Model;

import com.mycompany.Connection.DBconnection;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuanLyBaoHiemModel {

    // Phương thức lấy thông tin bảo hiểm và nhân viên thông qua stored procedure
    public List<Object[]> getThongTinBaoHiemNhanVien() {
        Connection conn = null;
        List<Object[]> listBaoHiemNhanVien = new ArrayList<>();
        try {
            // Kết nối đến cơ sở dữ liệu
            conn = new DBconnection().getConnection();  
            
            if (conn != null) {
                // Gọi stored procedure GetThongTinBaoHiemNhanVien
                CallableStatement stmt = conn.prepareCall("{CALL GetThongTinBaoHiemNhanVien()}");  // Gọi thủ tục lưu trữ
                
                // Thực hiện câu lệnh truy vấn
                ResultSet rs = stmt.executeQuery();
                
                // Lặp qua từng kết quả
                while (rs.next()) {
                    Object[] row = new Object[]{
                        rs.getString("MaNV"),       
                        rs.getString("TenNV"),      
                        rs.getString("MaBaoHiem"),  
                        rs.getString("TenBaoHiem"), 
                        rs.getString("NoiDungBH")   
                    };
                    listBaoHiemNhanVien.add(row);  // Thêm mỗi hàng vào danh sách
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            if (conn != null) {
                try {
                    conn.close();  // Đóng kết nối khi hoàn thành
                } catch (Exception e) {
                    e.printStackTrace();  
                }
            }
        }
        return listBaoHiemNhanVien;  // Trả về danh sách kết quả
    }
    
    public boolean addBaoHiem(String maNV, String maBH) {
        Connection conn = null;
        try {
            conn = new DBconnection().getConnection(); 
            if (conn != null) {
                String query = "INSERT INTO NV_BaoHiem (MaBaoHiem, MaNV) VALUES (?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query); 

                // Set các tham số cho câu truy vấn
                stmt.setString(1, maBH);
                stmt.setString(2, maNV);

                int row = stmt.executeUpdate();
                return row > 0;
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
        return false; 
    }
    
    public boolean deleteBaoHiem(String maNV, String maBH) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            // Xóa bảo hiểm dựa trên mã nhân viên (MaNV) và mã bảo hiểm (MaBaoHiem)
            String query = "DELETE FROM NV_BaoHiem WHERE MaNV = ? AND MaBaoHiem = ?";
            PreparedStatement stmt = conn.prepareStatement(query); 

            // Set các tham số cho câu truy vấn
            stmt.setString(1, maNV);  // Mã nhân viên
            stmt.setString(2, maBH);  // Mã bảo hiểm

            int row = stmt.executeUpdate();
            return row > 0;  // Trả về true nếu xóa thành công
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
    return false;  // Trả về false nếu xóa thất bại
}

    
    
}
