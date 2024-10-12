/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Entity;

/**
 *
 * @author Khoahihi79
 */
public class ChiTietPhieuNhapSp {
    
    private String MaPnsp;

    private String SoLo;
    
    public ChiTietPhieuNhapSp() {}

    public ChiTietPhieuNhapSp(String MaPnsp, String SoLo) {
        this.MaPnsp = MaPnsp;
        this.SoLo = SoLo;
    }

    public String getMaPnsp() {
        return MaPnsp;
    }

    public void setMaPnsp(String MaPnsp) {
        this.MaPnsp = MaPnsp;
    }

    public String getSoLo() {
        return SoLo;
    }

    public void setSoLo(String SoLo) {
        this.SoLo = SoLo;
    }
    
    
}
