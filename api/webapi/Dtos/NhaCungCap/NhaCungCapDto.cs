using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.NhaCungCap
{
    public class NhaCungCapDto
    {
        public string MaNcc { get; set; } = null!;

        public string? TenNcc { get; set; }

        public string? Email { get; set; }

        public string? Sdt { get; set; }

        public string? DiaChi { get; set; }
    }
}