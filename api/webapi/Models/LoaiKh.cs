using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class LoaiKh
{
    public string MaLoaiKh { get; set; } = null!;

    public string? TenLoaiKh { get; set; }

    public virtual ICollection<UuDai> MaUuDais { get; set; } = new List<UuDai>();
}
