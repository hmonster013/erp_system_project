
using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using webapi.Data;
using webapi.Dtos.CtphieuNghiemThu; // Thêm không gian tên cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/ctphieunghiemthu")]
    [ApiController]
    public class CtphieuNghiemThuController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ICtphieuNghiemThuRepository _ctphieuNghiemThuRepository;

        public CtphieuNghiemThuController(ApplicationDBContext context, ICtphieuNghiemThuRepository ctphieuNghiemThuRepository)
        {
            _context = context;
            _ctphieuNghiemThuRepository = ctphieuNghiemThuRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var ctphieuNghiemThus = await _ctphieuNghiemThuRepository.GetAllAsync();
            var ctphieuNghiemThuDtos = ctphieuNghiemThus.Select(x => x.ToCtphieuNghiemThuDto()); // Chuyển đổi sang DTO

            return Ok(ctphieuNghiemThuDtos);
        }

        [HttpGet]
        [Route("{MaPnt}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaPnt)
        {
            var ctphieuNghiemThu = await _ctphieuNghiemThuRepository.GetByIdAsync(MaPnt);

            var ctphieuNghiemThuDtos = ctphieuNghiemThu.Select(x => x.ToCtphieuNghiemThuDto());

            return Ok(ctphieuNghiemThuDtos); // Chuyển đổi sang DTO
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateCtphieuNghiemThuRequestDto createCtphieuNghiemThuRequestDto)
        {
            var ctphieuNghiemThuModel = createCtphieuNghiemThuRequestDto.ToCtphieuNghiemThuFormCreateDTO(); // Chuyển đổi sang mô hình
            await _ctphieuNghiemThuRepository.CreateAsync(ctphieuNghiemThuModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaPnt = ctphieuNghiemThuModel.MaPnt }, ctphieuNghiemThuModel.ToCtphieuNghiemThuDto()); // Chuyển đổi sang DTO
        }

    }
}