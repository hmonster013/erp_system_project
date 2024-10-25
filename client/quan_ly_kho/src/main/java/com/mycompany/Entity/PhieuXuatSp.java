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
public class PhieuXuatSp {
    
    private String MaPxsp;

    private String MaDdh;

    private String NgayXuat;

    private String MaNv;
    
    public PhieuXuatSp() {}

    public PhieuXuatSp(String MaPxsp, String MaDdh, String NgayXuat, String MaNv) {
        this.MaPxsp = MaPxsp;
        this.MaDdh = MaDdh;
        this.NgayXuat = NgayXuat;
        this.MaNv = MaNv;
    }

    public String getMaPxsp() {
        return MaPxsp;
    }

    public void setMaPxsp(String MaPxsp) {
        this.MaPxsp = MaPxsp;
    }

    public String getMaDdh() {
        return MaDdh;
    }

    public void setMaDdh(String MaDdh) {
        this.MaDdh = MaDdh;
    }

    public String getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(String NgayXuat) {
        this.NgayXuat = NgayXuat;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }
    
}
