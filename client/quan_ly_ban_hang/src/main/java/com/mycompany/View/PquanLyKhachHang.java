/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Controller.QuanLyKhachHangController;
import com.mycompany.Dtos.KhachHang.CreateKhachHangRequestDto;
import com.mycompany.Dtos.KhachHang.KhachHangDto;
import com.mycompany.Dtos.KhachHang.UpdateKhachHangDto;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class pQuanLyKhachHang extends javax.swing.JPanel {

    private final QuanLyKhachHangController controller;

    public pQuanLyKhachHang() {
        initComponents();
        controller = new QuanLyKhachHangController();
        loadKhachHangs();
        initButtonListeners();
    }

    private void initButtonListeners() {
        jButton_ThemMoiKH.addActionListener(evt -> addKhachHang());
        jButton_CapNhatTT.addActionListener(evt -> updateKhachHang());
        jButton_XoaKH.addActionListener(evt -> deleteKhachHang());
        jButton_TimKiem.addActionListener(evt -> searchKhachHang());
        jTable_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_danhkhachKHMouseClicked(evt);
            }
        });
    }

    private void loadKhachHangs() {
        List<KhachHangDto> khachHangs = controller.getAllKhachHangs();
        DefaultTableModel model = (DefaultTableModel) jTable_KhachHang.getModel();
        model.setRowCount(0);

        if (khachHangs != null) {
            for (KhachHangDto kh : khachHangs) {
                model.addRow(new Object[]{
                    kh.getMaKh(), kh.getTenKh(), kh.getEmail(), kh.getSdt(), kh.getDiaChi()
                });
            }
        }
    }

    private void addKhachHang() {
        CreateKhachHangRequestDto dto = new CreateKhachHangRequestDto();
        dto.setMaKh(jTextFiel_MaKH.getText());
        dto.setTenKh(jTextFiel_TenKH.getText());
        dto.setEmail(jTextFiel_EmailKH.getText());
        dto.setSdt(jTextFiel_SdtKH.getText());
        dto.setDiaChi(jTextFiel_DiachiKH.getText());
        
        String resultMessage = controller.createKhachHang(dto);
        JOptionPane.showMessageDialog(this, resultMessage);

        if (resultMessage.equals("Thêm mới khách hàng thành công.")) {
            loadKhachHangs();
        }
    }

    private void updateKhachHang() {
        String maKh = jTextFiel_MaKH.getText();
        UpdateKhachHangDto dto = new UpdateKhachHangDto();
        dto.setTenKh(jTextFiel_TenKH.getText());
        dto.setEmail(jTextFiel_EmailKH.getText());
        dto.setSdt(jTextFiel_SdtKH.getText());
        dto.setDiaChi(jTextFiel_DiachiKH.getText());

        String resultMessage = controller.updateKhachHang(maKh, dto);
        JOptionPane.showMessageDialog(this, resultMessage);

        if (resultMessage.equals("Cập nhật thông tin thành công.")) {
            loadKhachHangs();
        }
    }

    private void deleteKhachHang() {
        String maKh = jTextFiel_MaKH.getText();

        String resultMessage = controller.deleteKhachHang(maKh);
        JOptionPane.showMessageDialog(this, resultMessage);

        if (resultMessage.equals("Xóa khách hàng thành công.")) {
            loadKhachHangs();
        }
    }


    private void searchKhachHang() {
        String searchTerm = jTextFiel_SearchTenKH.getText();

        if (searchTerm.isEmpty()) {
            loadKhachHangs();
        }

        try {
            List<KhachHangDto> khachHangsFound = controller.searchKhachHangByTen(searchTerm);

            if (khachHangsFound != null && !khachHangsFound.isEmpty()) {
                updateKhachHangTable(khachHangsFound);
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng nào với tên: " + searchTerm, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi trong quá trình tìm kiếm.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateKhachHangTable(List<KhachHangDto> khachHangs) {
        DefaultTableModel model = (DefaultTableModel) jTable_KhachHang.getModel();
        model.setRowCount(0);

        for (KhachHangDto khachHang : khachHangs) {
            model.addRow(new Object[]{khachHang.getMaKh(), 
                khachHang.getTenKh(), 
                khachHang.getEmail(), 
                khachHang.getSdt(), 
                khachHang.getDiaChi()});
        }
    }


    private void jTable_danhkhachKHMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable_KhachHang.getSelectedRow();
        if (selectedRow != -1) {
            jTextFiel_MaKH.setText(jTable_KhachHang.getValueAt(selectedRow, 0).toString());
            jTextFiel_TenKH.setText(jTable_KhachHang.getValueAt(selectedRow, 1).toString());
            jTextFiel_EmailKH.setText(jTable_KhachHang.getValueAt(selectedRow, 2).toString());
            jTextFiel_SdtKH.setText(jTable_KhachHang.getValueAt(selectedRow, 3).toString());
            jTextFiel_DiachiKH.setText(jTable_KhachHang.getValueAt(selectedRow, 4).toString());
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

        jTextFiel_SearchTenKH = new javax.swing.JTextField();
        jButton_TimKiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_KhachHang = new javax.swing.JTable();
        jButton_ThemMoiKH = new javax.swing.JButton();
        jButton_CapNhatTT = new javax.swing.JButton();
        jButton_XoaKH = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFiel_MaKH = new javax.swing.JTextField();
        jTextFiel_TenKH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFiel_EmailKH = new javax.swing.JTextField();
        jTextFiel_SdtKH = new javax.swing.JTextField();
        jTextFiel_DiachiKH = new javax.swing.JTextField();

        jButton_TimKiem.setText("Tìm kiếm");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("DANH SÁCH KHÁCH HÀNG");

        jTable_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Tên KH", "Email", "SĐT", "Địa chỉ"
            }
        ));
        jScrollPane1.setViewportView(jTable_KhachHang);

        jButton_ThemMoiKH.setText("Thêm mới khách hàng");

        jButton_CapNhatTT.setText("Cập nhật thông tin");

        jButton_XoaKH.setText("Xóa khách hàng");

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Tên khách hàng");

        jLabel5.setText("Email");

        jLabel6.setText("SĐT");

        jLabel7.setText("Địa chỉ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(360, 360, 360))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFiel_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFiel_TenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                    .addComponent(jTextFiel_EmailKH)
                                    .addComponent(jTextFiel_SdtKH)
                                    .addComponent(jTextFiel_DiachiKH)))
                            .addComponent(jTextFiel_SearchTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_ThemMoiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_CapNhatTT, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_XoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_TimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFiel_SearchTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiem))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFiel_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFiel_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton_ThemMoiKH)
                    .addComponent(jTextFiel_EmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton_CapNhatTT)
                    .addComponent(jTextFiel_SdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jButton_XoaKH)
                    .addComponent(jTextFiel_DiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CapNhatTT;
    private javax.swing.JButton jButton_ThemMoiKH;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_XoaKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_KhachHang;
    private javax.swing.JTextField jTextFiel_DiachiKH;
    private javax.swing.JTextField jTextFiel_EmailKH;
    private javax.swing.JTextField jTextFiel_MaKH;
    private javax.swing.JTextField jTextFiel_SdtKH;
    private javax.swing.JTextField jTextFiel_SearchTenKH;
    private javax.swing.JTextField jTextFiel_TenKH;
    // End of variables declaration//GEN-END:variables

}
