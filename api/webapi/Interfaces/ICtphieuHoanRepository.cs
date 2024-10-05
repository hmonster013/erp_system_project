using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.CtphieuHoan;
using webapi.Dtos.TaiKhoan;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ICtphieuHoanRepository
    {
        Task<List<CtphieuHoan>> GetAllAsync();
        Task<CtphieuHoan?> GetByIdAsync(string maPh, string maSp);
        Task<CtphieuHoan> CreateAsync(CtphieuHoan ctphieuHoanModel);
        Task<CtphieuHoan> UpdateAsync(string maPh, string maSp, UpdateCtphieuHoanDto updateCtphieuHoanDto);
        Task<CtphieuHoan> DeleteAsync(string maPh, string maSp);
    }
}
