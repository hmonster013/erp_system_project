using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.CtdonDh
{
    public class CreateCtdonDhRequestDto
    {
        public string MaDdh { get; set; } = null!;

        public string MaSp { get; set; } = null!;

        public int? SoLuong { get; set; }
    }
}