using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.CtHoaDon;
using webapi.Models;

namespace webapi.Controllers
{
    public class CtHoaDonRepository : ICtHoaDonRepository
    {
        private readonly ApplicationDBContext _context;

        public CtHoaDonRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<CtHoaDon> CreateAsync(CtHoaDon ctHoaDonModel)
        {
            await _context.CtHoaDons.AddAsync(ctHoaDonModel);
            await _context.SaveChangesAsync();

            return ctHoaDonModel;
        }

        public async Task<CtHoaDon> DeleteAsync(string MaHd, string MaSp)
        {
            var ctHoaDonModel = await _context.CtHoaDons.FirstOrDefaultAsync(x => x.MaHd == MaHd && x.MaSp == MaSp);

            if (ctHoaDonModel == null)
            {
                return null;
            }

            _context.CtHoaDons.Remove(ctHoaDonModel);
            await _context.SaveChangesAsync();

            return ctHoaDonModel;
        }

        public async Task<List<CtHoaDon>> GetAllAsync()
        {
            return await _context.CtHoaDons.ToListAsync();
        }

        public async Task<CtHoaDon?> GetByIdAsync(string MaHd, string MaSp)
        {
            return await _context.CtHoaDons.FirstOrDefaultAsync(x => x.MaHd == MaHd && x.MaSp == MaSp);
        }

        public async Task<CtHoaDon> UpdateAsync(string MaHd, string MaSp, UpdateCtHoaDonDto updateCtHoaDonDto)
        {
            var ctHoaDonModel = await _context.CtHoaDons.FirstOrDefaultAsync(x => x.MaHd == MaHd && x.MaSp == MaSp);

            if (ctHoaDonModel == null)
            {
                return null;
            }

            ctHoaDonModel.SoLuong = updateCtHoaDonDto.SoLuong;
            ctHoaDonModel.DonGia = updateCtHoaDonDto.DonGia;

            await _context.SaveChangesAsync();

            return ctHoaDonModel;
        }
    }
}
