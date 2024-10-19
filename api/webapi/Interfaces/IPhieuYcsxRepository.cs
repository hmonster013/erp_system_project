
using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.EntityFrameworkCore;
using System.Threading.Tasks;
using webapi.Dtos.PhieuYcsx;
using webapi.Models;

namespace webapi.Controllers
{
    public interface IPhieuYcsxRepository
    {
        Task<List<PhieuYcsx>> GetAllAsync();
        Task<PhieuYcsx?> GetByIdAsync(string maYcsx);
        Task<PhieuYcsx> CreateAsync(PhieuYcsx phieuYcsxModel);
        Task<PhieuYcsx> UpdateAsync(string maYcsx, UpdatePhieuYcsxDto updatePhieuYcsxDto);
        Task<PhieuYcsx> DeleteAsync(string maYcsx);
    }
}