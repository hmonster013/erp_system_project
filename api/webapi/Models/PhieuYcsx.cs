using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class PhieuYcsx
{
    public string MaYc { get; set; } = null!;

    public DateOnly? NgayBd { get; set; }

    public DateOnly? NgayKt { get; set; }

    public string? VanBan { get; set; }

    public string? MaNv { get; set; }

    public virtual ICollection<CtphieuYcsx> CtphieuYcsxes { get; set; } = new List<CtphieuYcsx>();

    public virtual ICollection<LoSanPham> LoSanPhams { get; set; } = new List<LoSanPham>();

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }

    public virtual ICollection<PhieuNghiemThu> PhieuNghiemThus { get; set; } = new List<PhieuNghiemThu>();

    public virtual ICollection<PhieuNhapNvl> PhieuNhapNvls { get; set; } = new List<PhieuNhapNvl>();
}
