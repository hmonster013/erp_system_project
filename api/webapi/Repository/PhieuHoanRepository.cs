using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.PhieuHoan;
using webapi.Dtos.TaiKhoan; // Điều chỉnh namespace nếu cần
using webapi.Models;

namespace webapi.Controllers
{
    public class PhieuHoanRepository : IPhieuHoanRepository
    {
        private readonly ApplicationDBContext _context;

        public PhieuHoanRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<PhieuHoan> CreateAsync(PhieuHoan phieuHoanModel)
        {
            await _context.PhieuHoans.AddAsync(phieuHoanModel);
            await _context.SaveChangesAsync();

            return phieuHoanModel;
        }

        public async Task<PhieuHoan> DeleteAsync(string MaPh)
        {
            var phieuHoanModel = await _context.PhieuHoans.FirstOrDefaultAsync(x => x.MaPh == MaPh);

            if (phieuHoanModel == null)
            {
                return null;
            }

            _context.PhieuHoans.Remove(phieuHoanModel);
            await _context.SaveChangesAsync();

            return phieuHoanModel;
        }

        public async Task<List<PhieuHoan>> GetAllAsync()
        {
            return await _context.PhieuHoans.ToListAsync();
        }

        public async Task<PhieuHoan?> GetByIdAsync(string MaPh)
        {
            return await _context.PhieuHoans.FindAsync(MaPh);
        }

        public async Task<PhieuHoan> UpdateAsync(string MaPh, UpdatePhieuHoanDto updatePhieuHoanDto)
        {
            var phieuHoanModel = await _context.PhieuHoans.FirstOrDefaultAsync(x => x.MaPh == MaPh);

            if (phieuHoanModel == null)
            {
                return null;
            }

            phieuHoanModel.MaDdh = updatePhieuHoanDto.MaDdh;
            phieuHoanModel.NgayHoan = updatePhieuHoanDto.NgayHoan;
            phieuHoanModel.MaNv = updatePhieuHoanDto.MaNv;

            await _context.SaveChangesAsync();

            return phieuHoanModel;
        }
    }
}
