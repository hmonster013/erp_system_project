/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.HoaDon;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class UpdateHoaDonDto {
    private String maDdh;
    private Date ngayLapHd; // Sử dụng Date để đại diện cho ngày
    private String tinhTrangHd;
    private String maNv;

    // Getter and Setter for maDdh
    public String getMaDdh() {
        return maDdh;
    }

    public void setMaDdh(String maDdh) {
        this.maDdh = maDdh;
    }

    // Getter and Setter for ngayLapHd
    public Date getNgayLapHd() {
        return ngayLapHd;
    }

    public void setNgayLapHd(Date ngayLapHd) {
        this.ngayLapHd = ngayLapHd;
    }

    // Getter and Setter for tinhTrangHd
    public String getTinhTrangHd() {
        return tinhTrangHd;
    }

    public void setTinhTrangHd(String tinhTrangHd) {
        this.tinhTrangHd = tinhTrangHd;
    }

    // Getter and Setter for maNv
    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }    
}
