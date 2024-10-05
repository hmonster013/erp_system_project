using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.CtHoaDon;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ICtHoaDonRepository
    {
        Task<List<CtHoaDon>> GetAllAsync();
        Task<CtHoaDon?> GetByIdAsync(string MaHd, string MaSp);
        Task<CtHoaDon> CreateAsync(CtHoaDon ctHoaDonModel);
        Task<CtHoaDon> UpdateAsync(string MaHd, string MaSp, UpdateCtHoaDonDto updateCtHoaDonDto);
        Task<CtHoaDon> DeleteAsync(string MaHd, string MaSp);
    }
}
