/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quan_ly_san_xuat.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Khoahihi79
 */
public class DBConnection {
    private static final String URL = "jdbc:sqlserver://localhost\\KHOA:1433;databaseName=erp_database;integratedSecurity=true;encrypt=false";
    
   
    private static Connection conn = null;

    public DBConnection() {
        try {
                conn = DriverManager.getConnection(URL);
            } catch(Exception e) {
                e.printStackTrace();
            } 
    }
    
    public  Connection getConnection() {
       try {
                if(conn == null) {
                    conn = DriverManager.getConnection(URL);
                }
            } catch(Exception e) {
                e.printStackTrace();
            } 
            return conn;
        }   
}
