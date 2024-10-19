using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.CtPhieuYcsx
{
    public class UpdateCtPhieuYcsxDto
    {
        public string MaYc { get; set; } = null!;

        public string MaSp { get; set; } = null!;

        public int? SoLuongSx { get; set; }
    }
}