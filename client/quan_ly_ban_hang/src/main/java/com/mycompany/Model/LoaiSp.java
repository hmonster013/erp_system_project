/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.LoaiSpt.LoaiSpDto;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class LoaiSp {

    private static final String BASE_URL = "http://localhost:5106/api/loaisp";
    private final ApiClient apiClient;

    public LoaiSp() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả LoaiSp từ API
    public List<LoaiSpDto> getAllLoaiSps() throws Exception {
        return apiClient.get("", new TypeToken<List<LoaiSpDto>>() {}.getType());
    }

    // Lấy một LoaiSp theo mã loại
    public LoaiSpDto getLoaiSpByMaLoai(String maLoai) throws Exception {
        String endpoint = String.format("/%s", maLoai);
        return apiClient.get(endpoint, LoaiSpDto.class);
    }

    // Lấy một LoaiSp theo tên loại
    public LoaiSpDto getLoaiSpByTenLoai(String tenLoai) throws Exception {
        // Mã hóa chuỗi tên loại với UTF-8
        String encodedTenLoai = URLEncoder.encode(tenLoai, StandardCharsets.UTF_8)
                                       .replace("+", "%20"); // Thay thế dấu '+' bằng '%20'

        // Tạo endpoint với tên loại đã được mã hóa
        String endpoint = String.format("/search/%s", encodedTenLoai);

        // Gọi API để lấy LoaiSpDto
        return apiClient.get(endpoint, LoaiSpDto.class);
    }
}
