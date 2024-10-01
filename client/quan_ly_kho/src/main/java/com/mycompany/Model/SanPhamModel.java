/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Model;

import com.mycompany.Connection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Khoahihi79
 */
public class SanPhamModel {
    
    public SanPhamModel() {}
    
    
    public boolean addCauHoi(String maSP, String tenSP, int soLuongTonKho) {
        try (Connection conn = new DBConnection().getConnection()) {
            if(conn != null) {
                String query = "{call addHangTonKho(?,?,?)}";
                PreparedStatement stmt  = conn.prepareStatement(query);
                stmt.setString(1, maSP);
                stmt.setString(2, tenSP);
                stmt.setInt(3, soLuongTonKho);
                int row = stmt.executeUpdate();
                return row > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return false;
    }
}
