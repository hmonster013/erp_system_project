using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.CtphieuXuatNvl;
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/ctphieuxuatnvl")]
    [ApiController]
    public class CtphieuXuatNvlController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ICtphieuXuatNvlRepository _ctphieuXuatNvlRepository;

        public CtphieuXuatNvlController(ApplicationDBContext context, ICtphieuXuatNvlRepository ctphieuXuatNvlRepository)
        {
            _context = context;
            _ctphieuXuatNvlRepository = ctphieuXuatNvlRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var ctphieuXuatNvls = await _ctphieuXuatNvlRepository.GetAllAsync();
            var ctphieuXuatNvlDto = ctphieuXuatNvls.Select(x => x.ToCtphieuXuatNvlDto());

            return Ok(ctphieuXuatNvlDto);
        }

        [HttpGet]
        [Route("{MaPxnvl}/{MaNvl}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaPxnvl, [FromRoute] string MaNvl)
        {
            var ctphieuXuatNvl = await _ctphieuXuatNvlRepository.GetByIdAsync(MaPxnvl, MaNvl);

            if (ctphieuXuatNvl == null)
            {
                return NotFound();
            }

            return Ok(ctphieuXuatNvl.ToCtphieuXuatNvlDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateCtphieuXuatNvlRequestDto createCtphieuXuatNvlRequestDto)
        {
            var ctphieuXuatNvlModel = createCtphieuXuatNvlRequestDto.ToCtphieuXuatNvlFormCreateDTO();
            await _ctphieuXuatNvlRepository.CreateAsync(ctphieuXuatNvlModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaPxnvl = ctphieuXuatNvlModel.MaPxnvl, MaNvl = ctphieuXuatNvlModel.MaNvl }, ctphieuXuatNvlModel.ToCtphieuXuatNvlDto());
        }

        [HttpPut]
        [Route("{MaPxnvl}/{MaNvl}")]
        public async Task<IActionResult> Update([FromRoute] string MaPxnvl, [FromRoute] string MaNvl, [FromBody] UpdateCtphieuXuatNvlDto updateCtphieuXuatNvlDto)
        {
            var ctphieuXuatNvlModel = await _ctphieuXuatNvlRepository.UpdateAsync(MaPxnvl, MaNvl, updateCtphieuXuatNvlDto);

            if (ctphieuXuatNvlModel == null)
            {
                return NotFound();
            }

            return Ok(ctphieuXuatNvlModel.ToCtphieuXuatNvlDto());
        }

        [HttpDelete]
        [Route("{MaPxnvl}/{MaNvl}")]
        public async Task<IActionResult> Delete([FromRoute] string MaPxnvl, [FromRoute] string MaNvl)
        {
            var ctphieuXuatNvlModel = await _ctphieuXuatNvlRepository.DeleteAsync(MaPxnvl, MaNvl);

            if (ctphieuXuatNvlModel == null)
            {
                return NotFound();
            }

            return NoContent();
        }
    }
}
