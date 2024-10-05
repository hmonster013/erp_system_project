INSERT INTO ThongTinNhanVien (MaNV, TenNV, GioiTinh, NgaySinh, QueQuan, SDT, TDHV) VALUES
('NV001', 'Nguyen Van A', 'Nam', '1990-01-01', 'Ha Noi', '0123456789', 'Dai hoc'),
('NV002', 'Tran Thi B', 'Nu', '1992-02-02', 'Hai Phong', '0987654321', 'Cao dang'),
('NV003', 'Le Van C', 'Nam', '1989-03-03', 'Da Nang', '0123456780', 'Trung cap'),
('NV004', 'Pham Thi D', 'Nu', '1995-04-04', 'Hue', '0123456781', 'Dai hoc'),
('NV005', 'Ngo Van E', 'Nam', '1988-05-05', 'Can Tho', '0123456782', 'Dai hoc'),
('NV006', 'Vu Thi F', 'Nu', '1993-06-06', 'Nha Trang', '0123456783', 'Cao dang'),
('NV007', 'Hoang Van G', 'Nam', '1991-07-07', 'Vinh', '0123456784', 'Trung cap'),
('NV008', 'Nguyen Thi H', 'Nu', '1994-08-08', 'Bac Ninh', '0123456785', 'Dai hoc'),
('NV009', 'Truong Van I', 'Nam', '1996-09-09', 'Thai Nguyen', '0123456786', 'Cao dang');

INSERT INTO TaiKhoan (Username, Password, MaNV) 
VALUES
('user001', 'pass001', 'NV001'),
('user002', 'pass002', 'NV002'),
('user003', 'pass003', 'NV003'),
('user004', 'pass004', 'NV004'),
('user005', 'pass005', 'NV005'),
('user006', 'pass006', 'NV006'),
('user007', 'pass007', 'NV007'),
('user008', 'pass008', 'NV008'),
('user009', 'pass009', 'NV009');

INSERT INTO BoPhan (MaBP, TenBP, SDT) 
VALUES
(N'BP001', N'Phong Nhan Su', N'0123456789'),
(N'BP002', N'Phong Ke Toan', N'0987654321'),
(N'BP003', N'Phong Marketing', N'0123456780'),
(N'BP004', N'Phong Ban Hang', N'0987654312'),
(N'BP005', N'Phong IT', N'0123456790'),
(N'BP006', N'Phong Quan Ly', N'0987654320'),
(N'BP007', N'Phong Phat Trien', N'0123456781'),
(N'BP008', N'Phong Hanh Chinh', N'0987654323'),
(N'BP009', N'Phong Nghien Cuu', N'0123456782'),
(N'BP010', N'Phong Doi Ngoai', N'0987654324');

INSERT INTO BacLuong (MaBL, LuongCB, HSLuong, HSPhuCap) 
VALUES
('BL001', 5000000, 3, 1),
('BL002', 5500000, 3, 2),
('BL003', 6000000, 4, 1),
('BL004', 6500000, 4, 2),
('BL005', 7000000, 5, 1),
('BL006', 7500000, 5, 2),
('BL007', 8000000, 6, 1),
('BL008', 8500000, 6, 2),
('BL009', 9000000, 7, 1);

INSERT INTO ChucVu (MaCV, TenCV, MaBL) 
VALUES
(N'CV001', N'Chuc Vu A', N'BL001'),
(N'CV002', N'Chuc Vu B', N'BL002'),
(N'CV003', N'Chuc Vu C', N'BL003'),
(N'CV004', N'Chuc Vu D', N'BL004'),
(N'CV005', N'Chuc Vu E', N'BL005'),
(N'CV006', N'Chuc Vu F', N'BL006'),
(N'CV007', N'Chuc Vu G', N'BL007'),
(N'CV008', N'Chuc Vu H', N'BL008'),
(N'CV009', N'Chuc Vu I', N'BL009');

INSERT INTO QTCongTac (MaQT, MaNV, MaCV, ThoiGianBD, ThoiGianKT, MaBP) 
VALUES
('QT001', 'NV001', 'CV001', '2023-01-01', '2024-01-01', 'BP001'),
('QT002', 'NV002', 'CV002', '2023-02-01', '2024-02-01', 'BP002'),
('QT003', 'NV003', 'CV003', '2023-03-01', '2024-03-01', 'BP003'),
('QT004', 'NV004', 'CV004', '2023-04-01', '2024-04-01', 'BP004'),
('QT005', 'NV005', 'CV005', '2023-05-01', '2024-05-01', 'BP005'),
('QT006', 'NV006', 'CV006', '2023-06-01', '2024-06-01', 'BP006'),
('QT007', 'NV007', 'CV007', '2023-07-01', '2024-07-01', 'BP007'),
('QT008', 'NV008', 'CV008', '2023-08-01', '2024-08-01', 'BP008'),
('QT009', 'NV009', 'CV009', '2023-09-01', '2024-09-01', 'BP009');

INSERT INTO HopDong (MaHopDong, TenHopDong, MaNV, NgayBatDau, NgatKetThuc, VanBan) VALUES
('HD001', 'Hop dong 1', 'NV001', '2024-01-01', '2024-12-31', 'Noi dung hop dong 1'),
('HD002', 'Hop dong 2', 'NV002', '2024-01-15', '2025-01-14', 'Noi dung hop dong 2'),
('HD003', 'Hop dong 3', 'NV003', '2024-02-01', '2025-01-31', 'Noi dung hop dong 3'),
('HD004', 'Hop dong 4', 'NV004', '2024-02-15', '2025-02-14', 'Noi dung hop dong 4'),
('HD005', 'Hop dong 5', 'NV005', '2024-03-01', '2025-02-28', 'Noi dung hop dong 5'),
('HD006', 'Hop dong 6', 'NV006', '2024-03-15', '2025-03-14', 'Noi dung hop dong 6'),
('HD007', 'Hop dong 7', 'NV007', '2024-04-01', '2025-03-31', 'Noi dung hop dong 7'),
('HD008', 'Hop dong 8', 'NV008', '2024-04-15', '2025-04-14', 'Noi dung hop dong 8'),
('HD009', 'Hop dong 9', 'NV009', '2024-05-01', '2025-04-30', 'Noi dung hop dong 9');

