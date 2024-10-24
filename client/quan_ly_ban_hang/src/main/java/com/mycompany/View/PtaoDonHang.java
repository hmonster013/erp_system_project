/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.View;

import com.mycompany.Controller.QuanLyDonHangController;
import com.mycompany.Controller.QuanLyKhachHangController;
import com.mycompany.Controller.QuanLyTonKhoController;
import com.mycompany.Dtos.CtdonDh.CreateCtdonDhRequestDto;
import com.mycompany.Dtos.DonDh.CreateDonDhRequestDto;
import com.mycompany.Dtos.KhachHang.KhachHangDto;
import com.mycompany.Dtos.SanPham.SanPhamDto;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


public class pTaoDonHang extends javax.swing.JPanel {
    private String maNv;
    private QuanLyKhachHangController quanLyKhachHangController;
    private QuanLyTonKhoController quanLyTonKhoController;
    private QuanLyDonHangController quanLyDonHangController;
    
    public pTaoDonHang(String maNv) {
        this.maNv = maNv;
        quanLyKhachHangController = new QuanLyKhachHangController();
        quanLyTonKhoController = new QuanLyTonKhoController();
        quanLyDonHangController = new QuanLyDonHangController();
        
        initComponents();
        jTextField_MaMH.setEnabled(false);
        jTextField_TenMH.setEnabled(false);
        jTextField_SoLuongMH.setEnabled(false);
        jButton_ThemMatHang.setEnabled(false);
        
        initButtonListeners();
        loadKhachHangs();
        loadSanPhams();
    }
    
