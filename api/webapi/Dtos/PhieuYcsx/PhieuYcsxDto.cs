using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.PhieuYcsx
{
    public class PhieuYcsxDto
    {
        public string MaYc { get; set; } = null!;

        public DateOnly? NgayBd { get; set; }

        public DateOnly? NgayKt { get; set; }

        public string? VanBan { get; set; }

        public string? MaNv { get; set; }
    }
}