using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class CtphieuYcsx
{
    public string MaYc { get; set; } = null!;

    public string MaSp { get; set; } = null!;

    public int? SoLuongSx { get; set; }

    public virtual SanPham MaSpNavigation { get; set; } = null!;

    public virtual PhieuYcsx MaYcNavigation { get; set; } = null!;
}
