/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Controller.QuanLyTonKhoController;
import com.mycompany.Dtos.SanPham.SanPhamDto;
import com.mycompany.dtos.loaisp.LoaiSpDto;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class pQuanLyTonKho extends javax.swing.JPanel {
    private final QuanLyTonKhoController quanLyTonKhoController;

    public pQuanLyTonKho() {
        initComponents();
        this.quanLyTonKhoController = new QuanLyTonKhoController();
        showAllProducts();
        loadLoaiSp();
        initButtonListeners();
    }

    private void initButtonListeners() {
        jButton_ShowAllSp.addActionListener(evt -> showAllProducts()); // Hiển thị tất cả sản phẩm
        jButton_TimKiem.addActionListener(evt -> searchProducts()); // Tìm kiếm sản phẩm
        jComboBox_LoaiSp.addActionListener(evt -> updateProductsByLoaiSp());
    }
    
    private void loadLoaiSp() {
        List<LoaiSpDto> loaiSps = quanLyTonKhoController.getAllLoaiSp();
        jComboBox_LoaiSp.removeAllItems();

        if (loaiSps != null) {
            for (LoaiSpDto loaiSp : loaiSps) {
                jComboBox_LoaiSp.addItem(loaiSp.getTenLoai());
            }
        }
    }

    private void showAllProducts() {
        List<SanPhamDto> sanPhams = quanLyTonKhoController.getAllSanPhams();
        DefaultTableModel model = (DefaultTableModel) jTable_SanPham.getModel();
        model.setRowCount(0);

        if (sanPhams != null) {
            for (SanPhamDto sanPham : sanPhams) {
                model.addRow(new Object[]{
                    sanPham.getMaSp(),
                    sanPham.getTenSp(),
                    sanPham.getSoLuongTon()
                });
            }
        }
    }

    private void searchProducts() {
        String searchTerm = jTextField_TenSp.getText().trim();
        DefaultTableModel model = (DefaultTableModel) jTable_SanPham.getModel();

        List<SanPhamDto> foundProducts = quanLyTonKhoController.searchProductsInTable(model, searchTerm);

        model.setRowCount(0);

        if (!foundProducts.isEmpty()) {
            for (SanPhamDto sanPham : foundProducts) {
                model.addRow(new Object[]{
                    sanPham.getMaSp(),
                    sanPham.getTenSp(),
                    sanPham.getSoLuongTon()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void updateProductsByLoaiSp() {
        String tenLoaiSp = (String) jComboBox_LoaiSp.getSelectedItem();
        if (tenLoaiSp != null) {
            List<SanPhamDto> sanPhams = quanLyTonKhoController.getProductsByLoaiSp(tenLoaiSp);
            DefaultTableModel model = (DefaultTableModel) jTable_SanPham.getModel();
            model.setRowCount(0); // Xóa dữ liệu cũ trong bảng

            if (sanPhams != null) {
                for (SanPhamDto sanPham : sanPhams) {
                    model.addRow(new Object[]{
                        sanPham.getMaSp(),
                        sanPham.getTenSp(),
                        sanPham.getSoLuongTon()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào cho loại đã chọn!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
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

        jTextField_TenSp = new javax.swing.JTextField();
        jComboBox_LoaiSp = new javax.swing.JComboBox<>();
        jButton_TimKiem = new javax.swing.JButton();
        jButton_ShowAllSp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_SanPham = new javax.swing.JTable();

        jComboBox_LoaiSp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton_TimKiem.setText("Tìm kiếm");

        jButton_ShowAllSp.setText("Hiển thị tất cả");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("DANH KHÁCH MẶT HÀNG");

        jTable_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã mặt hàng", "Tên mặt hàng", "Số lượng tồn"
            }
        ));
        jScrollPane1.setViewportView(jTable_SanPham);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_LoaiSp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_TenSp))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_ShowAllSp, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                            .addComponent(jButton_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_TenSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiem))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_LoaiSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_ShowAllSp))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ShowAllSp;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JComboBox<String> jComboBox_LoaiSp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_SanPham;
    private javax.swing.JTextField jTextField_TenSp;
    // End of variables declaration//GEN-END:variables
}
