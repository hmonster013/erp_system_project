using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.CtphieuXuatNvl;
using webapi.Models;

namespace webapi.Controllers
{
    public static class CtphieuXuatNvlMappers
    {
        public static CtphieuXuatNvlDto ToCtphieuXuatNvlDto(this CtphieuXuatNvl ctphieuXuatNvlModel)
        {
            return new CtphieuXuatNvlDto
            {
                MaPxnvl = ctphieuXuatNvlModel.MaPxnvl,
                MaNvl = ctphieuXuatNvlModel.MaNvl,
                SoLuong = ctphieuXuatNvlModel.SoLuong
            };
        }

        public static CtphieuXuatNvl ToCtphieuXuatNvlFormCreateDTO(this CreateCtphieuXuatNvlRequestDto createCtphieuXuatNvlRequestDto)
        {
            return new CtphieuXuatNvl
            {
                MaPxnvl = createCtphieuXuatNvlRequestDto.MaPxnvl,
                MaNvl = createCtphieuXuatNvlRequestDto.MaNvl,
                SoLuong = createCtphieuXuatNvlRequestDto.SoLuong
            };
        }
    }
}