INSERT INTO Cong (MaNV, MaBL, ThangNam, SoNgayCong, SoNgayNghi, SoGioLamThem)
VALUES
(N'NV001', N'BL001', N'202301', 20, 2, 5),
(N'NV002', N'BL002', N'202301', 18, 4, 3),
(N'NV003', N'BL003', N'202301', 22, 1, 7),
(N'NV004', N'BL004', N'202301', 15, 6, 2),
(N'NV005', N'BL005', N'202301', 25, 0, 10),
(N'NV006', N'BL006', N'202301', 19, 3, 4),
(N'NV007', N'BL007', N'202301', 21, 2, 6),
(N'NV008', N'BL008', N'202301', 20, 1, 5),
(N'NV009', N'BL009', N'202301', 24, 0, 8);

INSERT INTO phieuktkl (MaPhieuKTKL, NoiDung, SoTienKTKL, MaNV) 
VALUES
('KTKL001', 'Khen thưởng hoàn thành dự án', 5000000, 'NV001'),
('KTKL002', 'Kỷ luật đi trễ', -200000, 'NV002'),
('KTKL003', 'Khen thưởng ý tưởng sáng tạo', 3000000, 'NV003'),
('KTKL004', 'Kỷ luật vi phạm nội quy', -500000, 'NV004'),
('KTKL005', 'Khen thưởng nhân viên xuất sắc', 4000000, 'NV005'),
('KTKL006', 'Kỷ luật không hoàn thành công việc', -1000000, 'NV006'),
('KTKL007', 'Khen thưởng đóng góp cho dự án', 2000000, 'NV007'),
('KTKL008', 'Kỷ luật nghỉ việc không lý do', -300000, 'NV008'),
('KTKL009', 'Khen thưởng làm thêm giờ', 1500000, 'NV009');

INSERT INTO BaoHiem (MaBaoHiem, TenBaoHiem, NoiDungBH)
VALUES
(N'BH001', N'Bao Hiem Nhan Tho', N'Bao ve tai chinh cho nguoi tham gia trong truong hop mat'),
(N'BH002', N'Bao Hiem Y Te', N'Bao ve chi phi y te cho nguoi tham gia'),
(N'BH003', N'Bao Hiem Tai Nan', N'Bao ve tai chinh trong truong hop tai nan lao dong'),
(N'BH004', N'Bao Hiem Xe Cot', N'Bao ve tai san khi su dung xe cot'),
(N'BH005', N'Bao Hiem Du Lich', N'Bao ve cho khach du lich trong truong hop khong may'),
(N'BH006', N'Bao Hiem Tai San', N'Bao ve tai san ca nhan truoc cac rui ro'),
(N'BH007', N'Bao Hiem Xa Hoi', N'Bao ve cac quyen loi xa hoi cho nguoi lao dong'),
(N'BH008', N'Bao Hiem Kinh Doanh', N'Bao ve cho doanh nghiep trong hoat dong kinh doanh'),
(N'BH009', N'Bao Hiem Hoa Hong', N'Bao ve khach hang trong giao dich'),
(N'BH010', N'Bao Hiem Su Kien', N'Bao ve tai chinh cho cac su kien khong mong muon');

INSERT INTO PhuCap (MaPhuCap, TenPhuCap, NoiDungPC) VALUES
('PC001', 'Phu cap an trua', 'Phu cap cho nhan vien an trua'),
('PC002', 'Phu cap xang xe', 'Phu cap cho nhan vien di lai'),
('PC003', 'Phu cap thiet bi', 'Phu cap cho thiet bi lam viec'),
('PC004', 'Phu cap nha o', 'Phu cap cho nhan vien thue nha'),
('PC005', 'Phu cap ve sinh', 'Phu cap cho dich vu ve sinh'),
('PC006', 'Phu cap di lai', 'Phu cap cho chi phi di lai'),
('PC007', 'Phu cap hoc tap', 'Phu cap cho nhan vien hoc tap'),
('PC008', 'Phu cap khac', 'Phu cap cho cac truong hop khac'),
('PC009', 'Phu cap tang cuong', 'Phu cap tang cuong cho nhan vien');

INSERT INTO ChinhSach (MaChinhSach, TenChinhSach, NoiDungCS)
VALUES
(N'CS001', N'Chinh Sach A', N'Noi dung chinh sach A'),
(N'CS002', N'Chinh Sach B', N'Noi dung chinh sach B'),
(N'CS003', N'Chinh Sach C', N'Noi dung chinh sach C'),
(N'CS004', N'Chinh Sach D', N'Noi dung chinh sach D'),
(N'CS005', N'Chinh Sach E', N'Noi dung chinh sach E'),
(N'CS006', N'Chinh Sach F', N'Noi dung chinh sach F'),
(N'CS007', N'Chinh Sach G', N'Noi dung chinh sach G'),
(N'CS008', N'Chinh Sach H', N'Noi dung chinh sach H'),
(N'CS009', N'Chinh Sach I', N'Noi dung chinh sach I'),
(N'CS010', N'Chinh Sach J', N'Noi dung chinh sach J');

