
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class HopDongRepository : IHopDongRepository
    {
        private readonly ApplicationDBContext _context;
        public HopDongRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}