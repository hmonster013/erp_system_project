
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PhuCapRepository : IPhuCapRepository
    {
        private readonly ApplicationDBContext _context;
        public PhuCapRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}