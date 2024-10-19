
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.CtphieuNghiemThu; // Thêm không gian tên cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    public class CtphieuNghiemThuRepository : ICtphieuNghiemThuRepository
    {
        private readonly ApplicationDBContext _context;
        public CtphieuNghiemThuRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<CtphieuNghiemThu> CreateAsync(CtphieuNghiemThu ctphieuNghiemThuModel)
        {
            await _context.CtphieuNghiemThus.AddAsync(ctphieuNghiemThuModel);
            await _context.SaveChangesAsync();

            return ctphieuNghiemThuModel;
        }

        public async Task<List<CtphieuNghiemThu>> GetAllAsync()
        {
            return await _context.CtphieuNghiemThus.ToListAsync();
        }

        public async Task<List<CtphieuNghiemThu?>> GetByIdAsync(string MaPnt)
        {
            return await _context.CtphieuNghiemThus
                                .Where(x => x.MaPnt == MaPnt)
                                .ToListAsync();
        }
    }
}