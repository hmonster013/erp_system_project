
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;

namespace webapi.Controllers
{
    public class MauMaSpRepository : IMauMaSpRepository
    {
        private readonly ApplicationDBContext _context;
        public MauMaSpRepository(ApplicationDBContext context)
        {
            _context = context;
        }
    }
}