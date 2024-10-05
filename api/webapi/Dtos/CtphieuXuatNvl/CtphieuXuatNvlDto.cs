using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.CtphieuXuatNvl
{
    public class CtphieuXuatNvlDto
    {
        public string MaPxnvl { get; set; } = null!;

        public string MaNvl { get; set; } = null!;

        public int? SoLuong { get; set; }
    }
}