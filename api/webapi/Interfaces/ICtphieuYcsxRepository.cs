
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using webapi.Dtos.CtPhieuYcsx;
using webapi.Models;

namespace webapi.Controllers
{
    public interface ICtphieuYcsxRepository
    {
        Task<List<CtphieuYcsx>> GetAllAsync();
        Task<CtphieuYcsx?> GetByIdAsync(string maCtYcsx);
        Task<CtphieuYcsx> CreateAsync(CtphieuYcsx ctPhieuYcsxModel);
        Task<CtphieuYcsx> UpdateAsync(string maCtYcsx, UpdateCtPhieuYcsxDto updateCtPhieuYcsxDto);
        Task<CtphieuYcsx> DeleteAsync(string maCtYcsx);
        Task<List<CtphieuYcsx>> GetByMaYcAsync(string maYc);
    }
}