INSERT INTO NV_BaoHiem (MaBaoHiem, MaNV) VALUES
('BH001', 'NV001'),
('BH002', 'NV002'),
('BH003', 'NV003'),
('BH001', 'NV004'),
('BH002', 'NV005'),
('BH003', 'NV006'),
('BH001', 'NV007'),
('BH002', 'NV008'),
('BH003', 'NV009');

INSERT INTO NV_PhuCap (MaPhuCap, MaNV) VALUES
('PC001', 'NV001'),
('PC002', 'NV002'),
('PC003', 'NV003'),
('PC001', 'NV004'),
('PC002', 'NV005'),
('PC003', 'NV006'),
('PC001', 'NV007'),
('PC002', 'NV008'),
('PC003', 'NV009');

INSERT INTO NV_ChinhSach (MaChinhSach, MaNV) VALUES
('CS001', 'NV001'),
('CS002', 'NV002'),
('CS003', 'NV003'),
('CS001', 'NV004'),
('CS002', 'NV005'),
('CS003', 'NV006'),
('CS001', 'NV007'),
('CS002', 'NV008'),
('CS003', 'NV009');

INSERT INTO LoaiSP (MaLoai, TenLoai) VALUES
('LSP001', 'Banh keo'),
('LSP002', 'Socola'),
('LSP003', 'Banh quy'),
('LSP004', 'Keo nhai'),
('LSP005', 'Banh trung thu'),
('LSP006', 'Banh xeo'),
('LSP007', 'Snack'),
('LSP008', 'Thuc pham dinh duong'),
('LSP009', 'Nuoc ngot');

INSERT INTO SanPham (MaSP, MaLoai, TenSP, GiaBan, ThanhPhan, KLT, SoLuongTon) VALUES
('SP001', 'LSP001', 'Banh keo Bibica', 20000, 'Duong, bot, muối', '100g', 500),
('SP002', 'LSP002', 'Socola Bibica', 30000, 'Socola, sữa', '150g', 300),
('SP003', 'LSP003', 'Banh quy Bibica', 25000, 'Bột mì, đường, bơ', '200g', 400),
('SP004', 'LSP004', 'Keo nhai Bibica', 15000, 'Đường, hương liệu', '50g', 600),
('SP005', 'LSP005', 'Banh trung thu Bibica', 50000, 'Bột, nhân đậu', '300g', 200),
('SP006', 'LSP006', 'Banh xeo Bibica', 22000, 'Bột gạo, tôm', '100g', 350),
('SP007', 'LSP007', 'Snack Bibica', 12000, 'Ngô, gia vị', '50g', 700),
('SP008', 'LSP008', 'Nuoc ngot Bibica', 10000, 'Nước, đường', '500ml', 800),
('SP009', 'LSP009', 'Thuc pham dinh duong Bibica', 18000, 'Vitamin, khoáng chất', '30g', 450);

INSERT INTO PhieuYCSX (MaYC, NgayBD, NgayKT, VanBan, MaNV) VALUES
('YC001', '2024-01-01', '2024-01-15', 'Yeu cau san xuat 1', 'NV001'),
('YC002', '2024-01-16', '2024-01-30', 'Yeu cau san xuat 2', 'NV002'),
('YC003', '2024-02-01', '2024-02-15', 'Yeu cau san xuat 3', 'NV003'),
('YC004', '2024-02-16', '2024-02-28', 'Yeu cau san xuat 4', 'NV004'),
('YC005', '2024-03-01', '2024-03-15', 'Yeu cau san xuat 5', 'NV005'),
('YC006', '2024-03-16', '2024-03-31', 'Yeu cau san xuat 6', 'NV006'),
('YC007', '2024-04-01', '2024-04-15', 'Yeu cau san xuat 7', 'NV007'),
('YC008', '2024-04-16', '2024-04-30', 'Yeu cau san xuat 8', 'NV008'),
('YC009', '2024-05-01', '2024-05-15', 'Yeu cau san xuat 9', 'NV009');

INSERT INTO CTPhieuYCSX (MaYC, MaSP, SoLuongSX)
VALUES
(N'YC001', N'SP001', 100),
(N'YC002', N'SP002', 200),
(N'YC003', N'SP003', 150),
(N'YC004', N'SP004', 250),
(N'YC005', N'SP005', 300),
(N'YC006', N'SP001', 120),
(N'YC007', N'SP006', 80),
(N'YC008', N'SP007', 90),
(N'YC009', N'SP008', 60);

INSERT INTO NguyenVatLieu (MaNVL, TenNVL, GhiChu, SoLuongTon) VALUES
('NVL001', 'Bot mi', 'Nguyen lieu chinh lam banh', 500),
('NVL002', 'Duong', 'Dung de tao do ngot', 300),
('NVL003', 'Bo', 'Nguyen lieu tao do beo', 200),
('NVL004', 'Trung', 'Nguyen lieu cung cap protein', 400),
('NVL005', 'Sua', 'Dung de lam kem va banh', 250),
('NVL006', 'Nuoc', 'Nguyen lieu can thiet cho moi loai banh', 1000),
('NVL007', 'Baking', 'Chat tao no cho banh', 150),
('NVL008', 'Muoi', 'Them huong vi cho banh', 50),
('NVL009', 'Huong lieu', 'Nguyen lieu tao huong vi dac trung', 75);

