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
public class DonHang {
    
    private String MaDdh;

    private String MaKh;

    private String NgayLap;

    private String NgayGiao;

    private String TinhTrang;

    private String MaNv;
    
    public DonHang() {}

    public DonHang(String MaDdh, String MaKh, String NgayLap, String NgayGiao, String TinhTrang, String MaNv) {
        this.MaDdh = MaDdh;
        this.MaKh = MaKh;
        this.NgayLap = NgayLap;
        this.NgayGiao = NgayGiao;
        this.TinhTrang = TinhTrang;
        this.MaNv = MaNv;
    }

    public String getMaDdh() {
        return MaDdh;
    }

    public void setMaDdh(String MaDdh) {
        this.MaDdh = MaDdh;
    }

    public String getMaKh() {
        return MaKh;
    }

    public void setMaKh(String MaKh) {
        this.MaKh = MaKh;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getNgayGiao() {
        return NgayGiao;
    }

    public void setNgayGiao(String NgayGiao) {
        this.NgayGiao = NgayGiao;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    public String getMaNv() {
        return MaNv;
    }

    public void setMaNv(String MaNv) {
        this.MaNv = MaNv;
    }
    
    
}
