/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.CtphieuHoan;

/**
 *
 * @author ACER
 */
public class UpdateCtphieuHoanDto {

    private Integer soLuongHoan;
    private String lyDoHoan;

    // Constructors
    public UpdateCtphieuHoanDto() {}

    public UpdateCtphieuHoanDto(Integer soLuongHoan, String lyDoHoan) {
        this.soLuongHoan = soLuongHoan;
        this.lyDoHoan = lyDoHoan;
    }

    // Getters and Setters
    public Integer getSoLuongHoan() {
        return soLuongHoan;
    }

    public void setSoLuongHoan(Integer soLuongHoan) {
        this.soLuongHoan = soLuongHoan;
    }

    public String getLyDoHoan() {
        return lyDoHoan;
    }

    public void setLyDoHoan(String lyDoHoan) {
        this.lyDoHoan = lyDoHoan;
    }

    // Optional: You can add toString method for debugging
    @Override
    public String toString() {
        return "UpdateCtphieuHoanDto{" +
                "soLuongHoan=" + soLuongHoan +
                ", lyDoHoan='" + lyDoHoan + '\'' +
                '}';
    }
}