    private void initButtonListeners() {
        jButton_TimKH.addActionListener(evt -> searchKhachHang());
        jButton_TimSp.addActionListener(evt -> searchSanPham());
        jButton_Taodon.addActionListener(evt -> addDonDatHang());
        jButton_ThemMatHang.addActionListener(evt -> addCtDonDh());
        jButton_HoanThanh.addActionListener(evt -> hoanThanh());
        jTable_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    jTable_danhkhachKHMouseClicked(evt);
                }
            }
        });
        jTable_SanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getClickCount() == 1) {
                    jTable_danhkhachSPMouseClicked(evt);
                }
            }
        });
    }
    
    public void loadKhachHangs() {
        List<KhachHangDto> khachHangs = quanLyKhachHangController.getAllKhachHangs();
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
    
    public void loadSanPhams() {
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
    
    private void jTable_danhkhachKHMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable_KhachHang.getSelectedRow();
        if (selectedRow != -1) {
            jTextField_MaKH.setText(jTable_KhachHang.getValueAt(selectedRow, 0).toString());
        }
    }
    
    private void jTable_danhkhachSPMouseClicked(java.awt.event.MouseEvent evt) {
        int selectedRow = jTable_SanPham.getSelectedRow();
        if (selectedRow != -1) {
            jTextField_MaMH.setText(jTable_SanPham.getValueAt(selectedRow, 0).toString());
            jTextField_TenMH.setText(jTable_SanPham.getValueAt(selectedRow, 1).toString());
        }
    }
    
    public void searchKhachHang () {
        String searchTerm = jTextField_SearchTenKH.getText();

        if (searchTerm.isEmpty()) {
            loadKhachHangs();
            return;
        }

        try {
            List<KhachHangDto> khachHangsFound = quanLyKhachHangController.searchKhachHangByTen(searchTerm);

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
                    sanPham.getSoLuongTon()
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm nào!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void addDonDatHang() {
        try {
            String maKh = jTextField_MaKH.getText();
            String maDH = jTextField_MaDH.getText();
            Date ngayLap = jDateChooser_NgayLap.getDate();
            Date ngayGiao = jDateChooser_NgayGiao.getDate();
            String tinhTrang = "Chưa giao";

            if (maKh.isEmpty() || maDH.isEmpty() || ngayLap == null || ngayGiao == null || tinhTrang.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String ngayLapFormatted = sdf.format(ngayLap);
            String ngayGiaoFormatted = sdf.format(ngayGiao);

            CreateDonDhRequestDto donDhRequest = new CreateDonDhRequestDto();
            donDhRequest.setMaKh(maKh);
            donDhRequest.setMaDdh(maDH);
            donDhRequest.setNgayLap(ngayLapFormatted);
            donDhRequest.setNgayGiao(ngayGiaoFormatted);
            donDhRequest.setTinhTrang(tinhTrang);
            donDhRequest.setMaNv(maNv);

            String resultMessage = quanLyDonHangController.createDonDh(donDhRequest);

            JOptionPane.showMessageDialog(this, resultMessage, "Thông báo", JOptionPane.INFORMATION_MESSAGE);

            if (resultMessage.contains("thành công")) {
                resetDonDatHangForm();
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi trong quá trình tạo đơn hàng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Phương thức reset form sau khi tạo đơn thành công
    private void resetDonDatHangForm() {
        jTextField_MaKH.setEnabled(false);
        jTextField_MaDH.setEnabled(false);
        jDateChooser_NgayLap.setEnabled(false);
        jDateChooser_NgayGiao.setEnabled(false);
        jTable_KhachHang.setEnabled(false);
        
        jTextField_MaMH.setEnabled(true);
        jTextField_TenMH.setEnabled(true);
        jTextField_SoLuongMH.setEnabled(true);
        jButton_ThemMatHang.setEnabled(true);
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
        jTextField_SearchTenKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton_TimKH = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_KhachHang = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField_SearchTenSanPham = new javax.swing.JTextField();
        jButton_TimSp = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_SanPham = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_MaMH = new javax.swing.JTextField();
        jTextField_TenMH = new javax.swing.JTextField();
        jTextField_SoLuongMH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_MaKH = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField_MaDH = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_danhSachDaThem = new javax.swing.JTable();
        jButton_Taodon = new javax.swing.JButton();
        jButton_HoanThanh = new javax.swing.JButton();
        jDateChooser_NgayLap = new com.toedter.calendar.JDateChooser();
        jDateChooser_NgayGiao = new com.toedter.calendar.JDateChooser();
        jTextField_MaNV = new javax.swing.JTextField();
        jButton_ThemMatHang = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(51, 153, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TẠO ĐƠN HÀNG");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Chọn khách hàng");

        jButton_TimKH.setBackground(new java.awt.Color(51, 153, 255));
        jButton_TimKH.setForeground(new java.awt.Color(255, 255, 255));
        jButton_TimKH.setText("Tìm");

        jTable_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã KH", "Tên KH", "SĐT"
            }
        ));
        jTable_KhachHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_KhachHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable_KhachHang);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Chọn mặt hàng");

        jButton_TimSp.setBackground(new java.awt.Color(51, 153, 255));
        jButton_TimSp.setForeground(new java.awt.Color(255, 255, 255));
        jButton_TimSp.setText("Tìm");

        jTable_SanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã MH", "Tên HN", "Tồn kho"
            }
        ));
        jTable_SanPham.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable_SanPham.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable_SanPham);

        jLabel4.setText("Mã mặt hàng");

        jLabel5.setText("Tên mặt hàng");

        jLabel6.setText("Số  lượng");

        jLabel7.setText("Mã khách hàng");

        jLabel8.setText("Mã đơn hàng");

        jLabel9.setText("Ngày đặt");

        jLabel10.setText("Ngày giao");

        jLabel11.setText("Mã nhân viên");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("DANH SÁCH MẶT HÀNG ĐÃ THÊM");

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
        DefaultTableModel model = (DefaultTableModel) jTable_danhSachDaThem.getModel();
        model.setRowCount(0);
        jScrollPane3.setViewportView(jTable_danhSachDaThem);

        jButton_Taodon.setBackground(new java.awt.Color(51, 153, 255));
        jButton_Taodon.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Taodon.setText("Tạo đơn");

        jButton_HoanThanh.setBackground(new java.awt.Color(51, 153, 255));
        jButton_HoanThanh.setForeground(new java.awt.Color(255, 255, 255));
        jButton_HoanThanh.setText("Hoàn thành");

        jTextField_MaNV.setEnabled(false);

        jButton_ThemMatHang.setBackground(new java.awt.Color(51, 153, 255));
        jButton_ThemMatHang.setForeground(new java.awt.Color(255, 255, 255));
        jButton_ThemMatHang.setText("Thêm mặt hàng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton_HoanThanh)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jTextField_SearchTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton_TimSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jTextField_SearchTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton_TimKH))
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_MaMH, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel6))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jTextField_SoLuongMH)
                                            .addGap(18, 18, 18)
                                            .addComponent(jButton_ThemMatHang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextField_TenMH, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(83, 83, 83)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                                        .addComponent(jButton_Taodon))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jDateChooser_NgayGiao, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                                            .addComponent(jTextField_MaDH)
                                            .addComponent(jTextField_MaKH)
                                            .addComponent(jDateChooser_NgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextField_MaNV))))))))
                .addContainerGap(50, Short.MAX_VALUE))
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
                    .addComponent(jTextField_SearchTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_TimKH)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_MaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_MaDH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser_NgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser_NgayGiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jTextField_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_SearchTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_TimSp)
                        .addComponent(jLabel12))
                    .addComponent(jButton_Taodon))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_MaMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_TenMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_SoLuongMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jButton_ThemMatHang))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_HoanThanh)
                        .addGap(0, 21, Short.MAX_VALUE))))
        );

        jTextField_MaNV.setText(maNv);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_HoanThanh;
    private javax.swing.JButton jButton_Taodon;
    private javax.swing.JButton jButton_ThemMatHang;
    private javax.swing.JButton jButton_TimKH;
    private javax.swing.JButton jButton_TimSp;
    private com.toedter.calendar.JDateChooser jDateChooser_NgayGiao;
    private com.toedter.calendar.JDateChooser jDateChooser_NgayLap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_KhachHang;
    private javax.swing.JTable jTable_SanPham;
    private javax.swing.JTable jTable_danhSachDaThem;
    private javax.swing.JTextField jTextField_MaDH;
    private javax.swing.JTextField jTextField_MaKH;
    private javax.swing.JTextField jTextField_MaMH;
    private javax.swing.JTextField jTextField_MaNV;
    private javax.swing.JTextField jTextField_SearchTenKH;
    private javax.swing.JTextField jTextField_SearchTenSanPham;
    private javax.swing.JTextField jTextField_SoLuongMH;
    private javax.swing.JTextField jTextField_TenMH;
    // End of variables declaration//GEN-END:variables
}
