using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.PhieuXuatSp;
using webapi.Models;

namespace webapi.Controllers
{
    public interface IPhieuXuatSpRepository
    {
        Task<List<PhieuXuatSp>> GetAllAsync();
        Task<PhieuXuatSp?> GetByIdAsync(string MaPxsp);
        Task<PhieuXuatSp> CreateAsync(PhieuXuatSp phieuXuatSpModel);
        Task<PhieuXuatSp> UpdateAsync(string MaPxsp, UpdatePhieuXuatSpDto updatePhieuXuatSpDto);
        Task<PhieuXuatSp> DeleteAsync(string MaPxsp);
    }
}
