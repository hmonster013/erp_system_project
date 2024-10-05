using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.HoaDon
{
    public class UpdateHoaDonDto
    {
        public string? MaDdh { get; set; }

        public DateOnly? NgayLapHd { get; set; }

        public string? TinhTrangHd { get; set; }

        public string? MaNv { get; set; }        
    }
}