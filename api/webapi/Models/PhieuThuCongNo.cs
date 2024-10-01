using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuThuCongNo
{
    public string MaPtcn { get; set; } = null!;

    public string? MaKh { get; set; }

    public string? NoiDung { get; set; }

    public int? SoTienThu { get; set; }

    public DateOnly? NgayThu { get; set; }

    public string? MaNv { get; set; }

    public virtual KhachHang? MaKhNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
