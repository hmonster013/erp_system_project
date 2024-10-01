using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class ThongTinNhanVien
{
    public string MaNv { get; set; } = null!;

    public string? TenNv { get; set; }

    public string? GioiTinh { get; set; }

    public DateOnly? NgaySinh { get; set; }

    public string? QueQuan { get; set; }

    public string? Sdt { get; set; }

    public string? Tdhv { get; set; }

    public virtual ICollection<ChienDich> ChienDiches { get; set; } = new List<ChienDich>();

    public virtual ICollection<Cong> Congs { get; set; } = new List<Cong>();

    public virtual ICollection<DonDh> DonDhs { get; set; } = new List<DonDh>();

    public virtual ICollection<HinhAnhQc> HinhAnhQcs { get; set; } = new List<HinhAnhQc>();

    public virtual ICollection<HoaDon> HoaDons { get; set; } = new List<HoaDon>();

    public virtual ICollection<HopDong> HopDongs { get; set; } = new List<HopDong>();

    public virtual ICollection<MauMaSp> MauMaSps { get; set; } = new List<MauMaSp>();

    public virtual ICollection<PhieuChiCongNo> PhieuChiCongNos { get; set; } = new List<PhieuChiCongNo>();

    public virtual ICollection<PhieuChi> PhieuChis { get; set; } = new List<PhieuChi>();

    public virtual ICollection<PhieuHoan> PhieuHoans { get; set; } = new List<PhieuHoan>();

    public virtual ICollection<PhieuNghiemThu> PhieuNghiemThus { get; set; } = new List<PhieuNghiemThu>();

    public virtual ICollection<PhieuNhapNvl> PhieuNhapNvls { get; set; } = new List<PhieuNhapNvl>();

    public virtual ICollection<PhieuNhapSp> PhieuNhapSps { get; set; } = new List<PhieuNhapSp>();

    public virtual ICollection<PhieuThuCongNo> PhieuThuCongNos { get; set; } = new List<PhieuThuCongNo>();

    public virtual ICollection<PhieuThu> PhieuThus { get; set; } = new List<PhieuThu>();

    public virtual ICollection<PhieuXuatNvl> PhieuXuatNvls { get; set; } = new List<PhieuXuatNvl>();

    public virtual ICollection<PhieuXuatSp> PhieuXuatSps { get; set; } = new List<PhieuXuatSp>();

    public virtual ICollection<PhieuYcsx> PhieuYcsxes { get; set; } = new List<PhieuYcsx>();

    public virtual ICollection<Phieuktkl> Phieuktkls { get; set; } = new List<Phieuktkl>();

    public virtual ICollection<PnhangHoan> PnhangHoans { get; set; } = new List<PnhangHoan>();

    public virtual ICollection<QtcongTac> QtcongTacs { get; set; } = new List<QtcongTac>();

    public virtual ICollection<TaiKhoan> TaiKhoans { get; set; } = new List<TaiKhoan>();

    public virtual ICollection<BaoHiem> MaBaoHiems { get; set; } = new List<BaoHiem>();

    public virtual ICollection<ChinhSach> MaChinhSaches { get; set; } = new List<ChinhSach>();

    public virtual ICollection<PhuCap> MaPhuCaps { get; set; } = new List<PhuCap>();
}
