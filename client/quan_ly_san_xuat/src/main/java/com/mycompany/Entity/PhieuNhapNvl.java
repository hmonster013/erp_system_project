/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Entity;

/**
 *
 * @author Khoahihi79
 */
public class PhieuNhapNvl {
    
    private String MaPnnvl;

    private String MaYc;

    private String MaNcc ;

    private String NgayNhap;

    private String MaNv;
    
    private boolean PhanLoai;
    
    public PhieuNhapNvl() {}

    public PhieuNhapNvl(String MaPnnvl, String NgayNhap, String MaNcc) {
        this.MaPnnvl = MaPnnvl;
        this.NgayNhap = NgayNhap;
        this.MaNcc = MaNcc;
    }

    public String getMaPnnvl() {
        return MaPnnvl;
    }

    public void setMaPnnvl(String MaPnnvl) {
        this.MaPnnvl = MaPnnvl;
    }

    public String getMaYc() {
        return MaYc;
    }

    public void setMaYc(String MaYc) {
        this.MaYc = MaYc;
    }

    public String getMaNcc() {
        return MaNcc;
    }

    public void setMaNcc(String MaNcc) {
        this.MaNcc = MaNcc;
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

    public boolean isPhanLoai() {
        return PhanLoai;
    }

    public void setPhanLoai(boolean PhanLoai) {
        this.PhanLoai = PhanLoai;
    }
    
    
    
    
}
