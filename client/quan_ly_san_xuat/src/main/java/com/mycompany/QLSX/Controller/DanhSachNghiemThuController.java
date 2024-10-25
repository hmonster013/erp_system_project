/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLSX.Controller;

import com.mycompany.QLSX.API.CtPhieuNghiemThuService;
import com.mycompany.QLSX.API.LoSanPhamService;
import com.mycompany.QLSX.API.PhieuNghiemThuService;
import com.mycompany.QLSX.API.SanPhamService;
import com.mycompany.QLSX.Entity.CtPhieuNghiemThu;
import com.mycompany.QLSX.Entity.PhieuNghiemThu;
import com.mycompany.QLSX.View.pNghiemThu;
import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khoahihi79
 */
public class DanhSachNghiemThuController {
    private pNghiemThu form;
    private PhieuNghiemThuService phieuNghiemThuService;
    private CtPhieuNghiemThuService ctPhieuNghiemThuService;
    private SanPhamService sanPhamService;
    private LoSanPhamService loSanPhamService;
    private DefaultTableModel tableModelDsNt;
    private DefaultTableModel tableModelCtNt;
    
    public DanhSachNghiemThuController() {}

    public DanhSachNghiemThuController(pNghiemThu form) {
        this.form = form;
        this.phieuNghiemThuService = new PhieuNghiemThuService();
        this.ctPhieuNghiemThuService = new CtPhieuNghiemThuService();
        this.loSanPhamService = new LoSanPhamService();
        this.sanPhamService = new SanPhamService();
        createTable("DsNt");
        createTable("CtNt");
        showDanhSachTable();
        showChiTietPNT();
    }
    
    private void createTable(String tableName) {
        if(tableName.equals("DsNt")) {
            tableModelDsNt = new DefaultTableModel();
            tableModelDsNt.addColumn("Phiếu YCSX");
            tableModelDsNt.addColumn("Mã PNT");
            tableModelDsNt.addColumn("Nội dung");
            tableModelDsNt.addColumn("Ngày nghiệm thu");
        } else {   
            tableModelCtNt = new DefaultTableModel();
            tableModelCtNt.addColumn("Số lô");
            tableModelCtNt.addColumn("Tên sản phẩm");
            tableModelCtNt.addColumn("Số lượng SP");
             tableModelCtNt.addColumn("Kết quả nghiệm thu");
        }
    }
    
    private void showDanhSachTable() {
        try {       
                List<PhieuNghiemThu> listPhieuNghiemThu = phieuNghiemThuService.getAllPhieuNghiemThuByUrl("");
                if(listPhieuNghiemThu != null) {
                    JTable tableNghiemThu = form.getjTable_tren();           
                    for(PhieuNghiemThu phieuNghiemThu : listPhieuNghiemThu) {
                        Object[] row = {phieuNghiemThu.getMaYc(), phieuNghiemThu.getMaPnt(), phieuNghiemThu.getVanBan(), phieuNghiemThu.getNgayNt()};
                        tableModelDsNt.addRow(row);
                    }
                    tableNghiemThu.setModel(tableModelDsNt);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void refreshDataTable() {
       tableModelDsNt.setRowCount(0);
       showDanhSachTable();
    }
    
    private void chiTietPNT(String maPnt) {
         try {       
                tableModelCtNt.setRowCount(0);
                List<CtPhieuNghiemThu> listCtPhieuNghiemThu =ctPhieuNghiemThuService.getCtPhieuNghiemThuByMaPnt(maPnt);
                String tenSanPham = "";
                if(listCtPhieuNghiemThu != null) {
                    JTable tableCtNghiemThu = form.getjTable_duoi();           
                    for(CtPhieuNghiemThu ctPhieuNghiemThu : listCtPhieuNghiemThu) {
                        String maSanPham = loSanPhamService.getLoSpBySoLo(ctPhieuNghiemThu.getSoLo()).getMaSp();
                        String soLuong = String.valueOf(loSanPhamService.getLoSpBySoLo(ctPhieuNghiemThu.getSoLo()).getSoLuongSp());
                        tenSanPham = sanPhamService.getTenSpByMaSp(maSanPham);
                        Object[] row = {ctPhieuNghiemThu.getSoLo(), tenSanPham,soLuong, ctPhieuNghiemThu.getKetQuaNt()};
                        tableModelCtNt.addRow(row);
                    }
                    tableCtNghiemThu.setModel(tableModelCtNt);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void showChiTietPNT() {
            form.getjTable_tren().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                        int selectedRow = form.getjTable_tren().getSelectedRow();
                        if(selectedRow != -1) {
                            String maPhieu = form.getjTable_tren().getValueAt(selectedRow, 1).toString();
                            form.setChiTiet(maPhieu);
                            chiTietPNT(maPhieu);
                        }
                }      
            });
        }
}
