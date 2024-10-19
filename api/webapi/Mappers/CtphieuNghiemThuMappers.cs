
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.CtphieuNghiemThu;
using webapi.Models;

namespace webapi.Controllers
{
    public static class CtphieuNghiemThuMappers
    {
        public static CtphieuNghiemThuDto ToCtphieuNghiemThuDto(this CtphieuNghiemThu ctphieuNghiemThuModel)
        {
            return new CtphieuNghiemThuDto
            {
                MaPnt = ctphieuNghiemThuModel.MaPnt,
                SoLo = ctphieuNghiemThuModel.SoLo,
                KetQuaNt = ctphieuNghiemThuModel.KetQuaNt
            };
        }

        public static CtphieuNghiemThu ToCtphieuNghiemThuFormCreateDTO(this CreateCtphieuNghiemThuRequestDto createCtphieuNghiemThuRequestDto)
        {
            return new CtphieuNghiemThu
            {
                MaPnt = createCtphieuNghiemThuRequestDto.MaPnt,
                SoLo = createCtphieuNghiemThuRequestDto.SoLo,
                KetQuaNt = createCtphieuNghiemThuRequestDto.KetQuaNt
            };
        }
    }
}