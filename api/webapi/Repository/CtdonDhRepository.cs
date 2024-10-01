
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class CtdonDhRepository : ICtdonDhRepository
    {
        private readonly ApplicationDBContext _context;
        public CtdonDhRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}