using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.BoPhan
{
    public class CreateBoPhanRequestDto
    {
        public string MaBp { get; set; } = null!;

        public string? TenBp { get; set; }

        public string? Sdt { get; set; }
    }
}