using webapi.Dtos.CtHoaDon;
using webapi.Dtos.HoaDon; // Đảm bảo không gian tên này đúng với DTO của bạn
using webapi.Models;

namespace webapi.Controllers
{
    public static class CtHoaDonMappers
    {
        public static CtHoaDonDto ToCtHoaDonDto(this CtHoaDon ctHoaDonModel)
        {
            return new CtHoaDonDto
            {
                MaHd = ctHoaDonModel.MaHd,
                MaSp = ctHoaDonModel.MaSp,
                SoLuong = ctHoaDonModel.SoLuong,
                DonGia = ctHoaDonModel.DonGia
            };
        }

        public static CtHoaDon ToCtHoaDonFormCreateDTO(this CreateCtHoaDonRequestDto createCtHoaDonRequestDto)
        {
            return new CtHoaDon
            {
                MaHd = createCtHoaDonRequestDto.MaHd,
                MaSp = createCtHoaDonRequestDto.MaSp,
                SoLuong = createCtHoaDonRequestDto.SoLuong,
                DonGia = createCtHoaDonRequestDto.DonGia
            };
        }
    }
}
