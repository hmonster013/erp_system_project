using System.Collections.Generic;
using System.Threading.Tasks;
using webapi.Dtos.CtphieuNhapNvl;
using webapi.Dtos.PhieuNhapNvl;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ICtphieuNhapNvlRepository
    {
        Task<List<CtphieuNhapNvl>> GetAllAsync();
        Task<CtphieuNhapNvl?> GetByIdAsync(string MaPnnvl, string MaNvl);
        Task<CtphieuNhapNvl> CreateAsync(CtphieuNhapNvl ctphieuNhapNvlModel);
        Task<CtphieuNhapNvl> UpdateAsync(string MaPnnvl, string MaNvl, UpdateCtphieuNhapNvlDto updateCtphieuNhapNvlDto);
        Task<CtphieuNhapNvl> DeleteAsync(string MaPnnvl, string MaNvl);
    }
}
