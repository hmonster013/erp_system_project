package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.TaiKhoan.CreateTaiKhoanRequestDto;
import com.mycompany.Dtos.TaiKhoan.TaiKhoanDto;
import com.mycompany.Dtos.TaiKhoan.UpdateTaiKhoanDto;

public class TaiKhoan {

    private static final String BASE_URL = "http://localhost:5106/api/tai-khoan";
    private final ApiClient apiClient;

    public TaiKhoan() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả TaiKhoan từ API
    public List<TaiKhoanDto> getAllTaiKhoans() throws Exception {
        return apiClient.get("", new TypeToken<List<TaiKhoanDto>>() {}.getType());
    }

    // Lấy một TaiKhoan theo Username
    public TaiKhoanDto getTaiKhoanByUsername(String username) throws Exception {
        String endpoint = String.format("/%s", username);
        return apiClient.get(endpoint, TaiKhoanDto.class);
    }

    // Tạo mới một TaiKhoan
    public boolean createTaiKhoan(CreateTaiKhoanRequestDto dto) throws Exception {
        return apiClient.post("", dto);
    }

    // Cập nhật một TaiKhoan
    public boolean updateTaiKhoan(String username, UpdateTaiKhoanDto dto) throws Exception {
        String endpoint = String.format("/%s", username);
        return apiClient.put(endpoint, dto);
    }

    // Xóa một TaiKhoan
    public boolean deleteTaiKhoan(String username) throws Exception {
        String endpoint = String.format("/%s", username);
        return apiClient.delete(endpoint);
    }
    
    public String getMaBoPhan(String MaNV) throws Exception{
        ApiClient apiClient1 = new ApiClient("http://localhost:5106/api/bophan");
        String endpoint = String.format("/%s", MaNV);
        return apiClient1.get(endpoint, String.class);
    }
}
