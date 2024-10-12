using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.SanPham;
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/sanpham")]
    [ApiController]
    public class SanPhamController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ISanPhamRepository _sanPhamRepository;

        public SanPhamController(ApplicationDBContext context, ISanPhamRepository sanPhamRepository)
        {
            _context = context;
            _sanPhamRepository = sanPhamRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var sanPhams = await _sanPhamRepository.GetAllAsync();
            var sanPhamDtos = sanPhams.Select(x => x.ToSanPhamDto());

            return Ok(sanPhamDtos);
        }

        [HttpGet]
        [Route("{MaSp}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaSp)
        {
            var sanPham = await _sanPhamRepository.GetByIdAsync(MaSp);

            if (sanPham == null)
            {
                return NotFound();
            }

            return Ok(sanPham.ToSanPhamDto());
        }

        [HttpGet]
        [Route("ten/{MaSp}")]
        public async Task<IActionResult> GetTenSpByMaSp([FromRoute] string MaSp)
        {
            var tenSp = await _sanPhamRepository.GetTenSpByMaSpAsync(MaSp);

            if (tenSp == null)
            {
                return NotFound();
            }

            return Ok(new { TenSp = tenSp });
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateSanPhamRequestDto createSanPhamRequestDto)
        {
            var sanPhamModel = createSanPhamRequestDto.ToSanPhamFormCreateDTO();
            await _sanPhamRepository.CreateAsync(sanPhamModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaSp = sanPhamModel.MaSp }, sanPhamModel.ToSanPhamDto());
        }

        [HttpPut]
        [Route("{MaSp}")]
        public async Task<IActionResult> Update([FromRoute] string MaSp, [FromBody] UpdateSanPhamDto updateSanPhamDto)
        {
            var sanPhamModel = await _sanPhamRepository.UpdateAsync(MaSp, updateSanPhamDto);

            if (sanPhamModel == null)
            {
                return NotFound();
            }

            return Ok(sanPhamModel.ToSanPhamDto());
        }

        [HttpDelete]
        [Route("{MaSp}")]
        public async Task<IActionResult> Delete([FromRoute] string MaSp)
        {
            var sanPhamModel = await _sanPhamRepository.DeleteAsync(MaSp);

            if (sanPhamModel == null)
            {
                return NotFound();
            }

            return NoContent();
        }

        [HttpGet("search/{maLoai}")]
        public async Task<IActionResult> GetByMaLoai([FromRoute] string maLoai)
        {
            var sanPhams = await _sanPhamRepository.GetByMaLoaiAsync(maLoai);

            if (sanPhams == null || !sanPhams.Any())
            {
                return NotFound();
            }

            var sanPhamDtos = sanPhams.Select(x => x.ToSanPhamDto());
            return Ok(sanPhamDtos);
        }
    }
}
