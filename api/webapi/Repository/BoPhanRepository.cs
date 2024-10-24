
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Data;
using Microsoft.EntityFrameworkCore;
using webapi.Dtos.BoPhan;
using webapi.Models;

namespace webapi.Controllers
{
    public class BoPhanRepository : IBoPhanRepository
    {
        private readonly ApplicationDBContext _context;
        public BoPhanRepository(ApplicationDBContext context)
        {
            _context = context;
        }

    public async Task<string?> GetMaBoPhanByMaNv(string maNv)
    {
        var maBoPhan = await (from tk in _context.TaiKhoans
                              join nv in _context.ThongTinNhanViens on tk.MaNv equals nv.MaNv
                              join qtct in _context.QtcongTacs on nv.MaNv equals qtct.MaNv
                              join bp in _context.BoPhans on qtct.MaBp equals bp.MaBp
                              where tk.MaNv == maNv
                              select bp.MaBp).FirstOrDefaultAsync();

        return maBoPhan;
    }
    }
}