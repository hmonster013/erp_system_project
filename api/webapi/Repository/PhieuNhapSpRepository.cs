using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.PhieuNhapSp;
using webapi.Models;

namespace webapi.Controllers
{
    public class PhieuNhapSpRepository : IPhieuNhapSpRepository
    {
        private readonly ApplicationDBContext _context;

        public PhieuNhapSpRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<PhieuNhapSp> CreateAsync(PhieuNhapSp phieuNhapSpModel)
        {
            await _context.PhieuNhapSps.AddAsync(phieuNhapSpModel);
            await _context.SaveChangesAsync();

            return phieuNhapSpModel;
        }

        public async Task<PhieuNhapSp> DeleteAsync(string maPnsp)
        {
            var phieuNhapSpModel = await _context.PhieuNhapSps.FirstOrDefaultAsync(x => x.MaPnsp == maPnsp);

            if (phieuNhapSpModel == null)
            {
                return null;
            }

            _context.PhieuNhapSps.Remove(phieuNhapSpModel);
            await _context.SaveChangesAsync();

            return phieuNhapSpModel;
        }

        public async Task<List<PhieuNhapSp>> GetAllAsync()
        {
            return await _context.PhieuNhapSps.ToListAsync();
        }

        public async Task<PhieuNhapSp?> GetByIdAsync(string maPnsp)
        {
            return await _context.PhieuNhapSps.FindAsync(maPnsp);
        }

        public async Task<PhieuNhapSp> UpdateAsync(string maPnsp, UpdatePhieuNhapSpDto updatePhieuNhapSpDto)
        {
            var phieuNhapSpModel = await _context.PhieuNhapSps.FirstOrDefaultAsync(x => x.MaPnsp == maPnsp);

            if (phieuNhapSpModel == null)
            {
                return null;
            }

            phieuNhapSpModel.NgayNhap = updatePhieuNhapSpDto.NgayNhap;
            phieuNhapSpModel.MaNv = updatePhieuNhapSpDto.MaNv;

            await _context.SaveChangesAsync();

            return phieuNhapSpModel;
        }
    }
}
