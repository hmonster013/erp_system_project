using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class CtphieuNghiemThu
{
    public string MaPnt { get; set; } = null!;

    public string SoLo { get; set; } = null!;

    public string? KetQuaNt { get; set; }

    public virtual PhieuNghiemThu MaPntNavigation { get; set; } = null!;

    public virtual LoSanPham SoLoNavigation { get; set; } = null!;
}
