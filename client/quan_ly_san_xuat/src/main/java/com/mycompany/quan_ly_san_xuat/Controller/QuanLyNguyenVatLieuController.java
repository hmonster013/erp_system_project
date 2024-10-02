/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quan_ly_san_xuat.Controller;

import com.mycompany.quan_ly_san_xuat.Model.NVLModel;
import com.mycompany.quan_ly_san_xuat.view.pDanhSachNVL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khoahihi79
 */
public class QuanLyNguyenVatLieuController {
    private pDanhSachNVL form;
    private NVLModel nVLModel;
    private DefaultTableModel tableNVL;
    
    public QuanLyNguyenVatLieuController() {}
    
    public QuanLyNguyenVatLieuController(pDanhSachNVL form) {
        this.form = form;
        this.nVLModel = new NVLModel();
        createTableNVL();
        themNVL();
        refreshDataTable();
    }
    
     private void createTableNVL() {
        tableNVL = new DefaultTableModel();
        tableNVL.addColumn("Mã NVL");
        tableNVL.addColumn("Tên NVL");
        tableNVL.addColumn("Ghi Chú"); 
    }
    
    
    private void themNVL() {
        form.getjButton_them().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String maNVL = form.getMaNVL();
                String tenNVL = form.getTenNVL();
                String ghiChu= form.getGhiChu();
                if(!maNVL.equals("") || !tenNVL.equals("") || !ghiChu.equals("")) {
                    nVLModel.addNguyenVatLieu(maNVL, tenNVL, ghiChu);
                    JOptionPane.showMessageDialog(form, "Thêm thành công!");
                } else {
                    JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường");
                }
            }
        });
    }
    
    private void refreshDataTable() {
         List<Object[]> dsNVL = nVLModel.danhSachNVL();
            tableNVL.setRowCount(0);
            for (Object[] nvl : dsNVL) {
                tableNVL.addRow(nvl);
            }
            form.getjTable_danhSachNVL().setModel(tableNVL);
    }
}
