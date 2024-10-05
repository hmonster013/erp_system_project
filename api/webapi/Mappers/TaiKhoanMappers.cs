using webapi.Dtos.TaiKhoan;
using webapi.Models;

namespace webapi.Controllers
{
    public static class TaiKhoanMappers
    {
        public static TaiKhoanDto ToTaiKhoanDto(this TaiKhoan taiKhoanModel)
        {
            return new TaiKhoanDto
            {
                Username = taiKhoanModel.Username,
                Password = taiKhoanModel.Password,
                MaNv = taiKhoanModel.MaNv
            };
        }

        public static TaiKhoan ToTaiKhoanFormCreateDTO(this CreateTaiKhoanRequestDto createTaiKhoanRequestDto)
        {
            return new TaiKhoan
            {
                Username = createTaiKhoanRequestDto.Username,
                Password = createTaiKhoanRequestDto.Password,
                MaNv = createTaiKhoanRequestDto.MaNv
            };
        }
    }
}
