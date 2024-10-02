using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.NhaCungCap;
using webapi.Models;

namespace webapi.Controllers
{
    public class NhaCungCapRepository : INhaCungCapRepository
    {
        private readonly ApplicationDBContext _context;
        public NhaCungCapRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<NhaCungCap> CreateAsync(NhaCungCap nhaCungCapModel)
        {
            await _context.NhaCungCaps.AddAsync(nhaCungCapModel);
            await _context.SaveChangesAsync();

            return nhaCungCapModel;
        }

        public async Task<NhaCungCap> DeleteAsync(string MaNcc)
        {
            var nhaCungCapModel = await _context.NhaCungCaps.FirstOrDefaultAsync(x => x.MaNcc == MaNcc);

            if (nhaCungCapModel == null)
            {
                return null;
            }

            _context.NhaCungCaps.Remove(nhaCungCapModel);
            await _context.SaveChangesAsync();

            return nhaCungCapModel;
        }

        public async Task<List<NhaCungCap>> GetAllAsync()
        {
            return await _context.NhaCungCaps.ToListAsync();
        }

        public async Task<NhaCungCap?> GetByIdAsync(string MaNcc)
        {
            return await _context.NhaCungCaps.FindAsync(MaNcc);
        }

        public async Task<NhaCungCap> UpdateAsync(string MaNcc, UpdateNhaCungCapDto updateNhaCungCapDto)
        {
            var nhaCungCapModel = await _context.NhaCungCaps.FirstOrDefaultAsync(x => x.MaNcc == MaNcc);

            if (nhaCungCapModel == null)
            {
                return null;
            }

            nhaCungCapModel.TenNcc = updateNhaCungCapDto.TenNcc;
            nhaCungCapModel.Email = updateNhaCungCapDto.Email;
            nhaCungCapModel.Sdt = updateNhaCungCapDto.Sdt;
            nhaCungCapModel.DiaChi = updateNhaCungCapDto.DiaChi;

            await _context.SaveChangesAsync();

            return nhaCungCapModel;
        }
    }
}
