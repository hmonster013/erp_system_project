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
public class QuanLyBoPhanModel {
    public List<Object[]> danhSacBoPhan() {
    Connection conn = null;
    List<Object[]> listBoPhan = new ArrayList<>();
    try {
         conn = new DBconnection().getConnection();  
        if (conn != null) {
            String query = "SELECT MaBP, TenBP, SDT FROM BoPhan";
            PreparedStatement stmt = conn.prepareStatement(query);  
            ResultSet rs = stmt.executeQuery();  
            
            // Lặp qua từng kết quả
            while (rs.next()) {
                Object[] row = new Object[]{
                    rs.getString("MaBP"),
                    rs.getString("TenBP"),
                    rs.getString("SDT"),                          
                };
                listBoPhan.add(row);  // Thêm mỗi hàng vào danh sách
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
    return listBoPhan;  
}
    
     public boolean addTaiKhoan(String maBP, String tenBP, String SDT) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "INSERT INTO BoPhan (MaBP, TenBP, SDT) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query); 
            
            // Set các tham số cho câu truy vấn
            stmt.setString(1, maBP);
            stmt.setString(2, tenBP);
            stmt.setString(3, SDT);
            
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
     
     public boolean updateBoPhan(String maBP, String tenBP, String SDT) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "UPDATE BoPhan SET TenBP = ?, SDT = ? WHERE MaBP = ?";
            PreparedStatement stmt = conn.prepareStatement(query); 
            
            // Set các tham số cho câu truy vấn
            stmt.setString(1, tenBP);
            stmt.setString(2, SDT);
            stmt.setString(3, maBP);
            
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
     
     public boolean deleteBoPhan(String maBP) {
    Connection conn = null;
    try {
        conn = new DBconnection().getConnection(); 
        if (conn != null) {
            String query = "DELETE FROM BoPhan WHERE MaBP = ?";
            PreparedStatement stmt = conn.prepareStatement(query); 
            
            // Set tham số cho câu truy vấn
            stmt.setString(1, maBP);
            
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
