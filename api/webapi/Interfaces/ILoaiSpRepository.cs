using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using webapi.Dtos.LoaiSp; // Đảm bảo có đúng namespace cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    public interface ILoaiSpRepository
    {
        Task<List<LoaiSp>> GetAllAsync();
        Task<LoaiSp?> GetByIdAsync(string maLoai);
        Task<LoaiSp> CreateAsync(LoaiSp loaiSpModel);
        Task<LoaiSp> UpdateAsync(string maLoai, UpdateLoaiSpDto updateLoaiSpDto);
        Task<LoaiSp> DeleteAsync(string maLoai);
        Task<LoaiSp?> GetByTenLoaiAsync(string tenLoai);
    }
}
