
using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using webapi.Dtos.PhieuYcsx;
using webapi.Data;

namespace webapi.Controllers
{
    [Route("api/phieuycsx")]
    [ApiController]
    public class PhieuYcsxController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly IPhieuYcsxRepository _phieuYcsxRepository;

        public PhieuYcsxController(ApplicationDBContext context, IPhieuYcsxRepository phieuYcsxRepository)
        {
            _context = context;
            _phieuYcsxRepository = phieuYcsxRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var phieuYcsxes = await _phieuYcsxRepository.GetAllAsync();
            var phieuycsxDtos = phieuYcsxes.Select(x => x.ToPhieuYcsxDto());

            return Ok(phieuycsxDtos);
        }
        
        [HttpGet]
        [Route("{MaYcsx}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaYcsx)
        {
            var phieuYcsx = await _phieuYcsxRepository.GetByIdAsync(MaYcsx);

            if (phieuYcsx == null)
            {
                return NotFound();
            }

            return Ok(phieuYcsx.ToPhieuYcsxDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreatePhieuYcsxRequestDto createPhieuYcsxRequestDto)
        {
            var phieuYcsxModel = createPhieuYcsxRequestDto.ToPhieuYcsxFromCreateDTO();
            await _phieuYcsxRepository.CreateAsync(phieuYcsxModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaYcsx = phieuYcsxModel.MaYc }, phieuYcsxModel.ToPhieuYcsxDto());
        }

        [HttpPut]
        [Route("{MaYcsx}")]
        public async Task<IActionResult> Update([FromRoute] string MaYcsx, [FromBody] UpdatePhieuYcsxDto updatePhieuYcsxDto)
        {
            var phieuYcsxModel = await _phieuYcsxRepository.UpdateAsync(MaYcsx, updatePhieuYcsxDto);

            if (phieuYcsxModel == null)
            {
                return NotFound();
            }

            return Ok(phieuYcsxModel.ToPhieuYcsxDto());
        }

        [HttpDelete]
        [Route("{MaYcsx}")]
        public async Task<IActionResult> Delete([FromRoute] string MaYcsx)
        {
            var phieuYcsxModel = await _phieuYcsxRepository.DeleteAsync(MaYcsx);

            if (phieuYcsxModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}