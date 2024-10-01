
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class CtpnhangHoanRepository : ICtpnhangHoanRepository
    {
        private readonly ApplicationDBContext _context;
        public CtpnhangHoanRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}