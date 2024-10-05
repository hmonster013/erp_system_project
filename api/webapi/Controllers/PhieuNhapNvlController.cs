using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.PhieuNhapNvl;
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/phieunhapnvl")]
    [ApiController]
    public class PhieuNhapNvlController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly IPhieuNhapNvlRepository _phieuNhapNvlRepository;

        public PhieuNhapNvlController(ApplicationDBContext context, IPhieuNhapNvlRepository phieuNhapNvlRepository)
        {
            _context = context;
            _phieuNhapNvlRepository = phieuNhapNvlRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var phieuNhapNvls = await _phieuNhapNvlRepository.GetAllAsync();
            var phieuNhapNvlDtos = phieuNhapNvls.Select(x => x.ToPhieuNhapNvlDto());

            return Ok(phieuNhapNvlDtos);
        }

        [HttpGet("{MaPnnvl}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaPnnvl)
        {
            var phieuNhapNvl = await _phieuNhapNvlRepository.GetByIdAsync(MaPnnvl);

            if (phieuNhapNvl == null)
            {
                return NotFound();
            }

            return Ok(phieuNhapNvl.ToPhieuNhapNvlDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreatePhieuNhapNvlRequestDto createPhieuNhapNvlRequestDto)
        {
            var phieuNhapNvlModel = createPhieuNhapNvlRequestDto.ToPhieuNhapNvlFromCreateDTO();
            await _phieuNhapNvlRepository.CreateAsync(phieuNhapNvlModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaPnnvl = phieuNhapNvlModel.MaPnnvl }, phieuNhapNvlModel.ToPhieuNhapNvlDto());
        }

        [HttpPut("{MaPnnvl}")]
        public async Task<IActionResult> Update([FromRoute] string MaPnnvl, [FromBody] UpdatePhieuNhapNvlDto updatePhieuNhapNvlDto)
        {
            var phieuNhapNvlModel = await _phieuNhapNvlRepository.UpdateAsync(MaPnnvl, updatePhieuNhapNvlDto);

            if (phieuNhapNvlModel == null)
            {
                return NotFound();
            }

            return Ok(phieuNhapNvlModel.ToPhieuNhapNvlDto());
        }

        [HttpDelete("{MaPnnvl}")]
        public async Task<IActionResult> Delete([FromRoute] string MaPnnvl)
        {
            var phieuNhapNvlModel = await _phieuNhapNvlRepository.DeleteAsync(MaPnnvl);

            if (phieuNhapNvlModel == null)
            {
                return NotFound();
            }

            return NoContent();
        }
    }
}
