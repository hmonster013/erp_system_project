
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Azure.Core;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.TaiKhoan;

namespace webapi.Controllers
{
    [Route("api/thongtinnhanvien")]
    [ApiController]
    public class ThongTinNhanVienController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly IThongTinNhanVienRepository _thongTinNhanVienRepository;

        public ThongTinNhanVienController(ApplicationDBContext context, IThongTinNhanVienRepository thongTinNhanVienRepository)
        {
            _context = context;
            _thongTinNhanVienRepository = thongTinNhanVienRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var thongTinNhanViens = await _thongTinNhanVienRepository.GetAllAsync();
            var thongtinnhanvienDto = thongTinNhanViens.Select(x => x.ToThongTinNhanVienDto());

            return Ok(thongtinnhanvienDto);
        }
        
        [HttpGet]
        [Route("{MaNv}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaNv)
        {
            var thongtinnhanvien = await _thongTinNhanVienRepository.GetByIdAsync(MaNv);

            if (thongtinnhanvien == null)
            {
                return NotFound();
            }

            return Ok(thongtinnhanvien.ToThongTinNhanVienDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateThongTinNhanVienRequestDto createThongTinNhanVienRequestDto)
        {
            var thongtinnhanvienModel = createThongTinNhanVienRequestDto.ToThongTinNhanVienFormCreateDTO();
            await _thongTinNhanVienRepository.CreateAsync(thongtinnhanvienModel);

            return CreatedAtAction(nameof(GetDataByID), new {MaNv = thongtinnhanvienModel.MaNv}, thongtinnhanvienModel.ToThongTinNhanVienDto());
        }

        [HttpPut]
        [Route("{MaNv}")]
        public async Task<IActionResult> Update([FromRoute] string MaNv, [FromBody] UpdateThongTinNhanVienDto updateThongTinNhanVienDto)
        {
            var thongtinnhanvienModel = await _thongTinNhanVienRepository.UpdateAsync(MaNv, updateThongTinNhanVienDto);

            if (thongtinnhanvienModel == null)
            {
                return NotFound();
            }

            return Ok(thongtinnhanvienModel.ToThongTinNhanVienDto());
        }

        [HttpDelete]
        [Route("{MaNv}")]
        public async Task<IActionResult> Delete([FromRoute] string MaNv)
        {
            var thongtinnhanvienModel = await _thongTinNhanVienRepository.DeleteAsync(MaNv);

            if (thongtinnhanvienModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}