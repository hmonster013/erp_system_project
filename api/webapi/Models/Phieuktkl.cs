using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class Phieuktkl
{
    public string MaPhieuKtkl { get; set; } = null!;

    public string? NoiDung { get; set; }

    public int? SoTienKtkl { get; set; }

    public string? MaNv { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
