using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.CtphieuHoan;
using webapi.Models;

namespace webapi.Controllers
{
    public class CtphieuHoanRepository : ICtphieuHoanRepository
    {
        private readonly ApplicationDBContext _context;

        public CtphieuHoanRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<CtphieuHoan> CreateAsync(CtphieuHoan ctphieuHoanModel)
        {
            await _context.CtphieuHoans.AddAsync(ctphieuHoanModel);
            await _context.SaveChangesAsync();

            return ctphieuHoanModel;
        }

        public async Task<CtphieuHoan> DeleteAsync(string maPh, string maSp)
        {
            var ctphieuHoanModel = await _context.CtphieuHoans.FirstOrDefaultAsync(x => x.MaPh == maPh && x.MaSp == maSp);

            if (ctphieuHoanModel == null)
            {
                return null;
            }

            _context.CtphieuHoans.Remove(ctphieuHoanModel);
            await _context.SaveChangesAsync();

            return ctphieuHoanModel;
        }

        public async Task<List<CtphieuHoan>> GetAllAsync()
        {
            return await _context.CtphieuHoans.ToListAsync();
        }

        public async Task<CtphieuHoan?> GetByIdAsync(string maPh, string maSp)
        {
            return await _context.CtphieuHoans.FirstOrDefaultAsync(x => x.MaPh == maPh && x.MaSp == maSp);
        }

        public async Task<CtphieuHoan> UpdateAsync(string maPh, string maSp, UpdateCtphieuHoanDto updateCtphieuHoanDto)
        {
            var ctphieuHoanModel = await _context.CtphieuHoans.FirstOrDefaultAsync(x => x.MaPh == maPh && x.MaSp == maSp);

            if (ctphieuHoanModel == null)
            {
                return null;
            }

            ctphieuHoanModel.SoLuongHoan = updateCtphieuHoanDto.SoLuongHoan;
            ctphieuHoanModel.LyDoHoan = updateCtphieuHoanDto.LyDoHoan;

            await _context.SaveChangesAsync();

            return ctphieuHoanModel;
        }
    }
}
