
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class LoaiSpRepository : ILoaiSpRepository
    {
        private readonly ApplicationDBContext _context;
        public LoaiSpRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}