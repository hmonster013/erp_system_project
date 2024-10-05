using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.CtHoaDon;
using webapi.Dtos.TaiKhoan; // Đảm bảo bạn có DTO cần thiết cho CtHoaDon

namespace webapi.Controllers
{
    [Route("api/cthoadon")]
    [ApiController]
    public class CtHoaDonController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ICtHoaDonRepository _ctHoaDonRepository;

        public CtHoaDonController(ApplicationDBContext context, ICtHoaDonRepository ctHoaDonRepository)
        {
            _context = context;
            _ctHoaDonRepository = ctHoaDonRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var ctHoaDons = await _ctHoaDonRepository.GetAllAsync();
            var ctHoaDonDtos = ctHoaDons.Select(x => x.ToCtHoaDonDto());

            return Ok(ctHoaDonDtos);
        }
        
        [HttpGet]
        [Route("{MaHd}/{MaSp}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaHd, [FromRoute] string MaSp)
        {
            var ctHoaDon = await _ctHoaDonRepository.GetByIdAsync(MaHd, MaSp);

            if (ctHoaDon == null)
            {
                return NotFound();
            }

            return Ok(ctHoaDon.ToCtHoaDonDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateCtHoaDonRequestDto createCtHoaDonRequestDto)
        {
            var ctHoaDonModel = createCtHoaDonRequestDto.ToCtHoaDonFormCreateDTO();
            await _ctHoaDonRepository.CreateAsync(ctHoaDonModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaHd = ctHoaDonModel.MaHd, MaSp = ctHoaDonModel.MaSp }, ctHoaDonModel.ToCtHoaDonDto());
        }

        [HttpPut]
        [Route("{MaHd}/{MaSp}")]
        public async Task<IActionResult> Update([FromRoute] string MaHd, [FromRoute] string MaSp, [FromBody] UpdateCtHoaDonDto updateCtHoaDonDto)
        {
            var ctHoaDonModel = await _ctHoaDonRepository.UpdateAsync(MaHd, MaSp, updateCtHoaDonDto);

            if (ctHoaDonModel == null)
            {
                return NotFound();
            }

            return Ok(ctHoaDonModel.ToCtHoaDonDto());
        }

        [HttpDelete]
        [Route("{MaHd}/{MaSp}")]
        public async Task<IActionResult> Delete([FromRoute] string MaHd, [FromRoute] string MaSp)
        {
            var ctHoaDonModel = await _ctHoaDonRepository.DeleteAsync(MaHd, MaSp);

            if (ctHoaDonModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}
