
using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using webapi.Data;
using webapi.Dtos.PhieuNghiemThu; // Thêm không gian tên cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/phieunghiemthu")]
    [ApiController]
    public class PhieuNghiemThuController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly IPhieuNghiemThuRepository _phieuNghiemThuRepository;

        public PhieuNghiemThuController(ApplicationDBContext context, IPhieuNghiemThuRepository phieuNghiemThuRepository)
        {
            _context = context;
            _phieuNghiemThuRepository = phieuNghiemThuRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var phieuNghiemThus = await _phieuNghiemThuRepository.GetAllAsync();
            var phieuNghiemThuDtos = phieuNghiemThus.Select(x => x.ToPhieuNghiemThuDto()); // Chuyển đổi sang DTO

            return Ok(phieuNghiemThuDtos);
        }

        [HttpGet]
        [Route("{MaPnt}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaPnt)
        {
            var phieuNghiemThu = await _phieuNghiemThuRepository.GetByIdAsync(MaPnt);

            if (phieuNghiemThu == null)
            {
                return NotFound();
            }

            return Ok(phieuNghiemThu.ToPhieuNghiemThuDto()); // Chuyển đổi sang DTO
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreatePhieuNghiemThuRequestDto createPhieuNghiemThuRequestDto)
        {
            var phieuNghiemThuModel = createPhieuNghiemThuRequestDto.ToPhieuNghiemThuFormCreateDTO(); // Chuyển đổi sang mô hình
            await _phieuNghiemThuRepository.CreateAsync(phieuNghiemThuModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaPnt = phieuNghiemThuModel.MaPnt }, phieuNghiemThuModel.ToPhieuNghiemThuDto()); // Chuyển đổi sang DTO
        }
    }
}