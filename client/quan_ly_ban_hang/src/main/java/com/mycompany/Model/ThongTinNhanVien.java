package com.mycompany.Model;

import com.google.gson.reflect.TypeToken;
import java.util.List;
import com.mycompany.Dtos.ThongTinNhanVien.CreateThongTinNhanVienRequestDto;
import com.mycompany.Dtos.ThongTinNhanVien.ThongTinNhanVienDto;
import com.mycompany.Dtos.ThongTinNhanVien.UpdateThongTinNhanVienDto;

public class ThongTinNhanVien {

    private static final String BASE_URL = "http://localhost:5106/api/thongtinnhanvien";
    private final ApiClient apiClient;

    public ThongTinNhanVien() {
        this.apiClient = new ApiClient(BASE_URL);
    }

    // Lấy tất cả thông tin nhân viên từ API
    public List<ThongTinNhanVienDto> getAllThongTinNhanViens() throws Exception {
        return apiClient.get("", new TypeToken<List<ThongTinNhanVienDto>>() {}.getType());
    }

    // Lấy một thông tin nhân viên theo mã nhân viên
    public ThongTinNhanVienDto getThongTinNhanVienByMaNv(String maNv) throws Exception {
        String endpoint = String.format("/%s", maNv);
        return apiClient.get(endpoint, ThongTinNhanVienDto.class);
    }

    // Tạo mới một thông tin nhân viên
    public boolean createThongTinNhanVien(CreateThongTinNhanVienRequestDto dto) throws Exception {
        return apiClient.post("", dto);
    }

    // Cập nhật một thông tin nhân viên
    public boolean updateThongTinNhanVien(String maNv, UpdateThongTinNhanVienDto dto) throws Exception {
        String endpoint = String.format("/%s", maNv);
        return apiClient.put(endpoint, dto);
    }

    // Xóa một thông tin nhân viên
    public boolean deleteThongTinNhanVien(String maNv) throws Exception {
        String endpoint = String.format("/%s", maNv);
        return apiClient.delete(endpoint);
    }
}
