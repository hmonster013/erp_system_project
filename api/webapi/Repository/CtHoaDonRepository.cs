
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class CtHoaDonRepository : ICtHoaDonRepository
    {
        private readonly ApplicationDBContext _context;
        public CtHoaDonRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}