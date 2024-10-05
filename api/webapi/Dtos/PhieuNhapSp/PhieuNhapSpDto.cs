using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.PhieuNhapSp
{
    public class PhieuNhapSpDto
    {
        public string MaPnsp { get; set; } = null!;

        public DateOnly? NgayNhap { get; set; }

        public string? MaNv { get; set; }
    }
}