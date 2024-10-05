/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.DonDh;

/**
 *
 * @author ACER
 */
import java.util.Date;

public class DonDhDto {
    private String maDdh;
    private String maKh;
    private Date ngayLap;
    private Date ngayGiao;
    private String tinhTrang;
    private String maNv;

    // Getter and Setter for maDdh
    public String getMaDdh() {
        return maDdh;
    }

    public void setMaDdh(String maDdh) {
        this.maDdh = maDdh;
    }

    // Getter and Setter for maKh
    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    // Getter and Setter for ngayLap
    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    // Getter and Setter for ngayGiao
    public Date getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(Date ngayGiao) {
        this.ngayGiao = ngayGiao;
    }

    // Getter and Setter for tinhTrang
    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    // Getter and Setter for maNv
    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }
}

