package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.PhieuHoan.CreatePhieuHoanRequestDto;
import com.mycompany.Dtos.PhieuHoan.PhieuHoanDto;
import com.mycompany.Dtos.PhieuHoan.UpdatePhieuHoanDto;

public class PhieuHoan {

    private static final String BASE_URL = "http://localhost:5106/api/phieuhoan";
    private final ApiClient apiClient;

    public PhieuHoan() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả PhieuHoan từ API
    public List<PhieuHoanDto> getAllPhieuHoans() throws Exception {
        return apiClient.get("", new TypeToken<List<PhieuHoanDto>>() {}.getType());
    }

    // Lấy một PhieuHoan theo ID
    public PhieuHoanDto getPhieuHoanById(String maPh) throws Exception {
        String endpoint = String.format("/%s", maPh);
        return apiClient.get(endpoint, PhieuHoanDto.class);
    }

    // Tạo mới một PhieuHoan
    public boolean createPhieuHoan(CreatePhieuHoanRequestDto dto) throws Exception {
        return apiClient.post("", dto);
    }

    // Cập nhật một PhieuHoan
    public boolean updatePhieuHoan(String maPh, UpdatePhieuHoanDto dto) throws Exception {
        String endpoint = String.format("/%s", maPh);
        return apiClient.put(endpoint, dto);
    }

    // Xóa một PhieuHoan
    public boolean deletePhieuHoan(String maPh) throws Exception {
        String endpoint = String.format("/%s", maPh);
        return apiClient.delete(endpoint);
    }
}
