
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class KhachHangRepository : IKhachHangRepository
    {
        private readonly ApplicationDBContext _context;
        public KhachHangRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}