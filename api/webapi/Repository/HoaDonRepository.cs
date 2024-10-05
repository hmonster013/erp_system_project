using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.HoaDon; // Thay đổi namespace tương ứng với DTO của bạn
using webapi.Models;

namespace webapi.Controllers
{
    public class HoaDonRepository : IHoaDonRepository
    {
        private readonly ApplicationDBContext _context;

        public HoaDonRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<HoaDon> CreateAsync(HoaDon hoaDonModel)
        {
            await _context.HoaDons.AddAsync(hoaDonModel);
            await _context.SaveChangesAsync();
            return hoaDonModel;
        }

        public async Task<HoaDon> DeleteAsync(string MaHd)
        {
            var hoaDonModel = await _context.HoaDons.FirstOrDefaultAsync(x => x.MaHd == MaHd);

            if (hoaDonModel == null)
            {
                return null;
            }

            _context.HoaDons.Remove(hoaDonModel);
            await _context.SaveChangesAsync();

            return hoaDonModel;
        }

        public async Task<List<HoaDon>> GetAllAsync()
        {
            return await _context.HoaDons.ToListAsync();
        }

        public async Task<HoaDon?> GetByIdAsync(string MaHd)
        {
            return await _context.HoaDons.FindAsync(MaHd);
        }

        public async Task<HoaDon> UpdateAsync(string MaHd, UpdateHoaDonDto updateHoaDonDto)
        {
            var hoaDonModel = await _context.HoaDons.FirstOrDefaultAsync(x => x.MaHd == MaHd);

            if (hoaDonModel == null)
            {
                return null;
            }

            hoaDonModel.MaDdh = updateHoaDonDto.MaDdh;
            hoaDonModel.NgayLapHd = updateHoaDonDto.NgayLapHd;
            hoaDonModel.TinhTrangHd = updateHoaDonDto.TinhTrangHd;
            hoaDonModel.MaNv = updateHoaDonDto.MaNv;

            await _context.SaveChangesAsync();

            return hoaDonModel;
        }
    }
}
