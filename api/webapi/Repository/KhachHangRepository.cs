using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.KhachHang;
using webapi.Models;

namespace webapi.Controllers
{
    public class KhachHangRepository : IKhachHangRepository
    {
        private readonly ApplicationDBContext _context;
        public KhachHangRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<KhachHang> CreateAsync(KhachHang khachHangModel)
        {
            await _context.KhachHangs.AddAsync(khachHangModel);
            await _context.SaveChangesAsync();

            return khachHangModel;
        }

        public async Task<KhachHang> DeleteAsync(string MaKh)
        {
            var khachHangModel = await _context.KhachHangs.FirstOrDefaultAsync(x => x.MaKh == MaKh);

            if (khachHangModel == null)
            {
                return null;
            }

            _context.KhachHangs.Remove(khachHangModel);
            await _context.SaveChangesAsync();

            return khachHangModel;
        }

        public async Task<List<KhachHang>> GetAllAsync()
        {
            return await _context.KhachHangs.ToListAsync();
        }

        public async Task<KhachHang?> GetByIdAsync(string MaKh)
        {
            return await _context.KhachHangs.FindAsync(MaKh);
        }

        // Tìm kiếm khách hàng theo tên
        public async Task<List<KhachHang>> GetByTenKhAsync(string TenKh)
        {
            return await _context.KhachHangs
                .Where(x => x.TenKh.Contains(TenKh))
                .ToListAsync();
        }

        public async Task<KhachHang> UpdateAsync(string MaKh, UpdateKhachHangDto updateKhachHangDto)
        {
            var existingKhachHang = await _context.KhachHangs.FirstOrDefaultAsync(x => x.MaKh == MaKh);

            if (existingKhachHang == null)
            {
                return null;
            }

            existingKhachHang.TenKh = updateKhachHangDto.TenKh;
            existingKhachHang.Email = updateKhachHangDto.Email;
            existingKhachHang.Sdt = updateKhachHangDto.Sdt;
            existingKhachHang.DiaChi = updateKhachHangDto.DiaChi;

            await _context.SaveChangesAsync();

            return existingKhachHang;
        }
    }
}
