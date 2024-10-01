using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuChi
{
    public string MaPhieuChi { get; set; } = null!;

    public string? MaDmc { get; set; }

    public string? NoiDung { get; set; }

    public int? SoTienChi { get; set; }

    public DateOnly? NgayChi { get; set; }

    public string? MaNv { get; set; }

    public virtual DanhMucChi? MaDmcNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
