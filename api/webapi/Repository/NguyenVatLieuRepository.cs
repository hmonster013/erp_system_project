using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Models;
using webapi.Dtos.NguyenVatLieu;
using webapi.Data;
using webapi.Controllers;

namespace webapi.Controllers
{
    public class NguyenVatLieuRepository : INguyenVatLieuRepository
    {
        private readonly ApplicationDBContext _context;
        public NguyenVatLieuRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<NguyenVatLieu> CreateAsync(NguyenVatLieu nguyenVatLieuModel)
        {
            await _context.NguyenVatLieus.AddAsync(nguyenVatLieuModel);
            await _context.SaveChangesAsync();

            return nguyenVatLieuModel;
        }

        public async Task<List<NguyenVatLieu>> GetAllAsync()
        {
            return await _context.NguyenVatLieus.ToListAsync();
        }

        public async Task<NguyenVatLieu?> GetByIdAsync(string MaNvl)
        {
            return await _context.NguyenVatLieus.FindAsync(MaNvl);
        }

        public async Task<NguyenVatLieu> UpdateAsync(string MaNvl, UpdateNguyenVatLieuDto updateNguyenVatLieuDto)
        {
            var nguyenVatLieuModel = await _context.NguyenVatLieus.FirstOrDefaultAsync(x => x.MaNvl == MaNvl);

            if (nguyenVatLieuModel == null)
            {
                return null;
            }

            nguyenVatLieuModel.MaNvl = updateNguyenVatLieuDto.MaNvl;
            nguyenVatLieuModel.TenNvl = updateNguyenVatLieuDto.TenNvl;
            nguyenVatLieuModel.GhiChu = updateNguyenVatLieuDto.GhiChu;
            nguyenVatLieuModel.SoLuongTon = updateNguyenVatLieuDto.SoLuongTon;

            await _context.SaveChangesAsync();

            return nguyenVatLieuModel;
        }
    }
}