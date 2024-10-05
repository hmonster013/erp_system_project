using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.KhachHang
{
    public class UpdateKhachHangDto
    {
        public string? TenKh { get; set; }

        public string? Email { get; set; }

        public string? Sdt { get; set; }

        public string? DiaChi { get; set; }

        public string? MaLoaiKh { get; set; }
    }
}