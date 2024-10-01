
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PhieuNhapNvlRepository : IPhieuNhapNvlRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuNhapNvlRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}