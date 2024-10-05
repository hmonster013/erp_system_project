using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.KhachHang; // Bạn cần tạo DTO cho KhachHang
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/khachhang")]
    [ApiController]
    public class KhachHangController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly IKhachHangRepository _khachHangRepository;

        public KhachHangController(ApplicationDBContext context, IKhachHangRepository khachHangRepository)
        {
            _context = context;
            _khachHangRepository = khachHangRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var khachHangs = await _khachHangRepository.GetAllAsync();
            var khachHangDtos = khachHangs.Select(x => x.ToKhachHangDto()); // Chuyển đổi sang DTO

            return Ok(khachHangDtos);
        }

        [HttpGet]
        [Route("{MaKh}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaKh)
        {
            var khachHang = await _khachHangRepository.GetByIdAsync(MaKh);

            if (khachHang == null)
            {
                return NotFound();
            }

            return Ok(khachHang.ToKhachHangDto()); // Chuyển đổi sang DTO
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateKhachHangRequestDto createKhachHangRequestDto) // Nhận DTO yêu cầu
        {
            var khachHangModel = createKhachHangRequestDto.ToKhachHangFromCreateDTO(); // Chuyển DTO sang entity
            await _khachHangRepository.CreateAsync(khachHangModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaKh = khachHangModel.MaKh }, khachHangModel.ToKhachHangDto());
        }

        [HttpPut]
        [Route("{MaKh}")]
        public async Task<IActionResult> Update([FromRoute] string MaKh, [FromBody] UpdateKhachHangDto updateKhachHangDto)
        {
            var updatedKhachHang = await _khachHangRepository.UpdateAsync(MaKh, updateKhachHangDto);

            if (updatedKhachHang == null)
            {
                return NotFound();
            }

            return Ok(updatedKhachHang.ToKhachHangDto()); // Chuyển đổi sang DTO
        }

        [HttpDelete]
        [Route("{MaKh}")]
        public async Task<IActionResult> Delete([FromRoute] string MaKh)
        {
            var khachHangModel = await _khachHangRepository.DeleteAsync(MaKh);

            if (khachHangModel == null)
            {
                return NotFound();
            }

            return NoContent();
        }

        [HttpGet("search/{tenKh}")]
        public async Task<IActionResult> SearchByName([FromRoute] string tenKh)
        {
            var khachHangs = await _khachHangRepository.GetByTenKhAsync(tenKh);
            
            var khachHangDtos = khachHangs.Select(x => x.ToKhachHangDto()).ToList();

            return Ok(khachHangDtos);
        }
    }
}
