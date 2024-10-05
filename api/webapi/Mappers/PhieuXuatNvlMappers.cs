using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.PhieuXuatNvl;
using webapi.Models;

namespace webapi.Controllers
{
    public static class PhieuXuatNvlMappers
    {
        public static PhieuXuatNvlDto ToPhieuXuatNvlDto(this PhieuXuatNvl phieuXuatNvlModel)
        {
            return new PhieuXuatNvlDto
            {
                MaPxnvl = phieuXuatNvlModel.MaPxnvl,
                NgayXuat = phieuXuatNvlModel.NgayXuat,
                MaNv = phieuXuatNvlModel.MaNv
            };
        }

        public static PhieuXuatNvl ToPhieuXuatNvlFormCreateDTO(this CreatePhieuXuatNvlRequestDto createPhieuXuatNvlRequestDto)
        {
            return new PhieuXuatNvl
            {
                MaPxnvl = createPhieuXuatNvlRequestDto.MaPxnvl,
                NgayXuat = createPhieuXuatNvlRequestDto.NgayXuat,
                MaNv = createPhieuXuatNvlRequestDto.MaNv
            };
        }
    }
}
