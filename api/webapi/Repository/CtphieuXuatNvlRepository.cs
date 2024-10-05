using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.CtphieuXuatNvl;
using webapi.Models;

namespace webapi.Controllers
{
    public class CtphieuXuatNvlsRepository : ICtphieuXuatNvlRepository
    {
        private readonly ApplicationDBContext _context;

        public CtphieuXuatNvlsRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<CtphieuXuatNvl> CreateAsync(CtphieuXuatNvl ctPhieuXuatNvlModel)
        {
            await _context.CtphieuXuatNvls.AddAsync(ctPhieuXuatNvlModel);
            await _context.SaveChangesAsync();

            return ctPhieuXuatNvlModel;
        }

        public async Task<CtphieuXuatNvl> DeleteAsync(string maPxnvl, string maNvl)
        {
            var ctPhieuXuatNvlModel = await _context.CtphieuXuatNvls
                .FirstOrDefaultAsync(x => x.MaPxnvl == maPxnvl && x.MaNvl == maNvl);

            if (ctPhieuXuatNvlModel == null)
            {
                return null;
            }

            _context.CtphieuXuatNvls.Remove(ctPhieuXuatNvlModel);
            await _context.SaveChangesAsync();

            return ctPhieuXuatNvlModel;
        }

        public async Task<List<CtphieuXuatNvl>> GetAllAsync()
        {
            return await _context.CtphieuXuatNvls.ToListAsync();
        }

        public async Task<CtphieuXuatNvl?> GetByIdAsync(string maPxnvl, string maNvl)
        {
            return await _context.CtphieuXuatNvls
                .FirstOrDefaultAsync(x => x.MaPxnvl == maPxnvl && x.MaNvl == maNvl);
        }

        public async Task<CtphieuXuatNvl> UpdateAsync(string maPxnvl, string maNvl, UpdateCtphieuXuatNvlDto updateDto)
        {
            var ctPhieuXuatNvlModel = await _context.CtphieuXuatNvls
                .FirstOrDefaultAsync(x => x.MaPxnvl == maPxnvl && x.MaNvl == maNvl);

            if (ctPhieuXuatNvlModel == null)
            {
                return null;
            }

            ctPhieuXuatNvlModel.SoLuong = updateDto.SoLuong;

            await _context.SaveChangesAsync();

            return ctPhieuXuatNvlModel;
        }
    }
}
