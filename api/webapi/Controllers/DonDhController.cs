using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.DonDh; // Giả sử bạn đã tạo DTO cho DonDh
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/dondh")]
    [ApiController]
    public class DonDhController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly IDonDhRepository _donDhRepository;

        public DonDhController(ApplicationDBContext context, IDonDhRepository donDhRepository)
        {
            _context = context;
            _donDhRepository = donDhRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var donDhs = await _donDhRepository.GetAllAsync();
            var donDhDtos = donDhs.Select(x => x.ToDonDhDto()); // Giả sử bạn đã tạo phương thức ToDonDhDto

            return Ok(donDhDtos);
        }
        
        [HttpGet]
        [Route("{MaDdh}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaDdh)
        {
            var donDh = await _donDhRepository.GetByIdAsync(MaDdh);

            if (donDh == null)
            {
                return NotFound();
            }

            return Ok(donDh.ToDonDhDto()); // Giả sử bạn đã tạo phương thức ToDonDhDto
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateDonDhRequestDto createDonDhRequestDto) // Giả sử bạn đã tạo DTO cho tạo đơn đặt hàng
        {
            var donDhModel = createDonDhRequestDto.ToDonDhFormCreateDTO(); // Giả sử bạn đã tạo phương thức ToDonDhFormCreateDTO
            await _donDhRepository.CreateAsync(donDhModel);

            return CreatedAtAction(nameof(GetDataByID), new { MaDdh = donDhModel.MaDdh }, donDhModel.ToDonDhDto()); // Giả sử bạn đã tạo phương thức ToDonDhDto
        }

        [HttpPut]
        [Route("{MaDdh}")]
        public async Task<IActionResult> Update([FromRoute] string MaDdh, [FromBody] UpdateDonDhDto updateDonDhDto) // Giả sử bạn đã tạo DTO cho cập nhật đơn đặt hàng
        {
            var donDhModel = await _donDhRepository.UpdateAsync(MaDdh, updateDonDhDto);

            if (donDhModel == null)
            {
                return NotFound();
            }

            return Ok(donDhModel.ToDonDhDto()); // Giả sử bạn đã tạo phương thức ToDonDhDto
        }

        [HttpDelete]
        [Route("{MaDdh}")]
        public async Task<IActionResult> Delete([FromRoute] string MaDdh)
        {
            var donDhModel = await _donDhRepository.DeleteAsync(MaDdh);

            if (donDhModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }

        [HttpGet]
        [Route("search/{tenKh}")]
        public async Task<IActionResult> GetByTenKh([FromRoute] string tenKh)
        {
            var donDhs = await _donDhRepository.GetByTenKhAsync(tenKh);

            if (donDhs == null || !donDhs.Any())
            {
                return NotFound();
            }

            var donDhDtos = donDhs.Select(x => x.ToDonDhDto());
            return Ok(donDhDtos);
        }

        [HttpGet]
        [Route("all-with-tenkh")]
        public async Task<IActionResult> GetAllWithTenKh()
        {
            var donDhsWithTenKh = await _donDhRepository.GetAllWithTenKhAsync();

            if (donDhsWithTenKh == null || !donDhsWithTenKh.Any())
            {
                return NotFound();
            }

            return Ok(donDhsWithTenKh);
        }
    }
}