INSERT INTO LoSanPham (SoLo, MaYC, MaSP, SoLuongSP, NSX, HSD) VALUES
('LO001', 'YC001', 'SP001', 100, '2024-01-01', '2025-01-01'),
('LO002', 'YC002', 'SP002', 150, '2024-02-01', '2025-02-01'),
('LO003', 'YC003', 'SP003', 200, '2024-03-01', '2025-03-01'),
('LO004', 'YC004', 'SP004', 250, '2024-04-01', '2025-04-01'),
('LO005', 'YC005', 'SP005', 300, '2024-05-01', '2025-05-01'),
('LO006', 'YC006', 'SP006', 350, '2024-06-01', '2025-06-01'),
('LO007', 'YC007', 'SP007', 400, '2024-07-01', '2025-07-01'),
('LO008', 'YC008', 'SP008', 450, '2024-08-01', '2025-08-01'),
('LO009', 'YC009', 'SP009', 500, '2024-09-01', '2025-09-01');

INSERT INTO PhieuNghiemThu (MaPNT, MaYC, NgayNT, VanBan, MaNV) 
VALUES
('PNT001', 'YC001', '2024-09-01', 'Van ban nghiem thu cho san pham A', 'NV001'),
('PNT002', 'YC002', '2024-09-02', 'Van ban nghiem thu cho san pham B', 'NV002'),
('PNT003', 'YC003', '2024-09-03', 'Van ban nghiem thu cho san pham C', 'NV003'),
('PNT004', 'YC004', '2024-09-04', 'Van ban nghiem thu cho san pham D', 'NV004'),
('PNT005', 'YC005', '2024-09-05', 'Van ban nghiem thu cho san pham E', 'NV005'),
('PNT006', 'YC006', '2024-09-06', 'Van ban nghiem thu cho san pham F', 'NV006'),
('PNT007', 'YC007', '2024-09-07', 'Van ban nghiem thu cho san pham G', 'NV007'),
('PNT008', 'YC008', '2024-09-08', 'Van ban nghiem thu cho san pham H', 'NV008'),
('PNT009', 'YC009', '2024-09-09', 'Van ban nghiem thu cho san pham I', 'NV009');

INSERT INTO CTPhieuNghiemThu (MaPNT, SoLo, KetQuaNT) VALUES 
(N'PNT001', N'LO001', N'Dat'),
(N'PNT002', N'LO002', N'Khong dat'),
(N'PNT003', N'LO003', N'Dat'),
(N'PNT004', N'LO004', N'Khong dat'),
(N'PNT005', N'LO001', N'Dat'),
(N'PNT006', N'LO005', N'Khong dat'),
(N'PNT007', N'LO006', N'Dat'),
(N'PNT008', N'LO007', N'Khong dat'),
(N'PNT009', N'LO008', N'Dat');

/*INSERT INTO ChienDich (MaCD, TenCD, NgayBatDau, NgayKetThuc, MaNV) VALUES 
(N'CD001', N'Chiến Dịch A', '2023-01-01', '2023-01-31', N'NV001'),
(N'CD002', N'Chiến Dịch B', '2023-02-01', '2023-02-28', N'NV002'),
(N'CD003', N'Chiến Dịch C', '2023-03-01', '2023-03-31', N'NV003'),
(N'CD004', N'Chiến Dịch D', '2023-04-01', '2023-04-30', N'NV004'),
(N'CD005', N'Chiến Dịch E', '2023-05-01', '2023-05-31', N'NV005'),
(N'CD006', N'Chiến Dịch F', '2023-06-01', '2023-06-30', N'NV006'),
(N'CD007', N'Chiến Dịch G', '2023-07-01', '2023-07-31', N'NV007'),
(N'CD008', N'Chiến Dịch H', '2023-08-01', '2023-08-31', N'NV008'),
(N'CD009', N'Chiến Dịch I', '2023-09-01', '2023-09-30', N'NV009');*/

INSERT INTO LoaiKH (MaLoaiKH, TenLoaiKH) VALUES
('LKH001', 'Khach hang thuong'),
('LKH002', 'Khach hang VIP'),
('LKH003', 'Khach hang doanh nghiep'),
('LKH004', 'Khach hang tieu thu'),
('LKH005', 'Khach hang moi'),
('LKH006', 'Khach hang cao cap'),
('LKH007', 'Khach hang tham gia su kien'),
('LKH008', 'Khach hang quoc te'),
('LKH009', 'Khach hang trung thanh');

INSERT INTO KhachHang (MaKH, TenKH, Email, SDT, DiaChi, MaLoaiKH) VALUES
('KH001', 'Nguyen Van A', 'nguyenvana@example.com', '0123456789', 'Ha Noi', 'LKH001'),
('KH002', 'Tran Thi B', 'tranthib@example.com', '0987654321', 'Hai Phong', 'LKH002'),
('KH003', 'Le Van C', 'levanc@example.com', '0123456780', 'Da Nang', 'LKH003'),
('KH004', 'Pham Thi D', 'phamthid@example.com', '0123456781', 'Hue', 'LKH004'),
('KH005', 'Ngo Van E', 'ngovan@example.com', '0123456782', 'Can Tho', 'LKH005'),
('KH006', 'Vu Thi F', 'vuthif@example.com', '0123456783', 'Nha Trang', 'LKH006'),
('KH007', 'Hoang Van G', 'hoangvang@example.com', '0123456784', 'Vinh', 'LKH007'),
('KH008', 'Nguyen Thi H', 'nguyenthih@example.com', '0123456785', 'Bac Ninh', 'LKH008'),
('KH009', 'Truong Van I', 'truongvani@example.com', '0123456786', 'Thai Nguyen', 'LKH009');

