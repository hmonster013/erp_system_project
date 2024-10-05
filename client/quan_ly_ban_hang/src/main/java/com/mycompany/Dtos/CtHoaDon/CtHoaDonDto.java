/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.CtHoaDon;

/**
 *
 * @author ACER
 */
public class CtHoaDonDto {
    private String maHd;
    private String maSp;
    private Integer soLuong; // Sử dụng Integer để có thể nhận giá trị null
    private Integer donGia; // Sử dụng Integer để có thể nhận giá trị null

    // Getter and Setter for maHd
    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    // Getter and Setter for maSp
    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    // Getter and Setter for soLuong
    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    // Getter and Setter for donGia
    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }
}

