using webapi.Dtos.CtphieuNhapSp;
using webapi.Dtos.PhieuNhapSp;
using webapi.Models;

namespace webapi.Controllers
{
    public static class CtphieuNhapSpMappers
    {
        public static CtphieuNhapSpDto ToCtphieuNhapSpDto(this CtphieuNhapSp ctphieuNhapSpModel)
        {
            return new CtphieuNhapSpDto
            {
                MaPnsp = ctphieuNhapSpModel.MaPnsp,
                SoLo = ctphieuNhapSpModel.SoLo
            };
        }

        public static CtphieuNhapSp ToCtphieuNhapSpFormCreateDTO(this CreateCtphieuNhapSpRequestDto createCtphieuNhapSpRequestDto)
        {
            return new CtphieuNhapSp
            {
                MaPnsp = createCtphieuNhapSpRequestDto.MaPnsp,
                SoLo = createCtphieuNhapSpRequestDto.SoLo
            };
        }
    } 
}
