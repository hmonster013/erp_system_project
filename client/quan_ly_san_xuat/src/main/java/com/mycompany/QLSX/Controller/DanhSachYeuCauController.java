/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.QLSX.Controller;

import com.mycompany.QLSX.API.CtPhieuYcsxService;
import com.mycompany.QLSX.API.PhieuYcsxService;
import com.mycompany.QLSX.API.SanPhamService;
import com.mycompany.QLSX.Entity.CtPhieuYcsx;
import com.mycompany.QLSX.Entity.PhieuYcsx;
import com.mycompany.QLSX.View.pDanhSachYeuCau;
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
public class DanhSachYeuCauController {
    private pDanhSachYeuCau form;
    private CtPhieuYcsxService ctPhieuYcsxService;
    private PhieuYcsxService phieuYcsxService;
    private SanPhamService sanPhamService;
    private DefaultTableModel tableModelYcsx;
    private DefaultTableModel tableModelCtYcsx;
    
    public DanhSachYeuCauController() {}
    
    public DanhSachYeuCauController(pDanhSachYeuCau form) {
        this.form = form;
        this.phieuYcsxService = new PhieuYcsxService();
        this.ctPhieuYcsxService = new CtPhieuYcsxService();
        this.sanPhamService = new SanPhamService();
        createTable("Ycsx");
        createTable("CtYcsx");
        showDanhSachTable();
        showChiTietYcsx();
    }
    
    private void createTable(String tableName) {
        if(tableName.equals("Ycsx")) {
            tableModelYcsx = new DefaultTableModel();
            tableModelYcsx.addColumn("Mã phiếu");
            tableModelYcsx.addColumn("Ngày bắt đầu");
            tableModelYcsx.addColumn("Ngày kết thúc");
        } else {   
            tableModelCtYcsx = new DefaultTableModel();
            tableModelCtYcsx.addColumn("Mã sản phẩm");
            tableModelCtYcsx.addColumn("Tên sản phẩm");
            tableModelCtYcsx.addColumn("Số lương cần sản xuất");
        }
    }
    
    public void showDanhSachTable() {
        try {       
                List<PhieuYcsx> listPhieuYcsx = phieuYcsxService.getAllPhieuYcsx();
                if(listPhieuYcsx != null) {
                    JTable tableYcsx = form.getjTable_tren();           
                    for(PhieuYcsx phieuYcsx : listPhieuYcsx) {
                        Object[] row = {phieuYcsx.getMaYc(), phieuYcsx.getNgayBd(), phieuYcsx.getNgayKt()};
                        tableModelYcsx.addRow(row);
                    }
                    tableYcsx.setModel(tableModelYcsx);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void refreshDataTable() {
        tableModelYcsx.setRowCount(0);
        showDanhSachTable();
    }
    
    private void chiTietYcsx(String maYc) {
         try {       
                tableModelCtYcsx.setRowCount(0);
                List<CtPhieuYcsx> listCtPhieuYcsx = ctPhieuYcsxService.getCtPhieuYcsxByMaYc(maYc);
                String tenSanPham = "";
                if(listCtPhieuYcsx != null) {
                    JTable tableCtYcsx = form.getjTable_duoi();           
                    for(CtPhieuYcsx ctPhieuYcsx : listCtPhieuYcsx) {
                        tenSanPham = sanPhamService.getTenSpByMaSp(ctPhieuYcsx.getMaSp());
                        Object[] row = {ctPhieuYcsx.getMaSp(), tenSanPham, ctPhieuYcsx.getSoLuongSx()};
                        tableModelCtYcsx.addRow(row);
                    }
                    tableCtYcsx.setModel(tableModelCtYcsx);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void showChiTietYcsx() {
            form.getjTable_tren().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                        int selectedRow = form.getjTable_tren().getSelectedRow();
                        if(selectedRow != -1) {
                            String maPhieu = form.getjTable_tren().getValueAt(selectedRow, 0).toString();
                            form.setChiTiet(maPhieu);
                            chiTietYcsx(maPhieu);
                        }
                }      
            });
        }
}
    

