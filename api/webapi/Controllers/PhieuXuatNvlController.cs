using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.PhieuXuatNvl;
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/phieuxuatnvl")]
    [ApiController]
    public class PhieuXuatNvlController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly IPhieuXuatNvlRepository _phieuXuatNvlRepository;

        public PhieuXuatNvlController(ApplicationDBContext context, IPhieuXuatNvlRepository phieuXuatNvlRepository)
        {
            _context = context;
            _phieuXuatNvlRepository = phieuXuatNvlRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var phieuXuatNvls = await _phieuXuatNvlRepository.GetAllAsync();
            var phieuXuatNvlDtos = phieuXuatNvls.Select(x => x.ToPhieuXuatNvlDto());

            return Ok(phieuXuatNvlDtos);
        }
        
        [HttpGet]
        [Route("{MaPxnvl}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaPxnvl)
        {
            var phieuXuatNvl = await _phieuXuatNvlRepository.GetByIdAsync(MaPxnvl);

            if (phieuXuatNvl == null)
            {
                return NotFound();
            }

            return Ok(phieuXuatNvl.ToPhieuXuatNvlDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreatePhieuXuatNvlRequestDto createPhieuXuatNvlRequestDto)
        {
            var phieuXuatNvlModel = createPhieuXuatNvlRequestDto.ToPhieuXuatNvlFormCreateDTO();
            await _phieuXuatNvlRepository.CreateAsync(phieuXuatNvlModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaPxnvl = phieuXuatNvlModel.MaPxnvl }, phieuXuatNvlModel.ToPhieuXuatNvlDto());
        }

        [HttpPut]
        [Route("{MaPxnvl}")]
        public async Task<IActionResult> Update([FromRoute] string MaPxnvl, [FromBody] UpdatePhieuXuatNvlDto updatePhieuXuatNvlDto)
        {
            var phieuXuatNvlModel = await _phieuXuatNvlRepository.UpdateAsync(MaPxnvl, updatePhieuXuatNvlDto);

            if (phieuXuatNvlModel == null)
            {
                return NotFound();
            }

            return Ok(phieuXuatNvlModel.ToPhieuXuatNvlDto());
        }

        [HttpDelete]
        [Route("{MaPxnvl}")]
        public async Task<IActionResult> Delete([FromRoute] string MaPxnvl)
        {
            var phieuXuatNvlModel = await _phieuXuatNvlRepository.DeleteAsync(MaPxnvl);

            if (phieuXuatNvlModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}
