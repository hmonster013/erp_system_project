using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.CtdonDh;
using webapi.Models;

namespace webapi.Controllers
{
    public class CtdonDhRepository : ICtdonDhRepository
    {
        private readonly ApplicationDBContext _context;

        public CtdonDhRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<CtdonDh> CreateAsync(CtdonDh ctdonDhModel)
        {
            await _context.CtdonDhs.AddAsync(ctdonDhModel);
            await _context.SaveChangesAsync();

            return ctdonDhModel;
        }

        public async Task<CtdonDh> DeleteAsync(string maDdh, string maSp)
        {
            var ctdonDhModel = await _context.CtdonDhs
                .FirstOrDefaultAsync(x => x.MaDdh == maDdh && x.MaSp == maSp);

            if (ctdonDhModel == null)
            {
                return null;
            }

            _context.CtdonDhs.Remove(ctdonDhModel);
            await _context.SaveChangesAsync();

            return ctdonDhModel;
        }

        public async Task<List<CtdonDh>> GetAllAsync()
        {
            return await _context.CtdonDhs.ToListAsync();
        }

        public async Task<CtdonDh?> GetByIdAsync(string maDdh, string maSp)
        {
            return await _context.CtdonDhs
                .FirstOrDefaultAsync(x => x.MaDdh == maDdh && x.MaSp == maSp);
        }

        public async Task<CtdonDh> UpdateAsync(string maDdh, string maSp, UpdateCtdonDhDto updateCtdonDhDto)
        {
            var existingCtdonDhModel = await _context.CtdonDhs
                .FirstOrDefaultAsync(x => x.MaDdh == maDdh && x.MaSp == maSp);

            if (existingCtdonDhModel == null)
            {
                return null;
            }

            existingCtdonDhModel.SoLuong = updateCtdonDhDto.SoLuong;

            await _context.SaveChangesAsync();

            return existingCtdonDhModel;
        }

        public async Task<List<CtdonDhWithTenSp>> GetByMaDdhAsync(string maDdh)
        {
            var results = await _context.CtdonDhs
                .Where(x => x.MaDdh == maDdh)
                .Select(x => new CtdonDhWithTenSp
                {
                    MaDdh = x.MaDdh,
                    MaSp = x.MaSp,
                    GiaBan = _context.SanPhams.FirstOrDefault(sp => sp.MaSp == x.MaSp).GiaBan,
                    TenSp = _context.SanPhams.FirstOrDefault(sp => sp.MaSp == x.MaSp).TenSp,
                    SoLuong = x.SoLuong
                })
                .ToListAsync();

            return results;
        }
    }
}
