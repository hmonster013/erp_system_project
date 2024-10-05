/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quan_ly_san_xuat.Model;

import com.mycompany.quan_ly_san_xuat.Connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Khoahihi79
 */
public class NVLModel {
    public boolean addNguyenVatLieu(String maNVL, String tenNVL, String ghiChu) {
        try (Connection conn = new DBConnection().getConnection()) {
            if(conn != null) {
                String query = "{call themNVL(?,?,?)}";
                PreparedStatement stmt  = conn.prepareStatement(query);
                stmt.setString(1, maNVL);
                stmt.setString(2, tenNVL);
                stmt.setString(3, ghiChu);
                int row = stmt.executeUpdate();
                return row > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }
    
    public List<Object[]> danhSachNVL() {
        Connection conn = null;
        List<Object[]> listNVL = new ArrayList<>();
        try {
            conn = new DBConnection().getConnection();
            if (conn != null) {
                String query = "SELECT MaNVL, TenNVL, GhiChu FROM nguyenvatlieu";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    Object[] row = new Object[]{
                        rs.getString("MaNVL"),
                        rs.getString("TenNVL"),
                        rs.getString("GhiChu"),
                    };
                    listNVL.add(row);
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
        return listNVL;
    }
}
