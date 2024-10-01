using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class BacLuong
{
    public string MaBl { get; set; } = null!;

    public int? LuongCb { get; set; }

    public int? Hsluong { get; set; }

    public int? HsphuCap { get; set; }

    public virtual ICollection<ChucVu> ChucVus { get; set; } = new List<ChucVu>();

    public virtual ICollection<Cong> Congs { get; set; } = new List<Cong>();
}
