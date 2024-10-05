package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.CtdonDh.CreateCtdonDhRequestDto;
import com.mycompany.Dtos.CtdonDh.CtdonDhDto;
import com.mycompany.Dtos.CtdonDh.CtdonDhWithTenSp;
import com.mycompany.Dtos.CtdonDh.UpdateCtdonDhDto;

public class CtdonDh {

    private static final String BASE_URL = "http://localhost:5106/api/ctdondh";
    private final ApiClient apiClient;

    public CtdonDh() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả CtdonDh từ API
    public List<CtdonDhDto> getAllCtdonDhs() throws Exception {
        return apiClient.get("", new TypeToken<List<CtdonDhDto>>() {}.getType());
    }

    // Lấy một CtdonDh theo ID
    public CtdonDhDto getCtdonDhById(String maDdh, String maSp) throws Exception {
        String endpoint = String.format("/%s/%s", maDdh, maSp);
        return apiClient.get(endpoint, CtdonDhDto.class);
    }

    // Tạo mới một CtdonDh
    public boolean createCtdonDh(CreateCtdonDhRequestDto dto) throws Exception {
        return apiClient.post("", dto);
    }

    // Cập nhật một CtdonDh
    public boolean updateCtdonDh(String maDdh, String maSp, UpdateCtdonDhDto dto) throws Exception {
        String endpoint = String.format("/%s/%s", maDdh, maSp);
        return apiClient.put(endpoint, dto);
    }

    // Xóa một CtdonDh
    public boolean deleteCtdonDh(String maDdh, String maSp) throws Exception {
        String endpoint = String.format("/%s/%s", maDdh, maSp);
        return apiClient.delete(endpoint);
    }
    
    // Lấy danh sách CtdonDh theo maDdh
    public List<CtdonDhWithTenSp> getCtdonDhsByMaDdh(String maDdh) throws Exception {
        String endpoint = String.format("/search/%s", maDdh);
        return apiClient.get(endpoint, new TypeToken<List<CtdonDhWithTenSp>>() {}.getType());
    }
}
