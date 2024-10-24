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
public class QuanLyBacLuongModel {
    public boolean addBacLuong(String maBL, int luongCB, int hsLuong, int hsPhucap) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "INSERT INTO BacLuong (MaBL, LuongCB, HSLuong, HSPhucap ) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query); // Chuẩn bị câu truy vấn
            
            // Set các tham số cho câu truy vấn
            stmt.setString(1, maBL);
            stmt.setInt(2, luongCB);
            stmt.setInt(3, hsLuong);
            stmt.setInt(4, hsPhucap);
             
            
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
   
   public List<Object[]> danhSachBacLuong() {
    Connection conn = null;
    List<Object[]> listBacLuong = new ArrayList<>();
    try {
         conn = new DBconnection().getConnection();  // Kết nối với CSDL
        if (conn != null) {
            String query = "SELECT MaBL, LuongCB, HSLuong, HSPhucap FROM BacLuong";
            PreparedStatement stmt = conn.prepareStatement(query);  // Chuẩn bị câu truy vấn
            ResultSet rs = stmt.executeQuery();  // Thực hiện truy vấn và nhận kết quả
            
            // Lặp qua từng kết quả
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("MaBL"),
                    rs.getInt("LuongCB"),
                    rs.getInt("HSLuong"),
                    rs.getInt("HSPhucap"),      
                };
                listBacLuong.add(row);  // Thêm mỗi hàng vào danh sách
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
    return listBacLuong;  
}
   
   public boolean updateBacLuong(String maBL, int luongCB, int hsLuong, int hsPhucap) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "UPDATE BacLuong SET LuongCB = ?, HSLuong = ?, HSPhucap = ? WHERE MaBL = ?";
            PreparedStatement stmt = conn.prepareStatement(query); 
            
            // Set các tham số cho câu truy vấn
            stmt.setInt(1, luongCB);
            stmt.setInt(2, hsLuong);
            stmt.setInt(3, hsPhucap);
            stmt.setString(4, maBL);
            
            int row = stmt.executeUpdate(); 
            return row > 0; // Kiểm tra xem có cập nhật thành công không
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
   
   public boolean deleteBacLuong(String maBL) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "DELETE FROM BacLuong WHERE MaBL = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            
            // Set tham số cho câu truy vấn
            stmt.setString(1, maBL);
            
            int row = stmt.executeUpdate(); 
            return row > 0; // Kiểm tra xem có xóa thành công không
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


   
  
}
