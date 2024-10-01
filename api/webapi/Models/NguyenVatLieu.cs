using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class NguyenVatLieu
{
    public string MaNvl { get; set; } = null!;

    public string? TenNvl { get; set; }

    public string? GhiChu { get; set; }

    public int? SoLuongTon { get; set; }

    public virtual ICollection<CtphieuNhapNvl> CtphieuNhapNvls { get; set; } = new List<CtphieuNhapNvl>();

    public virtual ICollection<CtphieuXuatNvl> CtphieuXuatNvls { get; set; } = new List<CtphieuXuatNvl>();
}
