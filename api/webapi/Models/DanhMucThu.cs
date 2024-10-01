using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class DanhMucThu
{
    public string MaDmt { get; set; } = null!;

    public string? TenDmt { get; set; }

    public virtual ICollection<PhieuThu> PhieuThus { get; set; } = new List<PhieuThu>();
}
