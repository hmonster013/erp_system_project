using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.SanPham
{
    public class CreateSanPhamRequestDto
    {
        public string MaSp { get; set; } = null!;

        public string? MaLoai { get; set; }

        public string? TenSp { get; set; }

        public int? GiaBan { get; set; }

        public string? ThanhPhan { get; set; }

        public string? Klt { get; set; }

        public int? SoLuongTon { get; set; }        
    }
}