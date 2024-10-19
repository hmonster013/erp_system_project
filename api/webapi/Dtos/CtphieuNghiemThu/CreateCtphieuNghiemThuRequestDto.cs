using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.CtphieuNghiemThu
{
    public class CreateCtphieuNghiemThuRequestDto
    {
        public string MaPnt { get; set; } = null!;

        public string SoLo { get; set; } = null!;

        public string? KetQuaNt { get; set; }
    }
}