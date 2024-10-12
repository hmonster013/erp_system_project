using System.Collections.Generic;
using System.Threading.Tasks;
using webapi.Dtos.CtphieuNhapSp;
using webapi.Dtos.PhieuNhapSp;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ICtphieuNhapSpRepository {

        Task<CtphieuNhapSp?> GetByIdAsync(string MaPnsp, string SoLo); 
        Task<CtphieuNhapSp> CreateAsync(CtphieuNhapSp ctphieuNhapSpModel);
    }
}
