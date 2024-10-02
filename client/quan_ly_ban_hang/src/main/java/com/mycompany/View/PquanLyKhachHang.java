/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author mihvu
 */
public class PquanLyKhachHang extends javax.swing.JPanel {

    /**
     * Creates new form PquanLyKhachHang
     */
    public PquanLyKhachHang() {
        initComponents();
    }

    public JButton getjButton1() {
        return jButton_themmoiKH;
    }

    public JButton getjButton2() {
        return jButton_capNhatTT;
    }

    public JButton getjButton3() {
        return jButton_xoaKH;
    }

    public JButton getjButton_huy() {
        return jButton_huy;
    }

    public JButton getjButton_luu() {
        return jButton_luu;
    }

    public JButton getjButton_timKiemTT() {
        return jButton_timKiemTT;
    }

    public JTable getjTable_danhkhachKH() {
        return jTable_danhkhachKH;
    }
    // Getter and Setter for jTextFiel_DiachiKH
    public void setDiachiKH(String value) {
        jTextFiel_DiachiKH.setText(value);
    }

    public String getDiachiKH() {
        return jTextFiel_DiachiKH.getText().trim();
    }

    // Getter and Setter for jTextFiel_EmailKH
    public void setEmailKH(String value) {
        jTextFiel_EmailKH.setText(value);
    }

    public String getEmailKH() {
        return jTextFiel_EmailKH.getText().trim();
    }

    // Getter and Setter for jTextFiel_MaKH
    public void setMaKH(String value) {
        jTextFiel_MaKH.setText(value);
    }

    public String getMaKH() {
        return jTextFiel_MaKH.getText().trim();
    }

    // Getter and Setter for jTextFiel_SdtKH
    public void setSdtKH(String value) {
        jTextFiel_SdtKH.setText(value);
    }

    public String getSdtKH() {
        return jTextFiel_SdtKH.getText().trim();
    }

    // Getter and Setter for jTextFiel_TenKH
    public void setTenKH(String value) {
        jTextFiel_TenKH.setText(value);
    }

    public String getTenKH() {
        return jTextFiel_TenKH.getText().trim();
    }

    // Getter and Setter for jTextFiel_timKiemTT
    public void setTimKiemTT(String value) {
        jTextFiel_timKiemTT.setText(value);
    }

    public String getTimKiemTT() {
        return jTextFiel_timKiemTT.getText().trim();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFiel_timKiemTT = new javax.swing.JTextField();
        jButton_timKiemTT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_danhkhachKH = new javax.swing.JTable();
        jButton_themmoiKH = new javax.swing.JButton();
        jButton_capNhatTT = new javax.swing.JButton();
        jButton_xoaKH = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFiel_MaKH = new javax.swing.JTextField();
        jTextFiel_TenKH = new javax.swing.JTextField();
        jTextFiel_EmailKH = new javax.swing.JTextField();
        jTextFiel_SdtKH = new javax.swing.JTextField();
        jTextFiel_DiachiKH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton_huy = new javax.swing.JButton();
        jButton_luu = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton_timKiemTT.setText("TÌM KIẾM");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("DANH SÁCH KHÁCH HÀNG");

        jTable_danhkhachKH.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_danhkhachKH);

        jButton_themmoiKH.setText("Thêm mới khách hàng");

        jButton_capNhatTT.setText("Cập nhật thông tin");

        jButton_xoaKH.setText("Xóa khánh hàng");

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Tên khách hàng");

        jLabel5.setText("Email");

        jLabel6.setText("SĐT");

        jLabel7.setText("Địa chỉ");

        jButton_huy.setText("Hủy");

        jButton_luu.setText("Lưu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFiel_timKiemTT, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButton_timKiemTT, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFiel_DiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFiel_MaKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFiel_TenKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFiel_EmailKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFiel_SdtKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jButton_luu)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_huy))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton_xoaKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_capNhatTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_themmoiKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFiel_timKiemTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_timKiemTT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_themmoiKH)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_capNhatTT)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_xoaKH)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFiel_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFiel_TenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFiel_EmailKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFiel_SdtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTextFiel_DiachiKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_luu)
                            .addComponent(jButton_huy))
                        .addGap(52, 52, 52))))
        );

        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_capNhatTT;
    private javax.swing.JButton jButton_huy;
    private javax.swing.JButton jButton_luu;
    private javax.swing.JButton jButton_themmoiKH;
    private javax.swing.JButton jButton_timKiemTT;
    private javax.swing.JButton jButton_xoaKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_danhkhachKH;
    private javax.swing.JTextField jTextFiel_DiachiKH;
    private javax.swing.JTextField jTextFiel_EmailKH;
    private javax.swing.JTextField jTextFiel_MaKH;
    private javax.swing.JTextField jTextFiel_SdtKH;
    private javax.swing.JTextField jTextFiel_TenKH;
    private javax.swing.JTextField jTextFiel_timKiemTT;
    // End of variables declaration//GEN-END:variables
}