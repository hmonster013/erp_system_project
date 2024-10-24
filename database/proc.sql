CREATE PROCEDURE GetThongTinBaoHiemNhanVien
AS
BEGIN
    SELECT 
        nv.MaNV,                 -- Mã nhân viên
        nv.TenNV,                -- Tên nhân viên
        bh.MaBaoHiem,            -- Mã bảo hiểm
        bh.TenBaoHiem,           -- Tên bảo hiểm
        bh.NoiDungBH             -- Nội dung bảo hiểm
    FROM 
        ThongTinNhanVien nv
    INNER JOIN 
        NV_BaoHiem nvbh ON nv.MaNV = nvbh.MaNV  -- Kết hợp thông tin nhân viên và bảo hiểm
    INNER JOIN 
        BaoHiem bh ON nvbh.MaBaoHiem = bh.MaBaoHiem;  -- Kết hợp thông tin bảo hiểm
END;
GO


exec GetThongTinBaoHiemNhanVien