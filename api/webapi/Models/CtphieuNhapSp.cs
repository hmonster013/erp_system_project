using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class CtphieuNhapSp
{
    public string MaPnsp { get; set; } = null!;

    public string SoLo { get; set; } = null!;

    public virtual LoSanPham SoLoNavigation { get; set; }

    public virtual PhieuNhapSp MaPnspNavigation { get; set; }
}
