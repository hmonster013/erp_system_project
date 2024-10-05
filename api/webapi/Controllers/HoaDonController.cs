using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.HoaDon; // Thay đổi namespace tương ứng với DTO của bạn
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/hoadon")]
    [ApiController]
    public class HoaDonController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly IHoaDonRepository _hoaDonRepository;

        public HoaDonController(ApplicationDBContext context, IHoaDonRepository hoaDonRepository)
        {
            _context = context;
            _hoaDonRepository = hoaDonRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var hoaDons = await _hoaDonRepository.GetAllAsync();
            var hoaDonDto = hoaDons.Select(x => x.ToHoaDonDto()); // Chuyển đổi thành DTO

            return Ok(hoaDonDto);
        }
        
        [HttpGet]
        [Route("{MaHd}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaHd)
        {
            var hoaDon = await _hoaDonRepository.GetByIdAsync(MaHd);

            if (hoaDon == null)
            {
                return NotFound();
            }

            return Ok(hoaDon.ToHoaDonDto()); // Chuyển đổi thành DTO
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateHoaDonRequestDto createHoaDonRequestDto)
        {
            var hoaDonModel = createHoaDonRequestDto.ToHoaDonFormCreateDTO(); // Chuyển đổi từ DTO
            await _hoaDonRepository.CreateAsync(hoaDonModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaHd = hoaDonModel.MaHd }, hoaDonModel.ToHoaDonDto()); // Chuyển đổi thành DTO
        }

        [HttpPut]
        [Route("{MaHd}")]
        public async Task<IActionResult> Update([FromRoute] string MaHd, [FromBody] UpdateHoaDonDto updateHoaDonDto)
        {
            var hoaDonModel = await _hoaDonRepository.UpdateAsync(MaHd, updateHoaDonDto);

            if (hoaDonModel == null)
            {
                return NotFound();
            }

            return Ok(hoaDonModel.ToHoaDonDto()); // Chuyển đổi thành DTO
        }

        [HttpDelete]
        [Route("{MaHd}")]
        public async Task<IActionResult> Delete([FromRoute] string MaHd)
        {
            var hoaDonModel = await _hoaDonRepository.DeleteAsync(MaHd);

            if (hoaDonModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}
