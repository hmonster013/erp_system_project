/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Dtos.CtdonDh;

/**
 *
 * @author ACER
 */
public class UpdateCtdonDhDto {

    private Integer soLuong;

    // Constructors
    public UpdateCtdonDhDto() {}

    public UpdateCtdonDhDto(Integer soLuong) {
        this.soLuong = soLuong;
    }

    // Getters and Setters
    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    // Optional: You can also add toString method for debugging
    @Override
    public String toString() {
        return "UpdateCtdonDhDto{" +
                "soLuong=" + soLuong +
                '}';
    }
}

