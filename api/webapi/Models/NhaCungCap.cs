using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class NhaCungCap
{
    public string MaNcc { get; set; } = null!;

    public string? TenNcc { get; set; }

    public string? Email { get; set; }

    public string? Sdt { get; set; }

    public string? DiaChi { get; set; }

    public virtual ICollection<PhieuChiCongNo> PhieuChiCongNos { get; set; } = new List<PhieuChiCongNo>();

    public virtual ICollection<PhieuNhapNvl> PhieuNhapNvls { get; set; } = new List<PhieuNhapNvl>();
}
