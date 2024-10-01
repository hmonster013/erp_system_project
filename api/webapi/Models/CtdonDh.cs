using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class CtdonDh
{
    public string MaDdh { get; set; } = null!;

    public string MaSp { get; set; } = null!;

    public int? SoLuong { get; set; }

    public virtual DonDh MaDdhNavigation { get; set; } = null!;

    public virtual SanPham MaSpNavigation { get; set; } = null!;
}
