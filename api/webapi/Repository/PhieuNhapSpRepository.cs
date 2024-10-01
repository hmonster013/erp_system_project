
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PhieuNhapSpRepository : IPhieuNhapSpRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuNhapSpRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}