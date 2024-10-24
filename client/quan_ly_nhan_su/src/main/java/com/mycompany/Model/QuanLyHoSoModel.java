/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Model;

import com.mycompany.Connection.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class QuanLyHoSoModel {
public boolean addHoSo(String maNV, String tenNV, String gioiTinh, java.sql.Date ngaySinh, String queQuan, String sdt, String tdHv) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "INSERT INTO ThongTinNhanVien (MaNV, TenNV, GioiTinh, NgaySinh, QueQuan, SDT, TDHV) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query); // Chuẩn bị câu truy vấn
            
            // Set các tham số cho câu truy vấn
            stmt.setString(1, maNV);
            stmt.setString(2, tenNV);
            stmt.setString(3, gioiTinh);
            stmt.setDate(4, ngaySinh); // Chuyển đổi ngày sinh
            stmt.setString(5, queQuan);
            stmt.setString(6, sdt);
            stmt.setString(7, tdHv);
            
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
    return false; // Trả về false nếu không thành công
}
   
   public List<Object[]> danhSachHoSoNV() {
    Connection conn = null;
    List<Object[]> listNV = new ArrayList<>();
    try {
         conn = new DBconnection().getConnection();  // Kết nối với CSDL
        if (conn != null) {
            String query = "SELECT MaNV, TenNV, GioiTinh, NgaySinh, QueQuan, SDT, TDHV FROM ThongTinNhanVien";
            PreparedStatement stmt = conn.prepareStatement(query);  // Chuẩn bị câu truy vấn
            ResultSet rs = stmt.executeQuery();  // Thực hiện truy vấn và nhận kết quả
            
            // Lặp qua từng kết quả
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("MaNV"),      
                    rs.getString("TenNV"),     
                    rs.getString("GioiTinh"),  
                    rs.getDate("NgaySinh"),    
                    rs.getString("QueQuan"),   
                    rs.getString("SDT"),       
                    rs.getString("TDHV")      
                };
                listNV.add(row);  // Thêm mỗi hàng vào danh sách
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
    return listNV;  // Trả về danh sách nhân viên
}
   
   public boolean deleteHoSo(String maNV) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "DELETE FROM ThongTinNhanVien WHERE MaNV = ?";
            PreparedStatement stmt = conn.prepareStatement(query); // Chuẩn bị câu truy vấn
            
            stmt.setString(1, maNV);
            
            int row = stmt.executeUpdate(); // Thực hiện câu lệnh xóa
            return row > 0; // Trả về true nếu xóa thành công
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
    return false; // Trả về false nếu không thành công
}
   
  public boolean updateHoSo(String maNV, String tenNV, String gioiTinh, java.sql.Date ngaySinh, String queQuan, String sdt, String tdHv) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "UPDATE ThongTinNhanVien SET TenNV = ?, GioiTinh = ?, NgaySinh = ?, QueQuan = ?, SDT = ?, TDHV = ? WHERE MaNV = ?";
            PreparedStatement stmt = conn.prepareStatement(query); // Chuẩn bị câu truy vấn
            
            // Set các tham số cho câu truy vấn
            stmt.setString(1, tenNV);
            stmt.setString(2, gioiTinh);
            stmt.setDate(3, ngaySinh); 
            stmt.setString(4, queQuan);
            stmt.setString(5, sdt);
            stmt.setString(6, tdHv);
            stmt.setString(7, maNV); 
            
            int row = stmt.executeUpdate(); // Thực hiện cập nhật
            return row > 0; // Kiểm tra xem có cập nhật thành công không
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

  public List<Object[]> searchHoSo(String tenNV) {
    Connection conn = null;
    List<Object[]> listNV = new ArrayList<>();
    try {
        conn = new DBconnection().getConnection(); // Kết nối với CSDL
        if (conn != null) {
            String query = "SELECT MaNV, TenNV, GioiTinh, NgaySinh, QueQuan, SDT, TDHV FROM ThongTinNhanVien WHERE TenNV = ?";
            PreparedStatement stmt = conn.prepareStatement(query); // Chuẩn bị câu truy vấn
            
            stmt.setString(1, tenNV); 
            
            ResultSet rs = stmt.executeQuery(); // Thực hiện truy vấn và nhận kết quả
            
            // Lặp qua từng kết quả
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("MaNV"),      
                    rs.getString("TenNV"),     
                    rs.getString("GioiTinh"),  
                    rs.getDate("NgaySinh"),    
                    rs.getString("QueQuan"),   
                    rs.getString("SDT"),       
                    rs.getString("TDHV")      
                };
                listNV.add(row); // Thêm mỗi hàng vào danh sách
            }
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
    return listNV; // Trả về danh sách nhân viên tìm thấy
}
}
