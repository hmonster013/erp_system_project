
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class SanPhamRepository : ISanPhamRepository
    {
        private readonly ApplicationDBContext _context;
        public SanPhamRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}