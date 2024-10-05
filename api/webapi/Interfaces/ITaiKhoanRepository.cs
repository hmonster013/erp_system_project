using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.TaiKhoan;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ITaiKhoanRepository
    {
        Task<List<TaiKhoan>> GetAllAsync();
        Task<TaiKhoan?> GetByIdAsync(string username);
        Task<TaiKhoan> CreateAsync(TaiKhoan taiKhoanModel);
        Task<TaiKhoan> UpdateAsync(string username, UpdateTaiKhoanDto updateTaiKhoanDto);
        Task<TaiKhoan> DeleteAsync(string username);
    }
}
