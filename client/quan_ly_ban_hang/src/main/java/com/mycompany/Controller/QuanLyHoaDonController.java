/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Dtos.DonDh.DonDhDto;
import com.mycompany.Dtos.DonDh.UpdateDonDhDto;
import com.mycompany.Dtos.HoaDon.CreateHoaDonRequestDto;
import com.mycompany.Dtos.HoaDon.HoaDonDto;
import com.mycompany.Model.HoaDon;
import com.mycompany.Model.DonDh;
import java.text.SimpleDateFormat;

/**
 *
 * @author ACER
 */
public class QuanLyHoaDonController {

    private final HoaDon hoaDonModel;

    public QuanLyHoaDonController() {
        this.hoaDonModel = new HoaDon();
    }

    public String createHoaDon(CreateHoaDonRequestDto dto) {
        try {
            HoaDonDto existingHoaDon = hoaDonModel.getHoaDonById(dto.getMaHd());
            if (existingHoaDon != null) {
                return "Đơn hàng đã được thanh toán.";
            }

            // Nếu chưa tồn tại, tiến hành tạo hóa đơn mới
            boolean success = hoaDonModel.createHoaDon(dto);
            if (success) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                
                String maDdh = dto.getMaDdh();
                DonDh donDhModel = new DonDh();
                DonDhDto donDhDto = donDhModel.getDonDhById(maDdh);
                UpdateDonDhDto updateDto = new UpdateDonDhDto(
                        donDhDto.getMaKh(),
                        dateFormat.format(donDhDto.getNgayLap()),
                        dateFormat.format(donDhDto.getNgayGiao()),
                        "Đã giao",
                        donDhDto.getMaNv()
                );

                donDhModel.updateDonDh(maDdh, updateDto);

                return "Tạo hóa đơn thành công và cập nhật trạng thái đơn hàng thành công.";
            } else {
                return "Tạo hóa đơn thất bại.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Đã xảy ra lỗi khi tạo hóa đơn: " + e.getMessage();
        }
    }
}
