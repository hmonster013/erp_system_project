using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.CtphieuXuatSp;
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/ctphieuxuatsp")]
    [ApiController]
    public class CtphieuXuatSpController : ControllerBase
    {
        private readonly ICtphieuXuatSpRepository _ctphieuXuatSpRepository;

        public CtphieuXuatSpController(ICtphieuXuatSpRepository ctphieuXuatSpRepository)
        {
            _ctphieuXuatSpRepository = ctphieuXuatSpRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var ctphieuXuatSps = await _ctphieuXuatSpRepository.GetAllAsync();
            var ctphieuXuatSpDtos = ctphieuXuatSps.Select(x => x.ToCtphieuXuatSpDto());

            return Ok(ctphieuXuatSpDtos);
        }

        [HttpGet]
        [Route("{maPxsp}/{maSp}")]
        public async Task<IActionResult> GetDataById([FromRoute] string maPxsp, [FromRoute] string maSp)
        {
            var ctphieuXuatSp = await _ctphieuXuatSpRepository.GetByIdAsync(maPxsp, maSp);

            if (ctphieuXuatSp == null)
            {
                return NotFound();
            }

            return Ok(ctphieuXuatSp.ToCtphieuXuatSpDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateCtphieuXuatSpRequestDto createRequestDto)
        {
            var ctphieuXuatSpModel = createRequestDto.ToCtphieuXuatSpFormCreateDTO();
            await _ctphieuXuatSpRepository.CreateAsync(ctphieuXuatSpModel);

            return CreatedAtAction(nameof(GetDataById), new { maPxsp = ctphieuXuatSpModel.MaPxsp, maSp = ctphieuXuatSpModel.MaSp }, ctphieuXuatSpModel.ToCtphieuXuatSpDto());
        }

        [HttpPut]
        [Route("{maPxsp}/{maSp}")]
        public async Task<IActionResult> Update([FromRoute] string maPxsp, [FromRoute] string maSp, [FromBody] CtphieuXuatSp updateModel)
        {
            var updatedCtphieuXuatSp = await _ctphieuXuatSpRepository.UpdateAsync(maPxsp, maSp, updateModel);

            if (updatedCtphieuXuatSp == null)
            {
                return NotFound();
            }

            return Ok(updatedCtphieuXuatSp.ToCtphieuXuatSpDto());
        }

        [HttpDelete]
        [Route("{maPxsp}/{maSp}")]
        public async Task<IActionResult> Delete([FromRoute] string maPxsp, [FromRoute] string maSp)
        {
            var deletedCtphieuXuatSp = await _ctphieuXuatSpRepository.DeleteAsync(maPxsp, maSp);

            if (deletedCtphieuXuatSp == null)
            {
                return NotFound();
            }

            return NoContent();
        }
    }
}
