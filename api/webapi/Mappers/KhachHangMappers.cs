using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.KhachHang;
using webapi.Models;

namespace webapi.Controllers
{
    public static class KhachHangMappers
    {
        public static KhachHangDto ToKhachHangDto(this KhachHang khachHangModel)
        {
            return new KhachHangDto
            {
                MaKh = khachHangModel.MaKh,
                TenKh = khachHangModel.TenKh,
                Email = khachHangModel.Email,
                Sdt = khachHangModel.Sdt,
                DiaChi = khachHangModel.DiaChi,
                MaLoaiKh = khachHangModel.MaLoaiKh
            };
        }

        public static KhachHang ToKhachHangFromCreateDTO(this CreateKhachHangRequestDto createKhachHangRequestDto)
        {
            return new KhachHang
            {
                MaKh = createKhachHangRequestDto.MaKh,
                TenKh = createKhachHangRequestDto.TenKh,
                Email = createKhachHangRequestDto.Email,
                Sdt = createKhachHangRequestDto.Sdt,
                DiaChi = createKhachHangRequestDto.DiaChi,
                MaLoaiKh = createKhachHangRequestDto.MaLoaiKh
            };
        }
    }
}
