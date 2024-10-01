
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using webapi.Data;

namespace webapi.Controllers
{        
    [Route("api/taikhoan")]
    [ApiController]
    public class TaiKhoanController : ControllerBase
    {
        private readonly ApplicationDBContext _context;
        private readonly ITaiKhoanRepository _taiKhoanRepository;

        public TaiKhoanController(ApplicationDBContext context, ITaiKhoanRepository taiKhoanRepository)
        {
            _context = context;
            _taiKhoanRepository = taiKhoanRepository;
        }

        // [HttpGet]
        // public async Task<IActionResult> GetAll()
        // {
            
        // }
    }
}