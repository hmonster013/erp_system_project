using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.CtphieuNhapSp; // Thêm không gian tên cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    public class CtphieuNhapSpRepository : ICtphieuNhapSpRepository
    {
        private readonly ApplicationDBContext _context;

        public CtphieuNhapSpRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<CtphieuNhapSp> CreateAsync(CtphieuNhapSp ctphieuNhapSpModel)
        {
            await _context.CtphieuNhapSps.AddAsync(ctphieuNhapSpModel);
            await _context.SaveChangesAsync();

            return ctphieuNhapSpModel;
        }

        public async Task<CtphieuNhapSp?> GetByIdAsync(string MaPnsp, string SoLo)
        {
            return await _context.CtphieuNhapSps.FirstOrDefaultAsync(x => x.MaPnsp == MaPnsp && x.SoLo == SoLo);
        }

    }
}
