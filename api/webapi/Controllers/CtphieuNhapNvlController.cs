using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.CtphieuNhapNvl; // Thêm không gian tên cho DTO
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/ctphieunhapnvl")]
    [ApiController]
    public class CtphieuNhapNvlController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ICtphieuNhapNvlRepository _ctphieuNhapNvlRepository;

        public CtphieuNhapNvlController(ApplicationDBContext context, ICtphieuNhapNvlRepository ctphieuNhapNvlRepository)
        {
            _context = context;
            _ctphieuNhapNvlRepository = ctphieuNhapNvlRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var ctphieuNhapNvls = await _ctphieuNhapNvlRepository.GetAllAsync();
            var ctphieuNhapNvlDtos = ctphieuNhapNvls.Select(x => x.ToCtphieuNhapNvlDto()); // Chuyển đổi sang DTO

            return Ok(ctphieuNhapNvlDtos);
        }

        [HttpGet]
        [Route("{MaPnnvl}/{MaNvl}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaPnnvl, [FromRoute] string MaNvl)
        {
            var ctphieuNhapNvl = await _ctphieuNhapNvlRepository.GetByIdAsync(MaPnnvl, MaNvl);

            if (ctphieuNhapNvl == null)
            {
                return NotFound();
            }

            return Ok(ctphieuNhapNvl.ToCtphieuNhapNvlDto()); // Chuyển đổi sang DTO
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateCtphieuNhapNvlRequestDto createCtphieuNhapNvlRequestDto)
        {
            var ctphieuNhapNvlModel = createCtphieuNhapNvlRequestDto.ToCtphieuNhapNvlFormCreateDTO(); // Chuyển đổi sang mô hình
            await _ctphieuNhapNvlRepository.CreateAsync(ctphieuNhapNvlModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaPnnvl = ctphieuNhapNvlModel.MaPnnvl, MaNvl = ctphieuNhapNvlModel.MaNvl }, ctphieuNhapNvlModel.ToCtphieuNhapNvlDto()); // Chuyển đổi sang DTO
        }

        [HttpPut]
        [Route("{MaPnnvl}/{MaNvl}")]
        public async Task<IActionResult> Update([FromRoute] string MaPnnvl, [FromRoute] string MaNvl, [FromBody] UpdateCtphieuNhapNvlDto updateCtphieuNhapNvlDto)
        {
            var ctphieuNhapNvlModel = await _ctphieuNhapNvlRepository.UpdateAsync(MaPnnvl, MaNvl, updateCtphieuNhapNvlDto);

            if (ctphieuNhapNvlModel == null)
            {
                return NotFound();
            }

            return Ok(ctphieuNhapNvlModel.ToCtphieuNhapNvlDto()); // Chuyển đổi sang DTO
        }

        [HttpDelete]
        [Route("{MaPnnvl}/{MaNvl}")]
        public async Task<IActionResult> Delete([FromRoute] string MaPnnvl, [FromRoute] string MaNvl)
        {
            var ctphieuNhapNvlModel = await _ctphieuNhapNvlRepository.DeleteAsync(MaPnnvl, MaNvl);

            if (ctphieuNhapNvlModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}
