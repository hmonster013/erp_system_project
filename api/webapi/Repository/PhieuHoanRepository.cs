
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PhieuHoanRepository : IPhieuHoanRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuHoanRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}