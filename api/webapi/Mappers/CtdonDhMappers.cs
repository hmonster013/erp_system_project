using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.CtdonDh;
using webapi.Dtos.TaiKhoan;
using webapi.Models;

namespace webapi.Controllers
{
    public static class CtdonDhMappers
    {
        public static CtdonDhDto ToCtdonDhDto(this CtdonDh ctdonDhModel)
        {
            return new CtdonDhDto
            {
                MaDdh = ctdonDhModel.MaDdh,
                MaSp = ctdonDhModel.MaSp,
                SoLuong = ctdonDhModel.SoLuong
            };
        }

        public static CtdonDh ToCtdonDhFormCreateDTO(this CreateCtdonDhRequestDto createCtdonDhRequestDto)
        {
            return new CtdonDh
            {
                MaDdh = createCtdonDhRequestDto.MaDdh,
                MaSp = createCtdonDhRequestDto.MaSp,
                SoLuong = createCtdonDhRequestDto.SoLuong
            };
        }
    }
}
