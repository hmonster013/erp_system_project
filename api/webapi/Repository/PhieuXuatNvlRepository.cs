using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Models;
using webapi.Dtos.PhieuXuatNvl;

namespace webapi.Controllers
{
    public class PhieuXuatNvlRepository : IPhieuXuatNvlRepository
    {
        private readonly ApplicationDBContext _context;

        public PhieuXuatNvlRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<PhieuXuatNvl> CreateAsync(PhieuXuatNvl phieuXuatNvlModel)
        {
            await _context.PhieuXuatNvls.AddAsync(phieuXuatNvlModel);
            await _context.SaveChangesAsync();

            return phieuXuatNvlModel;
        }

        public async Task<PhieuXuatNvl> DeleteAsync(string MaPxnvl)
        {
            var phieuXuatNvlModel = await _context.PhieuXuatNvls.FirstOrDefaultAsync(x => x.MaPxnvl == MaPxnvl);

            if (phieuXuatNvlModel == null)
            {
                return null;
            }

            _context.PhieuXuatNvls.Remove(phieuXuatNvlModel);
            await _context.SaveChangesAsync();

            return phieuXuatNvlModel;
        }

        public async Task<List<PhieuXuatNvl>> GetAllAsync()
        {
            return await _context.PhieuXuatNvls.ToListAsync();
        }

        public async Task<PhieuXuatNvl?> GetByIdAsync(string MaPxnvl)
        {
            return await _context.PhieuXuatNvls.FindAsync(MaPxnvl);
        }

        public async Task<PhieuXuatNvl> UpdateAsync(string MaPxnvl, UpdatePhieuXuatNvlDto updatePhieuXuatNvlDto)
        {
            var phieuXuatNvlModel = await _context.PhieuXuatNvls.FirstOrDefaultAsync(x => x.MaPxnvl == MaPxnvl);

            if (phieuXuatNvlModel == null)
            {
                return null;
            }

            phieuXuatNvlModel.NgayXuat = updatePhieuXuatNvlDto.NgayXuat;
            phieuXuatNvlModel.MaNv = updatePhieuXuatNvlDto.MaNv;

            await _context.SaveChangesAsync();

            return phieuXuatNvlModel;
        }
    }
}