/*INSERT INTO UuDai (MaUuDai, NoiDungUuDai) 
VALUES
('UD001', N'Giảm giá 10% cho đơn hàng trên 500.000 VNĐ'),
('UD002', N'Mua 1 tặng 1 sản phẩm A'),
('UD003', N'Giảm giá 20% cho khách hàng thân thiết'),
('UD004', N'Tặng voucher 50.000 VNĐ cho lần mua tiếp theo'),
('UD005', N'Giảm giá 15% cho khách hàng mới'),
('UD006', N'Mua 2 sản phẩm A được giảm giá 25%'),
('UD007', N'Tặng quà cho đơn hàng trên 1 triệu VNĐ'),
('UD008', N'Giảm giá 5% cho khách hàng thanh toán qua thẻ'),
('UD009', N'Khách hàng giới thiệu bạn bè được giảm giá 30% cho lần mua tiếp theo');*/

/*INSERT INTO UuDai_LoaiKH (MaUuDai, MaLoaiKH) 
VALUES
('UD001', 'LKH001'),
('UD002', 'LKH002'),
('UD003', 'LKH001'),
('UD004', 'LKH003'),
('UD005', 'LKH002'),
('UD006', 'LKH001'),
('UD007', 'LKH003'),
('UD008', 'LKH002'),
('UD009', 'LKH001');*/

/*INSERT INTO UuDai_ChienDich (MaUuDai, MaCD) 
VALUES
('UD001', 'CD001'),
('UD002', 'CD002'),
('UD003', 'CD003'),
('UD004', 'CD001'),
('UD005', 'CD002'),
('UD006', 'CD003'),
('UD007', 'CD001'),
('UD008', 'CD002');*/

INSERT INTO MauMaSP (MaAnhSP, MaSP, MoTa, HinhAnhSP, MaNV) VALUES
('MA001', 'SP001', 'Hinh anh banh keo', 'link_hinh_1.jpg', 'NV001'),
('MA002', 'SP002', 'Hinh anh socola', 'link_hinh_2.jpg', 'NV002'),
('MA003', 'SP003', 'Hinh anh banh quy', 'link_hinh_3.jpg', 'NV003'),
('MA004', 'SP004', 'Hinh anh keo nhai', 'link_hinh_4.jpg', 'NV004'),
('MA005', 'SP005', 'Hinh anh banh trung thu', 'link_hinh_5.jpg', 'NV005'),
('MA006', 'SP006', 'Hinh anh banh xeo', 'link_hinh_6.jpg', 'NV006'),
('MA007', 'SP007', 'Hinh anh snack', 'link_hinh_7.jpg', 'NV007'),
('MA008', 'SP008', 'Hinh anh nuoc ngot', 'link_hinh_8.jpg', 'NV008'),
('MA009', 'SP009', 'Hinh anh thuc pham dinh duong', 'link_hinh_9.jpg', 'NV009');

/*INSERT INTO HinhAnhQC (MaAnhQC, MaCD, MoTa, HinhAnhQC, MaNV) VALUES
('AQC001', 'CD001', 'Hinh anh quang cao 1', 'link_hinh_1.jpg', 'NV001'),
('AQC002', 'CD002', 'Hinh anh quang cao 2', 'link_hinh_2.jpg', 'NV002'),
('AQC003', 'CD003', 'Hinh anh quang cao 3', 'link_hinh_3.jpg', 'NV003'),
('AQC004', 'CD004', 'Hinh anh quang cao 4', 'link_hinh_4.jpg', 'NV004'),
('AQC005', 'CD005', 'Hinh anh quang cao 5', 'link_hinh_5.jpg', 'NV005'),
('AQC006', 'CD006', 'Hinh anh quang cao 6', 'link_hinh_6.jpg', 'NV006'),
('AQC007', 'CD007', 'Hinh anh quang cao 7', 'link_hinh_7.jpg', 'NV007'),
('AQC008', 'CD008', 'Hinh anh quang cao 8', 'link_hinh_8.jpg', 'NV008'),
('AQC009', 'CD009', 'Hinh anh quang cao 9', 'link_hinh_9.jpg', 'NV009');*/

INSERT INTO DonDH (MaDDH, MaKH, NgayLap, NgayGiao, TinhTrang, MaNV) VALUES 
(N'DDH001', N'KH001', '2023-01-01', '2023-01-05', N'Đã giao', N'NV001'),
(N'DDH002', N'KH002', '2023-01-02', '2023-01-06', N'Chưa giao', N'NV002'),
(N'DDH003', N'KH003', '2023-01-03', '2023-01-07', N'Đã giao', N'NV003'),
(N'DDH004', N'KH004', '2023-01-04', '2023-01-08', N'Đã giao', N'NV004'),
(N'DDH005', N'KH005', '2023-01-05', '2023-01-09', N'Chưa giao', N'NV005'),
(N'DDH006', N'KH006', '2023-01-06', '2023-01-10', N'Đã giao', N'NV006'),
(N'DDH007', N'KH007', '2023-01-07', '2023-01-11', N'Chưa giao', N'NV007'),
(N'DDH008', N'KH008', '2023-01-08', '2023-01-12', N'Đã giao', N'NV008'),
(N'DDH009', N'KH009', '2023-01-09', '2023-01-13', N'Chưa giao', N'NV009');

INSERT CTDonDH (MaDDH, MaSP, SoLuong) VALUES 
(N'DDH001', N'SP001', 2),
(N'DDH002', N'SP002', 1),
(N'DDH003', N'SP003', 3),
(N'DDH004', N'SP001', 1),
(N'DDH005', N'SP004', 5),
(N'DDH006', N'SP005', 2),
(N'DDH007', N'SP006', 4),
(N'DDH008', N'SP007', 1),
(N'DDH009', N'SP008', 3);

