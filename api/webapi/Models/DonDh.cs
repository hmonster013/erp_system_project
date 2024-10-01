using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class DonDh
{
    public string MaDdh { get; set; } = null!;

    public string? MaKh { get; set; }

    public DateOnly? NgayLap { get; set; }

    public DateOnly? NgayGiao { get; set; }

    public string? TinhTrang { get; set; }

    public string? MaNv { get; set; }

    public virtual ICollection<CtdonDh> CtdonDhs { get; set; } = new List<CtdonDh>();

    public virtual ICollection<HoaDon> HoaDons { get; set; } = new List<HoaDon>();

    public virtual KhachHang? MaKhNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }

    public virtual ICollection<PhieuHoan> PhieuHoans { get; set; } = new List<PhieuHoan>();

    public virtual ICollection<PhieuXuatSp> PhieuXuatSps { get; set; } = new List<PhieuXuatSp>();

    public virtual ICollection<PnhangHoan> PnhangHoans { get; set; } = new List<PnhangHoan>();
}
