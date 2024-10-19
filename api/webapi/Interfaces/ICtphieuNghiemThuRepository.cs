
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.CtphieuNghiemThu;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ICtphieuNghiemThuRepository
    {
        Task<List<CtphieuNghiemThu>> GetAllAsync();
        Task<List<CtphieuNghiemThu?>> GetByIdAsync(string MaPnt);
        Task<CtphieuNghiemThu> CreateAsync(CtphieuNghiemThu ctphieuNghiemThuModel);
    }
}