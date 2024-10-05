package com.mycompany.Controller;

import com.mycompany.Model.KhachHang;
import com.mycompany.Dtos.KhachHang.CreateKhachHangRequestDto;
import com.mycompany.Dtos.KhachHang.KhachHangDto;
import com.mycompany.Dtos.KhachHang.UpdateKhachHangDto;
import java.util.List;

public class QuanLyKhachHangController {
    
    private final KhachHang khachHangModel;

    public QuanLyKhachHangController() {
        this.khachHangModel = new KhachHang();
    }

    // Lấy tất cả KhachHang
    public List<KhachHangDto> getAllKhachHangs() {
        try {
            return khachHangModel.getAllKhachHangs();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Lấy thông tin KhachHang theo ID
    public KhachHangDto getKhachHangById(String maKh) {
        try {
            return khachHangModel.getKhachHangById(maKh);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Tạo mới KhachHang
    public String createKhachHang(CreateKhachHangRequestDto dto) {
        if (!validateKhachHang(dto) ) {
            return "Vui lòng nhập đầy đủ thông tin khách hàng.";
        }

        if (isKhachHangExists(dto.getMaKh())) {
            return "Khách hàng đã tồn tại.";
        }

        try {
            boolean isCreated = khachHangModel.createKhachHang(dto);
            return isCreated ? "Thêm mới khách hàng thành công." : "Thêm mới khách hàng thất bại.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Thêm mới khách hàng thất bại.";
        }
    }

    // Cập nhật thông tin KhachHang
    public String updateKhachHang(String maKh, UpdateKhachHangDto dto) {
        if (maKh.isEmpty() || maKh == null) {
            return "Vui lòng nhập mã khách hàng.";
        }
        
        // Kiểm tra xem khách hàng có tồn tại không
        if (!isKhachHangExists(maKh)) {
            return "Khách hàng không tồn tại.";
        }

        // Kiểm tra tính hợp lệ của dữ liệu
        if (!validateUpdateKhachHang(dto)) {
            return "Vui lòng nhập đầy đủ thông tin để cập nhật.";
        }

        try {
            boolean isUpdated = khachHangModel.updateKhachHang(maKh, dto);
            return isUpdated ? "Cập nhật thông tin thành công." : "Cập nhật thông tin thất bại.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Cập nhật thông tin thất bại.";
        }
    }

    // Xóa KhachHang theo mã ID
    public String deleteKhachHang(String maKh) {
        try {
            if (maKh.isEmpty() || maKh == null) {
                return "Vui lòng nhập mã khách hàng.";
            }
            
            if (!isKhachHangExists(maKh)) {
                return "Khách hàng không tồn tại.";
            }

            // Thực hiện xóa khách hàng
            boolean isDeleted = khachHangModel.deleteKhachHang(maKh);
            return isDeleted ? "Xóa khách hàng thành công." : "Xóa khách hàng thất bại.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Đã xảy ra lỗi khi xóa khách hàng. Vui lòng thử lại sau.";
        }
    }
    
    // Kiểm tra thông tin khách hàng có hợp lệ không
    public boolean validateKhachHang(CreateKhachHangRequestDto dto) {
        return dto.getMaKh() != null && !dto.getMaKh().isEmpty()
               && dto.getTenKh() != null && !dto.getTenKh().isEmpty() 
               && dto.getEmail() != null && !dto.getEmail().isEmpty() 
               && dto.getSdt() != null && !dto.getSdt().isEmpty() 
               && dto.getDiaChi() != null && !dto.getDiaChi().isEmpty();
    }
    
    public boolean validateUpdateKhachHang(UpdateKhachHangDto dto) {
        return dto.getTenKh() != null && !dto.getTenKh().isEmpty() 
               && dto.getEmail() != null && !dto.getEmail().isEmpty() 
               && dto.getSdt() != null && !dto.getSdt().isEmpty() 
               && dto.getDiaChi() != null && !dto.getDiaChi().isEmpty();
    }

    // Kiểm tra xem khách hàng có tồn tại hay không
    public boolean isKhachHangExists(String maKh) {
        KhachHangDto khachHang = getKhachHangById(maKh);
        return khachHang != null;
    }
    
    public List<KhachHangDto> searchKhachHangByTen(String tenKh) {
        try {
            return khachHangModel.searchKhachHangByTen(tenKh);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
