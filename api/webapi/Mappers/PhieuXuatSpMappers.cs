using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.PhieuXuatSp;
using webapi.Models;

namespace webapi.Controllers
{
    public static class PhieuXuatSpMappers
    {
        public static PhieuXuatSpDto ToPhieuXuatSpDto(this PhieuXuatSp phieuXuatSpModel)
        {
            return new PhieuXuatSpDto
            {
                MaPxsp = phieuXuatSpModel.MaPxsp,
                MaDdh = phieuXuatSpModel.MaDdh,
                NgayXuat = phieuXuatSpModel.NgayXuat,
                MaNv = phieuXuatSpModel.MaNv
            };
        }

        public static PhieuXuatSp ToPhieuXuatSpFromCreateDTO(this CreatePhieuXuatSpRequestDto createPhieuXuatSpRequestDto)
        {
            return new PhieuXuatSp
            {
                MaPxsp = createPhieuXuatSpRequestDto.MaPxsp,
                MaDdh = createPhieuXuatSpRequestDto.MaDdh,
                NgayXuat = createPhieuXuatSpRequestDto.NgayXuat,
                MaNv = createPhieuXuatSpRequestDto.MaNv
            };
        }
    }
}
