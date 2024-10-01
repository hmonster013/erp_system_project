
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.TaiKhoan;
using webapi.Models;

namespace webapi.Controllers
{
    public interface IThongTinNhanVienRepository
    {
        Task<List<ThongTinNhanVien>> GetAllAsync();
        Task<ThongTinNhanVien?> GetByIdAsync(string MaNv);
        Task<ThongTinNhanVien> CreateAsync(ThongTinNhanVien thongTinNhanVienModel);
        Task<ThongTinNhanVien> UpdateAsync(string MaNv, UpdateThongTinNhanVienDto updateThongTinNhanVienDto);
        Task<ThongTinNhanVien> DeleteAsync(string MaNv);
    }
}