INSERT INTO HoaDon (MaHD, MaDDH, NgayLapHD, TinhTrangHD, MaNV) VALUES
('HD001', 'DDH001', '2024-01-01', 'Da thanh toan', 'NV001'),
('HD002', 'DDH002', '2024-01-02', 'Chua thanh toan', 'NV002'),
('HD003', 'DDH003', '2024-01-03', 'Da thanh toan', 'NV003'),
('HD004', 'DDH004', '2024-01-04', 'Chua thanh toan', 'NV004'),
('HD005', 'DDH005', '2024-01-05', 'Da thanh toan', 'NV005'),
('HD007', 'DDH007', '2024-01-07', 'Da thanh toan', 'NV007'),
('HD008', 'DDH008', '2024-01-08', 'Chua thanh toan', 'NV008'),
('HD009', 'DDH009', '2024-01-09', 'Da thanh toan', 'NV009');

INSERT INTO CT_HoaDon (MaHD, MaSP, SoLuong, DonGia) VALUES 
(N'HD001', N'SP001', 2, 100000),
(N'HD002', N'SP002', 1, 200000),
(N'HD003', N'SP003', 5, 150000),
(N'HD004', N'SP004', 3, 250000),
(N'HD005', N'SP005', 4, 300000),
(N'HD007', N'SP007', 1, 180000),
(N'HD008', N'SP008', 6, 220000),
(N'HD009', N'SP009', 3, 130000);

INSERT INTO PhieuHoan (MaPH, MaDDH, NgayHoan, MaNV) 
VALUES
('PH001', 'DDH001', '2024-09-15', 'NV001'),
('PH002', 'DDH002', '2024-09-16', 'NV002'),
('PH003', 'DDH003', '2024-09-17', 'NV003'),
('PH004', 'DDH004', '2024-09-18', 'NV004'),
('PH005', 'DDH005', '2024-09-19', 'NV005'),
('PH006', 'DDH006', '2024-09-20', 'NV006'),
('PH007', 'DDH007', '2024-09-21', 'NV007'),
('PH008', 'DDH008', '2024-09-22', 'NV008'),
('PH009', 'DDH009', '2024-09-23', 'NV009');

INSERT INTO CTPhieuHoan (MaPH, MaSP, SoLuongHoan, LyDoHoan) VALUES 
(N'PH001', N'SP001', 1, N'Khong phu hop'),
(N'PH002', N'SP002', 1, N'Bi loi'),
(N'PH003', N'SP003', 2, N'Khach hang khong muon'),
(N'PH004', N'SP004', 1, N'Khong thich'),
(N'PH005', N'SP005', 1, N'Da nhan sai'),
(N'PH006', N'SP006', 2, N'Khong dung size'),
(N'PH007', N'SP007', 1, N'Khach muon tra'),
(N'PH008', N'SP008', 3, N'Khong hoan toan nhu mong doi'),
(N'PH009', N'SP009', 2, N'Giao hang cham');

INSERT INTO NhaCungCap (MaNCC, TenNCC, Email, SDT, DiaChi) VALUES
('NCC001', 'Cong ty A', 'congtyA@example.com', '0123456789', 'Dia chi A'),
('NCC002', 'Cong ty B', 'congtyB@example.com', '0987654321', 'Dia chi B'),
('NCC003', 'Cong ty C', 'congtyC@example.com', '0123456780', 'Dia chi C'),
('NCC004', 'Cong ty D', 'congtyD@example.com', '0987654320', 'Dia chi D'),
('NCC005', 'Cong ty E', 'congtyE@example.com', '0123456781', 'Dia chi E'),
('NCC006', 'Cong ty F', 'congtyF@example.com', '0123456782', 'Dia chi F'),
('NCC007', 'Cong ty G', 'congtyG@example.com', '0123456783', 'Dia chi G'),
('NCC008', 'Cong ty H', 'congtyH@example.com', '0123456784', 'Dia chi H'),
('NCC009', 'Cong ty I', 'congtyI@example.com', '0123456785', 'Dia chi I');

--0 là nhập từ kho, 1 là cho nhập từ bên ngoài
INSERT INTO PhieuNhapNVL (MaPNNVL, MaYC, MaNCC, NgayNhap, MaNV, PhanLoai) 
VALUES
('PN001', 'YC001', 'NCC001', '2024-09-25', 'NV001', 0),
('PN002', 'YC002', 'NCC002', '2024-09-26', 'NV002', 1),
('PN003', 'YC003', 'NCC003', '2024-09-27', 'NV003', 0),
('PN004', 'YC004', 'NCC004', '2024-09-28', 'NV004', 1),
('PN005', 'YC005', 'NCC005', '2024-09-29', 'NV005', 0),
('PN006', 'YC006', 'NCC006', '2024-09-30', 'NV006', 1),
('PN007', 'YC007', 'NCC007', '2024-10-01', 'NV007', 0),
('PN008', 'YC008', 'NCC008', '2024-10-02', 'NV008', 1),
('PN009', 'YC009', 'NCC009', '2024-10-03', 'NV009', 0);

INSERT INTO CTPhieuNhapNVL (MaPNNVL, MaNVL, SLNhap, DVT, GiaNhap, NSX, HSD) VALUES 
(N'PN001', N'NVL001', 100, N'kg', 50000, '2024-01-01', '2025-01-01'),
(N'PN002', N'NVL002', 200, N'kg', 60000, '2024-01-02', '2025-01-02'),
(N'PN003', N'NVL003', 150, N'kg', 55000, '2024-01-03', '2025-01-03'),
(N'PN004', N'NVL004', 250, N'kg', 70000, '2024-01-04', '2025-01-04'),
(N'PN005', N'NVL005', 300, N'kg', 65000, '2024-01-05', '2025-01-05'),
(N'PN006', N'NVL001', 120, N'kg', 52000, '2024-01-06', '2025-01-06'),
(N'PN007', N'NVL006', 80, N'kg', 48000, '2024-01-07', '2025-01-07'),
(N'PN008', N'NVL007', 90, N'kg', 72000, '2024-01-08', '2025-01-08'),
(N'PN009', N'NVL008', 60, N'kg', 70000, '2024-01-09', '2025-01-09');

