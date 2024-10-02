using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.PhieuXuatNvl
{
    public class UpdatePhieuXuatNvlDto
    {
        public DateOnly? NgayXuat { get; set; }

        public string? MaNv { get; set; }
    }
}