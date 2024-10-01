
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class CtphieuHoanRepository : ICtphieuHoanRepository
    {
        private readonly ApplicationDBContext _context;
        public CtphieuHoanRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}