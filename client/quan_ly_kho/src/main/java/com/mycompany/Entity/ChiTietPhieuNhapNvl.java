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
public class ChiTietPhieuNhapNvl {
    
    private String MaPnnvl;

    private String MaNvl;

    private int Slnhap;

    private String Dvt;

    private int GiaNhap;
    
    private String  Nsx;

    private String Hsd;
    
    public ChiTietPhieuNhapNvl() {}

    public ChiTietPhieuNhapNvl(String MaPnnvl, String MaNvl, int Slnhap, String Dvt,  int GiaNhap, String Nsx, String Hsd) {
        this.MaPnnvl = MaPnnvl;
        this.MaNvl = MaNvl;
        this.Slnhap = Slnhap;
        this.Dvt = Dvt;
        this.GiaNhap = GiaNhap;
        this.Nsx = Nsx;
        this.Hsd = Hsd;
    }

    public String getMaPnnvl() {
        return MaPnnvl;
    }

    public void setMaPnnvl(String MaPnnvl) {
        this.MaPnnvl = MaPnnvl;
    }

    public String getMaNvl() {
        return MaNvl;
    }

    public void setMaNvl(String MaNvl) {
        this.MaNvl = MaNvl;
    }

    public int getSlnhap() {
        return Slnhap;
    }

    public void setSlnhap(int Slnhap) {
        this.Slnhap = Slnhap;
    }

    public String getDvt() {
        return Dvt;
    }

    public void setDvt(String Dvt) {
        this.Dvt = Dvt;
    }

    public int getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(int GiaNhap) {
        this.GiaNhap = GiaNhap;
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
