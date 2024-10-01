
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.TaiKhoan;
using webapi.Models;

namespace webapi.Controllers
{
    public class ThongTinNhanVienRepository : IThongTinNhanVienRepository
    {
        private readonly ApplicationDBContext _context;
        public ThongTinNhanVienRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<ThongTinNhanVien> CreateAsync(ThongTinNhanVien thongTinNhanVienModel)
        {
            await _context.ThongTinNhanViens.AddAsync(thongTinNhanVienModel);
            await _context.SaveChangesAsync();

            return thongTinNhanVienModel;
        }

        public async Task<ThongTinNhanVien> DeleteAsync(string MaNv)
        {
            var thongTinNhanVienModel = await _context.ThongTinNhanViens.FirstOrDefaultAsync(x => x.MaNv == MaNv);

            if (thongTinNhanVienModel == null)
            {
                return null;
            }

            _context.ThongTinNhanViens.Remove(thongTinNhanVienModel);
            await _context.SaveChangesAsync();

            return thongTinNhanVienModel;
        }

        public async Task<List<ThongTinNhanVien>> GetAllAsync()
        {
            return await _context.ThongTinNhanViens.ToListAsync();
        }

        public async Task<ThongTinNhanVien?> GetByIdAsync(string MaNv)
        {
            return await _context.ThongTinNhanViens.FindAsync(MaNv);
        }

        public async Task<ThongTinNhanVien> UpdateAsync(string MaNv, UpdateThongTinNhanVienDto updateThongTinNhanVienDto)
        {
            var thongTinNhanVienModel = await _context.ThongTinNhanViens.FirstOrDefaultAsync(x => x.MaNv == MaNv);

            if (thongTinNhanVienModel == null)
            {
                return null;
            }

            thongTinNhanVienModel.TenNv = updateThongTinNhanVienDto.TenNv;
            thongTinNhanVienModel.GioiTinh = updateThongTinNhanVienDto.GioiTinh;
            thongTinNhanVienModel.NgaySinh = updateThongTinNhanVienDto.NgaySinh;
            thongTinNhanVienModel.QueQuan = updateThongTinNhanVienDto.QueQuan;
            thongTinNhanVienModel.Sdt = updateThongTinNhanVienDto.Sdt;
            thongTinNhanVienModel.Tdhv = updateThongTinNhanVienDto.Tdhv;

            await _context.SaveChangesAsync();

            return thongTinNhanVienModel;
        }
    }
}