using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.PhieuNhapNvl;
using webapi.Models;

namespace webapi.Controllers
{
    public class PhieuNhapNvlRepository : IPhieuNhapNvlRepository
    {
        private readonly ApplicationDBContext _context;

        public PhieuNhapNvlRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<PhieuNhapNvl> CreateAsync(PhieuNhapNvl phieuNhapNvlModel)
        {
            await _context.PhieuNhapNvls.AddAsync(phieuNhapNvlModel);
            await _context.SaveChangesAsync();

            return phieuNhapNvlModel;
        }

        public async Task<PhieuNhapNvl> DeleteAsync(string MaPnnvl)
        {
            var phieuNhapNvlModel = await _context.PhieuNhapNvls.FirstOrDefaultAsync(x => x.MaPnnvl == MaPnnvl);

            if (phieuNhapNvlModel == null)
            {
                return null;
            }

            _context.PhieuNhapNvls.Remove(phieuNhapNvlModel);
            await _context.SaveChangesAsync();

            return phieuNhapNvlModel;
        }

        public async Task<List<PhieuNhapNvl>> GetAllAsync()
        {
            return await _context.PhieuNhapNvls.ToListAsync();
        }

        public async Task<PhieuNhapNvl?> GetByIdAsync(string MaPnnvl)
        {
            return await _context.PhieuNhapNvls.FindAsync(MaPnnvl);
        }

        public async Task<PhieuNhapNvl> UpdateAsync(string MaPnnvl, UpdatePhieuNhapNvlDto updatePhieuNhapNvlDto)
        {
            var phieuNhapNvlModel = await _context.PhieuNhapNvls.FirstOrDefaultAsync(x => x.MaPnnvl == MaPnnvl);

            if (phieuNhapNvlModel == null)
            {
                return null;
            }

            phieuNhapNvlModel.MaYc = updatePhieuNhapNvlDto.MaYc;
            phieuNhapNvlModel.MaNcc = updatePhieuNhapNvlDto.MaNcc;
            phieuNhapNvlModel.NgayNhap = updatePhieuNhapNvlDto.NgayNhap;
            phieuNhapNvlModel.MaNv = updatePhieuNhapNvlDto.MaNv;
            phieuNhapNvlModel.PhanLoai = updatePhieuNhapNvlDto.PhanLoai;

            await _context.SaveChangesAsync();

            return phieuNhapNvlModel;
        }
    }
}
