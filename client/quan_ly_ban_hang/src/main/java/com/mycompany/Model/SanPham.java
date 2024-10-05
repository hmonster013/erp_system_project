package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.SanPham.CreateSanPhamRequestDto;
import com.mycompany.Dtos.SanPham.SanPhamDto;
import com.mycompany.Dtos.SanPham.UpdateSanPhamDto;

public class SanPham {

    private static final String BASE_URL = "http://localhost:5106/api/sanpham";
    private final ApiClient apiClient;

    public SanPham() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả SanPham từ API
    public List<SanPhamDto> getAllSanPhams() throws Exception {
        return apiClient.get("", new TypeToken<List<SanPhamDto>>() {}.getType());
    }

    // Lấy một SanPham theo ID
    public SanPhamDto getSanPhamById(String maSp) throws Exception {
        String endpoint = String.format("/%s", maSp);
        return apiClient.get(endpoint, SanPhamDto.class);
    }

    // Tạo mới một SanPham
    public boolean createSanPham(CreateSanPhamRequestDto dto) throws Exception {
        return apiClient.post("", dto);
    }

    // Cập nhật một SanPham
    public boolean updateSanPham(String maSp, UpdateSanPhamDto dto) throws Exception {
        String endpoint = String.format("/%s", maSp);
        return apiClient.put(endpoint, dto);
    }

    // Xóa một SanPham
    public boolean deleteSanPham(String maSp) throws Exception {
        String endpoint = String.format("/%s", maSp);
        return apiClient.delete(endpoint);
    }
    
    // Tìm kiếm SanPham theo mã loại
    public List<SanPhamDto> getSanPhamsByMaLoai(String maLoai) throws Exception {
        String endpoint = String.format("/search/%s", maLoai);
        return apiClient.get(endpoint, new TypeToken<List<SanPhamDto>>() {}.getType());
    }
}
