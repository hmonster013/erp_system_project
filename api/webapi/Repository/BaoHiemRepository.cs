
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class BaoHiemRepository : IBaoHiemRepository
    {
        private readonly ApplicationDBContext _context;
        public BaoHiemRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}