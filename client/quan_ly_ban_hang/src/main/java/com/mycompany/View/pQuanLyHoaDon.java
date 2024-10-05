/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Controller.QuanLyDonHangController;
import com.mycompany.Controller.QuanLyHoaDonController;
import com.mycompany.Dtos.CtdonDh.CtdonDhWithTenSp;
import com.mycompany.Dtos.DonDh.DonDhWithTenKhDto;
import com.mycompany.Dtos.HoaDon.CreateHoaDonRequestDto;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class pQuanLyHoaDon extends javax.swing.JPanel {
    private final QuanLyDonHangController controller;
    private String maNv;
    
    public pQuanLyHoaDon(String maNv) {
        this.controller = new QuanLyDonHangController();
        this.maNv = maNv;
        initComponents();
        loadDonHangs();
        initButtonListeners();
    }
    
    private void initButtonListeners() {
        jButton_TimKiem.addActionListener(evt -> searchDonHang());
        jButton_ThanhToan.addActionListener(evt -> createHoaDon());
        jButton_TinhTongHD.addActionListener(evt -> tinhTongHoaDon());
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
    
    private void searchDonHang() {
        String tenKh = jTextField_TenKH.getText().trim();
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

            try {
                int totalAmount = controller.calculateTotalAmount(maDdh);
                jTextField_TongTienHang.setText(String.valueOf(totalAmount));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi khi tính tổng tiền: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    
    private void loadChiTietDonHang(String maDdh) {
        try {
            List<CtdonDhWithTenSp> chiTietDonHangs = controller.getCtdonDhsByMaDdh(maDdh);

            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable_CtDonHang.getModel();
            model.setRowCount(0);

            if (chiTietDonHangs != null && !chiTietDonHangs.isEmpty()) {
                for (CtdonDhWithTenSp chiTiet : chiTietDonHangs) {
                    model.addRow(new Object[]{
                        chiTiet.getMaSp(),
                        chiTiet.getTenSp(),
                        chiTiet.getGiaBan(),
                        chiTiet.getSoLuong(),
                        chiTiet.getGiaBan() * chiTiet.getSoLuong()
                    });
                }
            } else {
                System.out.println("Không có chi tiết đơn hàng nào.");
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi tải chi tiết đơn hàng: " + e.getMessage());
        }
    }
    
    private void createHoaDon() {
        String maDdh = jTextField_MaDH.getText();
        String maHD = jTextField_MaHD.getText();

        java.util.Date date = jDateChooser1.getDate();
        if (date == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày.");
            return;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String ngayLapHd = dateFormat.format(date);

        String tinhTrangHd = "Đã thanh toán";

        if (maHD.isEmpty() || ngayLapHd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
            return;
        }

        CreateHoaDonRequestDto dto = new CreateHoaDonRequestDto();
        dto.setMaDdh(maDdh);
        dto.setMaHd(maHD);
        dto.setNgayLapHd(ngayLapHd);
        dto.setTinhTrangHd(tinhTrangHd);
        dto.setMaNv(maNv);

        QuanLyHoaDonController controller = new QuanLyHoaDonController();
        String resultMessage = controller.createHoaDon(dto);

        JOptionPane.showMessageDialog(this, resultMessage);
        loadDonHangs();
    }

    
    public void tinhTongHoaDon() {
        double tongTienHang = Double.parseDouble(jTextField_TongTienHang.getText());
        double chietKhau = Double.parseDouble(jTextField_ChietKhau.getText());
        jTextField_TongHD.setText(String.valueOf(tongTienHang - tongTienHang * (chietKhau / 100)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_TenKH = new javax.swing.JTextField();
        jButton_TimKiem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_DonHang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField_MaDH = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_CtDonHang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_TongTienHang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_ChietKhau = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_MaHD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton_TinhTongHD = new javax.swing.JButton();
        jTextField_TongHD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton_ThanhToan = new javax.swing.JButton();

        jButton_TimKiem.setText("Tìm kiếm");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("DANH SÁCH ĐƠN ĐẶT HÀNG");

        jTable_DonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã đơn", "Tên KH", "Ngày đặt", "Ngày giao", "Trạng thái"
            }
        ));
        jScrollPane1.setViewportView(jTable_DonHang);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Thông tin thanh toán cho đơn hàng:");

        jTable_CtDonHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã đơn hàng", "Tên mặt hàng", "Đơn giá", "Số lượng", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(jTable_CtDonHang);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Thông tin hóa đơn:");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Tổng tiền hàng");

        jTextField_TongTienHang.setEnabled(false);

        jLabel5.setText("Chiết khấu");

        jLabel6.setText("Mã hóa đơn");

        jLabel7.setText("Ngày lập HĐ");

        jButton_TinhTongHD.setText("Tính tổng HĐ");

        jTextField_TongHD.setEnabled(false);

        jLabel8.setText("%");

        jDateChooser1.setEnabled(false);
        jDateChooser1.setDate(new java.util.Date());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_TinhTongHD)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_TongHD))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_TongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(41, 41, 41)
                                .addComponent(jTextField_ChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_MaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField_TongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTextField_ChietKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_TinhTongHD)
                    .addComponent(jTextField_TongHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jButton_ThanhToan.setText("Thanh toán");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(43, 43, 43)
                                    .addComponent(jTextField_MaDH, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextField_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(jButton_TimKiem))
                                .addComponent(jScrollPane2)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jButton_ThanhToan)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKiem))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_MaDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton_ThanhToan)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_ThanhToan;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_TinhTongHD;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_CtDonHang;
    private javax.swing.JTable jTable_DonHang;
    private javax.swing.JTextField jTextField_ChietKhau;
    private javax.swing.JTextField jTextField_MaDH;
    private javax.swing.JTextField jTextField_MaHD;
    private javax.swing.JTextField jTextField_TenKH;
    private javax.swing.JTextField jTextField_TongHD;
    private javax.swing.JTextField jTextField_TongTienHang;
    // End of variables declaration//GEN-END:variables
}
