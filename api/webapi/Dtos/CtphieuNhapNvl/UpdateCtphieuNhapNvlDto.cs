using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.CtphieuNhapNvl
{
    public class UpdateCtphieuNhapNvlDto
    {
        public int? Slnhap { get; set; }

        public string? Dvt { get; set; }

        public int? GiaNhap { get; set; }

        public DateOnly? Nsx { get; set; }

        public DateOnly? Hsd { get; set; }
    }
}