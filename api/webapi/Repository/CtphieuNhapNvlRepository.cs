using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.CtphieuNhapNvl; // Thêm không gian tên cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    public class CtphieuNhapNvlRepository : ICtphieuNhapNvlRepository
    {
        private readonly ApplicationDBContext _context;

        public CtphieuNhapNvlRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<CtphieuNhapNvl> CreateAsync(CtphieuNhapNvl ctphieuNhapNvlModel)
        {
            await _context.CtphieuNhapNvls.AddAsync(ctphieuNhapNvlModel);
            await _context.SaveChangesAsync();

            return ctphieuNhapNvlModel;
        }

        public async Task<CtphieuNhapNvl> DeleteAsync(string MaPnnvl, string MaNvl)
        {
            var ctphieuNhapNvlModel = await _context.CtphieuNhapNvls.FirstOrDefaultAsync(x => x.MaPnnvl == MaPnnvl && x.MaNvl == MaNvl);

            if (ctphieuNhapNvlModel == null)
            {
                return null;
            }

            _context.CtphieuNhapNvls.Remove(ctphieuNhapNvlModel);
            await _context.SaveChangesAsync();

            return ctphieuNhapNvlModel;
        }

        public async Task<List<CtphieuNhapNvl>> GetAllAsync()
        {
            return await _context.CtphieuNhapNvls.ToListAsync();
        }

        public async Task<CtphieuNhapNvl?> GetByIdAsync(string MaPnnvl, string MaNvl)
        {
            return await _context.CtphieuNhapNvls.FirstOrDefaultAsync(x => x.MaPnnvl == MaPnnvl && x.MaNvl == MaNvl);
        }

        public async Task<CtphieuNhapNvl> UpdateAsync(string MaPnnvl, string MaNvl, UpdateCtphieuNhapNvlDto updateCtphieuNhapNvlDto)
        {
            var ctphieuNhapNvlModel = await _context.CtphieuNhapNvls.FirstOrDefaultAsync(x => x.MaPnnvl == MaPnnvl && x.MaNvl == MaNvl);

            if (ctphieuNhapNvlModel == null)
            {
                return null;
            }
            
            ctphieuNhapNvlModel.Slnhap = updateCtphieuNhapNvlDto.Slnhap;
            ctphieuNhapNvlModel.Dvt = updateCtphieuNhapNvlDto.Dvt;
            ctphieuNhapNvlModel.GiaNhap = updateCtphieuNhapNvlDto.GiaNhap;
            ctphieuNhapNvlModel.Nsx = updateCtphieuNhapNvlDto.Nsx;
            ctphieuNhapNvlModel.Hsd = updateCtphieuNhapNvlDto.Hsd;

            await _context.SaveChangesAsync();

            return ctphieuNhapNvlModel;
        }
    }
}
