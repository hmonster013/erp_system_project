
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class UuDaiRepository : IUuDaiRepository
    {
        private readonly ApplicationDBContext _context;
        public UuDaiRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}