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
public class PhieuYcsx {
    
    private String MaYc;

    private String NgayBd;

    private String NgayKt;

    private String VanBan;

    private String MaNv;
    
    public PhieuYcsx() {}

    public PhieuYcsx(String MaYc, String NgayBd, String NgayKt, String MaNv) {
        this.MaYc = MaYc;
        this.NgayBd = NgayBd;
        this.NgayKt = NgayKt;
        this.MaNv = MaNv;
    }

    public String getMaYc() {
        return MaYc;
    }

    public void setMaYc(String MaYc) {
        this.MaYc = MaYc;
    }

    public String getNgayBd() {
        return NgayBd;
    }

    public void setNgayBd(String NgayBd) {
        this.NgayBd = NgayBd;
    }

    public String getNgayKt() {
        return NgayKt;
    }

    public void setNgayKt(String NgayKt) {
        this.NgayKt = NgayKt;
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
