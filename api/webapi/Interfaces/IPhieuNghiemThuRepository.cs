
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.PhieuNghiemThu;
using webapi.Models;

namespace webapi.Controllers
{
    public interface IPhieuNghiemThuRepository
    {
        Task<List<PhieuNghiemThu>> GetAllAsync();
        Task<PhieuNghiemThu?> GetByIdAsync(string MaPnt);
        Task<PhieuNghiemThu> CreateAsync(PhieuNghiemThu phieuNghiemThuModel);
    }
}