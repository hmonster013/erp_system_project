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
public class CtDonHang {
    
    private String MaDdh;

    private String MaSp;

    private int SoLuong;
    
    public CtDonHang() {}

    public CtDonHang(String MaDdh, String MaSp, int SoLuong) {
        this.MaDdh = MaDdh;
        this.MaSp = MaSp;
        this.SoLuong = SoLuong;
    }

    public String getMaDdh() {
        return MaDdh;
    }

    public void setMaDdh(String MaDdh) {
        this.MaDdh = MaDdh;
    }

    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
