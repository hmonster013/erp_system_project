using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class MauMaSp
{
    public string MaAnhSp { get; set; } = null!;

    public string? MaSp { get; set; }

    public string? MoTa { get; set; }

    public string? HinhAnhSp { get; set; }

    public string? MaNv { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }

    public virtual SanPham? MaSpNavigation { get; set; }
}
