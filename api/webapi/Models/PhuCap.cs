using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhuCap
{
    public string MaPhuCap { get; set; } = null!;

    public string? TenPhuCap { get; set; }

    public string? NoiDungPc { get; set; }

    public virtual ICollection<ThongTinNhanVien> MaNvs { get; set; } = new List<ThongTinNhanVien>();
}
