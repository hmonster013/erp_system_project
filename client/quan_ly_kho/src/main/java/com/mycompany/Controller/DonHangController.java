/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.API.CtDonHangService;
import com.mycompany.API.DonHangService;
import com.mycompany.Entity.DonHang;
import com.mycompany.View.pDonHang;
import java.io.IOException;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khoahihi79
 */
public class DonHangController {
    private pDonHang form;
    private DonHangService donHangService;
    private CtDonHangService ctDonHangService;
    private DefaultTableModel tableModelDonHang;
    private DefaultTableModel tableModeCtlDonHang;
    
    public DonHangController() {}
    
    public DonHangController(pDonHang form) {
        this.form = form;
        this.donHangService = new DonHangService();
        this.ctDonHangService = new CtDonHangService();
        createTable("Đơn Hàng");
        createTable("CtDonHang");
        showDanhSachTable();
    }
    
     private void createTable(String tableName) {
        if(tableName.equals("Đơn Hàng")) {
            tableModelDonHang = new DefaultTableModel();
            tableModelDonHang.addColumn("Mã đơn");
            tableModelDonHang.addColumn("Tên KH");
            tableModelDonHang.addColumn("Ngày đặt");
            tableModelDonHang.addColumn("Ngày giao");
            tableModelDonHang.addColumn("Ngày trạng thái");
        } else {   
            tableModeCtlDonHang = new DefaultTableModel();
            tableModeCtlDonHang.addColumn("Mã mặt hàng");
            tableModeCtlDonHang.addColumn("Tên mặt hàng");
            tableModeCtlDonHang.addColumn("Số lượng đặt");
        }
    }
     
     private void showDanhSachTable() {
        try {      
                List<DonHang> listDonHang = donHangService.getAllDonHang();
                if(listDonHang != null) {
                    JTable tableDonHang = form.getjTable_donHang();           
                    for(DonHang donHang : listDonHang) {
                        Object[] row = {donHang.getMaDdh(), donHang.getMaKh(), donHang.getNgayLap(), donHang.getNgayGiao(), donHang.getTinhTrang()};
                        tableModelDonHang.addRow(row);
                    }
                    tableDonHang.setModel(tableModelDonHang);
                }  
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
