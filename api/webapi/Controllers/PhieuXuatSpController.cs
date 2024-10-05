using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.PhieuXuatSp;

namespace webapi.Controllers
{
    [Route("api/phieuxuatsp")]
    [ApiController]
    public class PhieuXuatSpController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly IPhieuXuatSpRepository _phieuXuatSpRepository;

        public PhieuXuatSpController(ApplicationDBContext context, IPhieuXuatSpRepository phieuXuatSpRepository)
        {
            _context = context;
            _phieuXuatSpRepository = phieuXuatSpRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var phieuXuatSps = await _phieuXuatSpRepository.GetAllAsync();
            var phieuXuatSpDtos = phieuXuatSps.Select(x => x.ToPhieuXuatSpDto());

            return Ok(phieuXuatSpDtos);
        }
        
        [HttpGet]
        [Route("{MaPxsp}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaPxsp)
        {
            var phieuXuatSp = await _phieuXuatSpRepository.GetByIdAsync(MaPxsp);

            if (phieuXuatSp == null)
            {
                return NotFound();
            }

            return Ok(phieuXuatSp.ToPhieuXuatSpDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreatePhieuXuatSpRequestDto createPhieuXuatSpRequestDto)
        {
            var phieuXuatSpModel = createPhieuXuatSpRequestDto.ToPhieuXuatSpFromCreateDTO();
            await _phieuXuatSpRepository.CreateAsync(phieuXuatSpModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaPxsp = phieuXuatSpModel.MaPxsp }, phieuXuatSpModel.ToPhieuXuatSpDto());
        }

        [HttpPut]
        [Route("{MaPxsp}")]
        public async Task<IActionResult> Update([FromRoute] string MaPxsp, [FromBody] UpdatePhieuXuatSpDto updatePhieuXuatSpDto)
        {
            var phieuXuatSpModel = await _phieuXuatSpRepository.UpdateAsync(MaPxsp, updatePhieuXuatSpDto);

            if (phieuXuatSpModel == null)
            {
                return NotFound();
            }

            return Ok(phieuXuatSpModel.ToPhieuXuatSpDto());
        }

        [HttpDelete]
        [Route("{MaPxsp}")]
        public async Task<IActionResult> Delete([FromRoute] string MaPxsp)
        {
            var phieuXuatSpModel = await _phieuXuatSpRepository.DeleteAsync(MaPxsp);

            if (phieuXuatSpModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}
