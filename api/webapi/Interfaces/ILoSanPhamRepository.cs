using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Models;
using webapi.Dtos.LoSanPham;

namespace webapi.Controllers
{
    public interface ILoSanPhamRepository
    {
        Task<List<LoSanPham>> GetAllAsync();
        Task<LoSanPham?> GetByIdAsync(string soLo);
        Task<List<LoSanPham?>> GetByMaYcAsync(string MaYc);
        Task<LoSanPham> CreateAsync(LoSanPham loSanPhamModel);
        Task<LoSanPham> UpdateAsync(string soLo, UpdateLoSanPhamDto updateLoSanPhamDto);
        Task<LoSanPham> DeleteAsync(string soLo);
    }
}
