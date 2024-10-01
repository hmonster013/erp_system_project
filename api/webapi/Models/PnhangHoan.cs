using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PnhangHoan
{
    public string MaPnhh { get; set; } = null!;

    public string? MaDdh { get; set; }

    public DateOnly? NgayHoan { get; set; }

    public string? MaNv { get; set; }

    public virtual ICollection<CtpnhangHoan> CtpnhangHoans { get; set; } = new List<CtpnhangHoan>();

    public virtual DonDh? MaDdhNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
