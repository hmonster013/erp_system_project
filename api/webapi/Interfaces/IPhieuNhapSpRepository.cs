using System.Collections.Generic;
using System.Threading.Tasks;
using webapi.Dtos.PhieuNhapSp;
using webapi.Models;

namespace webapi.Controllers
{
    public interface IPhieuNhapSpRepository
    {
        Task<List<PhieuNhapSp>> GetAllAsync(); // Lấy danh sách tất cả phiếu nhập
        Task<PhieuNhapSp?> GetByIdAsync(string maPnsp); // Lấy phiếu nhập theo mã
        Task<PhieuNhapSp> CreateAsync(PhieuNhapSp phieuNhapSpModel); // Tạo phiếu nhập mới
        Task<PhieuNhapSp> UpdateAsync(string maPnsp, UpdatePhieuNhapSpDto updatePhieuNhapSpDto); // Cập nhật phiếu nhập
        Task<PhieuNhapSp> DeleteAsync(string maPnsp); // Xóa phiếu nhập
    }
}
