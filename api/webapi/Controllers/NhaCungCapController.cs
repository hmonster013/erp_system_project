using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.NhaCungCap;

namespace webapi.Controllers
{
    [Route("api/nhacungcap")]
    [ApiController]
    public class NhaCungCapController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly INhaCungCapRepository _nhaCungCapRepository;

        public NhaCungCapController(ApplicationDBContext context, INhaCungCapRepository nhaCungCapRepository)
        {
            _context = context;
            _nhaCungCapRepository = nhaCungCapRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var nhaCungCaps = await _nhaCungCapRepository.GetAllAsync();
            var nhaCungCapDto = nhaCungCaps.Select(x => x.ToNhaCungCapDto());

            return Ok(nhaCungCapDto);
        }
        
        [HttpGet]
        [Route("{MaNcc}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaNcc)
        {
            var nhaCungCap = await _nhaCungCapRepository.GetByIdAsync(MaNcc);

            if (nhaCungCap == null)
            {
                return NotFound();
            }

            return Ok(nhaCungCap.ToNhaCungCapDto());
        }

        [HttpGet]
        [Route("ten/{TenNcc}")]
        public async Task<IActionResult> GetMaNccByTenNcc([FromRoute] String TenNcc)
        {    
            var maNcc = await _nhaCungCapRepository.GetMaNccByTenNccAsync(TenNcc);

            if (maNcc == null)
            {
                return NotFound();
            }

            return Ok(new { MaNcc = maNcc });
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] CreateNhaCungCapRequestDto createNhaCungCapRequestDto)
        {
            var nhaCungCapModel = createNhaCungCapRequestDto.ToNhaCungCapFormCreateDTO();
            await _nhaCungCapRepository.CreateAsync(nhaCungCapModel);

            return CreatedAtAction(nameof(GetDataByID), new {MaNcc = nhaCungCapModel.MaNcc}, nhaCungCapModel.ToNhaCungCapDto());
        }

        [HttpPut]
        [Route("{MaNcc}")]
        public async Task<IActionResult> Update([FromRoute] string MaNcc, [FromBody] UpdateNhaCungCapDto updateNhaCungCapDto)
        {
            var nhaCungCapModel = await _nhaCungCapRepository.UpdateAsync(MaNcc, updateNhaCungCapDto);

            if (nhaCungCapModel == null)
            {
                return NotFound();
            }

            return Ok(nhaCungCapModel.ToNhaCungCapDto());
        }

        [HttpDelete]
        [Route("{MaNcc}")]
        public async Task<IActionResult> Delete([FromRoute] string MaNcc)
        {
            var nhaCungCapModel = await _nhaCungCapRepository.DeleteAsync(MaNcc);

            if (nhaCungCapModel == null)
            {
                return NotFound();  
            }

            return NoContent();
        }
    }
}
