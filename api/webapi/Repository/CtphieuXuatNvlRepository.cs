
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class CtphieuXuatNvlRepository : ICtphieuXuatNvlRepository
    {
        private readonly ApplicationDBContext _context;
        public CtphieuXuatNvlRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}