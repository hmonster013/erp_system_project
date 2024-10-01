using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuThu
{
    public string MaPhieuThu { get; set; } = null!;

    public string? MaDmt { get; set; }

    public string? NoiDung { get; set; }

    public int? SoTienThu { get; set; }

    public DateOnly? NgayThu { get; set; }

    public string? MaNv { get; set; }

    public virtual DanhMucThu? MaDmtNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
