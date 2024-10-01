
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class CtphieuNghiemThuRepository : ICtphieuNghiemThuRepository
    {
        private readonly ApplicationDBContext _context;
        public CtphieuNghiemThuRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}