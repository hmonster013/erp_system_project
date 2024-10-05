package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.CtHoaDon.CreateCtHoaDonRequestDto;
import com.mycompany.Dtos.CtHoaDon.CtHoaDonDto;
import com.mycompany.Dtos.CtHoaDon.UpdateCtHoaDonDto;

public class CtHoaDon {

    private static final String BASE_URL = "http://localhost:5106/api/cthoadon";
    private final ApiClient apiClient;

    public CtHoaDon() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả CtHoaDon từ API
    public List<CtHoaDonDto> getAllCtHoaDons() throws Exception {
        return apiClient.get("", new TypeToken<List<CtHoaDonDto>>() {}.getType());
    }

    // Lấy một CtHoaDon theo ID
    public CtHoaDonDto getCtHoaDonById(String maHd, String maSp) throws Exception {
        String endpoint = String.format("/%s/%s", maHd, maSp);
        return apiClient.get(endpoint, CtHoaDonDto.class);
    }

    // Tạo mới một CtHoaDon
    public boolean createCtHoaDon(CreateCtHoaDonRequestDto dto) throws Exception {
        return apiClient.post("", dto);
    }

    // Cập nhật một CtHoaDon
    public boolean updateCtHoaDon(String maHd, String maSp, UpdateCtHoaDonDto dto) throws Exception {
        String endpoint = String.format("/%s/%s", maHd, maSp);
        return apiClient.put(endpoint, dto);
    }

    // Xóa một CtHoaDon
    public boolean deleteCtHoaDon(String maHd, String maSp) throws Exception {
        String endpoint = String.format("/%s/%s", maHd, maSp);
        return apiClient.delete(endpoint);
    }
}
