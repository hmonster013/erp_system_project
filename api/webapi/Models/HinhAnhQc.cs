using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class HinhAnhQc
{
    public string MaAnhQc { get; set; } = null!;

    public string? MaCd { get; set; }

    public string? MoTa { get; set; }

    public string? HinhAnhQc1 { get; set; }

    public string? MaNv { get; set; }

    public virtual ChienDich? MaCdNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
