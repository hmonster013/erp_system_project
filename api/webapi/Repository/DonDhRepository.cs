using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Data;
using webapi.Dtos.DonDh;
using webapi.Models;

namespace webapi.Controllers
{
    public class DonDhRepository : IDonDhRepository
    {
        private readonly ApplicationDBContext _context;

        public DonDhRepository(ApplicationDBContext context)
        {
            _context = context;
        }

        public async Task<DonDh> CreateAsync(DonDh donDhModel)
        {
            await _context.DonDhs.AddAsync(donDhModel);
            await _context.SaveChangesAsync();

            return donDhModel;
        }

        public async Task<DonDh> DeleteAsync(string MaDdh)
        {
            var donDhModel = await _context.DonDhs.FirstOrDefaultAsync(x => x.MaDdh == MaDdh);

            if (donDhModel == null)
            {
                return null;
            }

            _context.DonDhs.Remove(donDhModel);
            await _context.SaveChangesAsync();

            return donDhModel;
        }

        public async Task<List<DonDh>> GetAllAsync()
        {
            return await _context.DonDhs.ToListAsync();
        }

        public async Task<DonDh?> GetByIdAsync(string MaDdh)
        {
            return await _context.DonDhs.FindAsync(MaDdh);
        }

        public async Task<DonDh> UpdateAsync(string MaDdh, UpdateDonDhDto updateDonDhDto)
        {
            var donDhModel = await _context.DonDhs.FirstOrDefaultAsync(x => x.MaDdh == MaDdh);

            if (donDhModel == null)
            {
                return null;
            }

            donDhModel.MaKh = updateDonDhDto.MaKh;
            donDhModel.NgayLap = updateDonDhDto.NgayLap;
            donDhModel.NgayGiao = updateDonDhDto.NgayGiao;
            donDhModel.TinhTrang = updateDonDhDto.TinhTrang;
            donDhModel.MaNv = updateDonDhDto.MaNv;

            await _context.SaveChangesAsync();

            return donDhModel;
        }

        public async Task<List<DonDh>> GetByTenKhAsync(string tenKh)
        {
            return await _context.DonDhs
                .Join(
                    _context.KhachHangs,
                    donDh => donDh.MaKh,
                    khachHang => khachHang.MaKh,
                    (donDh, khachHang) => new { donDh, khachHang })
                .Where(dh => dh.khachHang.TenKh == tenKh)
                .Select(dh => dh.donDh)
                .ToListAsync();
        }

        public async Task<List<DonDhWithTenKh>> GetAllWithTenKhAsync() // Phương thức mới
        {
            return await _context.DonDhs
                .Join(
                    _context.KhachHangs,
                    donDh => donDh.MaKh,
                    khachHang => khachHang.MaKh,
                    (donDh, khachHang) => new DonDhWithTenKh
                    {
                        MaDdh = donDh.MaDdh,
                        TenKh = khachHang.TenKh,
                        NgayLap = donDh.NgayLap,
                        NgayGiao = donDh.NgayGiao,
                        TinhTrang = donDh.TinhTrang,
                        MaNv = donDh.MaNv
                    })
                .ToListAsync();
        }
    }
}
