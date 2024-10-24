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
public class DanhSachBaoHiemModel {
    // Thêm mới bảo hiểm
    public boolean addBaoHiem(String maBaoHiem, String tenBaoHiem, String noiDungBH) {
        Connection conn = null;
        try {
            conn = new DBconnection().getConnection(); 
            if (conn != null) {
                String query = "INSERT INTO BaoHiem (MaBaoHiem, TenBaoHiem, NoiDungBH) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(query);
                
                // Set các tham số cho câu truy vấn
                stmt.setString(1, maBaoHiem);
                stmt.setString(2, tenBaoHiem);
                stmt.setString(3, noiDungBH);
                
                int row = stmt.executeUpdate(); 
                return row > 0; // Kiểm tra xem có thêm thành công không
            }
        } catch (Exception e) {
            e.printStackTrace(); // Xử lý ngoại lệ
        } finally {
            if (conn != null) {
                try {
                    conn.close(); // Đóng kết nối khi hoàn thành
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    // Danh sách bảo hiểm
    public List<Object[]> danhSachBaoHiem() {
        Connection conn = null;
        List<Object[]> listBaoHiem = new ArrayList<>();
        try {
            conn = new DBconnection().getConnection();  // Kết nối với CSDL
            if (conn != null) {
                String query = "SELECT MaBaoHiem, TenBaoHiem, NoiDungBH FROM BaoHiem";
                PreparedStatement stmt = conn.prepareStatement(query);  // Chuẩn bị câu truy vấn
                ResultSet rs = stmt.executeQuery();  // Thực hiện truy vấn và nhận kết quả
                
                // Lặp qua từng kết quả
                while (rs.next()) {
                    Object[] row = new Object[]{
                        rs.getString("MaBaoHiem"),
                        rs.getString("TenBaoHiem"),
                        rs.getString("NoiDungBH"),
                    };
                    listBaoHiem.add(row);  // Thêm mỗi hàng vào danh sách
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
        return listBaoHiem;  
    }

    // Cập nhật bảo hiểm
    public boolean updateBaoHiem(String maBaoHiem, String tenBaoHiem, String noiDungBH) {
        Connection conn = null;
        try {
            conn = new DBconnection().getConnection(); 
            if (conn != null) {
                String query = "UPDATE BaoHiem SET TenBaoHiem = ?, NoiDungBH = ? WHERE MaBaoHiem = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                
                // Set các tham số cho câu truy vấn
                stmt.setString(1, tenBaoHiem);
                stmt.setString(2, noiDungBH);
                stmt.setString(3, maBaoHiem);
                
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

    // Xóa bảo hiểm
    public boolean deleteBaoHiem(String maBaoHiem) {
        Connection conn = null;
        try {
            conn = new DBconnection().getConnection(); 
            if (conn != null) {
                String query = "DELETE FROM BaoHiem WHERE MaBaoHiem = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                
                // Set tham số cho câu truy vấn
                stmt.setString(1, maBaoHiem);
                
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
