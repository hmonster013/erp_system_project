using System;
using System.Collections.Generic;

namespace webapi.Models;

public partial class UuDai
{
    public string MaUuDai { get; set; } = null!;

    public string? NoiDungUuDai { get; set; }

    public virtual ICollection<ChienDich> MaCds { get; set; } = new List<ChienDich>();

    public virtual ICollection<LoaiKh> MaLoaiKhs { get; set; } = new List<LoaiKh>();
}
