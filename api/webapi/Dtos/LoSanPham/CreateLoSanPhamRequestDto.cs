using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.LoSanPham
{
    public class CreateLoSanPhamRequestDto
    {
        public string SoLo { get; set; } = null!;

        public string? MaYc { get; set; }

        public string? MaSp { get; set; }

        public int? SoLuongSp { get; set; }

        public DateOnly? Nsx { get; set; }

        public DateOnly? Hsd { get; set; }
    }
}