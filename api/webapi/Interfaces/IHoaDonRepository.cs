using System.Collections.Generic;
using System.Threading.Tasks;
using webapi.Dtos.HoaDon; // Nhớ thay đổi namespace tương ứng với DTO của bạn
using webapi.Models;

namespace webapi.Controllers
{
    public interface IHoaDonRepository
    {
        Task<List<HoaDon>> GetAllAsync();
        Task<HoaDon?> GetByIdAsync(string MaHd);
        Task<HoaDon> CreateAsync(HoaDon hoaDonModel);
        Task<HoaDon> UpdateAsync(string MaHd, UpdateHoaDonDto updateHoaDonDto);
        Task<HoaDon> DeleteAsync(string MaHd);
    }
}