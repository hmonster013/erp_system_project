using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.LoaiSp;
using webapi.Models;

namespace webapi.Controllers
{
    public class LoaiSpRepository : ILoaiSpRepository
    {
        private readonly ApplicationDBContext _context;

        public LoaiSpRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<LoaiSp> CreateAsync(LoaiSp loaiSpModel)
        {
            await _context.LoaiSps.AddAsync(loaiSpModel);
            await _context.SaveChangesAsync();

            return loaiSpModel;
        }

        public async Task<LoaiSp> DeleteAsync(string maLoai)
        {
            var loaiSpModel = await _context.LoaiSps.FirstOrDefaultAsync(x => x.MaLoai == maLoai);

            if (loaiSpModel == null)
            {
                return null;
            }

            _context.LoaiSps.Remove(loaiSpModel);
            await _context.SaveChangesAsync();

            return loaiSpModel;
        }

        public async Task<List<LoaiSp>> GetAllAsync()
        {
            return await _context.LoaiSps.ToListAsync();
        }

        public async Task<LoaiSp?> GetByIdAsync(string maLoai)
        {
            return await _context.LoaiSps.FindAsync(maLoai);
        }

        public async Task<LoaiSp> UpdateAsync(string maLoai, UpdateLoaiSpDto updateLoaiSpDto)
        {
            var loaiSpModel = await _context.LoaiSps.FirstOrDefaultAsync(x => x.MaLoai == maLoai);

            if (loaiSpModel == null)
            {
                return null;
            }

            loaiSpModel.TenLoai = updateLoaiSpDto.TenLoai;

            await _context.SaveChangesAsync();

            return loaiSpModel;
        }

        public async Task<LoaiSp?> GetByTenLoaiAsync(string tenLoai)
        {
            return await _context.LoaiSps
                .FirstOrDefaultAsync(l => l.TenLoai == tenLoai);
        }
    }
}
