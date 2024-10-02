
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using webapi.Dtos.NhaCungCap;
using webapi.Models;

namespace webapi.Controllers
{
    public static class NhaCungCapMappers
    {
        // Map từ NhaCungCap Model sang NhaCungCapDto
        public static NhaCungCapDto ToNhaCungCapDto(this NhaCungCap nhaCungCapModel)
        {
            return new NhaCungCapDto
            {
                MaNcc = nhaCungCapModel.MaNcc,
                TenNcc = nhaCungCapModel.TenNcc,
                Email = nhaCungCapModel.Email,
                Sdt = nhaCungCapModel.Sdt,
                DiaChi = nhaCungCapModel.DiaChi
            };
        }

        // Map từ CreateNhaCungCapRequestDto sang NhaCungCap Model
        public static NhaCungCap ToNhaCungCapFormCreateDTO(this CreateNhaCungCapRequestDto createNhaCungCapRequestDto)
        {
            return new NhaCungCap
            {
                MaNcc = createNhaCungCapRequestDto.MaNcc,
                TenNcc = createNhaCungCapRequestDto.TenNcc,
                Email = createNhaCungCapRequestDto.Email,
                Sdt = createNhaCungCapRequestDto.Sdt,
                DiaChi = createNhaCungCapRequestDto.DiaChi
            };
        }
    }
}