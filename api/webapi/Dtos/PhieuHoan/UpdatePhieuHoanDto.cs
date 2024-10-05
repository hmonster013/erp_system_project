using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.PhieuHoan
{
    public class UpdatePhieuHoanDto
    {
        public string? MaDdh { get; set; }

        public DateOnly? NgayHoan { get; set; }

        public string? MaNv { get; set; }
    }
}