using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.KhachHang;
using webapi.Models;

namespace webapi.Controllers
{
    public interface IKhachHangRepository
    {
        Task<List<KhachHang>> GetAllAsync();
        Task<KhachHang?> GetByIdAsync(string MaKh);
        Task<List<KhachHang>> GetByTenKhAsync(string TenKh);
        Task<KhachHang> CreateAsync(KhachHang khachHangModel);
        Task<KhachHang> UpdateAsync(string MaKh, UpdateKhachHangDto updateKhachHangDto);
        Task<KhachHang> DeleteAsync(string MaKh);
    }
}
