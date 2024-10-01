
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class LoSanPhamRepository : ILoSanPhamRepository
    {
        private readonly ApplicationDBContext _context;
        public LoSanPhamRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}