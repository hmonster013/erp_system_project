using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.NguyenVatLieu;
using webapi.Models;

namespace webapi.Controllers
{
    public static class NguyenVatLieuMappers
    {
        public static NguyenVatLieuDto ToNguyenVatLieuDto(this NguyenVatLieu nguyenVatLieuModel)
        {
            return new NguyenVatLieuDto
            {
                MaNvl = nguyenVatLieuModel.MaNvl,
                TenNvl = nguyenVatLieuModel.TenNvl,
                GhiChu = nguyenVatLieuModel.GhiChu,
                SoLuongTon = nguyenVatLieuModel.SoLuongTon
            };
        }

        public static NguyenVatLieu ToNguyenVatLieuFormCreateDto(this CreateNguyenVatLieuRequestDto createNguyenVatLieuRequestDto)
        {
            return new NguyenVatLieu
            {
                MaNvl = createNguyenVatLieuRequestDto.MaNvl,
                TenNvl = createNguyenVatLieuRequestDto.TenNvl,
                GhiChu = createNguyenVatLieuRequestDto.GhiChu,
                SoLuongTon = createNguyenVatLieuRequestDto.SoLuongTon
            };
        }
    }
}