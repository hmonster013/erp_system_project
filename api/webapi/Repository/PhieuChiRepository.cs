
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PhieuChiRepository : IPhieuChiRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuChiRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}