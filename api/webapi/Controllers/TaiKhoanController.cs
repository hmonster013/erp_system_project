using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.TaiKhoan;
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/tai-khoan")]
    [ApiController]
    public class TaiKhoanController : ControllerBase
    {
        private readonly ITaiKhoanRepository _taiKhoanRepository;

        public TaiKhoanController(ITaiKhoanRepository taiKhoanRepository)
        {
            _taiKhoanRepository = taiKhoanRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var taiKhoans = await _taiKhoanRepository.GetAllAsync();
            var taiKhoanDtos = taiKhoans.Select(x => new TaiKhoanDto
            {
                Username = x.Username,
                Password = x.Password,
                MaNv = x.MaNv
            });

            return Ok(taiKhoanDtos);
        }

        [HttpGet]
        [Route("{username}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string username)
        {
            var taiKhoan = await _taiKhoanRepository.GetByIdAsync(username);

            if (taiKhoan == null)
            {
                return NotFound();
            }

            return Ok(new TaiKhoanDto
            {
                Username = taiKhoan.Username,
                Password = taiKhoan.Password,
                MaNv = taiKhoan.MaNv
            });
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateTaiKhoanRequestDto createTaiKhoanRequestDto)
        {
            var taiKhoanModel = new TaiKhoan
            {
                Username = createTaiKhoanRequestDto.Username,
                Password = createTaiKhoanRequestDto.Password,
                MaNv = createTaiKhoanRequestDto.MaNv
            };

            await _taiKhoanRepository.CreateAsync(taiKhoanModel);

            return CreatedAtAction(nameof(GetDataByID), new { username = taiKhoanModel.Username }, new TaiKhoanDto
            {
                Username = taiKhoanModel.Username,
                Password = taiKhoanModel.Password,
                MaNv = taiKhoanModel.MaNv
            });
        }

        [HttpPut]
        [Route("{username}")]
        public async Task<IActionResult> Update([FromRoute] string username, [FromBody] UpdateTaiKhoanDto updateTaiKhoanDto)
        {
            var taiKhoanModel = await _taiKhoanRepository.UpdateAsync(username, updateTaiKhoanDto);

            if (taiKhoanModel == null)
            {
                return NotFound();
            }

            return Ok(new TaiKhoanDto
            {
                Username = taiKhoanModel.Username,
                Password = taiKhoanModel.Password,
                MaNv = taiKhoanModel.MaNv
            });
        }

        [HttpDelete]
        [Route("{username}")]
        public async Task<IActionResult> Delete([FromRoute] string username)
        {
            var taiKhoanModel = await _taiKhoanRepository.DeleteAsync(username);

            if (taiKhoanModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}
