/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.CtphieuHoan;

/**
 *
 * @author ACER
 */
public class CreateCtphieuHoanRequestDto {
    private String maPh;
    private String maSp;
    private Integer soLuongHoan; // Sử dụng Integer cho kiểu dữ liệu có thể null
    private String lyDoHoan;

    // Getter and Setter for maPh
    public String getMaPh() {
        return maPh;
    }

    public void setMaPh(String maPh) {
        this.maPh = maPh;
    }

    // Getter and Setter for maSp
    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    // Getter and Setter for soLuongHoan
    public Integer getSoLuongHoan() {
        return soLuongHoan;
    }

    public void setSoLuongHoan(Integer soLuongHoan) {
        this.soLuongHoan = soLuongHoan;
    }

    // Getter and Setter for lyDoHoan
    public String getLyDoHoan() {
        return lyDoHoan;
    }

    public void setLyDoHoan(String lyDoHoan) {
        this.lyDoHoan = lyDoHoan;
    }    
}
