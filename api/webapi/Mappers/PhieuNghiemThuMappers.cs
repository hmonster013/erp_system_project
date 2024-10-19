
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.PhieuNghiemThu;
using webapi.Models;

namespace webapi.Controllers
{
    public static class PhieuNghiemThuMappers
    {
        public static PhieuNghiemThuDto ToPhieuNghiemThuDto(this PhieuNghiemThu phieuNghiemThuModel)
        {
            return new PhieuNghiemThuDto
            {
                MaPnt = phieuNghiemThuModel.MaPnt,
                MaYc = phieuNghiemThuModel.MaYc,
                NgayNt = phieuNghiemThuModel.NgayNt,
                VanBan = phieuNghiemThuModel.VanBan,
                MaNv = phieuNghiemThuModel.MaNv
            };
        }

        public static PhieuNghiemThu ToPhieuNghiemThuFormCreateDTO(this CreatePhieuNghiemThuRequestDto createPhieuNghiemThuRequestDto)
        {
            return new PhieuNghiemThu
            {
                MaPnt = createPhieuNghiemThuRequestDto.MaPnt,
                MaYc = createPhieuNghiemThuRequestDto.MaYc,
                NgayNt = createPhieuNghiemThuRequestDto.NgayNt,
                VanBan = createPhieuNghiemThuRequestDto.VanBan,
                MaNv = createPhieuNghiemThuRequestDto.MaNv
            };
        }
    }
}