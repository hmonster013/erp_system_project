
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class NhaCungCapRepository : INhaCungCapRepository
    {
        private readonly ApplicationDBContext _context;
        public NhaCungCapRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}