INSERT INTO PhieuXuatNVL (MaPXNVL, NgayXuat, MaNV) 
VALUES
('PXNVL001', '2024-10-01', 'NV001'),
('PXNVL002', '2024-10-02', 'NV002'),
('PXNVL003', '2024-10-03', 'NV003'),
('PXNVL004', '2024-10-04', 'NV004'),
('PXNVL005', '2024-10-05', 'NV005'),
('PXNVL006', '2024-10-06', 'NV006'),
('PXNVL007', '2024-10-07', 'NV007'),
('PXNVL008', '2024-10-08', 'NV008'),
('PXNVL009', '2024-10-09', 'NV009');

INSERT INTO CTPhieuXuatNVL (MaPXNVL, MaNVL, SoLuong) VALUES 
(N'PXNVL001', N'NVL001', 50),
(N'PXNVL002', N'NVL002', 30),
(N'PXNVL003', N'NVL003', 40),
(N'PXNVL004', N'NVL004', 20),
(N'PXNVL005', N'NVL001', 60),
(N'PXNVL006', N'NVL005', 25),
(N'PXNVL007', N'NVL006', 15),
(N'PXNVL008', N'NVL007', 35),
(N'PXNVL009', N'NVL008', 45);

INSERT INTO PhieuNhapSP (MaPNSP, NgayNhap, MaNV) 
VALUES
('PNSP001', '2024-10-01', 'NV001'),  
('PNSP002', '2024-10-02', 'NV002'),  
('PNSP003', '2024-10-03', 'NV003'), 
('PNSP004', '2024-10-04', 'NV004'),  
('PNSP005', '2024-10-05', 'NV005'),  
('PNSP006', '2024-10-06', 'NV006'),  
('PNSP007', '2024-10-07', 'NV007'), 
('PNSP008', '2024-10-08', 'NV008'),  
('PNSP009', '2024-10-09', 'NV009');  

INSERT INTO CTPhieuNhapSP (MaPNSP, SoLo) VALUES 
(N'PNSP001', N'LO001'),
(N'PNSP002', N'LO002'),
(N'PNSP003', N'LO003'),
(N'PNSP004', N'LO004'),
(N'PNSP005', N'LO005'),
(N'PNSP006', N'LO001'),
(N'PNSP007', N'LO006'),
(N'PNSP008', N'LO007'),
(N'PNSP009', N'LO008');

INSERT INTO PhieuXuatSP (MaPXSP, MaDDH, NgayXuat, MaNV) 
VALUES
('PXSP001', 'DDH001', '2024-10-10', 'NV001'),
('PXSP002', 'DDH002', '2024-10-11', 'NV002'),
('PXSP003', 'DDH003', '2024-10-12', 'NV003'),
('PXSP004', 'DDH004', '2024-10-13', 'NV004'),
('PXSP005', 'DDH005', '2024-10-14', 'NV005'),
('PXSP006', 'DDH006', '2024-10-15', 'NV006'),
('PXSP007', 'DDH007', '2024-10-16', 'NV007'),
('PXSP008', 'DDH008', '2024-10-17', 'NV008'),
('PXSP009', 'DDH009', '2024-10-18', 'NV009');

INSERT INTO CTPhieuXuatSP (MaPXSP, MaSP, SoLuong) VALUES 
(N'PXSP001', N'SP001', 100),
(N'PXSP001', N'SP002', 200),
(N'PXSP002', N'SP003', 150),
(N'PXSP002', N'SP004', 250),
(N'PXSP003', N'SP001', 120),
(N'PXSP003', N'SP005', 300),
(N'PXSP004', N'SP006', 80),
(N'PXSP004', N'SP007', 90),
(N'PXSP005', N'SP008', 60),
(N'PXSP005', N'SP009', 110);

INSERT INTO PNHangHoan (MaPNHH, MaDDH, NgayHoan, MaNV) VALUES
('PNHH001', 'DDH001', '2024-01-01', 'NV001'),
('PNHH002', 'DDH002', '2024-01-02', 'NV002'),
('PNHH003', 'DDH003', '2024-01-03', 'NV003'),
('PNHH004', 'DDH004', '2024-01-04', 'NV004'),
('PNHH005', 'DDH005', '2024-01-05', 'NV005'),
('PNHH007', 'DDH007', '2024-01-07', 'NV007'),
('PNHH008', 'DDH008', '2024-01-08', 'NV008'),
('PNHH009', 'DDH009', '2024-01-09', 'NV009');

INSERT INTO CTPNHangHoan (MaPNHH, MaSP, SoLuongHoan) VALUES 
(N'PNHH001', N'SP001', 10),
(N'PNHH002', N'SP002', 5),
(N'PNHH003', N'SP003', 8),
(N'PNHH004', N'SP004', 12),
(N'PNHH005', N'SP005', 20),
(N'PNHH007', N'SP006', 7),
(N'PNHH008', N'SP007', 9),
(N'PNHH009', N'SP008', 4);

