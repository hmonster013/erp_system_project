using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class CtphieuNhapNvl
{
    public string MaPnnvl { get; set; } = null!;

    public string MaNvl { get; set; } = null!;

    public int? Slnhap { get; set; }

    public string? Dvt { get; set; }

    public int? GiaNhap { get; set; }

    public DateOnly? Nsx { get; set; }

    public DateOnly? Hsd { get; set; }

    public virtual NguyenVatLieu MaNvlNavigation { get; set; } = null!;

    public virtual PhieuNhapNvl MaPnnvlNavigation { get; set; } = null!;
}
