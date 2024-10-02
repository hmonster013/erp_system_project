using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.PhieuXuatNvl
{
    public class PhieuXuatNvlDto
    {
        public string MaPxnvl { get; set; } = null!;

        public DateOnly? NgayXuat { get; set; }

        public string? MaNv { get; set; }
    }
}