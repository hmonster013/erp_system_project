
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.PhieuNghiemThu; // Thêm không gian tên cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    public class PhieuNghiemThuRepository : IPhieuNghiemThuRepository
    {
        private readonly ApplicationDBContext _context;
        public PhieuNghiemThuRepository(ApplicationDBContext context)
        {
            _context = context;
        }
        public async Task<PhieuNghiemThu> CreateAsync(PhieuNghiemThu phieuNghiemThuModel)
        {
            await _context.PhieuNghiemThus.AddAsync(phieuNghiemThuModel);
            await _context.SaveChangesAsync();

            return phieuNghiemThuModel;
        }

        public async Task<List<PhieuNghiemThu>> GetAllAsync()
        {
            return await _context.PhieuNghiemThus.ToListAsync();
        }

        public async Task<PhieuNghiemThu?> GetByIdAsync(string MaPnt)
        {
            return await _context.PhieuNghiemThus.FirstOrDefaultAsync(x => x.MaPnt == MaPnt);
        }
    }
}