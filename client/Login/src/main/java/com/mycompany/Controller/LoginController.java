/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Dtos.TaiKhoan.TaiKhoanDto;
import com.mycompany.Model.TaiKhoan;

/**
 *
 * @author ACER
 */
public class LoginController {
    private TaiKhoan taiKhoanModel;
    
    public LoginController() {
        this.taiKhoanModel = new TaiKhoan();
    }
    
    public boolean login(String username, String password) {
        try {
            TaiKhoanDto taiKhoanDto = taiKhoanModel.getTaiKhoanByUsername(username);
            
            if (taiKhoanDto != null && taiKhoanDto.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }            
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getMaBoPhan(String username) {
        try {
            TaiKhoanDto dto = taiKhoanModel.getTaiKhoanByUsername(username);
            
            return taiKhoanModel.getMaBoPhan(dto.getMaNv());
        } catch (Exception e) {
            return "";
        }
    }
}
