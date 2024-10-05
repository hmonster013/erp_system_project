
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.TaiKhoan;
using webapi.Models;

namespace webapi.Controllers
{
    public static class ThongTinNhanVienMappers
    {
        public static ThongTinNhanVienDto ToThongTinNhanVienDto(this ThongTinNhanVien thongTinNhanVienModel)
        {
            return new ThongTinNhanVienDto
            {
                MaNv = thongTinNhanVienModel.MaNv,
                TenNv = thongTinNhanVienModel.TenNv,
                GioiTinh = thongTinNhanVienModel.GioiTinh,
                NgaySinh = thongTinNhanVienModel.NgaySinh,
                QueQuan = thongTinNhanVienModel.QueQuan,
                Sdt = thongTinNhanVienModel.Sdt,
                Tdhv = thongTinNhanVienModel.Tdhv
            };
        }

        public static ThongTinNhanVien ToThongTinNhanVienFormCreateDTO(this CreateThongTinNhanVienRequestDto createThongTinNhanVienRequestDto)
        {
            return new ThongTinNhanVien
            {
                MaNv = createThongTinNhanVienRequestDto.MaNv,
                TenNv = createThongTinNhanVienRequestDto.TenNv,
                GioiTinh = createThongTinNhanVienRequestDto.GioiTinh,
                NgaySinh = createThongTinNhanVienRequestDto.NgaySinh,
                QueQuan = createThongTinNhanVienRequestDto.QueQuan,
                Sdt = createThongTinNhanVienRequestDto.Sdt,
                Tdhv = createThongTinNhanVienRequestDto.Tdhv
            };
        }
    }
}