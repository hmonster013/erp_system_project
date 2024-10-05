using webapi.Dtos.CtphieuNhapNvl;
using webapi.Dtos.PhieuNhapNvl;
using webapi.Models;

namespace webapi.Controllers
{
    public static class CtphieuNhapNvlMappers
    {
        public static CtphieuNhapNvlDto ToCtphieuNhapNvlDto(this CtphieuNhapNvl ctphieuNhapNvlModel)
        {
            return new CtphieuNhapNvlDto
            {
                MaPnnvl = ctphieuNhapNvlModel.MaPnnvl,
                MaNvl = ctphieuNhapNvlModel.MaNvl,
                Slnhap = ctphieuNhapNvlModel.Slnhap,
                Dvt = ctphieuNhapNvlModel.Dvt,
                GiaNhap = ctphieuNhapNvlModel.GiaNhap,
                Nsx = ctphieuNhapNvlModel.Nsx,
                Hsd = ctphieuNhapNvlModel.Hsd
            };
        }

        public static CtphieuNhapNvl ToCtphieuNhapNvlFormCreateDTO(this CreateCtphieuNhapNvlRequestDto createCtphieuNhapNvlRequestDto)
        {
            return new CtphieuNhapNvl
            {
                MaPnnvl = createCtphieuNhapNvlRequestDto.MaPnnvl,
                MaNvl = createCtphieuNhapNvlRequestDto.MaNvl,
                Slnhap = createCtphieuNhapNvlRequestDto.Slnhap,
                Dvt = createCtphieuNhapNvlRequestDto.Dvt,
                GiaNhap = createCtphieuNhapNvlRequestDto.GiaNhap,
                Nsx = createCtphieuNhapNvlRequestDto.Nsx,
                Hsd = createCtphieuNhapNvlRequestDto.Hsd
            };
        }
    }
}
