package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.HoaDon.CreateHoaDonRequestDto;
import com.mycompany.Dtos.HoaDon.HoaDonDto;
import com.mycompany.Dtos.HoaDon.UpdateHoaDonDto;

public class HoaDon {

    private static final String BASE_URL = "http://localhost:5106/api/hoadon";
    private final ApiClient apiClient;

    public HoaDon() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả HoaDon từ API
    public List<HoaDonDto> getAllHoaDons() throws Exception {
        return apiClient.get("", new TypeToken<List<HoaDonDto>>() {}.getType());
    }

    // Lấy một HoaDon theo ID
    public HoaDonDto getHoaDonById(String maHd) throws Exception {
        String endpoint = String.format("/%s", maHd);
        return apiClient.get(endpoint, HoaDonDto.class);
    }

    // Tạo mới một HoaDon
    public boolean createHoaDon(CreateHoaDonRequestDto dto) throws Exception {
        return apiClient.post("", dto);
    }

    // Cập nhật một HoaDon
    public boolean updateHoaDon(String maHd, UpdateHoaDonDto dto) throws Exception {
        String endpoint = String.format("/%s", maHd);
        return apiClient.put(endpoint, dto);
    }

    // Xóa một HoaDon
    public boolean deleteHoaDon(String maHd) throws Exception {
        String endpoint = String.format("/%s", maHd);
        return apiClient.delete(endpoint);
    }
}
