using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.PhieuXuatSp
{
    public class PhieuXuatSpDto
    {
        public string MaPxsp { get; set; } = null!;

        public string? MaDdh { get; set; }

        public DateOnly? NgayXuat { get; set; }

        public string? MaNv { get; set; }

    }
}