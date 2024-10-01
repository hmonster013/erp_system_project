using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class Cong
{
    public string MaNv { get; set; } = null!;

    public string? MaBl { get; set; }

    public string ThangNam { get; set; } = null!;

    public double? SoNgayCong { get; set; }

    public double? SoNgayNghi { get; set; }

    public double? SoGioLamThem { get; set; }

    public virtual BacLuong? MaBlNavigation { get; set; }

    public virtual ThongTinNhanVien MaNvNavigation { get; set; } = null!;
}
