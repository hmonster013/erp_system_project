
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class HoaDonRepository : IHoaDonRepository
    {
        private readonly ApplicationDBContext _context;
        public HoaDonRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}