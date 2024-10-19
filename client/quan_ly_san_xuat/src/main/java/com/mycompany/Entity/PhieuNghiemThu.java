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
public class PhieuNghiemThu {
    private String MaPnt;

    private String MaYc;

    private String NgayNt;

    private String VanBan;

    private String MaNv;
    
    public PhieuNghiemThu() {}

    public PhieuNghiemThu(String MaPnt, String MaYc, String NgayNt, String VanBan) {
        this.MaPnt = MaPnt;
        this.MaYc = MaYc;
        this.NgayNt = NgayNt;
        this.VanBan = VanBan;
    }

    public String getMaPnt() {
        return MaPnt;
    }

    public void setMaPnt(String MaPnt) {
        this.MaPnt = MaPnt;
    }

    public String getMaYc() {
        return MaYc;
    }

    public void setMaYc(String MaYc) {
        this.MaYc = MaYc;
    }

    public String getNgayNt() {
        return NgayNt;
    }

    public void setNgayNt(String NgayNt) {
        this.NgayNt = NgayNt;
    }

    public String getVanBan() {
        return VanBan;
    }

    public void setVanBan(String VanBan) {
        this.VanBan = VanBan;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }
    
    
}
