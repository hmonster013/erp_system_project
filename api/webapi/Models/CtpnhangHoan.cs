using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class CtpnhangHoan
{
    public string MaPnhh { get; set; } = null!;

    public string MaSp { get; set; } = null!;

    public int? SoLuongHoan { get; set; }

    public virtual PnhangHoan MaPnhhNavigation { get; set; } = null!;

    public virtual SanPham MaSpNavigation { get; set; } = null!;
}
