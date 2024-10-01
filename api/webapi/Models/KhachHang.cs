using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class KhachHang
{
    public string MaKh { get; set; } = null!;

    public string? TenKh { get; set; }

    public string? Email { get; set; }

    public string? Sdt { get; set; }

    public string? DiaChi { get; set; }

    public virtual ICollection<DonDh> DonDhs { get; set; } = new List<DonDh>();

    public virtual ICollection<PhieuThuCongNo> PhieuThuCongNos { get; set; } = new List<PhieuThuCongNo>();
}
