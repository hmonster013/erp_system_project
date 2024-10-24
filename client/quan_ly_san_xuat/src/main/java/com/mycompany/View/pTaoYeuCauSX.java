/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Controller.ChiTietYeuCauController;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class pTaoYeuCauSX extends javax.swing.JPanel {

    /**
     * Creates new form pTaoYeuCauSX
     */
    public pTaoYeuCauSX() {
        initComponents();
        ChiTietYeuCauController chiTietYeuCauController = new ChiTietYeuCauController(this);
        jButton_them.setEnabled(false);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_maphieu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_tren = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton_taoyeucau = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField_timkiem = new javax.swing.JTextField();
        jButton_tim = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_duoi = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_masp = new javax.swing.JTextField();
        jTextField_tensp = new javax.swing.JTextField();
        jButton_them = new javax.swing.JButton();
        jButton_hoanthanh = new javax.swing.JButton();
        jDateChooser_ngaybatdau = new com.toedter.calendar.JDateChooser();
        jDateChooser_ngayketthuc = new com.toedter.calendar.JDateChooser();
        jSpinner_slsx = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TẠO YÊU CẦU SẢN XUẤT");
        jLabel1.setOpaque(true);

        jLabel2.setText("Mã phiếu ");

        jLabel3.setText("Ngày bắt đầu");

        jLabel4.setText("Ngày kết thúc");

        jTable_tren.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "SL sản xuất"
            }
        ));
        jScrollPane1.setViewportView(jTable_tren);

        jLabel5.setText("DANH SÁCH SẢN PHẨM CẦN SẢN XUẤT");

        jButton_taoyeucau.setBackground(new java.awt.Color(0, 153, 255));
        jButton_taoyeucau.setForeground(new java.awt.Color(255, 255, 255));
        jButton_taoyeucau.setText("Tạo yêu cầu");
        jButton_taoyeucau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_taoyeucauActionPerformed(evt);
            }
        });

        jLabel6.setText("Chọn sản phẩm");

        jButton_tim.setBackground(new java.awt.Color(0, 153, 255));
        jButton_tim.setForeground(new java.awt.Color(255, 255, 255));
        jButton_tim.setText("Tìm");

        jTable_duoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "SL tồn"
            }
        ));
        jScrollPane2.setViewportView(jTable_duoi);
        if (jTable_duoi.getColumnModel().getColumnCount() > 0) {
            jTable_duoi.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel7.setText("Mã sản phẩm");

        jLabel8.setText("Tên sản phẩm");

        jLabel9.setText("Sl cần sản xuất");

        jButton_them.setBackground(new java.awt.Color(0, 153, 255));
        jButton_them.setForeground(new java.awt.Color(255, 255, 255));
        jButton_them.setText("Thêm sản phẩm");

        jButton_hoanthanh.setBackground(new java.awt.Color(0, 153, 255));
        jButton_hoanthanh.setForeground(new java.awt.Color(255, 255, 255));
        jButton_hoanthanh.setText("Hoàn thành");
        jButton_hoanthanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_hoanthanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_tim))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_tensp))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_masp))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(38, 38, 38)
                                .addComponent(jTextField_maphieu))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser_ngaybatdau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jDateChooser_ngayketthuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSpinner_slsx, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton_them))
                                    .addComponent(jButton_taoyeucau)
                                    .addComponent(jTextField_timkiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_hoanthanh)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(jLabel5)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_maphieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jDateChooser_ngaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jDateChooser_ngayketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton_taoyeucau)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton_tim)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton_hoanthanh)
                        .addGap(127, 127, 127)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_masp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jButton_them)
                    .addComponent(jSpinner_slsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_hoanthanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_hoanthanhActionPerformed
        jTextField_maphieu.setText("");
        jTextField_masp.setText("");
        jTextField_tensp.setText("");
        jSpinner_slsx.setValue(0);
        jDateChooser_ngaybatdau.setDate(null);
        jDateChooser_ngayketthuc.setDate(null);
        jButton_them.setEnabled(false);
        jTextField_maphieu.setEnabled(true);
        jDateChooser_ngaybatdau.setEnabled(true);
        jDateChooser_ngayketthuc.setEnabled(true);
        jButton_taoyeucau.setEnabled(true);
    }//GEN-LAST:event_jButton_hoanthanhActionPerformed

    private void jButton_taoyeucauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_taoyeucauActionPerformed
        jTextField_maphieu.setEnabled(false);
        jDateChooser_ngaybatdau.setEnabled(false);
        jDateChooser_ngayketthuc.setEnabled(false);
        jButton_taoyeucau.setEnabled(false);
        jButton_them.setEnabled(true);
    }//GEN-LAST:event_jButton_taoyeucauActionPerformed

    public JTextField getjTextField_timkiem() {
        return jTextField_timkiem;
    }

    public void setValueJSpinnerSoLuong(int value) {
        jSpinner_slsx.setValue(value);
    }
    
    public String getValueJSpinnerSoLuong() {
        return jSpinner_slsx.getValue().toString();
    }
    
     public void setValueJDateChooserNBD(Date value) {
        jDateChooser_ngaybatdau.setDate(value);
    }
    
    public Date getValueJDateChooserNBD() {
         java.util.Date utilDate = jDateChooser_ngaybatdau.getDate();
        return new Date(utilDate.getTime());
    }
    
    public void setValueJDateChooserNKT(Date value) {
        jDateChooser_ngayketthuc.setDate(value);
    }
    
    public Date getValueJDateChooserNKT() {
         java.util.Date utilDate = jDateChooser_ngayketthuc.getDate();
        return new Date(utilDate.getTime());
    }
    
    public JButton getjButton_taoyeucau() {
        return jButton_taoyeucau;
    }

    
    public JButton getjButton_hoanthanh() {
        return jButton_hoanthanh;
    }

    public JButton getjButton_them() {
        return jButton_them;
    }

    public JButton getjButton_tim() {
        return jButton_tim;
    }

    public JTable getjTable_duoi() {
        return jTable_duoi;
    }

    public JTable getjTable_tren() {
        return jTable_tren;
    }
    public void setMaPhieu(String value) {
    jTextField_maphieu.setText(value);
}

public String getMaPhieu() {
    return jTextField_maphieu.getText().trim();
}

public void setMaSP(String value) {
    jTextField_masp.setText(value);
}

public String getMaSP() {
    return jTextField_masp.getText().trim();
}


public void setTenSP(String value) {
    jTextField_tensp.setText(value);
}

public String getTenSP() {
    return jTextField_tensp.getText().trim();
}

public void setTimKiem(String value) {
    jTextField_timkiem.setText(value);
}

public String getTimKiem() {
    return jTextField_timkiem.getText().trim();
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_hoanthanh;
    private javax.swing.JButton jButton_taoyeucau;
    private javax.swing.JButton jButton_them;
    private javax.swing.JButton jButton_tim;
    private com.toedter.calendar.JDateChooser jDateChooser_ngaybatdau;
    private com.toedter.calendar.JDateChooser jDateChooser_ngayketthuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner_slsx;
    private javax.swing.JTable jTable_duoi;
    private javax.swing.JTable jTable_tren;
    private javax.swing.JTextField jTextField_maphieu;
    private javax.swing.JTextField jTextField_masp;
    private javax.swing.JTextField jTextField_tensp;
    private javax.swing.JTextField jTextField_timkiem;
    // End of variables declaration//GEN-END:variables
}
