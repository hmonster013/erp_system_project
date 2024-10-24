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
public class QuanLyTaiKhoanModel {
      public List<Object[]> danhSachTaiKhoan() {
    Connection conn = null;
    List<Object[]> listTaiKhoan = new ArrayList<>();
    try {
         conn = new DBconnection().getConnection();  
        if (conn != null) {
            String query = "SELECT Username, Password, MaNV FROM TaiKhoan";
            PreparedStatement stmt = conn.prepareStatement(query); 
            ResultSet rs = stmt.executeQuery();  
            
            // Lặp qua từng kết quả
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("Username"),
                    rs.getString("Password"),
                    rs.getString("MaNV"),                          
                };
                listTaiKhoan.add(row);  // Thêm mỗi hàng vào danh sách
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
    return listTaiKhoan;  
}
      
      public boolean addTaiKhoan(String userName, String passWord, String maNV) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "INSERT INTO TaiKhoan (Username, Password, MaNV) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query); 
            
            // Set các tham số cho câu truy vấn
            stmt.setString(1, userName);
            stmt.setString(2, passWord);
            stmt.setString(3, maNV);
            
            int row = stmt.executeUpdate(); // Thực hiện cập nhật
            return row > 0; // Kiểm tra xem có thêm thành công không
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
      
      public boolean updateTaiKhoan(String userName, String passWord, String maNV) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "UPDATE TaiKhoan SET Password = ?, MaNV = ? WHERE Username = ?";
            PreparedStatement stmt = conn.prepareStatement(query); // Chuẩn bị câu truy vấn
            
            // Set các tham số cho câu truy vấn
            stmt.setString(1, passWord);
            stmt.setString(2, maNV);
            stmt.setString(3, userName);
            
            int row = stmt.executeUpdate(); // Thực hiện cập nhật
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
      
      public boolean deleteTaiKhoan(String userName) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "DELETE FROM TaiKhoan WHERE Username = ?";
            PreparedStatement stmt = conn.prepareStatement(query); // Chuẩn bị câu truy vấn
            
            // Set tham số cho câu truy vấn
            stmt.setString(1, userName);
            
            int row = stmt.executeUpdate(); // Thực hiện xóa
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
