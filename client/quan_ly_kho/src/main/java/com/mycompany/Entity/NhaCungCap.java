/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Khoahihi79
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NhaCungCap {
    
    private String MaNcc;

    private String TenNcc;

    private String Email;

    private String Sdt;

    private String DiaChi;
    
    public NhaCungCap() {}

    public NhaCungCap(String MaNcc, String TenNcc, String Email, String Sdt, String DiaChi) {
        this.MaNcc = MaNcc;
        this.TenNcc = TenNcc;
        this.Email = Email;
        this.Sdt = Sdt;
        this.DiaChi = DiaChi;
    }

    public String getMaNcc() {
        return MaNcc;
    }

    public void setMaNcc(String MaNcc) {
        this.MaNcc = MaNcc;
    }

    public String getTenNcc() {
        return TenNcc;
    }

    public void setTenNcc(String TenNcc) {
        this.TenNcc = TenNcc;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }
    
    
    
    
}
