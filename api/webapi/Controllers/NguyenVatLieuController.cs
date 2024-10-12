using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;
using webapi.Dtos.NguyenVatLieu;

namespace webapi.Controllers
{
    [Route("api/nguyenvatlieu")]
    [ApiController]
    public class NguyenVatLieuController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly INguyenVatLieuRepository _nguyenVatLieuRepository;

        public NguyenVatLieuController(ApplicationDBContext context, INguyenVatLieuRepository nguyenVatLieuRepository)
        {
            _context = context;
            _nguyenVatLieuRepository = nguyenVatLieuRepository;
        }

        [HttpGet]
        public async Task<IActionResult> GetAll()
        {
            var nguyenVatLieus = await _nguyenVatLieuRepository.GetAllAsync();
            var nguyenVatLieuDtos = nguyenVatLieus.Select(x => x.ToNguyenVatLieuDto());

            return Ok(nguyenVatLieuDtos);
        }

        [HttpGet]
        [Route("{MaNvl}")]
        public async Task<IActionResult> GetDataByID([FromRoute] string MaNvl)
        {
            var nguyenVatLieu = await _nguyenVatLieuRepository.GetByIdAsync(MaNvl);

            if (nguyenVatLieu == null)
            {
                return NotFound();
            }

            return Ok(nguyenVatLieu.ToNguyenVatLieuDto());
        }

        [HttpPut]
        [Route("{MaNvl}")]
        public async Task<IActionResult> Update([FromRoute] string MaNvl, [FromBody] UpdateNguyenVatLieuDto updateNguyenVatLieuDto)
        {
            var nguyenVatLieuModel = await _nguyenVatLieuRepository.UpdateAsync(MaNvl, updateNguyenVatLieuDto);

            if (nguyenVatLieuModel == null)
            {
                return NotFound();
            }

            return Ok(nguyenVatLieuModel.ToNguyenVatLieuDto());
        }
    }
}

    