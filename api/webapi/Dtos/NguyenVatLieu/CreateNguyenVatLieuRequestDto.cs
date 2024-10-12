using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.NguyenVatLieu
{
    public class CreateNguyenVatLieuRequestDto
    {
        public string MaNvl { get; set; } = null!;

        public string? TenNvl { get; set; }

        public string? GhiChu { get; set; }

        public int? SoLuongTon { get; set; }
    }
}