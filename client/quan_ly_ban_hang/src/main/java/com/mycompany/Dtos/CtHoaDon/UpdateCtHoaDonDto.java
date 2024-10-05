/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.CtHoaDon;

/**
 *
 * @author ACER
 */
public class UpdateCtHoaDonDto {

    private Integer soLuong;
    private Integer donGia;

    // Constructors
    public UpdateCtHoaDonDto() {}

    public UpdateCtHoaDonDto(Integer soLuong, Integer donGia) {
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    // Getters and Setters
    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }

    // Optional: You can also add toString method for debugging
    @Override
    public String toString() {
        return "UpdateCtHoaDonDto{" +
                "soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }
}

