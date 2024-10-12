using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.SanPham;
using webapi.Models;

namespace webapi.Controllers
{
    public class SanPhamRepository : ISanPhamRepository
    {
        private readonly ApplicationDBContext _context;

        public SanPhamRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<SanPham> CreateAsync(SanPham sanPhamModel)
        {
            await _context.SanPhams.AddAsync(sanPhamModel);
            await _context.SaveChangesAsync();

            return sanPhamModel;
        }

        public async Task<SanPham> DeleteAsync(string MaSp)
        {
            var sanPhamModel = await _context.SanPhams.FirstOrDefaultAsync(x => x.MaSp == MaSp);

            if (sanPhamModel == null)
            {
                return null;
            }

            _context.SanPhams.Remove(sanPhamModel);
            await _context.SaveChangesAsync();

            return sanPhamModel;
        }

        public async Task<List<SanPham>> GetAllAsync()
        {
            return await _context.SanPhams.ToListAsync();
        }

        public async Task<SanPham?> GetByIdAsync(string MaSp)
        {
            return await _context.SanPhams.FindAsync(MaSp);
        }

        public async Task<SanPham> UpdateAsync(string MaSp, UpdateSanPhamDto updateSanPhamDto)
        {
            var sanPhamModel = await _context.SanPhams.FirstOrDefaultAsync(x => x.MaSp == MaSp);

            if (sanPhamModel == null)
            {
                return null;
            }

            sanPhamModel.MaLoai = updateSanPhamDto.MaLoai;
            sanPhamModel.TenSp = updateSanPhamDto.TenSp;
            sanPhamModel.GiaBan = updateSanPhamDto.GiaBan;
            sanPhamModel.ThanhPhan = updateSanPhamDto.ThanhPhan;
            sanPhamModel.Klt = updateSanPhamDto.Klt;
            sanPhamModel.SoLuongTon = updateSanPhamDto.SoLuongTon;

            await _context.SaveChangesAsync();

            return sanPhamModel;
        }

        public async Task<string?> GetTenSpByMaSpAsync(string MaSp)
        {
            var sanPham = await _context.SanPhams
                .FirstOrDefaultAsync(x => x.MaSp == MaSp);

            return sanPham?.TenSp; 
        }

        public async Task<List<SanPham>> GetByMaLoaiAsync(string maLoai)
        {
            return await _context.SanPhams
                .Where(sp => sp.MaLoai == maLoai)
                .ToListAsync();
        }
    }
}
