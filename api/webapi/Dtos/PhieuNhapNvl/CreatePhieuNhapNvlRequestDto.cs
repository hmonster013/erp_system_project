using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.PhieuNhapNvl
{
    public class CreatePhieuNhapNvlRequestDto
    {
        public string MaPnnvl { get; set; } = null!;

        public string? MaYc { get; set; }

        public string? MaNcc { get; set; }

        public DateOnly? NgayNhap { get; set; }

        public string? MaNv { get; set; }

        public bool? PhanLoai { get; set; }
    }
}