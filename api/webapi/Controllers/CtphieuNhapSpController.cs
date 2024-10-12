using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.CtphieuNhapSp; // Thêm không gian tên cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/ctphieunhapsp")]
    [ApiController]
    public class CtphieuNhapSpController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ICtphieuNhapSpRepository _ctphieuNhapSpRepository;

        public CtphieuNhapSpController(ApplicationDBContext context, ICtphieuNhapSpRepository ctphieuNhapSpRepository)
        {
            _context = context;
            _ctphieuNhapSpRepository = ctphieuNhapSpRepository;
        }

        [HttpGet]
        [Route("{MaPnsp}/{SoLo}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaPnsp, [FromRoute] string SoLo)
        {
            var ctphieuNhapSp = await _ctphieuNhapSpRepository.GetByIdAsync(MaPnsp, SoLo);

            if (ctphieuNhapSp == null)
            {
                return NotFound();
            }

            return Ok(ctphieuNhapSp.ToCtphieuNhapSpDto()); // Chuyển đổi sang DTO
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateCtphieuNhapSpRequestDto createCtphieuNhapSpRequestDto)
        {
            var ctphieuNhapSpModel = createCtphieuNhapSpRequestDto.ToCtphieuNhapSpFormCreateDTO(); // Chuyển đổi sang mô hình
            await _ctphieuNhapSpRepository.CreateAsync(ctphieuNhapSpModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaPnsp = ctphieuNhapSpModel.MaPnsp, Solo = ctphieuNhapSpModel.SoLo}, ctphieuNhapSpModel.ToCtphieuNhapSpDto()); // Chuyển đổi sang DTO
        }
    }
}
