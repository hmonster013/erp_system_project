using System.Collections.Generic;
using System.Threading.Tasks;
using webapi.Dtos.PhieuHoan;
using webapi.Models; // Đảm bảo rằng bạn đã thêm namespace đúng cho mô hình

namespace webapi.Controllers
{
    public interface IPhieuHoanRepository
    {
        Task<List<PhieuHoan>> GetAllAsync();
        Task<PhieuHoan?> GetByIdAsync(string MaPh);
        Task<PhieuHoan> CreateAsync(PhieuHoan phieuHoanModel);
        Task<PhieuHoan> UpdateAsync(string MaPh, UpdatePhieuHoanDto updatePhieuHoanDto);
        Task<PhieuHoan> DeleteAsync(string MaPh);
    }
}
