using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.LoaiSp
{
    public class LoaiSpDto
    {
        public string MaLoai { get; set; } = null!;

        public string? TenLoai { get; set; }        
    }
}