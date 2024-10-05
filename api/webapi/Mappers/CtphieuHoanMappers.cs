using webapi.Dtos.CtphieuHoan;
using webapi.Dtos.TaiKhoan; // Điều chỉnh namespace nếu cần
using webapi.Models;

namespace webapi.Controllers
{
    public static class CtphieuHoanMappers
    {
        public static CtphieuHoanDto ToCtphieuHoanDto(this CtphieuHoan ctphieuHoanModel)
        {
            return new CtphieuHoanDto
            {
                MaPh = ctphieuHoanModel.MaPh,
                MaSp = ctphieuHoanModel.MaSp,
                SoLuongHoan = ctphieuHoanModel.SoLuongHoan,
                LyDoHoan = ctphieuHoanModel.LyDoHoan
            };
        }

        public static CtphieuHoan ToCtphieuHoanFormCreateDTO(this CreateCtphieuHoanRequestDto createCtphieuHoanRequestDto)
        {
            return new CtphieuHoan
            {
                MaPh = createCtphieuHoanRequestDto.MaPh,
                MaSp = createCtphieuHoanRequestDto.MaSp,
                SoLuongHoan = createCtphieuHoanRequestDto.SoLuongHoan,
                LyDoHoan = createCtphieuHoanRequestDto.LyDoHoan
            };
        }
    }
}
