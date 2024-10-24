/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Controller.LoSanPhamController;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class pQuanLyLoSP extends javax.swing.JPanel {

    /**
     * Creates new form pQuanLyLoSP
     */
    public pQuanLyLoSP() {
        initComponents();
        LoSanPhamController loSanPhamController = new LoSanPhamController(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_trai = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_phai = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_phieuyeucau = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_maphieu = new javax.swing.JTextField();
        jTextField_masx = new javax.swing.JTextField();
        jTextField_tensp = new javax.swing.JTextField();
        jTextField_slsp = new javax.swing.JTextField();
        jTextField_solo = new javax.swing.JTextField();
        jButton_them = new javax.swing.JButton();
        jButton_sua = new javax.swing.JButton();
        jButton_xoa = new javax.swing.JButton();
        jDateChooser_nsx = new com.toedter.calendar.JDateChooser();
        jDateChooser_hsd = new com.toedter.calendar.JDateChooser();
        jButton_refresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable_trai.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_trai);

        jTable_phai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã YCSX", "Số lô", "Mã SP", "Tên SP", "SL", "NSX", "HSD", "Tình trạng"
            }
        ));
        jScrollPane2.setViewportView(jTable_phai);

        jLabel1.setBackground(new java.awt.Color(0, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ LÔ SẢN PHẨM");
        jLabel1.setOpaque(true);

        jLabel2.setText("Phiếu yêu cầu sản xuất");

        jLabel3.setText("Danh sách lô sản phẩm");

        jLabel4.setText("Mã phiếu YCSX");

        jLabel5.setText("Mã sản phẩm");

        jLabel6.setText("Tên sản phẩm");

        jLabel7.setText("Sl sản phẩm");

        jLabel8.setText("Số lô");

        jLabel9.setText("NSX");

        jLabel10.setText("HSD");

        jButton_them.setBackground(new java.awt.Color(0, 153, 255));
        jButton_them.setForeground(new java.awt.Color(255, 255, 255));
        jButton_them.setText("Thêm mới lô");

        jButton_sua.setBackground(new java.awt.Color(0, 153, 255));
        jButton_sua.setForeground(new java.awt.Color(255, 255, 255));
        jButton_sua.setText("Cập nhật lô");

        jButton_xoa.setBackground(new java.awt.Color(0, 153, 255));
        jButton_xoa.setForeground(new java.awt.Color(255, 255, 255));
        jButton_xoa.setText("Xóa");

        jButton_refresh.setBackground(new java.awt.Color(0, 153, 255));
        jButton_refresh.setForeground(new java.awt.Color(255, 255, 255));
        jButton_refresh.setText("Refresh");
        jButton_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_maphieu)
                            .addComponent(jTextField_masx)
                            .addComponent(jTextField_tensp)
                            .addComponent(jTextField_slsp)
                            .addComponent(jTextField_solo)
                            .addComponent(jDateChooser_nsx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooser_hsd, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(31, 31, 31)
                                .addComponent(jComboBox_phieuyeucau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jButton_them)
                                .addGap(54, 54, 54)
                                .addComponent(jButton_sua)
                                .addGap(62, 62, 62)
                                .addComponent(jButton_xoa))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_phieuyeucau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_maphieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_masx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_slsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_solo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_them)
                            .addComponent(jButton_sua)
                            .addComponent(jButton_xoa)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jDateChooser_nsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jDateChooser_hsd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_refresh)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refreshActionPerformed
        setMaPhieu("");
        setMaSX("");
        setTenSP("");
        setSLSP("");
        setSoLo("");
        setValueJDateChooser1(null);
        setValueJDateChooser2(null);
    }//GEN-LAST:event_jButton_refreshActionPerformed

    public JButton getjButton_xoa() {
        return jButton_xoa;
    }

    public JTextField getjTextField_slsp() {
        return jTextField_slsp;
    }
    
    

    public void setValueJDateChooser1(Date value) {
            jDateChooser_nsx.setDate(value);
        }

        public Date getValueJDateChooser1() {
             java.util.Date utilDate = jDateChooser_nsx.getDate();
            return new Date(utilDate.getTime());
        }
        
        public void setValueJDateChooser2(Date value) {
            jDateChooser_hsd.setDate(value);
        }

        public Date getValueJDateChooser2() {
             java.util.Date utilDate = jDateChooser_hsd.getDate();
            return new Date(utilDate.getTime());
        }
    
    public JButton getjButton_sua() {
        return jButton_sua;
    }

    public JButton getjButton_them() {
        return jButton_them;
    }

    public JComboBox<String> getjComboBox_phieuyeucau() {
        return jComboBox_phieuyeucau;
    }

    public JTable getjTable_phai() {
        return jTable_phai;
    }

    public JTable getjTable_trai() {
        return jTable_trai;
    }
    public void setMaPhieu(String value) {
    jTextField_maphieu.setText(value);
}

public String getMaPhieu() {
    return jTextField_maphieu.getText().trim();
}

public void setMaSX(String value) {
    jTextField_masx.setText(value);
}

public String getMaSX() {
    return jTextField_masx.getText().trim();
}

public void setSLSP(String value) {
    jTextField_slsp.setText(value);
}

public String getSLSP() {
    return jTextField_slsp.getText().trim();
}

public void setSoLo(String value) {
    jTextField_solo.setText(value);
}

public String getSoLo() {
    return jTextField_solo.getText().trim();
}

public void setTenSP(String value) {
    jTextField_tensp.setText(value);
}

public String getTenSP() {
    return jTextField_tensp.getText().trim();
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_refresh;
    private javax.swing.JButton jButton_sua;
    private javax.swing.JButton jButton_them;
    private javax.swing.JButton jButton_xoa;
    private javax.swing.JComboBox<String> jComboBox_phieuyeucau;
    private com.toedter.calendar.JDateChooser jDateChooser_hsd;
    private com.toedter.calendar.JDateChooser jDateChooser_nsx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTable jTable_phai;
    private javax.swing.JTable jTable_trai;
    private javax.swing.JTextField jTextField_maphieu;
    private javax.swing.JTextField jTextField_masx;
    private javax.swing.JTextField jTextField_slsp;
    private javax.swing.JTextField jTextField_solo;
    private javax.swing.JTextField jTextField_tensp;
    // End of variables declaration//GEN-END:variables
}
