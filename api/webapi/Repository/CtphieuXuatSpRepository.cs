
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class CtphieuXuatSpRepository : ICtphieuXuatSpRepository
    {
        private readonly ApplicationDBContext _context;
        public CtphieuXuatSpRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}