using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuXuatNvl
{
    public string MaPxnvl { get; set; } = null!;

    public DateOnly? NgayXuat { get; set; }

    public string? MaNv { get; set; }

    public virtual ICollection<CtphieuXuatNvl> CtphieuXuatNvls { get; set; } = new List<CtphieuXuatNvl>();

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
