using webapi.Dtos.HoaDon; // Nhớ thay đổi namespace tương ứng với DTO của bạn
using webapi.Models;

namespace webapi.Controllers
{
    public static class HoaDonMappers
    {
        public static HoaDonDto ToHoaDonDto(this HoaDon hoaDonModel)
        {
            return new HoaDonDto
            {
                MaHd = hoaDonModel.MaHd,
                MaDdh = hoaDonModel.MaDdh,
                NgayLapHd = hoaDonModel.NgayLapHd,
                TinhTrangHd = hoaDonModel.TinhTrangHd,
                MaNv = hoaDonModel.MaNv
            };
        }

        public static HoaDon ToHoaDonFormCreateDTO(this CreateHoaDonRequestDto createHoaDonRequestDto)
        {
            return new HoaDon
            {
                MaHd = createHoaDonRequestDto.MaHd,
                MaDdh = createHoaDonRequestDto.MaDdh,
                NgayLapHd = createHoaDonRequestDto.NgayLapHd,
                TinhTrangHd = createHoaDonRequestDto.TinhTrangHd,
                MaNv = createHoaDonRequestDto.MaNv
            };
        }
    }
}
