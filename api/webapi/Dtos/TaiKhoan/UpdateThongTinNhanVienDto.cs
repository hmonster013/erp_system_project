using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.TaiKhoan
{
    public class UpdateThongTinNhanVienDto
    {
        public string? TenNv { get; set; }

        public string? GioiTinh { get; set; }

        public DateOnly? NgaySinh { get; set; }

        public string? QueQuan { get; set; }

        public string? Sdt { get; set; }

        public string? Tdhv { get; set; }
    }
}