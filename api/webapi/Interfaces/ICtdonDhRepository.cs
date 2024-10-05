using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.CtdonDh;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ICtdonDhRepository
    {
        Task<List<CtdonDh>> GetAllAsync();
        Task<CtdonDh?> GetByIdAsync(string maDdh, string maSp);
        Task<CtdonDh> CreateAsync(CtdonDh ctdonDhModel);
        Task<CtdonDh> UpdateAsync(string maDdh, string maSp, UpdateCtdonDhDto updateCtdonDhDto);
        Task<CtdonDh> DeleteAsync(string maDdh, string maSp);
        Task<List<CtdonDhWithTenSp>> GetByMaDdhAsync(string maDdh);
    }
}
