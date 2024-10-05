using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.DonDh
{
    public class CreateDonDhRequestDto
    {
        public string MaDdh { get; set; } = null!;

        public string? MaKh { get; set; }

        public DateOnly? NgayLap { get; set; }

        public DateOnly? NgayGiao { get; set; }

        public string? TinhTrang { get; set; }

        public string? MaNv { get; set; }
    }
}