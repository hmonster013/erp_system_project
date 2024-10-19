using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Models;
using webapi.Dtos.LoSanPham;
using webapi.Data;
using webapi.Controllers;

namespace webapi.Repositories
{
    public class LoSanPhamRepository : ILoSanPhamRepository
    {
        private readonly ApplicationDBContext _context;

        public LoSanPhamRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<List<LoSanPham>> GetAllAsync()
        {
            return await _context.LoSanPhams.ToListAsync();
        }

        public async Task<LoSanPham?> GetByIdAsync(string soLo)
        {
            return await _context.LoSanPhams.FindAsync(soLo);
        }

        public async Task<List<LoSanPham?>> GetByMaYcAsync(string MaYc)
        {
            return await _context.LoSanPhams
                                .Where(x => x.MaYc == MaYc)
                                .ToListAsync();
        }

        public async Task<LoSanPham> CreateAsync(LoSanPham loSanPhamModel)
        {
            _context.LoSanPhams.Add(loSanPhamModel);
            await _context.SaveChangesAsync();
            return loSanPhamModel;
        }

        public async Task<LoSanPham> UpdateAsync(string soLo, UpdateLoSanPhamDto updateLoSanPhamDto)
        {
            var loSanPham = await GetByIdAsync(soLo);
            if (loSanPham == null)
            {
                throw new KeyNotFoundException("LoSanPham not found.");
            }

            // Cập nhật các trường của loSanPham từ updateLoSanPhamDto
            loSanPham.MaYc = updateLoSanPhamDto.MaYc ?? loSanPham.MaYc;
            loSanPham.MaSp = updateLoSanPhamDto.MaSp ?? loSanPham.MaSp;
            loSanPham.SoLuongSp = updateLoSanPhamDto.SoLuongSp ?? loSanPham.SoLuongSp;
            loSanPham.Nsx = updateLoSanPhamDto.Nsx ?? loSanPham.Nsx;
            loSanPham.Hsd = updateLoSanPhamDto.Hsd ?? loSanPham.Hsd;
            loSanPham.TinhTrang = updateLoSanPhamDto.TinhTrang ?? loSanPham.TinhTrang;

            await _context.SaveChangesAsync();
            return loSanPham;
        }

        public async Task<LoSanPham> DeleteAsync(string soLo)
        {
            var loSanPham = await GetByIdAsync(soLo);
            if (loSanPham == null)
            {
                throw new KeyNotFoundException("LoSanPham not found.");
            }

            _context.LoSanPhams.Remove(loSanPham);
            await _context.SaveChangesAsync();
            return loSanPham;
        }
    }
}
