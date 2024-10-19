
using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.AspNetCore.Mvc;
using System.Threading.Tasks;
using webapi.Dtos.CtPhieuYcsx;
using webapi.Data;

namespace webapi.Controllers
{
    [Route("api/ctphieuycsx")]
    [ApiController]
    public class CtphieuYcsxController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ICtphieuYcsxRepository _ctPhieuYcsxRepository;

        public CtphieuYcsxController(ApplicationDBContext context, ICtphieuYcsxRepository ctPhieuYcsxRepository)
        {
            _context = context;
            _ctPhieuYcsxRepository = ctPhieuYcsxRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var ctPhieuYcsxes = await _ctPhieuYcsxRepository.GetAllAsync();
            var ctPhieuycsxDtos = ctPhieuYcsxes.Select(x => x.ToCtPhieuYcsxDto());

            return Ok(ctPhieuycsxDtos);
        }
        
        [HttpGet]
        [Route("{MaYcsx}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaYcsx)
        {
            var ctPhieuYcsx = await _ctPhieuYcsxRepository.GetByIdAsync(MaYcsx);

            if (ctPhieuYcsx == null)
            {
                return NotFound();
            }

            return Ok(ctPhieuYcsx.ToCtPhieuYcsxDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateCtPhieuYcsxRequestDto createCtPhieuYcsxRequestDto)
        {
            var ctPhieuYcsxModel = createCtPhieuYcsxRequestDto.ToCtPhieuYcsxFromCreateDTO();
            await _ctPhieuYcsxRepository.CreateAsync(ctPhieuYcsxModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaYcsx = ctPhieuYcsxModel.MaYc }, ctPhieuYcsxModel.ToCtPhieuYcsxDto());
        }

        [HttpPut]
        [Route("{MaYcsx}")]
        public async Task<IActionResult> Update([FromRoute] string MaYcsx, [FromBody] UpdateCtPhieuYcsxDto updateCtPhieuYcsxDto)
        {
            var ctPhieuYcsxModel = await _ctPhieuYcsxRepository.UpdateAsync(MaYcsx, updateCtPhieuYcsxDto);

            if (ctPhieuYcsxModel == null)
            {
                return NotFound();
            }

            return Ok(ctPhieuYcsxModel.ToCtPhieuYcsxDto());
        }

        [HttpDelete]
        [Route("{MaYcsx}")]
        public async Task<IActionResult> Delete([FromRoute] string MaYcsx)
        {
            var ctPhieuYcsxModel = await _ctPhieuYcsxRepository.DeleteAsync(MaYcsx);

            if (ctPhieuYcsxModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }

        [HttpGet("search/{maYc}")]
        public async Task<IActionResult> GetByMaLoai([FromRoute] string maYc)
        {
            var ctPhieuYcsxes = await _ctPhieuYcsxRepository.GetByMaYcAsync(maYc);

            if (ctPhieuYcsxes == null || !ctPhieuYcsxes.Any())
            {
                return NotFound();
            }

            var ctPhieuYcsxDtos = ctPhieuYcsxes.Select(x => x.ToCtPhieuYcsxDto());
            return Ok(ctPhieuYcsxDtos);
        }
    }
}