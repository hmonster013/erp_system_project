
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PhieuChiCongNoRepository : IPhieuChiCongNoRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuChiCongNoRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}