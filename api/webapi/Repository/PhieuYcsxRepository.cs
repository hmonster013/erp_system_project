
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.PhieuYcsx;
using webapi.Models;

namespace webapi.Controllers
{
    public class PhieuYcsxRepository : IPhieuYcsxRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuYcsxRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<PhieuYcsx> CreateAsync(PhieuYcsx phieuYcsxModel)
        {
            await _context.PhieuYcsxes.AddAsync(phieuYcsxModel);
            await _context.SaveChangesAsync();

            return phieuYcsxModel;
        }

        public async Task<PhieuYcsx> DeleteAsync(string MaYc)
        {
            var phieuYcsxModel = await _context.PhieuYcsxes.FirstOrDefaultAsync(x => x.MaYc == MaYc);

            if (phieuYcsxModel == null)
            {
                return null;
            }

            _context.PhieuYcsxes.Remove(phieuYcsxModel);
            await _context.SaveChangesAsync();

            return phieuYcsxModel;
        }

        public async Task<List<PhieuYcsx>> GetAllAsync()
        {
            return await _context.PhieuYcsxes.ToListAsync();
        }

        public async Task<PhieuYcsx?> GetByIdAsync(string MaYc)
        {
            return await _context.PhieuYcsxes.FindAsync(MaYc);
        }

        public async Task<PhieuYcsx> UpdateAsync(string MaYc, UpdatePhieuYcsxDto updatePhieuYcsxDto)
        {
            var phieuYcsxModel = await _context.PhieuYcsxes.FirstOrDefaultAsync(x => x.MaYc == MaYc);

            if (phieuYcsxModel == null)
            {
                return null;
            }

            phieuYcsxModel.NgayBd = updatePhieuYcsxDto.NgayBd;
            phieuYcsxModel.NgayKt = updatePhieuYcsxDto.NgayKt;
            phieuYcsxModel.VanBan = updatePhieuYcsxDto.VanBan;

            await _context.SaveChangesAsync();

            return phieuYcsxModel;
        }
    }
}