INSERT INTO DanhMucThu (MaDMT, TenDMT) VALUES
('DMT001', N'Thực phẩm'),
('DMT002', N'Đồ uống'),
('DMT003', N'Bánh kẹo'),
('DMT004', N'Thực ăn nhanh'),
('DMT005', N'Gia vị'),
('DMT006', N'Đồ đông lạnh'),
('DMT007', N'Bánh ngọt'),
('DMT008', N'Trái cây'),
('DMT009', N'Sữa và sản phẩm từ sữa'),
('DMT010', N'Thực phẩm chức năng');

INSERT INTO DanhMucChi (MaDMT, TenDMT) VALUES
('DMC001', 'Chi nguyen vat lieu'),
('DMC002', 'Chi van hanh'),
('DMC003', 'Chi quang cao'),
('DMC004', 'Chi khau hao'),
('DMC005', 'Chi thuong'),
('DMC006', 'Chi su kien'),
('DMC007', 'Chi bao hiem'),
('DMC008', 'Chi tien luong'),
('DMC009', 'Chi phuc loi');

INSERT INTO PhieuThu (MaPhieuThu, MaDMT, NoiDung, SoTienThu, NgayThu, MaNV) 
VALUES
('PT001', 'DMT001', 'Thu tiền bán hàng', 1000000, '2024-10-01', 'NV001'),
('PT002', 'DMT002', 'Thu tiền dịch vụ', 2000000, '2024-10-02', 'NV002'),
('PT003', 'DMT003', 'Thu tiền thuê kho', 1500000, '2024-10-03', 'NV003'),
('PT004', 'DMT004', 'Thu tiền bán sản phẩm', 2500000, '2024-10-04', 'NV004'),
('PT005', 'DMT005', 'Thu tiền vận chuyển', 3000000, '2024-10-05', 'NV005'),
('PT006', 'DMT006', 'Thu tiền hoàn trả', 1200000, '2024-10-06', 'NV006'),
('PT007', 'DMT007', 'Thu tiền phạt vi phạm', 500000, '2024-10-07', 'NV007'),
('PT008', 'DMT008', 'Thu tiền cho thuê tài sản', 1800000, '2024-10-08', 'NV008'),
('PT009', 'DMT009', 'Thu tiền bán thiết bị', 2200000, '2024-10-09', 'NV009');

INSERT INTO PhieuChi (MaPhieuChi, MaDMC, NoiDung, SoTienChi, NgayChi, MaNV) VALUES
('PC001', 'DMC001', 'Chi cho mua nguyen vat lieu', 100000, '2024-01-01', 'NV001'),
('PC002', 'DMC002', 'Chi phi van hanh', 200000, '2024-01-02', 'NV002'),
('PC003', 'DMC003', 'Chi cho quang cao', 150000, '2024-01-03', 'NV003'),
('PC004', 'DMC001', 'Chi cho khau hao', 300000, '2024-01-04', 'NV004'),
('PC005', 'DMC002', 'Chi cho thuong', 50000, '2024-01-05', 'NV005'),
('PC006', 'DMC003', 'Chi cho su kien', 120000, '2024-01-06', 'NV006'),
('PC007', 'DMC001', 'Chi cho bao hiem', 250000, '2024-01-07', 'NV007'),
('PC008', 'DMC002', 'Chi cho tien luong', 400000, '2024-01-08', 'NV008'),
('PC009', 'DMC003', 'Chi cho phuc loi', 350000, '2024-01-09', 'NV009');

INSERT INTO PhieuChiCongNo (MaPCCN, MaNCC, NoiDung, SoTienChi, NgayChi, MaNV) VALUES
('PCCN001', 'NCC001', 'Chi tien mua nguyen vat lieu', 50000, '2024-01-01', 'NV001'),
('PCCN002', 'NCC002', 'Chi tien thiet bi', 75000, '2024-01-02', 'NV002'),
('PCCN003', 'NCC003', 'Chi tien van chuyen', 30000, '2024-01-03', 'NV003'),
('PCCN004', 'NCC004', 'Chi tien hoa don', 100000, '2024-01-04', 'NV004'),
('PCCN005', 'NCC005', 'Chi tien dich vu', 120000, '2024-01-05', 'NV005'),
('PCCN006', 'NCC006', 'Chi tien qua tang', 20000, '2024-01-06', 'NV006'),
('PCCN007', 'NCC007', 'Chi tien khac', 40000, '2024-01-07', 'NV007'),
('PCCN008', 'NCC008', 'Chi tien bao hiem', 60000, '2024-01-08', 'NV008'),
('PCCN009', 'NCC009', 'Chi tien khau hao', 90000, '2024-01-09', 'NV009');

INSERT INTO PhieuThuCongNo (MaPTCN, MaKH, NoiDung, SoTienThu, NgayThu, MaNV) 
VALUES
('PTCN001', 'KH001', N'Thu tiền hàng hóa', 1000000, '2024-09-25', 'NV001'),
('PTCN002', 'KH002', N'Thu tiền dịch vụ', 1500000, '2024-09-26', 'NV002'),
('PTCN003', 'KH003', N'Thu tiền hàng hóa', 1200000, '2024-09-27', 'NV003'),
('PTCN004', 'KH004', N'Thu tiền dịch vụ', 800000, '2024-09-28', 'NV004'),
('PTCN005', 'KH005', N'Thu tiền hàng hóa', 2000000, '2024-09-29', 'NV005'),
('PTCN006', 'KH006', N'Thu tiền dịch vụ', 900000, '2024-09-30', 'NV006'),
('PTCN007', 'KH007', N'Thu tiền hàng hóa', 1100000, '2024-10-01', 'NV007'),
('PTCN008', 'KH008', N'Thu tiền dịch vụ', 1300000, '2024-10-02', 'NV008'),
('PTCN009', 'KH009', N'Thu tiền hàng hóa', 1400000, '2024-10-03', 'NV009');