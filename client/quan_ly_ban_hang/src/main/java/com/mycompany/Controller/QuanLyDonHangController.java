/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Dtos.CtdonDh.CreateCtdonDhRequestDto;
import com.mycompany.Dtos.CtdonDh.CtdonDhDto;
import com.mycompany.Dtos.CtdonDh.CtdonDhWithTenSp;
import com.mycompany.Dtos.CtdonDh.UpdateCtdonDhDto;
import com.mycompany.Dtos.DonDh.CreateDonDhRequestDto;
import com.mycompany.Dtos.DonDh.DonDhWithTenKhDto;
import com.mycompany.Dtos.SanPham.SanPhamDto;
import com.mycompany.Dtos.SanPham.UpdateSanPhamDto;
import com.mycompany.Model.CtdonDh;
import com.mycompany.Model.DonDh;
import com.mycompany.Model.SanPham;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ACER
 */
public class QuanLyDonHangController {
    private final DonDh donDhModel;
    private final CtdonDh ctdonDhModel;
    
    public QuanLyDonHangController() {
        this.donDhModel = new DonDh();
        this.ctdonDhModel = new CtdonDh();
    }
    
    public List<DonDhWithTenKhDto> getAllWithTenKh() {
        try {
            return donDhModel.getAllWithTenKh();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Tìm kiếm đơn hàng theo tên khách hàng
    public List<DonDhWithTenKhDto> searchDonHangsByTenKh(String tenKh) {
        List<DonDhWithTenKhDto> donHangs = getAllWithTenKh();
        if (tenKh == null || tenKh.isEmpty()) {
            return donHangs;
        }
        return donHangs.stream()
                .filter(donHang -> donHang.getTenKh().toLowerCase().contains(tenKh.toLowerCase()))
                .collect(Collectors.toList());
    }
    
    // Lấy CtdonDh theo mã đơn hàng
    public List<CtdonDhWithTenSp> getCtdonDhsByMaDdh(String maDdh) throws Exception {
        try {
            return ctdonDhModel.getCtdonDhsByMaDdh(maDdh);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    // Tính tổng tiền cho một đơn hàng theo mã đơn hàng
    public int calculateTotalAmount(String maDdh) throws Exception {
        int totalAmount = 0;
        List<CtdonDhWithTenSp> chiTietDonHangs = getCtdonDhsByMaDdh(maDdh);
        
        if (chiTietDonHangs == null) {
            return 0;
        }
        
        for (CtdonDhWithTenSp chiTiet : chiTietDonHangs) {
            totalAmount += (chiTiet.getGiaBan() * chiTiet.getSoLuong());
        }

        return totalAmount;
    }
    
    public String createDonDh(CreateDonDhRequestDto dto) {
        if (!validateDonDh(dto)) {
            return "Vui lòng nhập đầy đủ thông tin đơn hàng.";
        }

        if (isDonDhExists(dto.getMaDdh())) {
            return "Đơn hàng đã tồn tại.";
        }

        try {
            boolean isCreated = donDhModel.createDonDh(dto);
            return isCreated ? "Tạo đơn hàng thành công." : "Tạo đơn hàng thất bại.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Tạo đơn hàng thất bại.";
        }
    }
    
    // Trong class QuanLyDonHangController
    public String deleteDonDh(String maDdh) {
        try {
            if (hasProducts(maDdh)) {
                return "Đơn hàng này có sản phẩm. Vui lòng xóa tất cả sản phẩm trước khi xóa đơn hàng.";
            }

            boolean isDeleted = donDhModel.deleteDonDh(maDdh);
            return isDeleted ? "Xóa đơn hàng thành công." : "Xóa đơn hàng thất bại.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Đã xảy ra lỗi khi xóa đơn hàng: " + e.getMessage();
        }
    }

    
    public boolean hasProducts(String maDdh) {
        try {
            List<CtdonDhWithTenSp> chiTietDonHangs = getCtdonDhsByMaDdh(maDdh);
            return chiTietDonHangs != null && !chiTietDonHangs.isEmpty();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    private boolean validateDonDh(CreateDonDhRequestDto dto) {
        return dto.getMaDdh() != null && !dto.getMaDdh().isEmpty()
                && dto.getMaKh() != null && !dto.getMaKh().isEmpty()
                && dto.getNgayLap() != null
                && dto.getNgayGiao() != null
                && dto.getTinhTrang() != null && !dto.getTinhTrang().isEmpty()
                && dto.getMaNv() != null && !dto.getMaNv().isEmpty();
    }

    private boolean isDonDhExists(String maDdh) {
        try {
            return donDhModel.getDonDhById(maDdh) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Thêm sản phẩm vào đơn hàng
    public String createCtdonDh(CreateCtdonDhRequestDto createCtdonDhRequestDto) {
        if (!validateCtdonDh(createCtdonDhRequestDto)) {
            return "Vui lòng nhập đầy đủ thông tin chi tiết đơn hàng.";
        }

        if (isCtdonDhExists(createCtdonDhRequestDto.getMaDdh(), createCtdonDhRequestDto.getMaSp())) {
            return "Sản phẩm đã tồn tại trong đơn hàng.";
        }

        try {
            // Giảm số lượng tồn khi thêm sản phẩm vào đơn hàng
            String maSp = createCtdonDhRequestDto.getMaSp();
            int soLuong = createCtdonDhRequestDto.getSoLuong();
            boolean isUpdated = updateSoLuongTon(maSp, -soLuong);

            if (!isUpdated) {
                return "Cập nhật số lượng tồn thất bại. Không thể thêm sản phẩm.";
            }

            boolean isCreated = ctdonDhModel.createCtdonDh(createCtdonDhRequestDto);
            return isCreated ? "Thêm sản phẩm thành công." : "Thêm sản phẩm thất bại.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Thêm sản phẩm thất bại.";
        }
    }

    
    // Cập nhật sản phẩm trong đơn hàng
    public String updateCtdonDh(String maDdh, String maSp, UpdateCtdonDhDto updateCtdonDhDto) {
        if (!validateUpdateCtdonDh(updateCtdonDhDto)) {
            return "Vui lòng nhập đầy đủ thông tin để cập nhật chi tiết đơn hàng.";
        }

        try {
            CtdonDhDto chiTietCu = ctdonDhModel.getCtdonDhById(maDdh, maSp);
            int soLuongCu = chiTietCu.getSoLuong();
            int soLuongMoi = updateCtdonDhDto.getSoLuong();

            if (soLuongMoi != soLuongCu) {
                if (soLuongMoi < soLuongCu) {
                    int soLuongThayDoi = soLuongCu - soLuongMoi;
                    boolean isUpdated = updateSoLuongTon(maSp, soLuongThayDoi);
                    if (!isUpdated) {
                        return "Cập nhật số lượng tồn thất bại.";
                    }
                } else {
                    int soLuongThayDoi = soLuongMoi - soLuongCu;
                    boolean isUpdated = updateSoLuongTon(maSp, -soLuongThayDoi);
                    if (!isUpdated) {
                        return "Cập nhật số lượng tồn thất bại.";
                    }
                }
            }

            boolean isUpdated = ctdonDhModel.updateCtdonDh(maDdh, maSp, updateCtdonDhDto);
            return isUpdated ? "Cập nhật sản phẩm thành công." : "Cập nhật sản phẩm thất bại.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Cập nhật sản phẩm thất bại.";
        }
    }


    // Hàm kiểm tra thông tin trước khi cập nhật
    private boolean validateUpdateCtdonDh(UpdateCtdonDhDto updateCtdonDhDto) {
        return updateCtdonDhDto.getSoLuong() > 0;
    }
    
    // Xóa sản phẩm khỏi đơn hàng
    public String deleteCtdonDh(String maDdh, String maSp) {
        if (!isCtdonDhExists(maDdh, maSp)) {
            return "Không tìm thấy sản phẩm trong đơn hàng.";
        }

        try {
            CtdonDhDto chiTiet = ctdonDhModel.getCtdonDhById(maDdh, maSp);
            int soLuong = chiTiet.getSoLuong();

            boolean isUpdated = updateSoLuongTon(maSp, soLuong);
            if (!isUpdated) {
                return "Cập nhật số lượng tồn thất bại. Không thể xóa sản phẩm.";
            }

            boolean isDeleted = ctdonDhModel.deleteCtdonDh(maDdh, maSp);
            return isDeleted ? "Xóa sản phẩm thành công." : "Xóa sản phẩm thất bại.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Xóa sản phẩm thất bại.";
        }
    }

    
    public boolean updateSoLuongTon(String maSp, int soLuong) {
        try {
            SanPham sanPhamModel = new SanPham();
            SanPhamDto sanPhamDto = sanPhamModel.getSanPhamById(maSp);
            if (sanPhamDto == null) {
                return false;
            }
           
            int newSoLuongTon = sanPhamDto.getSoLuongTon() + soLuong;
            UpdateSanPhamDto dto = new UpdateSanPhamDto(sanPhamDto.getMaLoai(),
                                                        sanPhamDto.getTenSp(),
                                                        sanPhamDto.getGiaBan(),
                                                        sanPhamDto.getThanhPhan(),
                                                        sanPhamDto.getKlt(),
                                                        newSoLuongTon);
            
            return sanPhamModel.updateSanPham(maSp, dto);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public boolean validateCtdonDh(CreateCtdonDhRequestDto dto) {
        return dto.getMaDdh() != null && !dto.getMaDdh().isEmpty() &&
               dto.getMaSp() != null && !dto.getMaSp().isEmpty() &&
               dto.getSoLuong() != null && dto.getSoLuong() > 0;
    }
    
    public boolean isCtdonDhExists(String maDdh, String maSp) {
        try {
            return ctdonDhModel.getCtdonDhById(maDdh, maSp) != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
