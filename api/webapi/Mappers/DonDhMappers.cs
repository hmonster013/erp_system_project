using webapi.Dtos.DonDh;
using webapi.Dtos.TaiKhoan;
using webapi.Models;

namespace webapi.Controllers
{
    public static class DonDhMappers
    {
        public static DonDhDto ToDonDhDto(this DonDh donDhModel)
        {
            return new DonDhDto
            {
                MaDdh = donDhModel.MaDdh,
                MaKh = donDhModel.MaKh,
                NgayLap = donDhModel.NgayLap,
                NgayGiao = donDhModel.NgayGiao,
                TinhTrang = donDhModel.TinhTrang,
                MaNv = donDhModel.MaNv
            };
        }

        public static DonDh ToDonDhFormCreateDTO(this CreateDonDhRequestDto createDonDhRequestDto)
        {
            return new DonDh
            {
                MaDdh = createDonDhRequestDto.MaDdh,
                MaKh = createDonDhRequestDto.MaKh,
                NgayLap = createDonDhRequestDto.NgayLap,
                NgayGiao = createDonDhRequestDto.NgayGiao,
                TinhTrang = createDonDhRequestDto.TinhTrang,
                MaNv = createDonDhRequestDto.MaNv
            };
        }
    }
}
