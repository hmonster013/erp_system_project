/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.PhieuHoan;

import java.util.Date;

/**
 *
 * @author ACER
 */
public class CreatePhieuHoanRequestDto {
    private String maPh;
    private String maDdh;
    private Date ngayHoan; // Sử dụng Date thay vì LocalDate
    private String maNv;

    // Getter and Setter for maPh
    public String getMaPh() {
        return maPh;
    }

    public void setMaPh(String maPh) {
        this.maPh = maPh;
    }

    // Getter and Setter for maDdh
    public String getMaDdh() {
        return maDdh;
    }

    public void setMaDdh(String maDdh) {
        this.maDdh = maDdh;
    }

    // Getter and Setter for ngayHoan
    public Date getNgayHoan() {
        return ngayHoan;
    }

    public void setNgayHoan(Date ngayHoan) {
        this.ngayHoan = ngayHoan;
    }

    // Getter and Setter for maNv
    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }    
}
