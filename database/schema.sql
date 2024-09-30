CREATE DATABASE erp_database
GO

USE erp_database
GO

----------------------------------------------------------
-------------------- Quản lý nhân sự ---------------------
----------------------------------------------------------
-- Bảng Thông tin nhân viên
CREATE TABLE ThongTinNhanVien (
    MaNV VARCHAR(10) PRIMARY KEY,
    TenNV VARCHAR(100),
    GioiTinh VARCHAR(3),
    NgaySinh DATE,
    QueQuan VARCHAR(50),
    SDT VARCHAR(15),
    TDHV VARCHAR(50)
);

-- Bảng Tài khoản
CREATE TABLE TaiKhoan (
    Usename VARCHAR(20) PRIMARY KEY,
    Password VARCHAR(20),
    MaNV VARCHAR(10),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Bộ phận
CREATE TABLE BoPhan (
    MaBP VARCHAR(10) PRIMARY KEY,
    TenBP VARCHAR(255),
    SDT VARCHAR(15)
);

-- Bảng Bậc lương
CREATE TABLE BacLuong (
    MaBL VARCHAR(10) PRIMARY KEY,
    LuongCB INT,
    HSLuong INT,
    HSPhuCap INT
);

-- Bảng Chức vụ
CREATE TABLE ChucVu (
    MaCV VARCHAR(10) PRIMARY KEY,
    TenCV VARCHAR(255),
    MaBL VARCHAR(10),
    FOREIGN KEY (MaBL) REFERENCES BacLuong(MaBL)
);

-- Bảng Quá trình công tác
CREATE TABLE QTCongTac (
    MaQT VARCHAR(10) PRIMARY KEY,
    MaNV VARCHAR(10),
    MaCV VARCHAR(10),
    ThoiGianBD DATE,
    ThoiGianKT DATE,
    MaBP VARCHAR(10),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV),
    FOREIGN KEY (MaCV) REFERENCES ChucVu(MaCV),
    FOREIGN KEY (MaBP) REFERENCES BoPhan(MaBP)
);

-- Bảng Hợp đồng
CREATE TABLE HopDong (
    MaHopDong VARCHAR(10) PRIMARY KEY,
    TenHopDong VARCHAR(100),
    MaNV VARCHAR(10),
    NgayBatDau DATE,
    NgatKetThuc DATE,
    VanBan TEXT,
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Công
CREATE TABLE Cong (
    MaNV VARCHAR(10),
    MaBL VARCHAR(10),
    ThangNam VARCHAR(6),
    SoNgayCong FLOAT,
    SoNgayNghi FLOAT,
    SoGioLamThem FLOAT,
    PRIMARY KEY (MaNV, ThangNam),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV),
    FOREIGN KEY (MaBL) REFERENCES BacLuong(MaBL)
);

