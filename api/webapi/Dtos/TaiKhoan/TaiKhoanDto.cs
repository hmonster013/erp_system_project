using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace webapi.Dtos.TaiKhoan
{
    public class TaiKhoanDto
    {
        public string Username { get; set; } = null!;

        public string? Password { get; set; }

        public string? MaNv { get; set; }

    }
}