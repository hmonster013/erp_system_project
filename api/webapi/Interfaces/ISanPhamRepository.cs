using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.SanPham;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ISanPhamRepository
    {
        Task<List<SanPham>> GetAllAsync();
        Task<SanPham?> GetByIdAsync(string MaSp);
        Task<SanPham> CreateAsync(SanPham sanPhamModel);
        Task<string?> GetTenSpByMaSpAsync(string MaSp);
        Task<SanPham> UpdateAsync(string MaSp, UpdateSanPhamDto updateSanPhamDto);
        Task<SanPham> DeleteAsync(string MaSp);
        Task<List<SanPham>> GetByMaLoaiAsync(string maLoai);
    }
}
