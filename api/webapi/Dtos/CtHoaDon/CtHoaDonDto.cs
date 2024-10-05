using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.CtHoaDon
{
    public class CtHoaDonDto
    {
        public string MaHd { get; set; } = null!;

        public string MaSp { get; set; } = null!;

        public int? SoLuong { get; set; }

        public int? DonGia { get; set; }
    }
}