-- Bảng Phiếu khen thưởng kỉ luật
CREATE TABLE phieuktkl (
    MaPhieuKTKL VARCHAR(10) PRIMARY KEY,
    NoiDung VARCHAR(100),
    SoTienKTKL INT,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Bảo hiểm
CREATE TABLE BaoHiem (
    MaBaoHiem VARCHAR(10) PRIMARY KEY,
    TenBaoHiem VARCHAR(100),
    NoiDungBH VARCHAR(255)
);

-- Bảng Phụ cấp
CREATE TABLE PhuCap (
    MaPhuCap VARCHAR(10) PRIMARY KEY,
    TenPhuCap VARCHAR(100),
    NoiDungPC VARCHAR(255)
);

-- Bảng Chính sách
CREATE TABLE ChinhSach (
    MaChinhSach VARCHAR(10) PRIMARY KEY,
    TenChinhSach VARCHAR(100),
    NoiDungCS VARCHAR(255)
);

-- Bảng Nhân viên – bảo hiểm
CREATE TABLE NV_BaoHiem (
    MaBaoHiem VARCHAR(10),
    MaNV VARCHAR(10),
    PRIMARY KEY (MaBaoHiem, MaNV),
    FOREIGN KEY (MaBaoHiem) REFERENCES BaoHiem(MaBaoHiem),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Nhân viên – Phụ cấp
CREATE TABLE NV_PhuCap (
    MaPhuCap VARCHAR(10),
    MaNV VARCHAR(10),
    PRIMARY KEY (MaPhuCap, MaNV),
    FOREIGN KEY (MaPhuCap) REFERENCES PhuCap(MaPhuCap),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Nhân viên – Chính sách
CREATE TABLE NV_ChinhSach (
    MaChinhSach VARCHAR(10),
    MaNV VARCHAR(10),
    PRIMARY KEY (MaChinhSach, MaNV),
    FOREIGN KEY (MaChinhSach) REFERENCES ChinhSach(MaChinhSach),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

----------------------------------------------------------
-------------------- Quản lý sản xuất --------------------
----------------------------------------------------------
-- Bảng Loại sản phẩm
CREATE TABLE LoaiSP (
    MaLoai VARCHAR(10) PRIMARY KEY,
    TenLoai VARCHAR(100)
);

-- Bảng Sản phẩm
CREATE TABLE SanPham (
    MaSP VARCHAR(10) PRIMARY KEY,
    MaLoai VARCHAR(10),
    TenSP VARCHAR(100),
    GiaBan INT,
    ThanhPhan VARCHAR(500),
    KLT VARCHAR(20),
    SoLuongTon INT
    FOREIGN KEY (MaLoai) REFERENCES LoaiSP(MaLoai)
);

-- Bảng Phiếu yêu cầu sản xuất
CREATE TABLE PhieuYCSX (
    MaYC VARCHAR(10) PRIMARY KEY,
    NgayBD DATE,
    NgayKT DATE,
    VanBan TEXT,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Chi tiết phiếu yêu cầu sản xuất
CREATE TABLE CTPhieuYCSX (
    MaYC VARCHAR(10),
    MaSP VARCHAR(10),
    SoLuongSX INT,
    PRIMARY KEY (MaYC, MaSP),
    FOREIGN KEY (MaYC) REFERENCES PhieuYCSX(MaYC),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);

-- Bảng Nguyên vật liệu
CREATE TABLE NguyenVatLieu (
    MaNVL VARCHAR(10) PRIMARY KEY,
    TenNVL VARCHAR(10),
    GhiChu VARCHAR(255),
    SoLuongTon INT
);

-- Bảng Lô sản phẩm
CREATE TABLE LoSanPham (
    SoLo VARCHAR(10) PRIMARY KEY,
    MaYC VARCHAR(10),
    MaSP VARCHAR(10),
    SoLuongSP INT,
    NSX DATE,
    HSD DATE,
    FOREIGN KEY (MaYC) REFERENCES PhieuYCSX(MaYC),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);

-- Bảng Phiếu nghiệm thu
CREATE TABLE PhieuNghiemThu (
    MaPNT VARCHAR(10) PRIMARY KEY,
    MaYC VARCHAR(10),
    NgayNT DATE,
    VanBan TEXT,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaYC) REFERENCES PhieuYCSX(MaYC),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Chi tiết phiếu nghiệm thu
CREATE TABLE CTPhieuNghiemThu (
    MaPNT VARCHAR(10),
    SoLo VARCHAR(10),
    KetQuaNT VARCHAR(100),
    PRIMARY KEY (MaPNT, SoLo),
    FOREIGN KEY (MaPNT) REFERENCES PhieuNghiemThu(MaPNT),
    FOREIGN KEY (SoLo) REFERENCES LoSanPham(SoLo)
);

----------------------------------------------------------
-------------------- Quản lý marketing -------------------
----------------------------------------------------------
-- Bảng Chiến dịch
CREATE TABLE ChienDich (
    MaCD VARCHAR(10) PRIMARY KEY,
    TenCD VARCHAR(100),
    NgayBatDau INT, -- Có thể thay đổi thành DATE nếu cần
    NgayKetThuc VARCHAR(500), -- Có thể thay đổi thành DATE nếu cần
    MaNV VARCHAR(10),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Loại Khách hàng
CREATE TABLE LoaiKH (
    MaLoaiKH VARCHAR(10) PRIMARY KEY,
    TenLoaiKH VARCHAR(50)
);

-- Bảng Ưu đãi
CREATE TABLE UuDai (
    MaUuDai VARCHAR(10) PRIMARY KEY,
    NoiDungUuDai VARCHAR(255)
);

-- Bảng Ưu đãi – Loại khách hàng
CREATE TABLE UuDai_LoaiKH (
    MaUuDai VARCHAR(10),
    MaLoaiKH VARCHAR(10),
    PRIMARY KEY (MaUuDai, MaLoaiKH),
    FOREIGN KEY (MaUuDai) REFERENCES UuDai(MaUuDai),
    FOREIGN KEY (MaLoaiKH) REFERENCES LoaiKH(MaLoaiKH)
);

-- Bảng Ưu đãi – Chiến dịch
CREATE TABLE UuDai_ChienDich (
    MaUuDai VARCHAR(10),
    MaCD VARCHAR(10),
    PRIMARY KEY (MaUuDai, MaCD),
    FOREIGN KEY (MaUuDai) REFERENCES UuDai(MaUuDai),
    FOREIGN KEY (MaCD) REFERENCES ChienDich(MaCD)
);

-- Bảng Mẫu mã sản phẩm
CREATE TABLE MauMaSP (
    MaAnhSP VARCHAR(10) PRIMARY KEY,
    MaSP VARCHAR(10),
    MoTa VARCHAR(50),
    HinhAnhSP TEXT,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Hình ảnh quảng cáo
CREATE TABLE HinhAnhQC (
    MaAnhQC VARCHAR(10) PRIMARY KEY,
    MaCD VARCHAR(10),
    MoTa VARCHAR(50),
    HinhAnhQC TEXT,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaCD) REFERENCES ChienDich(MaCD),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

----------------------------------------------------------
-------------------- Quản lý bán hàng --------------------
----------------------------------------------------------

-- Bảng Khách hàng (đại lý)
CREATE TABLE KhachHang (
    MaKH VARCHAR(10) PRIMARY KEY,
    TenKH VARCHAR(255),
    Email VARCHAR(100),
    SDT VARCHAR(15),
    DiaChi VARCHAR(255)
);

-- Bảng Đơn đặt hàng
CREATE TABLE DonDH (
    MaDDH VARCHAR(10) PRIMARY KEY,
    MaKH VARCHAR(10),
    NgayLap DATE,
    NgayGiao DATE,
    TinhTrang VARCHAR(50),
    MaNV VARCHAR(10),
    FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Chi tiết đơn đặt hàng
CREATE TABLE CTDonDH (
    MaDDH VARCHAR(10),
    MaSP VARCHAR(10),
    SoLuong INT,
    PRIMARY KEY (MaDDH, MaSP),
    FOREIGN KEY (MaDDH) REFERENCES DonDH(MaDDH),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);

-- Bảng Hóa đơn
CREATE TABLE HoaDon (
    MaHD VARCHAR(10) PRIMARY KEY,
    MaDDH VARCHAR(10),
    NgayLapHD DATE,
    TinhTrangHD VARCHAR(50),
    MaNV VARCHAR(10),
    FOREIGN KEY (MaDDH) REFERENCES DonDH(MaDDH),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Chi tiết hóa đơn
CREATE TABLE CT_HoaDon (
    MaHD VARCHAR(10),
    MaSP VARCHAR(10),
    SoLuong INT,
    DonGia INT,
    PRIMARY KEY (MaHD, MaSP),
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);

-- Bảng Phiếu hoàn (khi khách hoàn trả hàng)
CREATE TABLE PhieuHoan (
    MaPH VARCHAR(10) PRIMARY KEY,
    MaDDH VARCHAR(10),
    NgayHoan DATE,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaDDH) REFERENCES DonDH(MaDDH),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Chi tiết phiếu hoàn
CREATE TABLE CTPhieuHoan (
    MaPH VARCHAR(10),
    MaSP VARCHAR(10),
    SoLuongHoan INT,
    LyDoHoan VARCHAR(255),
    PRIMARY KEY (MaPH, MaSP),
    FOREIGN KEY (MaPH) REFERENCES PhieuHoan(MaPH),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);

----------------------------------------------------------
-------------------- Quản lý kho -------------------------
----------------------------------------------------------

-- Bảng Nhà cung cấp
CREATE TABLE NhaCungCap (
    MaNCC VARCHAR(10) PRIMARY KEY,
    TenNCC VARCHAR(255),
    Email VARCHAR(100),
    SDT VARCHAR(15),
    DiaChi VARCHAR(255)
);

-- Bảng Phiếu nhập nguyên vật liệu (nhập từ kho + nhập từ ngoài)
CREATE TABLE PhieuNhapNVL (
    MaPNNVL VARCHAR(10) PRIMARY KEY,
    MaYC VARCHAR(10),
	MaNCC VARCHAR(10),
    NgayNhap DATE,
    MaNV VARCHAR(10),
	PhanLoai BIT,
    FOREIGN KEY (MaYC) REFERENCES PhieuYCSX(MaYC),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV),
    FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC)
);

-- Bảng Chi tiết phiếu nhập nguyên vật liệu
CREATE TABLE CTPhieuNhapNVL (
    MaPNNVL VARCHAR(10),
    MaNVL VARCHAR(10),
    SLNhap INT,
    DVT VARCHAR(10),
	GiaNhap INT,
	NSX DATE,
	HSD DATE,
    PRIMARY KEY (MaPNNVL, MaNVL),
    FOREIGN KEY (MaPNNVL) REFERENCES PhieuNhapNVL(MaPNNVL),
    FOREIGN KEY (MaNVL) REFERENCES NguyenVatLieu(MaNVL)
);

-- Bảng Phiếu xuất nguyên vật liệu
CREATE TABLE PhieuXuatNVL (
    MaPXNVL VARCHAR(10) PRIMARY KEY,
    NgayXuat DATE,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Chi tiết phiếu xuất nguyên vật liệu
CREATE TABLE CTPhieuXuatNVL (
    MaPXNVL VARCHAR(10),
    MaNVL VARCHAR(10),
    SoLuong INT,
    PRIMARY KEY (MaPXNVL, MaNVL),
    FOREIGN KEY (MaPXNVL) REFERENCES PhieuXuatNVL(MaPXNVL),
    FOREIGN KEY (MaNVL) REFERENCES NguyenVatLieu(MaNVL)
);

-- Bảng Phiếu nhập sản phẩm (nhập từ bộ phận sản xuất vào kho)
CREATE TABLE PhieuNhapSP (
    MaPNSP VARCHAR(10) PRIMARY KEY,
    NgayNhap DATE,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Chi tiết phiếu nhập sản phẩm
CREATE TABLE CTPhieuNhapSP (
    MaPNSP VARCHAR(10),
    SoLo VARCHAR(10),
    PRIMARY KEY (MaPNSP, SoLo),
    FOREIGN KEY (MaPNSP) REFERENCES PhieuNhapSP(MaPNSP),
    FOREIGN KEY (SoLo) REFERENCES LoSanPham(SoLo)
);

-- Bảng Phiếu xuất sản phẩm (xuất theo đơn đặt hàng)
CREATE TABLE PhieuXuatSP (
    MaPXSP VARCHAR(10) PRIMARY KEY,
    MaDDH VARCHAR(10),
    NgayXuat DATE,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaDDH) REFERENCES DonDH(MaDDH),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Chi tiết phiếu xuất sản phẩm
CREATE TABLE CTPhieuXuatSP (
    MaPXSP VARCHAR(10),
    MaSP VARCHAR(10),
    SoLuong INT,
    PRIMARY KEY (MaPXSP, MaSP),
    FOREIGN KEY (MaPXSP) REFERENCES PhieuXuatSP(MaPXSP),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);

-- Bảng Phiếu nhập hàng hoàn (Hàng hoàn trả từ khách hàng)
CREATE TABLE PNHangHoan (
    MaPNHH VARCHAR(10) PRIMARY KEY,
    MaDDH VARCHAR(10),
    NgayHoan DATE,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaDDH) REFERENCES DonDH(MaDDH),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Chi tiết phiếu nhập hàng hoàn
CREATE TABLE CTPNHangHoan (
    MaPNHH VARCHAR(10),
    MaSP VARCHAR(10),
    SoLuongHoan INT,
    PRIMARY KEY (MaPNHH, MaSP),
    FOREIGN KEY (MaPNHH) REFERENCES PNHangHoan(MaPNHH),
    FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP)
);

----------------------------------------------------------
-------------------- Quản lý tài chính -------------------
----------------------------------------------------------

-- Bảng Danh mục thu
CREATE TABLE DanhMucThu (
    MaDMT VARCHAR(10) PRIMARY KEY,
    TenDMT VARCHAR(255)
);

-- Bảng Danh mục chi
CREATE TABLE DanhMucChi (
    MaDMT VARCHAR(10) PRIMARY KEY,
    TenDMT VARCHAR(255)
);

-- Bảng Phiếu thu
CREATE TABLE PhieuThu (
    MaPhieuThu VARCHAR(10) PRIMARY KEY,
    MaDMT VARCHAR(10),
    NoiDung VARCHAR(255),
    SoTienThu INT,
    NgayThu DATE,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaDMT) REFERENCES DanhMucThu(MaDMT),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Phiếu chi
CREATE TABLE PhieuChi (
    MaPhieuChi VARCHAR(10) PRIMARY KEY,
    MaDMC VARCHAR(10),
    NoiDung VARCHAR(255),
    SoTienChi INT,
    NgayChi DATE,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaDMC) REFERENCES DanhMucChi(MaDMT),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Phiếu thu công nợ
CREATE TABLE PhieuThuCongNo (
    MaPTCN VARCHAR(10) PRIMARY KEY,
    MaKH VARCHAR(10),
    NoiDung VARCHAR(255),
    SoTienThu INT,
    NgayThu DATE,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);

-- Bảng Phiếu chi công nợ
CREATE TABLE PhieuChiCongNo (
    MaPCCN VARCHAR(10) PRIMARY KEY,
    MaNCC VARCHAR(10),
    NoiDung VARCHAR(255),
    SoTienChi INT,
    NgayChi DATE,
    MaNV VARCHAR(10),
    FOREIGN KEY (MaNCC) REFERENCES NhaCungCap(MaNCC),
    FOREIGN KEY (MaNV) REFERENCES ThongTinNhanVien(MaNV)
);
