
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Dtos.BoPhan; 
using webapi.Models;
using webapi.Data;

namespace webapi.Controllers
{
    [Route("api/bophan")]
    [ApiController]
    public class BoPhanController : ControllerBase
    {

        private readonly ApplicationDBContext _context;
        private readonly IBoPhanRepository _boPhanRepository;

        public BoPhanController(ApplicationDBContext context, IBoPhanRepository boPhanRepository)
        {
            _context = context;
            _boPhanRepository = boPhanRepository;
        }

        [HttpGet("{manv}")]
        public async Task<IActionResult> GetMaBoPhanByMaNv(string manv)
        {
                var maBoPhan = await _boPhanRepository.GetMaBoPhanByMaNv(manv);

                if (maBoPhan == null)
                {
                    return NotFound("Không tìm thấy mã bộ phận.");
                }

                return Ok(maBoPhan);

        }
    }
}