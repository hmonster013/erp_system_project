using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.CtdonDh; // Nhớ tạo namespace cho các DTO tương ứng
using webapi.Models;

namespace webapi.Controllers
{
    [Route("api/ctdondh")]
    [ApiController]
    public class CtdonDhController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ICtdonDhRepository _ctdonDhRepository;

        public CtdonDhController(ApplicationDBContext context, ICtdonDhRepository ctdonDhRepository)
        {
            _context = context;
            _ctdonDhRepository = ctdonDhRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var ctdonDhs = await _ctdonDhRepository.GetAllAsync();
            var ctdonDhDtos = ctdonDhs.Select(x => x.ToCtdonDhDto());

            return Ok(ctdonDhDtos);
        }
        
        [HttpGet]
        [Route("{maDdh}/{maSp}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string maDdh, [FromRoute] string maSp)
        {
            var ctdonDh = await _ctdonDhRepository.GetByIdAsync(maDdh, maSp);

            if (ctdonDh == null)
            {
                return NotFound();
            }

            return Ok(ctdonDh.ToCtdonDhDto());
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateCtdonDhRequestDto createCtdonDhRequestDto)
        {
            var ctdonDhModel = createCtdonDhRequestDto.ToCtdonDhFormCreateDTO();
            await _ctdonDhRepository.CreateAsync(ctdonDhModel);

            return CreatedAtAction(nameof(GetDataByID), new { maDdh = ctdonDhModel.MaDdh, maSp = ctdonDhModel.MaSp }, ctdonDhModel.ToCtdonDhDto());
        }

        [HttpPut]
        [Route("{maDdh}/{maSp}")]
        public async Task<IActionResult> Update([FromRoute] string maDdh, [FromRoute] string maSp, [FromBody] UpdateCtdonDhDto updateCtdonDhDto)
        {
            var ctdonDhModel = await _ctdonDhRepository.UpdateAsync(maDdh, maSp, updateCtdonDhDto);

            if (ctdonDhModel == null)
            {
                return NotFound();
            }

            return Ok(ctdonDhModel.ToCtdonDhDto());
        }

        [HttpDelete]
        [Route("{maDdh}/{maSp}")]
        public async Task<IActionResult> Delete([FromRoute] string maDdh, [FromRoute] string maSp)
        {
            var ctdonDhModel = await _ctdonDhRepository.DeleteAsync(maDdh, maSp);

            if (ctdonDhModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }

        [HttpGet]
        [Route("search/{maDdh}")]
        public async Task<IActionResult> GetByMaDdh([FromRoute] string maDdh)
        {
            var ctdonDhs = await _ctdonDhRepository.GetByMaDdhAsync(maDdh);

            if (ctdonDhs == null || !ctdonDhs.Any())
            {
                return NotFound();
            }

            return Ok(ctdonDhs);
        }
    }
}
