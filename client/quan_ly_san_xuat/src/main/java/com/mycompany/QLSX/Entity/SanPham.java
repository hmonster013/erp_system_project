package com.mycompany.QLSX.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SanPham {
    
    private String MaSp;
    private String MaLoai;
    private String TenSp;
    private int GiaBan;
    private String ThanhPhan;
    private String Klt;
    private int SoLuongTon;
    
    // Constructor không tham số
    public SanPham() {}

    // Constructor có tham số
    public SanPham(String MaSp, String MaLoai, String TenSp, int GiaBan, String ThanhPhan, String Klt, int SoLuongTon) {
        this.MaSp = MaSp;
        this.MaLoai = MaLoai;
        this.TenSp = TenSp;
        this.GiaBan = GiaBan;
        this.ThanhPhan = ThanhPhan;
        this.Klt = Klt;
        this.SoLuongTon = SoLuongTon;
    }

      public SanPham(String MaSp, String MaLoai, String TenSp, int GiaBan, String ThanhPhan, String Klt) {
          this(MaSp, MaLoai, TenSp, GiaBan, ThanhPhan, Klt, 0);
      }
      
    // Getter và Setter cho MaSp
    public String getMaSp() {
        return MaSp;
    }

    public void setMaSp(String MaSp) {
        this.MaSp = MaSp;
    }

    // Getter và Setter cho MaLoai
    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    // Getter và Setter cho TenSp
    public String getTenSp() {
        return TenSp;
    }

    public void setTenSp(String TenSp) {
        this.TenSp = TenSp;
    }

    // Getter và Setter cho GiaBan
    public int getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(int GiaBan) {
        this.GiaBan = GiaBan;
    }

    // Getter và Setter cho ThanhPhan
    public String getThanhPhan() {
        return ThanhPhan;
    }

    public void setThanhPhan(String ThanhPhan) {
        this.ThanhPhan = ThanhPhan;
    }

    // Getter và Setter cho Klt
    public String getKlt() {
        return Klt;
    }

    public void setKlt(String Klt) {
        this.Klt = Klt;
    }

    // Getter và Setter cho SoLuongTon
    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int SoLuongTon) {
        this.SoLuongTon = SoLuongTon;
    }
}
