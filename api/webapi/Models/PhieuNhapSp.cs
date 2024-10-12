using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuNhapSp
{
    public string MaPnsp { get; set; } = null!;

    public DateOnly? NgayNhap { get; set; }

    public string? MaNv { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }

    public virtual ICollection<LoSanPham> SoLos { get; set; } = new List<LoSanPham>();

    public virtual ICollection<CtphieuNhapSp> CtphieuNhapSps { get; set; }
}
