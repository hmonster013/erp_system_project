/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.DonDh;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class UpdateDonDhDto {
    private String maKh;
    private String ngayLap;
    private String ngayGiao;
    private String tinhTrang;
    private String maNv;

    public UpdateDonDhDto() {
    }

    public UpdateDonDhDto(String maKh, String ngayLap, String ngayGiao, String tinhTrang, String maNv) {
        this.maKh = maKh;
        this.ngayLap = ngayLap;
        this.ngayGiao = ngayGiao;
        this.tinhTrang = tinhTrang;
        this.maNv = maNv;
    }

    // Getter and Setter for maKh
    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    // Getter and Setter for ngayLap
    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    // Getter and Setter for ngayGiao
    public String getNgayGiao() {
        return ngayGiao;
    }

    public void setNgayGiao(String ngayGiao) {
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
