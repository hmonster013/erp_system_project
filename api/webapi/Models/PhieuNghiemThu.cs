using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuNghiemThu
{
    public string MaPnt { get; set; } = null!;

    public string? MaYc { get; set; }

    public DateOnly? NgayNt { get; set; }

    public string? VanBan { get; set; }

    public string? MaNv { get; set; }

    public virtual ICollection<CtphieuNghiemThu> CtphieuNghiemThus { get; set; } = new List<CtphieuNghiemThu>();

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }

    public virtual PhieuYcsx? MaYcNavigation { get; set; }
}
