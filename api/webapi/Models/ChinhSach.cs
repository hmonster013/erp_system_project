using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class ChinhSach
{
    public string MaChinhSach { get; set; } = null!;

    public string? TenChinhSach { get; set; }

    public string? NoiDungCs { get; set; }

    public virtual ICollection<ThongTinNhanVien> MaNvs { get; set; } = new List<ThongTinNhanVien>();
}
