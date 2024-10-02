using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.CtphieuXuatSp
{
    public class CtphieuXuatSpDto
    {
        public string MaPxsp { get; set; } = null!;

        public string MaSp { get; set; } = null!;

        public int? SoLuong { get; set; }
    }
}