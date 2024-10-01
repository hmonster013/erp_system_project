
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class DonDhRepository : IDonDhRepository
    {
        private readonly ApplicationDBContext _context;
        public DonDhRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}