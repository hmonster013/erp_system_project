
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class DanhMucChiRepository : IDanhMucChiRepository
    {
        private readonly ApplicationDBContext _context;
        public DanhMucChiRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}