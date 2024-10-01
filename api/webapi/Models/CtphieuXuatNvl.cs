using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class CtphieuXuatNvl
{
    public string MaPxnvl { get; set; } = null!;

    public string MaNvl { get; set; } = null!;

    public int? SoLuong { get; set; }

    public virtual NguyenVatLieu MaNvlNavigation { get; set; } = null!;

    public virtual PhieuXuatNvl MaPxnvlNavigation { get; set; } = null!;
}
