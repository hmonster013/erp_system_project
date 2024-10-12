/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Entity;

import java.util.Date;

/**
 *
 * @author Khoahihi79
 */
public class LoSanPham {
    
    private String SoLo;

    private String MaYc;

    private String MaSp;

    private int SoLuongSp;

    private String Nsx; 

    private String Hsd;
    
    public LoSanPham() {}

    public LoSanPham(String SoLo, String MaYc, String MaSp, int SoLuongSp, String Nsx, String Hsd) {
        this.SoLo = SoLo;
        this.MaYc = MaYc;
        this.MaSp = MaSp;
        this.SoLuongSp = SoLuongSp;
        this.Nsx = Nsx;
        this.Hsd = Hsd;
    }

    public String getSoLo() {
        return SoLo;
    }

    public void setSoLo(String SoLo) {
        this.SoLo = SoLo;
    }

    public String getMaYc() {
        return MaYc;
    }

    public void setMaYc(String MaYc) {
        this.MaYc = MaYc;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public int getSoLuongSp() {
        return SoLuongSp;
    }

    public void setSoLuongSp(int SoLuongSp) {
        this.SoLuongSp = SoLuongSp;
    }

    public String getNsx() {
        return Nsx;
    }

    public void setNsx(String Nsx) {
        this.Nsx = Nsx;
    }

    public String getHsd() {
        return Hsd;
    }

    public void setHsd(String Hsd) {
        this.Hsd = Hsd;
    }
    
    
    
    
}
