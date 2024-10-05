using System;
using webapi.Dtos.PhieuNhapSp;
using webapi.Models;

namespace webapi.Controllers
{
    public static class PhieuNhapSpMappers
    {
        // Chuyển đổi từ PhieuNhapSp sang PhieuNhapSpDto
        public static PhieuNhapSpDto ToPhieuNhapSpDto(this PhieuNhapSp phieuNhapSpModel)
        {
            return new PhieuNhapSpDto
            {
                MaPnsp = phieuNhapSpModel.MaPnsp,
                NgayNhap = phieuNhapSpModel.NgayNhap,
                MaNv = phieuNhapSpModel.MaNv
            };
        }

        // Chuyển đổi từ CreatePhieuNhapSpRequestDto sang PhieuNhapSp
        public static PhieuNhapSp ToPhieuNhapSpFormCreateDTO(this CreatePhieuNhapSpRequestDto createPhieuNhapSpRequestDto)
        {
            return new PhieuNhapSp
            {
                MaPnsp = createPhieuNhapSpRequestDto.MaPnsp,
                NgayNhap = createPhieuNhapSpRequestDto.NgayNhap,
                MaNv = createPhieuNhapSpRequestDto.MaNv
            };
        }
    }
}
