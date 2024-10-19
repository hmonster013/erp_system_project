
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.CtPhieuYcsx;
using webapi.Models;

namespace webapi.Controllers
{
    public class CtphieuYcsxRepository : ICtphieuYcsxRepository
    {
        private readonly ApplicationDBContext _context;
        public CtphieuYcsxRepository(ApplicationDBContext context)
        {
            _context = context;
        }

         public async Task<CtphieuYcsx> CreateAsync(CtphieuYcsx ctPhieuYcsxModel)
        {
            await _context.CtphieuYcsxes.AddAsync(ctPhieuYcsxModel);
            await _context.SaveChangesAsync();

            return ctPhieuYcsxModel;
        }

        public async Task<CtphieuYcsx> DeleteAsync(string MaYc)
        {
            var ctPhieuYcsxModel = await _context.CtphieuYcsxes.FirstOrDefaultAsync(x => x.MaYc == MaYc);

            if (ctPhieuYcsxModel == null)
            {
                return null;
            }

            _context.CtphieuYcsxes.Remove(ctPhieuYcsxModel);
            await _context.SaveChangesAsync();

            return ctPhieuYcsxModel;
        }

        public async Task<List<CtphieuYcsx>> GetAllAsync()
        {
            return await _context.CtphieuYcsxes.ToListAsync();
        }

        public async Task<CtphieuYcsx?> GetByIdAsync(string MaYc)
        {
            return await _context.CtphieuYcsxes.FindAsync(MaYc);
        }

        public async Task<CtphieuYcsx> UpdateAsync(string MaYc, UpdateCtPhieuYcsxDto updateCtPhieuYcsxDto)
        {
            var ctPhieuYcsxModel = await _context.CtphieuYcsxes.FirstOrDefaultAsync(x => x.MaYc == MaYc);

            if (ctPhieuYcsxModel == null)
            {
                return null;
            }

            ctPhieuYcsxModel.MaSp = updateCtPhieuYcsxDto.MaSp;
            ctPhieuYcsxModel.SoLuongSx = updateCtPhieuYcsxDto.SoLuongSx;

            await _context.SaveChangesAsync();

            return ctPhieuYcsxModel;
        }

        public async Task<List<CtphieuYcsx>> GetByMaYcAsync(string MaYc)
        {
            return await _context.CtphieuYcsxes
                .Where(x => x.MaYc == MaYc)
                .ToListAsync();
        }
    }
}