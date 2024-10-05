/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.ThongTinNhanVien;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class UpdateThongTinNhanVienDto {
    private String tenNv;
    private String gioiTinh;
    private Date ngaySinh; // Thay đổi thành Date
    private String queQuan;
    private String sdt;
    private String tdhv;
    
    public String getTenNv() {
        return tenNv;
    }

    public void setTenNv(String tenNv) {
        this.tenNv = tenNv;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTdhv() {
        return tdhv;
    }

    public void setTdhv(String tdhv) {
        this.tdhv = tdhv;
    }    
}
