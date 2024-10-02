using System.Collections.Generic;
using System.Threading.Tasks;
using webapi.Dtos.PhieuNhapNvl;
using webapi.Models;

namespace webapi.Controllers
{
    public interface IPhieuNhapNvlRepository
    {
        Task<List<PhieuNhapNvl>> GetAllAsync();
        Task<PhieuNhapNvl?> GetByIdAsync(string MaPnnvl);
        Task<PhieuNhapNvl> CreateAsync(PhieuNhapNvl phieuNhapNvlModel);
        Task<PhieuNhapNvl> UpdateAsync(string MaPnnvl, UpdatePhieuNhapNvlDto updatePhieuNhapNvlDto);
        Task<PhieuNhapNvl> DeleteAsync(string MaPnnvl);
    }
}
