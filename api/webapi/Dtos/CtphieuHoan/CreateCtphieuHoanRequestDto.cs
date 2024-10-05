using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.CtphieuHoan
{
    public class CreateCtphieuHoanRequestDto
    {
        public string MaPh { get; set; } = null!;

        public string MaSp { get; set; } = null!;

        public int? SoLuongHoan { get; set; }

        public string? LyDoHoan { get; set; }
    }
}