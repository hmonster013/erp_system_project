package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.CtphieuHoan.CreateCtphieuHoanRequestDto;
import com.mycompany.Dtos.CtphieuHoan.CtphieuHoanDto;
import com.mycompany.Dtos.CtphieuHoan.UpdateCtphieuHoanDto;

public class CtphieuHoan {

    private static final String BASE_URL = "http://localhost:5106/api/ctphieuhoan";
    private final ApiClient apiClient;

    public CtphieuHoan() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả CtphieuHoan từ API
    public List<CtphieuHoanDto> getAllCtPhieuHoans() throws Exception {
        return apiClient.get("", new TypeToken<List<CtphieuHoanDto>>() {}.getType());
    }

    // Lấy một CtphieuHoan theo ID
    public CtphieuHoanDto getCtPhieuHoanById(String maPh, String maSp) throws Exception {
        String endpoint = String.format("/%s/%s", maPh, maSp);
        return apiClient.get(endpoint, CtphieuHoanDto.class);
    }

    // Tạo mới một CtphieuHoan
    public boolean createCtPhieuHoan(CreateCtphieuHoanRequestDto dto) throws Exception {
        return apiClient.post("", dto);
    }

    // Cập nhật một CtphieuHoan
    public boolean updateCtPhieuHoan(String maPh, String maSp, UpdateCtphieuHoanDto dto) throws Exception {
        String endpoint = String.format("/%s/%s", maPh, maSp);
        return apiClient.put(endpoint, dto);
    }

    // Xóa một CtphieuHoan
    public boolean deleteCtPhieuHoan(String maPh, String maSp) throws Exception {
        String endpoint = String.format("/%s/%s", maPh, maSp);
        return apiClient.delete(endpoint);
    }
}
