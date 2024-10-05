
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ICtphieuXuatSpRepository
    {
        Task<List<CtphieuXuatSp>> GetAllAsync();
        Task<CtphieuXuatSp?> GetByIdAsync(string maPxsp, string maSp);
        Task<CtphieuXuatSp> CreateAsync(CtphieuXuatSp ctphieuXuatSpModel);
        Task<CtphieuXuatSp> UpdateAsync(string maPxsp, string maSp, CtphieuXuatSp updateModel);
        Task<CtphieuXuatSp> DeleteAsync(string maPxsp, string maSp);
    }
}