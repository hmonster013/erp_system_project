
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.NhaCungCap;
using webapi.Models;

namespace webapi.Controllers
{
    public interface INhaCungCapRepository
    {
        Task<List<NhaCungCap>> GetAllAsync();
        Task<NhaCungCap?> GetByIdAsync(string MaNcc);
        Task<NhaCungCap> CreateAsync(NhaCungCap nhaCungCapModel);
        Task<NhaCungCap> UpdateAsync(string MaNcc, UpdateNhaCungCapDto updateNhaCungCapDto);
        Task<NhaCungCap> DeleteAsync(string MaNcc);        
    }
}