
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class TaiKhoanRepository : ITaiKhoanRepository
    {
        private readonly ApplicationDBContext _context;
        public TaiKhoanRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}