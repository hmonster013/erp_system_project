using System.Collections.Generic;
using System.Threading.Tasks;
using webapi.Dtos.DonDh;
using webapi.Models;

namespace webapi.Controllers
{
    public interface IDonDhRepository
    {
        Task<List<DonDh>> GetAllAsync();
        Task<DonDh?> GetByIdAsync(string MaDdh);
        Task<DonDh> CreateAsync(DonDh donDhModel);
        Task<DonDh> UpdateAsync(string MaDdh, UpdateDonDhDto updateDonDhDto);
        Task<DonDh> DeleteAsync(string MaDdh);
        Task<List<DonDh>> GetByTenKhAsync(string tenKh);
        Task<List<DonDhWithTenKh>> GetAllWithTenKhAsync();
    }
}
