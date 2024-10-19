using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.PhieuNghiemThu
{
    public class PhieuNghiemThuDto
    {
        public string MaPnt { get; set; } = null!;

        public string? MaYc { get; set; }

        public DateOnly? NgayNt { get; set; }

        public string? VanBan { get; set; }

        public string? MaNv { get; set; }
    }
}