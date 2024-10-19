using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.LoSanPham;

namespace webapi.Controllers
{
    [Route("api/losanpham")]
    [ApiController]
    public class LoSanPhamController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ILoSanPhamRepository _loSanPhamRepository;

        public LoSanPhamController(ApplicationDBContext context, ILoSanPhamRepository loSanPhamRepository)
        {
            _context = context;
            _loSanPhamRepository = loSanPhamRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var loSanPhams = await _loSanPhamRepository.GetAllAsync();
            var loSanPhamDtos = loSanPhams.Select(x => x.ToLoSanPhamDto());

            return Ok(loSanPhamDtos);
        }
        
        [HttpGet]
        [Route("{SoLo}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string SoLo)
        {
            var loSanPham = await _loSanPhamRepository.GetByIdAsync(SoLo);

            if (loSanPham == null)
            {
                return NotFound();
            }

            return Ok(loSanPham.ToLoSanPhamDto());
        }

        [HttpGet]
        [Route("search/{MaYc}")]
        public async Task<IActionResult> GetByMaYc([FromRoute] string MaYc)
        {
            var loSanPhams = await _loSanPhamRepository.GetByMaYcAsync(MaYc);

            var loSanPhamDtos = loSanPhams.Select(x => x.ToLoSanPhamDto());

            return Ok(loSanPhamDtos);
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateLoSanPhamRequestDto createLoSanPhamRequestDto)
        {
            var loSanPhamModel = createLoSanPhamRequestDto.ToLoSanPhamFromCreateDto();
            await _loSanPhamRepository.CreateAsync(loSanPhamModel);

            return CreatedAtAction(nameof(GetDataByID), new { SoLo = loSanPhamModel.SoLo }, loSanPhamModel.ToLoSanPhamDto());
        }

        [HttpPut]
        [Route("{SoLo}")]
        public async Task<IActionResult> Update([FromRoute] string SoLo, [FromBody] UpdateLoSanPhamDto updateLoSanPhamDto)
        {
            var loSanPhamModel = await _loSanPhamRepository.UpdateAsync(SoLo, updateLoSanPhamDto);

            if (loSanPhamModel == null)
            {
                return NotFound();
            }

            return Ok(loSanPhamModel.ToLoSanPhamDto());
        }

        [HttpDelete]
        [Route("{SoLo}")]
        public async Task<IActionResult> Delete([FromRoute] string SoLo)
        {
            var loSanPhamModel = await _loSanPhamRepository.DeleteAsync(SoLo);

            if (loSanPhamModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}
