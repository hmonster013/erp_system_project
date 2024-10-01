
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class LoaiKhRepository : ILoaiKhRepository
    {
        private readonly ApplicationDBContext _context;
        public LoaiKhRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}