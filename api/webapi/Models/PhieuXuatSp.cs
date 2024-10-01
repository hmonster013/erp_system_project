using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuXuatSp
{
    public string MaPxsp { get; set; } = null!;

    public string? MaDdh { get; set; }

    public DateOnly? NgayXuat { get; set; }

    public string? MaNv { get; set; }

    public virtual ICollection<CtphieuXuatSp> CtphieuXuatSps { get; set; } = new List<CtphieuXuatSp>();

    public virtual DonDh? MaDdhNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
