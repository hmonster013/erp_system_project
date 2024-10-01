using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuHoan
{
    public string MaPh { get; set; } = null!;

    public string? MaDdh { get; set; }

    public DateOnly? NgayHoan { get; set; }

    public string? MaNv { get; set; }

    public virtual ICollection<CtphieuHoan> CtphieuHoans { get; set; } = new List<CtphieuHoan>();

    public virtual DonDh? MaDdhNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
