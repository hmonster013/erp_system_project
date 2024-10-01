using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class BoPhan
{
    public string MaBp { get; set; } = null!;

    public string? TenBp { get; set; }

    public string? Sdt { get; set; }

    public virtual ICollection<QtcongTac> QtcongTacs { get; set; } = new List<QtcongTac>();
}
