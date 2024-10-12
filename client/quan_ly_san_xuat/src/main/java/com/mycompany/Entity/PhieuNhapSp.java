/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;

/**
 *
 * @author Khoahihi79
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PhieuNhapSp {
    
     private String MaPnsp;

    private String NgayNhap;

    private String MaNv;
    
    public PhieuNhapSp() {}

    public PhieuNhapSp(String MaPnsp, String NgayNhap) {
        this.MaPnsp = MaPnsp;
        this.NgayNhap = NgayNhap;
    }

    public String getMaPnsp() {
        return MaPnsp;
    }

    public void setMaPnsp(String MaPnsp) {
        this.MaPnsp = MaPnsp;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }
    
}
