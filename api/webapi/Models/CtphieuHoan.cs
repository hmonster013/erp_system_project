using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class CtphieuHoan
{
    public string MaPh { get; set; } = null!;

    public string MaSp { get; set; } = null!;

    public int? SoLuongHoan { get; set; }

    public string? LyDoHoan { get; set; }

    public virtual PhieuHoan MaPhNavigation { get; set; } = null!;

    public virtual SanPham MaSpNavigation { get; set; } = null!;
}
