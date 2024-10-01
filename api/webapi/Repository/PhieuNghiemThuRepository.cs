
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PhieuNghiemThuRepository : IPhieuNghiemThuRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuNghiemThuRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}