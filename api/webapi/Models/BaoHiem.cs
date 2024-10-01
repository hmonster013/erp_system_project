using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class BaoHiem
{
    public string MaBaoHiem { get; set; } = null!;

    public string? TenBaoHiem { get; set; }

    public string? NoiDungBh { get; set; }

    public virtual ICollection<ThongTinNhanVien> MaNvs { get; set; } = new List<ThongTinNhanVien>();
}
