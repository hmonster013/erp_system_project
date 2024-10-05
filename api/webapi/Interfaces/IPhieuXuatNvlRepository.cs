using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using webapi.Dtos.PhieuNhapNvl;
using webapi.Dtos.PhieuXuatNvl;
using webapi.Models;

namespace webapi.Controllers
{
    public interface IPhieuXuatNvlRepository
    {
        Task<List<PhieuXuatNvl>> GetAllAsync();
        Task<PhieuXuatNvl?> GetByIdAsync(string MaPxnvl);
        Task<PhieuXuatNvl> CreateAsync(PhieuXuatNvl phieuXuatNvlModel);
        Task<PhieuXuatNvl> UpdateAsync(string MaPxnvl, UpdatePhieuXuatNvlDto updatePhieuXuatNvlDto);
        Task<PhieuXuatNvl> DeleteAsync(string MaPxnvl);
    }
}
