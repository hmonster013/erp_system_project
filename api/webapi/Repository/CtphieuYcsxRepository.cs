
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class CtphieuYcsxRepository : ICtphieuYcsxRepository
    {
        private readonly ApplicationDBContext _context;
        public CtphieuYcsxRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}