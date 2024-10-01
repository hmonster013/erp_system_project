
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PhieuYcsxRepository : IPhieuYcsxRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuYcsxRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}