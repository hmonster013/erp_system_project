/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Controller;

import com.mycompany.Model.SanPhamModel;
import com.mycompany.View.fNhapSanPham;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Khoahihi79
 */
public class NhapKhoSanPhamController {
    private fNhapSanPham form;
    private SanPhamModel sanPhamModel;
    private DefaultTableModel tableTonKho;
    
    public NhapKhoSanPhamController() {}
    
    public NhapKhoSanPhamController(fNhapSanPham form) {
        this.form = form;
        this.sanPhamModel = new SanPhamModel();
        createTableTonKho();
        addHangTonKho();
    }
    
    private void createTableTonKho() {
        tableTonKho = new DefaultTableModel();
        tableTonKho.addColumn("Mã SP");
        tableTonKho.addColumn("Tên sản phẩm");
        tableTonKho.addColumn("Số lượng tồn kho");
    }
    
    private void addHangTonKho() {
        form.getButtonCNTK().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maSP = form.getMaSP();
                String tenSP = form.getTenSP();
                String soLuongTon = form.getSLTK();
                if(!maSP.equals("") || !tenSP.equals("") || !soLuongTon.equals("")) {
                    sanPhamModel.addCauHoi(maSP, tenSP, Integer.parseInt(soLuongTon));
                    JOptionPane.showMessageDialog(form, "Thêm thành công!");
                } else {
                    JOptionPane.showMessageDialog(form, "Vui lòng nhập đầy đủ các trường");
                }
            }
        });
    }
    
  /*  private void refreshDataTable(String idMonThi) {
         List<Object[]> dsCauHoi = cauHoiModel.getAllCauHoiTheoMon(idMonThi);
            tableModelCauHoi.setRowCount(0);
            for (Object[] cauHoi : dsCauHoi) {
                tableModelCauHoi.addRow(cauHoi);
            }
            form.getTableMonThi().setModel(tableModelCauHoi);
    } */
}
