/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.View;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author ACER
 */
public class fHomePage extends javax.swing.JFrame {
    private CardLayout cardLayout;
    private String maNv;
    
    public fHomePage(String maNv) {
        this.maNv = maNv;
        
        initComponents();
        setLocationRelativeTo(null);
        setupCardLayout();
        addSubPanel();
        setupMenu();
    }
    
    public void setupCardLayout(){
        cardLayout = new CardLayout();
        mainpanel.setLayout(cardLayout);
    }
    
    public void addSubPanel(){
        pQuanLyKhachHang panelKhachHang = new pQuanLyKhachHang();
        mainpanel.add(panelKhachHang, "QuanLyKhachHang");

        pQuanLyDonHang panelDonHang = new pQuanLyDonHang(maNv);
        mainpanel.add(panelDonHang, "QuanLyDonHang");

        pQuanLyHoaDon panelHoaDon = new pQuanLyHoaDon(maNv);
        mainpanel.add(panelHoaDon, "LapHoaDon");

        pQuanLyTonKho panelTonKho = new pQuanLyTonKho();
        mainpanel.add(panelTonKho, "XemHangTonKho");
    }
    
    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Tạo menu và các mục trong menu
        JMenu menuQuanLy = new JMenu("Quản Lý");
        
        JMenuItem menuItemKhachHang = new JMenuItem("Quản lý khách hàng");
        menuItemKhachHang.addActionListener(e -> showPanel("QuanLyKhachHang"));
        
        JMenuItem menuItemDonHang = new JMenuItem("Quản lý đơn hàng");
        menuItemDonHang.addActionListener(e -> showPanel("QuanLyDonHang"));
        
        JMenuItem menuItemLapHoaDon = new JMenuItem("Lập hóa đơn");
        menuItemLapHoaDon.addActionListener(e -> showPanel("LapHoaDon"));
        
        JMenuItem menuItemTonKho = new JMenuItem("Xem hàng tồn kho");
        menuItemTonKho.addActionListener(e -> showPanel("XemHangTonKho"));
        
        // Thêm các mục vào menu
        menuQuanLy.add(menuItemKhachHang);
        menuQuanLy.add(menuItemDonHang);
        menuQuanLy.add(menuItemLapHoaDon);
        menuQuanLy.add(menuItemTonKho);

        // Thêm menu vào thanh menu
        menuBar.add(menuQuanLy);

        // Thiết lập thanh menu cho JFrame
        setJMenuBar(menuBar);
    }
    
    // Phương thức chuyển đổi panel trong mainpanel
    private void showPanel(String panelName) {
        cardLayout.show(mainpanel, panelName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(null);

        mainpanel.setMinimumSize(new java.awt.Dimension(862, 757));
        mainpanel.setPreferredSize(new java.awt.Dimension(862, 757));
        mainpanel.setVerifyInputWhenFocusTarget(false);
        mainpanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
