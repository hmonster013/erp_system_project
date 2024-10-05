package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.DonDh.CreateDonDhRequestDto;
import com.mycompany.Dtos.DonDh.DonDhDto;
import com.mycompany.Dtos.DonDh.DonDhWithTenKhDto;
import com.mycompany.Dtos.DonDh.UpdateDonDhDto;

public class DonDh {

    private static final String BASE_URL = "http://localhost:5106/api/dondh";
    private final ApiClient apiClient;

    public DonDh() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả DonDh từ API
    public List<DonDhDto> getAllDonDhs() throws Exception {
        return apiClient.get("", new TypeToken<List<DonDhDto>>() {}.getType());
    }

    // Lấy một DonDh theo ID
    public DonDhDto getDonDhById(String maDdh) throws Exception {
        String endpoint = String.format("/%s", maDdh);
        return apiClient.get(endpoint, DonDhDto.class);
    }

    // Tạo mới một DonDh
    public boolean createDonDh(CreateDonDhRequestDto dto) throws Exception {
        return apiClient.post("", dto);
    }

    // Cập nhật một DonDh
    public boolean updateDonDh(String maDdh, UpdateDonDhDto dto) throws Exception {
        String endpoint = String.format("/%s", maDdh);
        return apiClient.put(endpoint, dto);
    }

    // Xóa một DonDh
    public boolean deleteDonDh(String maDdh) throws Exception {
        String endpoint = String.format("/%s", maDdh);
        return apiClient.delete(endpoint);
    }
    
    // Tìm kiếm DonDh theo tên khách hàng
    public List<DonDhDto> searchDonDhsByTenKh(String tenKh) throws Exception {
        String encodedTenKh = java.net.URLEncoder.encode(tenKh, "UTF-8").replace("+", "%20");
        String endpoint = String.format("/search/%s", encodedTenKh);
        return apiClient.get(endpoint, new TypeToken<List<DonDhDto>>() {}.getType());
    }

    // Lấy tất cả DonDh với tên khách hàng
    public List<DonDhWithTenKhDto> getAllWithTenKh() throws Exception {
        String endpoint = "/all-with-tenkh";
        return apiClient.get(endpoint, new TypeToken<List<DonDhWithTenKhDto>>() {}.getType());
    }
}
