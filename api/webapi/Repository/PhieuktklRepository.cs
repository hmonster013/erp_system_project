
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class PhieuktklRepository : IPhieuktklRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuktklRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}