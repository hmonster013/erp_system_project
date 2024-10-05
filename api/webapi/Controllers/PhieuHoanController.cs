using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.PhieuHoan;
using webapi.Dtos.TaiKhoan; // Điều chỉnh namespace nếu cần
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/phieuhoan")]
    [ApiController]
    public class PhieuHoanController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly IPhieuHoanRepository _phieuHoanRepository;

        public PhieuHoanController(ApplicationDBContext context, IPhieuHoanRepository phieuHoanRepository)
        {
            _context = context;
            _phieuHoanRepository = phieuHoanRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var phieuHoans = await _phieuHoanRepository.GetAllAsync();
            var phieuHoanDtos = phieuHoans.Select(x => x.ToPhieuHoanDto()); // Thay đổi phương thức chuyển đổi nếu cần

            return Ok(phieuHoanDtos);
        }
        
        [HttpGet]
        [Route("{MaPh}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaPh)
        {
            var phieuHoan = await _phieuHoanRepository.GetByIdAsync(MaPh);

            if (phieuHoan == null)
            {
                return NotFound();
            }

            return Ok(phieuHoan.ToPhieuHoanDto()); // Thay đổi phương thức chuyển đổi nếu cần
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreatePhieuHoanRequestDto createPhieuHoanRequestDto)
        {
            var phieuHoanModel = createPhieuHoanRequestDto.ToPhieuHoanFormCreateDTO(); // Thay đổi phương thức chuyển đổi nếu cần
            await _phieuHoanRepository.CreateAsync(phieuHoanModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaPh = phieuHoanModel.MaPh }, phieuHoanModel.ToPhieuHoanDto()); // Thay đổi phương thức chuyển đổi nếu cần
        }

        [HttpPut]
        [Route("{MaPh}")]
        public async Task<IActionResult> Update([FromRoute] string MaPh, [FromBody] UpdatePhieuHoanDto updatePhieuHoanDto)
        {
            var phieuHoanModel = await _phieuHoanRepository.UpdateAsync(MaPh, updatePhieuHoanDto);

            if (phieuHoanModel == null)
            {
                return NotFound();
            }

            return Ok(phieuHoanModel.ToPhieuHoanDto()); // Thay đổi phương thức chuyển đổi nếu cần
        }

        [HttpDelete]
        [Route("{MaPh}")]
        public async Task<IActionResult> Delete([FromRoute] string MaPh)
        {
            var phieuHoanModel = await _phieuHoanRepository.DeleteAsync(MaPh);

            if (phieuHoanModel == null)
            {
                return NotFound();
            }

            return NoContent();
        }
    }
}
