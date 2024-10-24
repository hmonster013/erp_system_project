/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.Main;

import com.mycompany.Connection.DBconnection;
import java.sql.Connection;

/**
 *
 * @author ACER
 */
public class Main {

    public static void main(String[] args) {
        Connection conn = new DBconnection().getConnection();
        if(conn != null) {
            System.out.println("Ket noi thanh cong");
        } else {
            System.out.println("Ket noi that bai");
        }
    }
}
