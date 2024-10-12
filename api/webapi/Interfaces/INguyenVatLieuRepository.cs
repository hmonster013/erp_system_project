
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Models;
using webapi.Dtos.NguyenVatLieu;

namespace webapi.Controllers
{
    public interface INguyenVatLieuRepository
    {
        Task<List<NguyenVatLieu>> GetAllAsync();
        Task<NguyenVatLieu?> GetByIdAsync(string MaNvl);
        Task<NguyenVatLieu> UpdateAsync(string MaNvl, UpdateNguyenVatLieuDto updateNguyenVatLieuDto);
        Task<NguyenVatLieu> CreateAsync(NguyenVatLieu nguyenVatLieuModel);
    }
}