
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PnhangHoanRepository : IPnhangHoanRepository
    {
        private readonly ApplicationDBContext _context;
        public PnhangHoanRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}