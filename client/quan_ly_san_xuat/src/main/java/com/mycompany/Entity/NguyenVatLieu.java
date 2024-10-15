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
public class NguyenVatLieu {
    
    private String MaNvl;

    private String TenNvl;

    private String GhiChu;

    private int SoLuongTon;
    
    public NguyenVatLieu() {}

    public NguyenVatLieu(String MaNvl, String TenNvl, String GhiChu, int SoLuongTon) {
        this.MaNvl = MaNvl;
        this.TenNvl = TenNvl;
        this.GhiChu = GhiChu;
        this.SoLuongTon = SoLuongTon;
    }
    
    public NguyenVatLieu(String MaNvl, String TenNvl, String GhiChu) {
        this(MaNvl, TenNvl, GhiChu, 0); 
    }

    public String getMaNvl() {
        return MaNvl;
    }

    public void setMaNvl(String MaNvl) {
        this.MaNvl = MaNvl;
    }

    public String getTenNvl() {
        return TenNvl;
    }

    public void setTenNvl(String TenNvl) {
        this.TenNvl = TenNvl;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }
    
    
}
