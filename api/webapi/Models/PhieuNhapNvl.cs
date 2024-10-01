using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuNhapNvl
{
    public string MaPnnvl { get; set; } = null!;

    public string? MaYc { get; set; }

    public string? MaNcc { get; set; }

    public DateOnly? NgayNhap { get; set; }

    public string? MaNv { get; set; }

    public bool? PhanLoai { get; set; }

    public virtual ICollection<CtphieuNhapNvl> CtphieuNhapNvls { get; set; } = new List<CtphieuNhapNvl>();

    public virtual NhaCungCap? MaNccNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }

    public virtual PhieuYcsx? MaYcNavigation { get; set; }
}
