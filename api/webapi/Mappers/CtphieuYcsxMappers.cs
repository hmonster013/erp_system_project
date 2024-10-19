
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Models;
using webapi.Dtos;
using webapi.Dtos.CtPhieuYcsx;

namespace webapi.Controllers
{
    public static class CtphieuYcsxMappers
    {
        public static CtPhieuYcsxDto ToCtPhieuYcsxDto(this CtphieuYcsx ctPhieuYcsxModel)
        {
            return new CtPhieuYcsxDto
            {
                MaYc = ctPhieuYcsxModel.MaYc,
                MaSp = ctPhieuYcsxModel.MaSp,
                SoLuongSx = ctPhieuYcsxModel.SoLuongSx
            };
        }

        public static CtphieuYcsx ToCtPhieuYcsxFromCreateDTO(this CreateCtPhieuYcsxRequestDto createCtPhieuYcsxRequestDto)
        {
            return new CtphieuYcsx
            {
                MaYc = createCtPhieuYcsxRequestDto.MaYc,
                MaSp = createCtPhieuYcsxRequestDto.MaSp,
                SoLuongSx = createCtPhieuYcsxRequestDto.SoLuongSx
            };
        }
    }
}