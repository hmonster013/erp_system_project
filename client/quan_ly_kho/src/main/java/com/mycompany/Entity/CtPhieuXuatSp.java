/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Entity;

/**
 *
 * @author Khoahihi79
 */
public class CtPhieuXuatSp {
    
    private String MaPxsp;

    private String MaSp;

    private int SoLuong;
    
    public CtPhieuXuatSp() {}

    public CtPhieuXuatSp(String MaPxsp, String MaSp, int SoLuong) {
        this.MaPxsp = MaPxsp;
        this.MaSp = MaSp;
        this.SoLuong = SoLuong;
    }

    public String getMaPxsp() {
        return MaPxsp;
    }

    public void setMaPxsp(String MaPxsp) {
        this.MaPxsp = MaPxsp;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
