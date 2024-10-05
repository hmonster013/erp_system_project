/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.CtdonDh;

/**
 *
 * @author ACER
 */
public class CreateCtdonDhRequestDto {
    private String maDdh;
    private String maSp;
    private Integer soLuong; // Sử dụng Integer để cho phép giá trị null

    // Getter and Setter for maDdh
    public String getMaDdh() {
        return maDdh;
    }

    public void setMaDdh(String maDdh) {
        this.maDdh = maDdh;
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
}
