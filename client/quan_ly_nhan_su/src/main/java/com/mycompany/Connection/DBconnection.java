/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class DBconnection {
     private static final String URL = "jdbc:sqlserver://localhost\\REUS_11:1433;databaseName=erp_database;integratedSecurity=true;encrypt=false";
   
    private static Connection conn = null;

    public DBconnection() {
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
