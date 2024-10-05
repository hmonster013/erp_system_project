using webapi.Dtos.PhieuHoan;
using webapi.Dtos.TaiKhoan; // Điều chỉnh theo namespace đúng của DTO
using webapi.Models;

namespace webapi.Controllers
{
    public static class PhieuHoanMappers
    {
        public static PhieuHoanDto ToPhieuHoanDto(this PhieuHoan phieuHoanModel)
        {
            return new PhieuHoanDto
            {
                MaPh = phieuHoanModel.MaPh,
                MaDdh = phieuHoanModel.MaDdh,
                NgayHoan = phieuHoanModel.NgayHoan,
                MaNv = phieuHoanModel.MaNv
            };
        }

        public static PhieuHoan ToPhieuHoanFormCreateDTO(this CreatePhieuHoanRequestDto createPhieuHoanRequestDto)
        {
            return new PhieuHoan
            {
                MaPh = createPhieuHoanRequestDto.MaPh,
                MaDdh = createPhieuHoanRequestDto.MaDdh,
                NgayHoan = createPhieuHoanRequestDto.NgayHoan,
                MaNv = createPhieuHoanRequestDto.MaNv
            };
        }
    }
}
