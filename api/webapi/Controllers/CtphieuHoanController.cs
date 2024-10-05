using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.CtphieuHoan;
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/ctphieuhoan")]
    [ApiController]
    public class CtphieuHoanController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ICtphieuHoanRepository _ctphieuHoanRepository;

        public CtphieuHoanController(ApplicationDBContext context, ICtphieuHoanRepository ctphieuHoanRepository)
        {
            _context = context;
            _ctphieuHoanRepository = ctphieuHoanRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var ctphieuHoans = await _ctphieuHoanRepository.GetAllAsync();
            var ctphieuHoanDto = ctphieuHoans.Select(x => x.ToCtphieuHoanDto());

            return Ok(ctphieuHoanDto);
        }

        [HttpGet]
        [Route("{maPh}/{maSp}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string maPh, [FromRoute] string maSp)
        {
            var ctphieuHoan = await _ctphieuHoanRepository.GetByIdAsync(maPh, maSp);

            if (ctphieuHoan == null)
            {
                return NotFound();
            }

            return Ok(ctphieuHoan.ToCtphieuHoanDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateCtphieuHoanRequestDto createCtphieuHoanRequestDto)
        {
            var ctphieuHoanModel = createCtphieuHoanRequestDto.ToCtphieuHoanFormCreateDTO();
            await _ctphieuHoanRepository.CreateAsync(ctphieuHoanModel);

            return CreatedAtAction(nameof(GetDataByID), new { maPh = ctphieuHoanModel.MaPh, maSp = ctphieuHoanModel.MaSp }, ctphieuHoanModel.ToCtphieuHoanDto());
        }

        [HttpPut]
        [Route("{maPh}/{maSp}")]
        public async Task<IActionResult> Update([FromRoute] string maPh, [FromRoute] string maSp, [FromBody] UpdateCtphieuHoanDto updateCtphieuHoanDto)
        {
            var ctphieuHoanModel = await _ctphieuHoanRepository.UpdateAsync(maPh, maSp, updateCtphieuHoanDto);

            if (ctphieuHoanModel == null)
            {
                return NotFound();
            }

            return Ok(ctphieuHoanModel.ToCtphieuHoanDto());
        }

        [HttpDelete]
        [Route("{maPh}/{maSp}")]
        public async Task<IActionResult> Delete([FromRoute] string maPh, [FromRoute] string maSp)
        {
            var ctphieuHoanModel = await _ctphieuHoanRepository.DeleteAsync(maPh, maSp);

            if (ctphieuHoanModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}
