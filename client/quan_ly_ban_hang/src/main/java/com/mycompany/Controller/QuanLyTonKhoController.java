package com.mycompany.Controller;

import com.mycompany.Dtos.SanPham.SanPhamDto;
import com.mycompany.Model.LoaiSp;
import com.mycompany.Model.SanPham;
import com.mycompany.Dtos.LoaiSpt.LoaiSpDto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class QuanLyTonKhoController {

    private final SanPham sanPhamModel;

    public QuanLyTonKhoController() {
        this.sanPhamModel = new SanPham();
    }

    // Lấy tất cả sản phẩm
    public List<SanPhamDto> getAllSanPhams() {
        try {
            List<SanPhamDto> sanPhams = sanPhamModel.getAllSanPhams();
            if (sanPhams == null || sanPhams.isEmpty()) {
                System.out.println("Không có sản phẩm nào trong kho.");
            }
            return sanPhams;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Đã xảy ra lỗi khi lấy danh sách sản phẩm.");
            return null;
        }
    }
    
    public List<SanPhamDto> searchProductsInTable(DefaultTableModel model, String searchTerm) {
        List<SanPhamDto> foundProducts = new ArrayList<>();

        // Duyệt qua các hàng trong DefaultTableModel
        for (int i = 0; i < model.getRowCount(); i++) {
            String tenSp = model.getValueAt(i, 1).toString();
            if (tenSp.toLowerCase().contains(searchTerm.toLowerCase())) {
                foundProducts.add(new SanPhamDto(
                    model.getValueAt(i, 0).toString(),
                    tenSp,
                    Integer.parseInt(model.getValueAt(i, 2).toString())
                ));
            }
        }

        return foundProducts;
    }
    
    public List<LoaiSpDto> getAllLoaiSp() {
        LoaiSp loaiSpModel = new LoaiSp(); // Khởi tạo đối tượng LoaiSp
        try {
            return loaiSpModel.getAllLoaiSps(); // Gọi phương thức từ đối tượng
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public List<SanPhamDto> getProductsByLoaiSp(String tenLoaiSp) {
        try {
            LoaiSp loaiSpModel = new LoaiSp();
            LoaiSpDto loaiSp = loaiSpModel.getLoaiSpByTenLoai(tenLoaiSp);
            if (loaiSp != null) {
                String maLoai = loaiSp.getMaLoai();
                return sanPhamModel.getSanPhamsByMaLoai(maLoai);
            } else {
                System.out.println("Không tìm thấy loại sản phẩm nào với tên: " + tenLoaiSp);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
