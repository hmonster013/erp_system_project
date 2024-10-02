using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.PhieuNhapSp;
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/phieunhapsp")]
    [ApiController]
    public class PhieuNhapSpController : ControllerBase
    {
        private readonly IPhieuNhapSpRepository _phieuNhapSpRepository;

        public PhieuNhapSpController(IPhieuNhapSpRepository phieuNhapSpRepository)
        {
            _phieuNhapSpRepository = phieuNhapSpRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var phieuNhapSps = await _phieuNhapSpRepository.GetAllAsync();
            var phieuNhapSpDtos = phieuNhapSps.Select(x => new PhieuNhapSpDto
            {
                MaPnsp = x.MaPnsp,
                NgayNhap = x.NgayNhap,
                MaNv = x.MaNv
            });

            return Ok(phieuNhapSpDtos);
        }
        
        [HttpGet]
        [Route("{maPnsp}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string maPnsp)
        {
            var phieuNhapSp = await _phieuNhapSpRepository.GetByIdAsync(maPnsp);

            if (phieuNhapSp == null)
            {
                return NotFound();
            }

            return Ok(new PhieuNhapSpDto
            {
                MaPnsp = phieuNhapSp.MaPnsp,
                NgayNhap = phieuNhapSp.NgayNhap,
                MaNv = phieuNhapSp.MaNv
            });
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreatePhieuNhapSpRequestDto createPhieuNhapSpRequestDto)
        {
            var phieuNhapSpModel = new PhieuNhapSp
            {
                MaPnsp = createPhieuNhapSpRequestDto.MaPnsp,
                NgayNhap = createPhieuNhapSpRequestDto.NgayNhap,
                MaNv = createPhieuNhapSpRequestDto.MaNv
            };

            await _phieuNhapSpRepository.CreateAsync(phieuNhapSpModel);

            return CreatedAtAction(nameof(GetDataByID), new { maPnsp = phieuNhapSpModel.MaPnsp }, new PhieuNhapSpDto
            {
                MaPnsp = phieuNhapSpModel.MaPnsp,
                NgayNhap = phieuNhapSpModel.NgayNhap,
                MaNv = phieuNhapSpModel.MaNv
            });
        }

        [HttpPut]
        [Route("{maPnsp}")]
        public async Task<IActionResult> Update([FromRoute] string maPnsp, [FromBody] UpdatePhieuNhapSpDto updatePhieuNhapSpDto)
        {
            var phieuNhapSpModel = await _phieuNhapSpRepository.UpdateAsync(maPnsp, updatePhieuNhapSpDto);

            if (phieuNhapSpModel == null)
            {
                return NotFound();
            }

            return Ok(new PhieuNhapSpDto
            {
                MaPnsp = phieuNhapSpModel.MaPnsp,
                NgayNhap = phieuNhapSpModel.NgayNhap,
                MaNv = phieuNhapSpModel.MaNv
            });
        }

        [HttpDelete]
        [Route("{maPnsp}")]
        public async Task<IActionResult> Delete([FromRoute] string maPnsp)
        {
            var phieuNhapSpModel = await _phieuNhapSpRepository.DeleteAsync(maPnsp);

            if (phieuNhapSpModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}
