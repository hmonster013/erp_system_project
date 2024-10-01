using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class CtphieuXuatSp
{
    public string MaPxsp { get; set; } = null!;

    public string MaSp { get; set; } = null!;

    public int? SoLuong { get; set; }

    public virtual PhieuXuatSp MaPxspNavigation { get; set; } = null!;

    public virtual SanPham MaSpNavigation { get; set; } = null!;
}
