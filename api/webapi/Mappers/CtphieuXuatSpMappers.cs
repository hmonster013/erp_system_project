
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.CtphieuXuatSp;
using webapi.Models;

namespace webapi.Controllers
{
    public static class CtphieuXuatSpMappers
    {
        public static CtphieuXuatSpDto ToCtphieuXuatSpDto(this CtphieuXuatSp ctphieuXuatSpModel)
        {
            return new CtphieuXuatSpDto
            {
                MaPxsp = ctphieuXuatSpModel.MaPxsp,
                MaSp = ctphieuXuatSpModel.MaSp,
                SoLuong = ctphieuXuatSpModel.SoLuong
            };
        }

        public static CtphieuXuatSp ToCtphieuXuatSpFormCreateDTO(this CreateCtphieuXuatSpRequestDto createCtphieuXuatSpRequestDto)
        {
            return new CtphieuXuatSp
            {
                MaPxsp = createCtphieuXuatSpRequestDto.MaPxsp,
                MaSp = createCtphieuXuatSpRequestDto.MaSp,
                SoLuong = createCtphieuXuatSpRequestDto.SoLuong
            };
        }
    }
}