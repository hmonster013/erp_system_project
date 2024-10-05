using System;
using webapi.Dtos.LoaiSp; // Đảm bảo có đúng namespace cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    public static class LoaiSpMapper
    {
        // Chuyển đổi từ mô hình LoaiSp sang LoaiSpDto
        public static LoaiSpDto ToLoaiSpDto(this LoaiSp loaiSpModel)
        {
            return new LoaiSpDto
            {
                MaLoai = loaiSpModel.MaLoai,
                TenLoai = loaiSpModel.TenLoai
            };
        }

        // Chuyển đổi từ CreateLoaiSpRequestDto sang mô hình LoaiSp
        public static LoaiSp ToLoaiSpFormCreateDTO(this CreateLoaiSpRequestDto createLoaiSpRequestDto)
        {
            return new LoaiSp
            {
                MaLoai = createLoaiSpRequestDto.MaLoai,
                TenLoai = createLoaiSpRequestDto.TenLoai
            };
        }
    }
}
