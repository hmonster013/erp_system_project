using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class SanPham
{
    public string MaSp { get; set; } = null!;

    public string? MaLoai { get; set; }

    public string? TenSp { get; set; }

    public int? GiaBan { get; set; }

    public string? ThanhPhan { get; set; }

    public string? Klt { get; set; }

    public int? SoLuongTon { get; set; }

    public virtual ICollection<CtHoaDon> CtHoaDons { get; set; } = new List<CtHoaDon>();

    public virtual ICollection<CtdonDh> CtdonDhs { get; set; } = new List<CtdonDh>();

    public virtual ICollection<CtphieuHoan> CtphieuHoans { get; set; } = new List<CtphieuHoan>();

    public virtual ICollection<CtphieuXuatSp> CtphieuXuatSps { get; set; } = new List<CtphieuXuatSp>();

    public virtual ICollection<CtphieuYcsx> CtphieuYcsxes { get; set; } = new List<CtphieuYcsx>();

    public virtual ICollection<CtpnhangHoan> CtpnhangHoans { get; set; } = new List<CtpnhangHoan>();

    public virtual ICollection<LoSanPham> LoSanPhams { get; set; } = new List<LoSanPham>();

    public virtual LoaiSp? MaLoaiNavigation { get; set; }

    public virtual ICollection<MauMaSp> MauMaSps { get; set; } = new List<MauMaSp>();
}
