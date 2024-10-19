
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Models;
using webapi.Dtos;
using webapi.Dtos.PhieuYcsx;

namespace webapi.Controllers
{
    public static class PhieuYcsxMappers
    {
        public static PhieuYcsxDto ToPhieuYcsxDto(this PhieuYcsx phieuYcsxModel)
        {
            return new PhieuYcsxDto
            {
                MaYc = phieuYcsxModel.MaYc,
                NgayBd = phieuYcsxModel.NgayBd,
                NgayKt = phieuYcsxModel.NgayKt,
                VanBan = phieuYcsxModel.VanBan,
                MaNv = phieuYcsxModel.MaNv
            };
        }

        public static PhieuYcsx ToPhieuYcsxFromCreateDTO(this CreatePhieuYcsxRequestDto createPhieuYcsxRequestDto)
        {
            return new PhieuYcsx
            {
                MaYc = createPhieuYcsxRequestDto.MaYc,
                NgayBd = createPhieuYcsxRequestDto.NgayBd,
                NgayKt = createPhieuYcsxRequestDto.NgayKt,
                VanBan = createPhieuYcsxRequestDto.VanBan,
                MaNv = createPhieuYcsxRequestDto.MaNv
            };
        }
    }
}