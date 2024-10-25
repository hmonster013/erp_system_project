/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLSX.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Khoahihi79
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CtPhieuNghiemThu {
    private String MaPnt;

    private String SoLo;

    private String KetQuaNt;
    
    public CtPhieuNghiemThu() {}

    public CtPhieuNghiemThu(String MaPnt, String SoLo, String KetQuaNt) {
        this.MaPnt = MaPnt;
        this.SoLo = SoLo;
        this.KetQuaNt = KetQuaNt;
    }

    public String getMaPnt() {
        return MaPnt;
    }

    public void setMaPnt(String MaPnt) {
        this.MaPnt = MaPnt;
    }

    public String getSoLo() {
        return SoLo;
    }

    public void setSoLo(String SoLo) {
        this.SoLo = SoLo;
    }

    public String getKetQuaNt() {
        return KetQuaNt;
    }

    public void setKetQuaNt(String KetQuaNt) {
        this.KetQuaNt = KetQuaNt;
    }
    
    
}
