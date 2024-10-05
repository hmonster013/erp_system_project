using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.LoaiSp;
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/loaisp")]
    [ApiController]
    public class LoaiSpController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ILoaiSpRepository _loaiSpRepository;

        public LoaiSpController(ApplicationDBContext context, ILoaiSpRepository loaiSpRepository)
        {
            _context = context;
            _loaiSpRepository = loaiSpRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var loaiSps = await _loaiSpRepository.GetAllAsync();
            var loaiSpDtos = loaiSps.Select(x => x.ToLoaiSpDto()); // Sử dụng mapper

            return Ok(loaiSpDtos);
        }

        [HttpGet]
        [Route("{maLoai}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string maLoai)
        {
            var loaiSp = await _loaiSpRepository.GetByIdAsync(maLoai);

            if (loaiSp == null)
            {
                return NotFound();
            }

            return Ok(loaiSp.ToLoaiSpDto()); // Sử dụng mapper
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateLoaiSpRequestDto createLoaiSpRequestDto)
        {
            var loaiSpModel = createLoaiSpRequestDto.ToLoaiSpFormCreateDTO(); // Sử dụng mapper để tạo mô hình
            await _loaiSpRepository.CreateAsync(loaiSpModel);

            return CreatedAtAction(nameof(GetDataByID), new { maLoai = loaiSpModel.MaLoai }, loaiSpModel.ToLoaiSpDto()); // Sử dụng mapper
        }

        [HttpPut]
        [Route("{maLoai}")]
        public async Task<IActionResult> Update([FromRoute] string maLoai, [FromBody] UpdateLoaiSpDto updateLoaiSpDto)
        {
            var loaiSpModel = await _loaiSpRepository.UpdateAsync(maLoai, updateLoaiSpDto);

            if (loaiSpModel == null)
            {
                return NotFound();
            }

            return Ok(loaiSpModel.ToLoaiSpDto()); // Sử dụng mapper
        }

        [HttpDelete]
        [Route("{maLoai}")]
        public async Task<IActionResult> Delete([FromRoute] string maLoai)
        {
            var loaiSpModel = await _loaiSpRepository.DeleteAsync(maLoai);

            if (loaiSpModel == null)
            {
                return NotFound();
            }

            return NoContent();
        }

        [HttpGet("search/{tenLoai}")]
        public async Task<IActionResult> GetByTenLoai([FromRoute] string tenLoai)
        {
            var loaiSp = await _loaiSpRepository.GetByTenLoaiAsync(tenLoai);

            if (loaiSp == null)
            {
                return NotFound();
            }

            return Ok(loaiSp.ToLoaiSpDto()); // Sử dụng mapper
        }
    }
}
