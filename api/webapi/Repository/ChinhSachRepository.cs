
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class ChinhSachRepository : IChinhSachRepository
    {
        private readonly ApplicationDBContext _context;
        public ChinhSachRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}