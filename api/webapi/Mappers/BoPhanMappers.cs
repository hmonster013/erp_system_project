
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.BoPhan; // Đảm bảo không gian tên này đúng với DTO của bạn
using webapi.Models;

namespace webapi.Controllers
{
    public static class BoPhanMappers
    {
        public static BoPhanDto ToBoPhanDto(this BoPhan boPhanModel)
        {
            return new BoPhanDto
            {
                MaBp = boPhanModel.MaBp,
                TenBp = boPhanModel.TenBp,
                Sdt = boPhanModel.Sdt
            };
        }

        public static BoPhan ToBoPhanFormCreateDTO(this CreateBoPhanRequestDto createBoPhanRequestDto)
        {
            return new BoPhan
            {
                MaBp = createBoPhanRequestDto.MaBp,
                TenBp = createBoPhanRequestDto.TenBp,
                Sdt = createBoPhanRequestDto.Sdt
            };
        }
    }
}