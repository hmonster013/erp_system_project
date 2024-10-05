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
    public class TaiKhoanRepository : ITaiKhoanRepository
    {
        private readonly ApplicationDBContext _context;

        public TaiKhoanRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<TaiKhoan> CreateAsync(TaiKhoan taiKhoanModel)
        {
            await _context.TaiKhoans.AddAsync(taiKhoanModel);
            await _context.SaveChangesAsync();

            return taiKhoanModel;
        }

        public async Task<TaiKhoan> DeleteAsync(string username)
        {
            var taiKhoanModel = await _context.TaiKhoans.FirstOrDefaultAsync(x => x.Username == username);

            if (taiKhoanModel == null)
            {
                return null;
            }

            _context.TaiKhoans.Remove(taiKhoanModel);
            await _context.SaveChangesAsync();

            return taiKhoanModel;
        }

        public async Task<List<TaiKhoan>> GetAllAsync()
        {
            return await _context.TaiKhoans.ToListAsync();
        }

        public async Task<TaiKhoan?> GetByIdAsync(string username)
        {
            return await _context.TaiKhoans.FindAsync(username);
        }

        public async Task<TaiKhoan> UpdateAsync(string username, UpdateTaiKhoanDto updateTaiKhoanDto)
        {
            var taiKhoanModel = await _context.TaiKhoans.FirstOrDefaultAsync(x => x.Username == username);

            if (taiKhoanModel == null)
            {
                return null;
            }

            taiKhoanModel.Password = updateTaiKhoanDto.Password;
            taiKhoanModel.MaNv = updateTaiKhoanDto.MaNv;

            await _context.SaveChangesAsync();

            return taiKhoanModel;
        }
    }
}
