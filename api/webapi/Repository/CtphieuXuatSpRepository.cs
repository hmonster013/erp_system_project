
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Models;

namespace webapi.Controllers
{
public class CtphieuXuatSpRepository : ICtphieuXuatSpRepository
    {
        private readonly ApplicationDBContext _context;

        public CtphieuXuatSpRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<CtphieuXuatSp> CreateAsync(CtphieuXuatSp ctphieuXuatSpModel)
        {
            await _context.CtphieuXuatSps.AddAsync(ctphieuXuatSpModel);
            await _context.SaveChangesAsync();

            return ctphieuXuatSpModel;
        }

        public async Task<CtphieuXuatSp> DeleteAsync(string maPxsp, string maSp)
        {
            var ctphieuXuatSpModel = await _context.CtphieuXuatSps
                .FirstOrDefaultAsync(x => x.MaPxsp == maPxsp && x.MaSp == maSp);

            if (ctphieuXuatSpModel == null)
            {
                return null;
            }

            _context.CtphieuXuatSps.Remove(ctphieuXuatSpModel);
            await _context.SaveChangesAsync();

            return ctphieuXuatSpModel;
        }

        public async Task<List<CtphieuXuatSp>> GetAllAsync()
        {
            return await _context.CtphieuXuatSps.ToListAsync();
        }

        public async Task<CtphieuXuatSp?> GetByIdAsync(string maPxsp, string maSp)
        {
            return await _context.CtphieuXuatSps
                .FirstOrDefaultAsync(x => x.MaPxsp == maPxsp && x.MaSp == maSp);
        }

        public async Task<CtphieuXuatSp> UpdateAsync(string maPxsp, string maSp, CtphieuXuatSp updateModel)
        {
            var ctphieuXuatSpModel = await _context.CtphieuXuatSps
                .FirstOrDefaultAsync(x => x.MaPxsp == maPxsp && x.MaSp == maSp);

            if (ctphieuXuatSpModel == null)
            {
                return null;
            }

            // Cập nhật các thuộc tính của ctphieuXuatSpModel
            ctphieuXuatSpModel.SoLuong = updateModel.SoLuong;

            await _context.SaveChangesAsync();

            return ctphieuXuatSpModel;
        }
    }
}