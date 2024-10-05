using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.CtphieuNhapNvl;
using webapi.Dtos.CtphieuXuatNvl;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ICtphieuXuatNvlRepository
    {
        Task<List<CtphieuXuatNvl>> GetAllAsync();
        Task<CtphieuXuatNvl?> GetByIdAsync(string MaPxnvl, string MaNvl);
        Task<CtphieuXuatNvl> CreateAsync(CtphieuXuatNvl ctphieuXuatNvlModel);
        Task<CtphieuXuatNvl> UpdateAsync(string MaPxnvl, string MaNvl, UpdateCtphieuXuatNvlDto updateCtphieuXuatNvlDto);
        Task<CtphieuXuatNvl> DeleteAsync(string MaPxnvl, string maNvl);
    }
}
