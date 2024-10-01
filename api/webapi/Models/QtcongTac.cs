using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class QtcongTac
{
    public string MaQt { get; set; } = null!;

    public string? MaNv { get; set; }

    public string? MaCv { get; set; }

    public DateOnly? ThoiGianBd { get; set; }

    public DateOnly? ThoiGianKt { get; set; }

    public string? MaBp { get; set; }

    public virtual BoPhan? MaBpNavigation { get; set; }

    public virtual ChucVu? MaCvNavigation { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
