using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.SanPham; // Đảm bảo có đúng namespace cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    public static class SanPhamMappers
    {
        public static SanPhamDto ToSanPhamDto(this SanPham sanPhamModel)
        {
            return new SanPhamDto
            {
                MaSp = sanPhamModel.MaSp,
                MaLoai = sanPhamModel.MaLoai,
                TenSp = sanPhamModel.TenSp,
                GiaBan = sanPhamModel.GiaBan,
                ThanhPhan = sanPhamModel.ThanhPhan,
                Klt = sanPhamModel.Klt,
                SoLuongTon = sanPhamModel.SoLuongTon
            };
        }

        public static SanPham ToSanPhamFormCreateDTO(this CreateSanPhamRequestDto createSanPhamRequestDto)
        {
            return new SanPham
            {
                MaSp = createSanPhamRequestDto.MaSp,
                MaLoai = createSanPhamRequestDto.MaLoai,
                TenSp = createSanPhamRequestDto.TenSp,
                GiaBan = createSanPhamRequestDto.GiaBan,
                ThanhPhan = createSanPhamRequestDto.ThanhPhan,
                Klt = createSanPhamRequestDto.Klt,
                SoLuongTon = createSanPhamRequestDto.SoLuongTon
            };
        }
    }
}
