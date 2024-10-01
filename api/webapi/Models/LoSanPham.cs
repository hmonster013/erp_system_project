using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class LoSanPham
{
    public string SoLo { get; set; } = null!;

    public string? MaYc { get; set; }

    public string? MaSp { get; set; }

    public int? SoLuongSp { get; set; }

    public DateOnly? Nsx { get; set; }

    public DateOnly? Hsd { get; set; }

    public virtual ICollection<CtphieuNghiemThu> CtphieuNghiemThus { get; set; } = new List<CtphieuNghiemThu>();

    public virtual SanPham? MaSpNavigation { get; set; }

    public virtual PhieuYcsx? MaYcNavigation { get; set; }

    public virtual ICollection<PhieuNhapSp> MaPnsps { get; set; } = new List<PhieuNhapSp>();
}
