
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class DanhMucThuRepository : IDanhMucThuRepository
    {
        private readonly ApplicationDBContext _context;
        public DanhMucThuRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}