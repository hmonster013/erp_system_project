
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class HinhAnhQcRepository : IHinhAnhQcRepository
    {
        private readonly ApplicationDBContext _context;
        public HinhAnhQcRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}