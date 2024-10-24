/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Controller.QuanLyDonHangController;
import com.mycompany.Dtos.CtdonDh.CtdonDhWithTenSp;
import com.mycompany.Dtos.DonDh.DonDhWithTenKhDto;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class pQuanLyDonHang extends javax.swing.JPanel {
    private final QuanLyDonHangController controller;
    private String maNv;
    
    public pQuanLyDonHang(String maNv) {
        this.controller = new QuanLyDonHangController();
        this.maNv = maNv;
        initComponents();
        loadDonHangs();
        initButtonListeners();
    }
    
    private void initButtonListeners() {
        jButton_timKhiemDH.addActionListener(evt -> searchDonHang());
        jButton_TaoDH.addActionListener(evt -> createDonHang());
        jButton_CapNhatDH.addActionListener(evt -> updateDonHang());
        jButton_XoaDH.addActionListener(evt -> deleteDonHang());
        jTable_DonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DonHangMouseClicked(evt);
            }
        });
    }
    
    private void loadDonHangs() {
        List<DonDhWithTenKhDto> donHangs = controller.getAllWithTenKh();

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_DonHang.getModel();
        model.setRowCount(0);

        if (donHangs != null && !donHangs.isEmpty()) {
            for (DonDhWithTenKhDto donHang : donHangs) {
                model.addRow(new Object[]{
                    donHang.getMaDdh(),    
                    donHang.getTenKh(),     
                    donHang.getNgayLap(),   
                    donHang.getNgayGiao(),  
                    donHang.getTinhTrang()
                });
            }
        } else {
            System.out.println("Không có đơn hàng nào.");
        }
    }

    private void createDonHang() {
        pTaoDonHang taoDonHang = new pTaoDonHang(maNv);

        JDialog dialog = new JDialog();
        dialog.setTitle("Tạo Đơn Hàng Mới");
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.add(taoDonHang);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setModal(true);
        dialog.setVisible(true);
        loadDonHangs();
    }

    private void updateDonHang() {
        int selectedRow = jTable_DonHang.getSelectedRow();
        if (selectedRow != -1) {
            pCapNhatDH taoDonHang = new pCapNhatDH(jTable_DonHang.getValueAt(selectedRow, 0).toString());

            JDialog dialog = new JDialog();
            dialog.setTitle("Cập nhật đơn hàng");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.add(taoDonHang);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
            dialog.setModal(true);
            dialog.setVisible(true);
            loadDonHangs();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn hàng cần cập nhật." , "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void deleteDonHang() {
        int selectedRow = jTable_DonHang.getSelectedRow();
        if (selectedRow != -1) {
            String maDdh = jTable_DonHang.getValueAt(selectedRow, 0).toString();

            if (controller.hasProducts(maDdh)) {
                int confirm = JOptionPane.showConfirmDialog(this, 
                    "Đơn hàng này có các sản phẩm. Bạn có chắc chắn muốn xóa tất cả sản phẩm trước khi xóa đơn hàng không?", 
                    "Xác nhận", 
                    JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    updateDonHang();

                    String result = controller.deleteDonDh(maDdh);

                    if (result.equals("Xóa đơn hàng thành công.")) {
                        JOptionPane.showMessageDialog(this, "Xóa đơn hàng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        loadDonHangs();
                    } else {
                        JOptionPane.showMessageDialog(this, result, "Lỗi", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                String result = controller.deleteDonDh(maDdh);

                if (result.equals("Xóa đơn hàng thành công.")) {
                    JOptionPane.showMessageDialog(this, "Xóa đơn hàng thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    loadDonHangs();
                } else {
                    JOptionPane.showMessageDialog(this, result, "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn hàng cần xóa.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }




    private void searchDonHang() {
        String tenKh = jTextField_TimKiemDH.getText().trim();
        List<DonDhWithTenKhDto> filteredDonHangs = controller.searchDonHangsByTenKh(tenKh);

        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_DonHang.getModel();
        model.setRowCount(0);

        for (DonDhWithTenKhDto donHang : filteredDonHangs) {
            model.addRow(new Object[]{
                donHang.getMaDdh(),
                donHang.getTenKh(),
                donHang.getNgayLap(),
                donHang.getNgayGiao(),
                donHang.getTinhTrang()
            });
        }
    }
    
    private void jTable_DonHangMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable_DonHang.getSelectedRow();
        if (selectedRow != -1) {
            String maDdh = jTable_DonHang.getValueAt(selectedRow, 0).toString();
            jTextField_MaDH.setText(maDdh);
            
            loadChiTietDonHang(maDdh);
        }
    }
    
    private void loadChiTietDonHang(String maDdh) {
        try {
            List<CtdonDhWithTenSp> chiTietDonHangs = controller.getCtdonDhsByMaDdh(maDdh);

            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_chiTietDH.getModel();
            model.setRowCount(0);

            if (chiTietDonHangs != null && !chiTietDonHangs.isEmpty()) {
                for (CtdonDhWithTenSp chiTiet : chiTietDonHangs) {
                    model.addRow(new Object[]{
                        chiTiet.getMaSp(),
                        chiTiet.getTenSp(),
                        chiTiet.getSoLuong()
                    });
                }
            } else {
                System.out.println("Không có chi tiết đơn hàng nào.");
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi tải chi tiết đơn hàng: " + e.getMessage());
        }
    }



    private void jTable_chitietDHMouseClicked(java.awt.event.MouseEvent evt) {
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_TimKiemDH = new javax.swing.JTextField();
        jButton_timKhiemDH = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DonHang = new javax.swing.JTable();
        jButton_TaoDH = new javax.swing.JButton();
        jButton_CapNhatDH = new javax.swing.JButton();
        jButton_XoaDH = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField_MaDH = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_chiTietDH = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jButton_timKhiemDH.setBackground(new java.awt.Color(51, 153, 255));
        jButton_timKhiemDH.setForeground(new java.awt.Color(255, 255, 255));
        jButton_timKhiemDH.setText("TÌM KIẾM");

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DANH SÁCH ĐẶT ĐƠN HÀNG");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel1.setOpaque(true);

        jTable_DonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã đơn", "Tên KH", "Ngày dặt", "Ngày giao", "Trạng thái"
            }
        ));
        jTable_DonHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_DonHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable_DonHang);

        jButton_TaoDH.setBackground(new java.awt.Color(51, 153, 255));
        jButton_TaoDH.setForeground(new java.awt.Color(255, 255, 255));
        jButton_TaoDH.setText("Tạo đơn hàng mới");

        jButton_CapNhatDH.setBackground(new java.awt.Color(51, 153, 255));
        jButton_CapNhatDH.setForeground(new java.awt.Color(255, 255, 255));
        jButton_CapNhatDH.setText("Cập nhật đơn hàng");

        jButton_XoaDH.setBackground(new java.awt.Color(51, 153, 255));
        jButton_XoaDH.setForeground(new java.awt.Color(255, 255, 255));
        jButton_XoaDH.setText("Xóa đơn hàng ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("CHI TIẾT ĐƠN ĐẶT HÀNG");

        jTable_chiTietDH.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable_chiTietDH.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_chiTietDH.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable_chiTietDH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_MaDH)
                        .addGap(192, 192, 192))
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addComponent(jTextField_TimKiemDH, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_CapNhatDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_XoaDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_TaoDH, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_timKhiemDH, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_timKhiemDH)
                    .addComponent(jTextField_TimKiemDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_TaoDH)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_CapNhatDH)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_XoaDH)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(jTextField_MaDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_CapNhatDH;
    private javax.swing.JButton jButton_TaoDH;
    private javax.swing.JButton jButton_XoaDH;
    private javax.swing.JButton jButton_timKhiemDH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_DonHang;
    private javax.swing.JTable jTable_chiTietDH;
    private javax.swing.JTextField jTextField_MaDH;
    private javax.swing.JTextField jTextField_TimKiemDH;
    // End of variables declaration//GEN-END:variables
}
