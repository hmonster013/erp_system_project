using System;
using webapi.Models;
using webapi.Dtos;
using webapi.Dtos.PhieuNhapNvl;

namespace webapi.Controllers
{
    public static class PhieuNhapNvlMappers
    {
        public static PhieuNhapNvlDto ToPhieuNhapNvlDto(this PhieuNhapNvl phieuNhapNvlModel)
        {
            return new PhieuNhapNvlDto
            {
                MaPnnvl = phieuNhapNvlModel.MaPnnvl,
                MaYc = phieuNhapNvlModel.MaYc,
                MaNcc = phieuNhapNvlModel.MaNcc,
                NgayNhap = phieuNhapNvlModel.NgayNhap,
                MaNv = phieuNhapNvlModel.MaNv,
                PhanLoai = phieuNhapNvlModel.PhanLoai
            };
        }

        public static PhieuNhapNvl ToPhieuNhapNvlFromCreateDTO(this CreatePhieuNhapNvlRequestDto createPhieuNhapNvlRequestDto)
        {
            return new PhieuNhapNvl
            {
                MaPnnvl = createPhieuNhapNvlRequestDto.MaPnnvl,
                MaYc = createPhieuNhapNvlRequestDto.MaYc,
                MaNcc = createPhieuNhapNvlRequestDto.MaNcc,
                NgayNhap = createPhieuNhapNvlRequestDto.NgayNhap,
                MaNv = createPhieuNhapNvlRequestDto.MaNv,
                PhanLoai = createPhieuNhapNvlRequestDto.PhanLoai
            };
        }
    }
}
