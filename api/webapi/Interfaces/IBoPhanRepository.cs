
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.BoPhan;
using webapi.Models;

namespace webapi.Controllers
{
    public interface IBoPhanRepository
    {
         Task<string?> GetMaBoPhanByMaNv(string maNv);
    }
}