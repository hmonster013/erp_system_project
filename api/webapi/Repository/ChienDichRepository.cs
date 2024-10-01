
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class ChienDichRepository : IChienDichRepository
    {
        private readonly ApplicationDBContext _context;
        public ChienDichRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}