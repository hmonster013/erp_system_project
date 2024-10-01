
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PhieuXuatNvlRepository : IPhieuXuatNvlRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuXuatNvlRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}