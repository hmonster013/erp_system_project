using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.CtphieuNhapSp
{
    public class CreateCtphieuNhapSpRequestDto
    {
        public string MaPnsp { get; set; } = null!;

        public string SoLo { get; set; } = null!;
    }
}