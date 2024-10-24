/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Controller.QuanLyBacLuongController;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class pQuanLyBacLuong extends javax.swing.JPanel {

    /**
     * Creates new form pQuanLyBacLuong
     */
    public pQuanLyBacLuong() {
        initComponents();
        QuanLyBacLuongController quanLyBacLuongController = new QuanLyBacLuongController(this);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_QLBacLuong = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_HSL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_MBL = new javax.swing.JTextField();
        jButton_ThemBL = new javax.swing.JButton();
        jTextField_LuongCB = new javax.swing.JTextField();
        jButton_XoaBL = new javax.swing.JButton();
        jButton_SuaBL = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField_HSPC = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jTable_QLBacLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_QLBacLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_QLBacLuongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_QLBacLuong);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mã bậc lương :");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ BẬC LƯƠNG");
        jLabel1.setToolTipText("");

        jTextField_HSL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Lương cơ bản :");

        jLabel5.setText("Hệ số lương :");

        jTextField_MBL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton_ThemBL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_ThemBL.setText("Thêm");
        jButton_ThemBL.setCursor(new java.awt.Cursor(java.awt.Cursor.SE_RESIZE_CURSOR));

        jTextField_LuongCB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton_XoaBL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_XoaBL.setText("Xóa");

        jButton_SuaBL.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_SuaBL.setText("sửa");

        jLabel7.setText("Hệ số phụ cấp :");

        jTextField_HSPC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addGap(102, 102, 102)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_MBL, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_LuongCB, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_HSL, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_HSPC, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_ThemBL)
                            .addComponent(jButton_SuaBL)
                            .addComponent(jButton_XoaBL)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextField_MBL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField_LuongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField_HSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField_HSPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(16, 16, 16)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel5)
                            .addGap(15, 15, 15)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_ThemBL)
                        .addGap(24, 24, 24)
                        .addComponent(jButton_SuaBL)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_XoaBL)))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_QLBacLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_QLBacLuongMouseClicked
        // Lấy chỉ số hàng được chọn
    int selectedRow = jTable_QLBacLuong.getSelectedRow();

    // Kiểm tra xem có hàng nào được chọn không
    if (selectedRow != -1) {
        // Lấy dữ liệu từ hàng được chọn
        String maBL = jTable_QLBacLuong.getValueAt(selectedRow, 0).toString();
        String luongCB = jTable_QLBacLuong.getValueAt(selectedRow, 1).toString();
        String hsLuong = jTable_QLBacLuong.getValueAt(selectedRow, 2).toString();
        String hsPhucap = jTable_QLBacLuong.getValueAt(selectedRow, 3).toString();

        // Cập nhật các trường văn bản với dữ liệu đã chọn
        setMBL(maBL);
        setLuongCB(luongCB);
        setHSL(hsLuong);
        setHSPC(hsPhucap);
    }

    }//GEN-LAST:event_jTable_QLBacLuongMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Mở trang Home
    Home home = new Home();
    home.setVisible(true);

    // Đóng JFrame hiện tại chứa JPanel này
    java.awt.Window window = javax.swing.SwingUtilities.getWindowAncestor(this);
    if (window != null) {
        window.dispose();  // Đóng cửa sổ hiện tại
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    public JButton getjButton_SuaBL() {
        return jButton_SuaBL;
    }

    public JButton getjButton_ThemBL() {
        return jButton_ThemBL;
    }

    public JButton getjButton_XoaBL() {
        return jButton_XoaBL;
    }

    public JTable getjTable_QLBacLuong() {
        return jTable_QLBacLuong;
    }
        // jTextField_MBL
    public void setMBL(String value) {
        jTextField_MBL.setText(value);
    }

    public String getMBL() {
        return jTextField_MBL.getText().trim();
    }

    // jTextField_LuongCB
    public void setLuongCB(String value) {
        jTextField_LuongCB.setText(value);
    }

    public String getLuongCB() {
        return jTextField_LuongCB.getText().trim();
    }

    // jTextField_HSL
    public void setHSL(String value) {
        jTextField_HSL.setText(value);
    }

    public String getHSL() {
        return jTextField_HSL.getText().trim();
    }

    // jTextField_HSPC
    public void setHSPC(String value) {
        jTextField_HSPC.setText(value);
    }

    public String getHSPC() {
        return jTextField_HSPC.getText().trim();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_SuaBL;
    private javax.swing.JButton jButton_ThemBL;
    private javax.swing.JButton jButton_XoaBL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_QLBacLuong;
    private javax.swing.JTextField jTextField_HSL;
    private javax.swing.JTextField jTextField_HSPC;
    private javax.swing.JTextField jTextField_LuongCB;
    private javax.swing.JTextField jTextField_MBL;
    // End of variables declaration//GEN-END:variables
}