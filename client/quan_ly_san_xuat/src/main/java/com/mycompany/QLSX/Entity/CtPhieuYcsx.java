/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLSX.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Khoahihi79
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CtPhieuYcsx {
    
    private String MaYc;

    private String MaSp;

    private int SoLuongSx;
    
    public CtPhieuYcsx() {}

    public CtPhieuYcsx(String MaYc, String MaSp, int SoLuongSx) {
        this.MaYc = MaYc;
        this.MaSp = MaSp;
        this.SoLuongSx = SoLuongSx;
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

    public int getSoLuongSx() {
        return SoLuongSx;
    }

    public void setSoLuongSx(int SoLuongSx) {
        this.SoLuongSx = SoLuongSx;
    }
    
    
}
