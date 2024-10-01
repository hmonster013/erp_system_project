using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class TaiKhoan
{
    public string Username { get; set; } = null!;

    public string? Password { get; set; }

    public string? MaNv { get; set; }

    public virtual ThongTinNhanVien? MaNvNavigation { get; set; }
}
