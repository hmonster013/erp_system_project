using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuChiCongNo
{
    public string MaPccn { get; set; } = null!;

    public string? MaNcc { get; set; }

    public string? NoiDung { get; set; }

    public int? SoTienChi { get; set; }

    public DateOnly? NgayChi { get; set; }

    public string? MaNv { get; set; }

    public virtual NhaCungCap? MaNccNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
