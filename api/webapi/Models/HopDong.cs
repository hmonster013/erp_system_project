using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class HopDong
{
    public string MaHopDong { get; set; } = null!;

    public string? TenHopDong { get; set; }

    public string? MaNv { get; set; }

    public DateOnly? NgayBatDau { get; set; }

    public DateOnly? NgatKetThuc { get; set; }

    public string? VanBan { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
