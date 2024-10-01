using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class DanhMucChi
{
    public string MaDmt { get; set; } = null!;

    public string? TenDmt { get; set; }

    public virtual ICollection<PhieuChi> PhieuChis { get; set; } = new List<PhieuChi>();
}
