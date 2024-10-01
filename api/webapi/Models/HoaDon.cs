using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class HoaDon
{
    public string MaHd { get; set; } = null!;

    public string? MaDdh { get; set; }

    public DateOnly? NgayLapHd { get; set; }

    public string? TinhTrangHd { get; set; }

    public string? MaNv { get; set; }

    public virtual ICollection<CtHoaDon> CtHoaDons { get; set; } = new List<CtHoaDon>();

    public virtual DonDh? MaDdhNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
