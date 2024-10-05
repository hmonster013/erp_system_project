package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.KhachHang.CreateKhachHangRequestDto;
import com.mycompany.Dtos.KhachHang.KhachHangDto;
import com.mycompany.Dtos.KhachHang.UpdateKhachHangDto;

public class KhachHang {

    private static final String BASE_URL = "http://localhost:5106/api/khachhang";
    private final ApiClient apiClient;

    public KhachHang() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả KhachHang từ API
    public List<KhachHangDto> getAllKhachHangs() throws Exception {
        return apiClient.get("", new TypeToken<List<KhachHangDto>>() {}.getType());
    }

    // Lấy một KhachHang theo ID
    public KhachHangDto getKhachHangById(String maKh) throws Exception {
        String endpoint = String.format("/%s", maKh);
        return apiClient.get(endpoint, KhachHangDto.class);
    }

    // Tạo mới một KhachHang
    public boolean createKhachHang(CreateKhachHangRequestDto dto) throws Exception {
        return apiClient.post("", dto);
    }

    // Cập nhật một KhachHang
    public boolean updateKhachHang(String maKh, UpdateKhachHangDto dto) throws Exception {
        String endpoint = String.format("/%s", maKh);
        return apiClient.put(endpoint, dto);
    }

    // Xóa một KhachHang
    public boolean deleteKhachHang(String maKh) throws Exception {
        String endpoint = String.format("/%s", maKh);
        return apiClient.delete(endpoint);
    }
    
    // Tìm kiếm theo tên khách hàng
    public List<KhachHangDto> searchKhachHangByTen(String tenKh) throws Exception {
        // Đảm bảo mã hóa tên trong URL
        String encodedTenKh = java.net.URLEncoder.encode(tenKh, "UTF-8").replace("+", "%20");
        String endpoint = String.format("/search/%s", encodedTenKh);
        return apiClient.get(endpoint, new TypeToken<List<KhachHangDto>>() {}.getType());
    }
}
