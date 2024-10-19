using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.LoSanPham;
using webapi.Models;

namespace webapi.Controllers
{
    public static class LoSanPhamMappers
    {
        public static LoSanPhamDto ToLoSanPhamDto(this LoSanPham loSanPhamModel)
        {
            return new LoSanPhamDto
            {
                SoLo = loSanPhamModel.SoLo,
                MaYc = loSanPhamModel.MaYc,
                MaSp = loSanPhamModel.MaSp,
                SoLuongSp = loSanPhamModel.SoLuongSp,
                Nsx = loSanPhamModel.Nsx,
                Hsd = loSanPhamModel.Hsd,
                TinhTrang = loSanPhamModel.TinhTrang
            };
        }

        public static LoSanPham ToLoSanPhamFromCreateDto(this CreateLoSanPhamRequestDto createLoSanPhamRequestDto)
        {
            return new LoSanPham
            {
                SoLo = createLoSanPhamRequestDto.SoLo,
                MaYc = createLoSanPhamRequestDto.MaYc,
                MaSp = createLoSanPhamRequestDto.MaSp,
                SoLuongSp = createLoSanPhamRequestDto.SoLuongSp,
                Nsx = createLoSanPhamRequestDto.Nsx,
                Hsd = createLoSanPhamRequestDto.Hsd,
                TinhTrang = createLoSanPhamRequestDto.TinhTrang
            };
        }
    }
}
