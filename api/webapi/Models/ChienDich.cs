using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class ChienDich
{
    public string MaCd { get; set; } = null!;

    public string? TenCd { get; set; }

    public int? NgayBatDau { get; set; }

    public string? NgayKetThuc { get; set; }

    public string? MaNv { get; set; }

    public virtual ICollection<HinhAnhQc> HinhAnhQcs { get; set; } = new List<HinhAnhQc>();

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }

    public virtual ICollection<UuDai> MaUuDais { get; set; } = new List<UuDai>();
}
