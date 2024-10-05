/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Controller.QuanLyDonHangController;
import com.mycompany.Controller.QuanLyTonKhoController;
import com.mycompany.Dtos.CtdonDh.CreateCtdonDhRequestDto;
import com.mycompany.Dtos.CtdonDh.CtdonDhWithTenSp;
import com.mycompany.Dtos.CtdonDh.UpdateCtdonDhDto;
import com.mycompany.Dtos.SanPham.SanPhamDto;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class pCapNhatDH extends javax.swing.JPanel {
    private String maDdh;
    private QuanLyTonKhoController quanLyTonKhoController;
    private QuanLyDonHangController quanLyDonHangController;
    
    public pCapNhatDH(String maDdh) {
        this.maDdh = maDdh;
        quanLyTonKhoController = new QuanLyTonKhoController();
        quanLyDonHangController = new QuanLyDonHangController();
        
        initComponents();
        jTextField_MaDH.setText(maDdh);
        
        initButtonListeners();
        loadSanPhams();
        loadChiTietDonHang(maDdh);
    }
    
    
    private void initButtonListeners() {
        jButton_ThemMH.addActionListener(evt -> addCtDonDh());
        jButton_TimTenHang.addActionListener(evt -> searchSanPham());
        jButton_XoaMH.addActionListener(evt -> deleteCtDonDh());
        jButton_CapNhatMH.addActionListener(evt -> updateCtDonDh());
        jButton_HoanThanh.addActionListener(evt -> hoanThanh());
        jTable_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    jTable_danhSachSpMouseClicked(evt);
                }
            }
        });
        jTable_danhSachDaThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    jTable_danhSachSpDaThemMouseClicked(evt);
                }
            }
        });
    }
    
    private void jTable_danhSachSpMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable_SanPham.getSelectedRow();
        if (selectedRow != -1) {
            jTextField_MaMH.setText(jTable_SanPham.getValueAt(selectedRow, 0).toString());
            jTextField_TenMH.setText(jTable_SanPham.getValueAt(selectedRow, 1).toString());
        }
    }
    
    private void jTable_danhSachSpDaThemMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable_danhSachDaThem.getSelectedRow();
        if (selectedRow != -1) {
            jTextField_MaMH.setText(jTable_danhSachDaThem.getValueAt(selectedRow, 0).toString());
            jTextField_TenMH.setText(jTable_danhSachDaThem.getValueAt(selectedRow, 1).toString());
            jTextField_SoLuongMH.setText(jTable_danhSachDaThem.getValueAt(selectedRow, 2).toString());
        }
    }
    
    private void addCtDonDh() {
        String maDdh = jTextField_MaDH.getText();
        String maSp = jTextField_MaMH.getText();
        String tenSp = jTextField_TenMH.getText();
        String soLuongStr = jTextField_SoLuongMH.getText();

        if (maDdh.isEmpty() || maSp.isEmpty() || soLuongStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin chi tiết đơn hàng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer soLuong;
        try {
            soLuong = Integer.parseInt(soLuongStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CreateCtdonDhRequestDto createCtdonDhRequestDto = new CreateCtdonDhRequestDto();
        createCtdonDhRequestDto.setMaDdh(maDdh);
        createCtdonDhRequestDto.setMaSp(maSp);
        createCtdonDhRequestDto.setSoLuong(soLuong);

        String result = quanLyDonHangController.createCtdonDh(createCtdonDhRequestDto);

        if (result.equals("Thêm sản phẩm thành công.")) {
            DefaultTableModel model = (DefaultTableModel) jTable_danhSachDaThem.getModel();
            model.addRow(new Object[]{maSp, tenSp, soLuong});
            
            loadSanPhams();
            
            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            jTextField_MaMH.setText("");
            jTextField_TenMH.setText("");
            jTextField_SoLuongMH.setText("");
        } else {
            JOptionPane.showMessageDialog(this, result, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateCtDonDh() {
        // Lấy thông tin chi tiết đơn hàng từ giao diện
        String maDdh = jTextField_MaDH.getText();
        String maSp = jTextField_MaMH.getText();
        String soLuongStr = jTextField_SoLuongMH.getText();

        if (maDdh.isEmpty() || maSp.isEmpty() || soLuongStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin để cập nhật.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Integer soLuong;
        try {
            soLuong = Integer.parseInt(soLuongStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Tạo DTO để gửi đến controller
        UpdateCtdonDhDto updateCtdonDhDto = new UpdateCtdonDhDto();
        updateCtdonDhDto.setSoLuong(soLuong);

        // Gọi phương thức update từ controller
        String result = quanLyDonHangController.updateCtdonDh(maDdh, maSp, updateCtdonDhDto);

        if (result.equals("Cập nhật sản phẩm thành công.")) {
            loadSanPhams();
            JOptionPane.showMessageDialog(this, "Cập nhật sản phẩm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadChiTietDonHang(maDdh); // Tải lại chi tiết đơn hàng sau khi cập nhật
        } else {
            JOptionPane.showMessageDialog(this, result, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteCtDonDh() {
        String maDdh = jTextField_MaDH.getText();
        String maSp = jTextField_MaMH.getText();

        if (maDdh.isEmpty() || maSp.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = quanLyDonHangController.deleteCtdonDh(maDdh, maSp);

        if (result.equals("Xóa sản phẩm thành công.")) {
            loadSanPhams();
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadChiTietDonHang(maDdh);
        } else {
            JOptionPane.showMessageDialog(this, result, "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void searchSanPham () {
        String searchTerm = jTextField_SearchTenSanPham.getText();
        DefaultTableModel model = (DefaultTableModel) jTable_SanPham.getModel();
        
        if (searchTerm.isEmpty()) {
            loadSanPhams();
            return;
        }
        
        List<SanPhamDto> foundProducts = quanLyTonKhoController.searchProductsInTable(model, searchTerm);

        model.setRowCount(0);

        if (!foundProducts.isEmpty()) {
            for (SanPhamDto sanPham : foundProducts) {
                model.addRow(new Object[]{
                    sanPham.getMaSp(),
                    sanPham.getTenSp(),
                    sanPham.getGiaBan(),
                    sanPham.getSoLuongTon()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void loadSanPhams() {
        List<SanPhamDto> sanPhams = quanLyTonKhoController.getAllSanPhams();
        DefaultTableModel model = (DefaultTableModel) jTable_SanPham.getModel();
        model.setRowCount(0);

        if (sanPhams != null) {
            for (SanPhamDto sanPham : sanPhams) {
                model.addRow(new Object[]{
                    sanPham.getMaSp(),
                    sanPham.getTenSp(),
                    sanPham.getGiaBan(),
                    sanPham.getSoLuongTon()
                });
            }
        }
    }
    
    private void loadChiTietDonHang(String maDdh) {
        try {
            List<CtdonDhWithTenSp> chiTietDonHangs = quanLyDonHangController.getCtdonDhsByMaDdh(maDdh);

            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_danhSachDaThem.getModel();
            model.setRowCount(0);

            if (chiTietDonHangs != null && !chiTietDonHangs.isEmpty()) {
                for (CtdonDhWithTenSp chiTiet : chiTietDonHangs) {
                    model.addRow(new Object[]{
                        chiTiet.getMaSp(),
                        chiTiet.getTenSp(),
                        chiTiet.getSoLuong()
                    });
                }
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi tải chi tiết đơn hàng: " + e.getMessage());
        }
    }
    
    public void hoanThanh () {
        java.awt.Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof JDialog) {
            ((JDialog) window).dispose();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_SearchTenSanPham = new javax.swing.JTextField();
        jButton_TimTenHang = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_SanPham = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_danhSachDaThem = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_MaDH = new javax.swing.JTextField();
        jTextField_MaMH = new javax.swing.JTextField();
        jTextField_TenMH = new javax.swing.JTextField();
        jTextField_SoLuongMH = new javax.swing.JTextField();
        jButton_ThemMH = new javax.swing.JButton();
        jButton_HoanThanh = new javax.swing.JButton();
        jButton_XoaMH = new javax.swing.JButton();
        jButton_CapNhatMH = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("CẬP NHẬT ĐƠN HÀNG");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Chọn mặt hàng");

        jButton_TimTenHang.setText("Tìm");

        jTable_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã mặt hàng", "Tên mặt hàng", "Giá", "Số lượng tồn"
            }
        ));
        jScrollPane1.setViewportView(jTable_SanPham);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Chi tiết đơn hàng");

        jTable_danhSachDaThem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã mặt hàng", "Tên mặt hàng", "Số lượng đặt"
            }
        ));
        jScrollPane2.setViewportView(jTable_danhSachDaThem);

        jLabel4.setText("Mã đơn hàng");

        jLabel5.setText("Mã mặt hàng");

        jLabel6.setText("Tên mặt hàng");

        jLabel7.setText("Số lượng đặt");

        jTextField_MaDH.setEnabled(false);

        jButton_ThemMH.setText("Thêm mặt hàng");

        jButton_HoanThanh.setText("Hoàn thành");

        jButton_XoaMH.setText("Xóa mặt hàng");

        jButton_CapNhatMH.setText("Cập nhật");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField_SearchTenSanPham)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_TimTenHang))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton_CapNhatMH)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7))
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField_MaMH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_MaDH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_SoLuongMH, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField_TenMH, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton_HoanThanh, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton_XoaMH, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton_ThemMH, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_SearchTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimTenHang))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_MaDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_MaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_TenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_SoLuongMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(jButton_ThemMH)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_CapNhatMH))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_XoaMH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_HoanThanh))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CapNhatMH;
    private javax.swing.JButton jButton_HoanThanh;
    private javax.swing.JButton jButton_ThemMH;
    private javax.swing.JButton jButton_TimTenHang;
    private javax.swing.JButton jButton_XoaMH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_SanPham;
    private javax.swing.JTable jTable_danhSachDaThem;
    private javax.swing.JTextField jTextField_MaDH;
    private javax.swing.JTextField jTextField_MaMH;
    private javax.swing.JTextField jTextField_SearchTenSanPham;
    private javax.swing.JTextField jTextField_SoLuongMH;
    private javax.swing.JTextField jTextField_TenMH;
    // End of variables declaration//GEN-END:variables
}
