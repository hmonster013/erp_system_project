using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class ChucVu
{
    public string MaCv { get; set; } = null!;

    public string? TenCv { get; set; }

    public string? MaBl { get; set; }

    public virtual BacLuong? MaBlNavigation { get; set; }

    public virtual ICollection<QtcongTac> QtcongTacs { get; set; } = new List<QtcongTac>();
}
