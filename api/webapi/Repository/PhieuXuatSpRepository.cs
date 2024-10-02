using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.PhieuXuatSp;
using webapi.Models;

namespace webapi.Controllers
{
    public class PhieuXuatSpRepository : IPhieuXuatSpRepository
    {
        private readonly ApplicationDBContext _context;

        public PhieuXuatSpRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<PhieuXuatSp> CreateAsync(PhieuXuatSp phieuXuatSpModel)
        {
            await _context.PhieuXuatSps.AddAsync(phieuXuatSpModel);
            await _context.SaveChangesAsync();

            return phieuXuatSpModel;
        }

        public async Task<PhieuXuatSp> DeleteAsync(string MaPxsp)
        {
            var phieuXuatSpModel = await _context.PhieuXuatSps.FirstOrDefaultAsync(x => x.MaPxsp == MaPxsp);

            if (phieuXuatSpModel == null)
            {
                return null;
            }

            _context.PhieuXuatSps.Remove(phieuXuatSpModel);
            await _context.SaveChangesAsync();

            return phieuXuatSpModel;
        }

        public async Task<List<PhieuXuatSp>> GetAllAsync()
        {
            return await _context.PhieuXuatSps.ToListAsync();
        }

        public async Task<PhieuXuatSp?> GetByIdAsync(string MaPxsp)
        {
            return await _context.PhieuXuatSps.FindAsync(MaPxsp);
        }

        public async Task<PhieuXuatSp> UpdateAsync(string MaPxsp, UpdatePhieuXuatSpDto updatePhieuXuatSpDto)
        {
            var phieuXuatSpModel = await _context.PhieuXuatSps.FirstOrDefaultAsync(x => x.MaPxsp == MaPxsp);

            if (phieuXuatSpModel == null)
            {
                return null;
            }

            phieuXuatSpModel.MaDdh = updatePhieuXuatSpDto.MaDdh;
            phieuXuatSpModel.NgayXuat = updatePhieuXuatSpDto.NgayXuat;
            phieuXuatSpModel.MaNv = updatePhieuXuatSpDto.MaNv;

            await _context.SaveChangesAsync();

            return phieuXuatSpModel;
        }
    }
}
