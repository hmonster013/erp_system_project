/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.SanPham;

/**
 *
 * @author ACER
 */
public class UpdateSanPhamDto {
    private String maLoai;
    private String tenSp;
    private Integer giaBan;
    private String thanhPhan;
    private String klt;
    private Integer soLuongTon;

    public UpdateSanPhamDto() {
    }

    public UpdateSanPhamDto(String maLoai, String tenSp, Integer giaBan, String thanhPhan, String klt, Integer soLuongTon) {
        this.maLoai = maLoai;
        this.tenSp = tenSp;
        this.giaBan = giaBan;
        this.thanhPhan = thanhPhan;
        this.klt = klt;
        this.soLuongTon = soLuongTon;
    }
    
    
    // Getter and Setter for maLoai
    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    // Getter and Setter for tenSp
    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    // Getter and Setter for giaBan
    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
    }

    // Getter and Setter for thanhPhan
    public String getThanhPhan() {
        return thanhPhan;
    }

    public void setThanhPhan(String thanhPhan) {
        this.thanhPhan = thanhPhan;
    }

    // Getter and Setter for klt
    public String getKlt() {
        return klt;
    }

    public void setKlt(String klt) {
        this.klt = klt;
    }

    // Getter and Setter for soLuongTon
    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }    
}