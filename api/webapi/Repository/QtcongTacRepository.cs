
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class QtcongTacRepository : IQtcongTacRepository
    {
        private readonly ApplicationDBContext _context;
        public QtcongTacRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}