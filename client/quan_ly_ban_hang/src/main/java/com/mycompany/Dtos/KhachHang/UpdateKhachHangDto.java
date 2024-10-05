/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.KhachHang;

/**
 *
 * @author ACER
 */
public class UpdateKhachHangDto {
    private String tenKh;
    private String email;
    private String sdt;
    private String diaChi;
    private String maLoaiKh;

    public String getTenKh() {
        return tenKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaLoaiKh() {
        return maLoaiKh;
    }

    public void setMaLoaiKh(String maLoaiKh) {
        this.maLoaiKh = maLoaiKh;
    }    
}
