using Microsoft.EntityFrameworkCore;
using webapi.Controllers;
using webapi.Data;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddControllers();
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddDbContext<ApplicationDBContext>(options =>{
    options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection"));
});

builder.Services.AddScoped<IBacLuongRepository, BacLuongRepository>();
builder.Services.AddScoped<IBaoHiemRepository, BaoHiemRepository>();
builder.Services.AddScoped<IBoPhanRepository, BoPhanRepository>();
builder.Services.AddScoped<IChienDichRepository, ChienDichRepository>();
builder.Services.AddScoped<IChinhSachRepository, ChinhSachRepository>();
builder.Services.AddScoped<IChucVuRepository, ChucVuRepository>();
builder.Services.AddScoped<ICongRepository, CongRepository>();
builder.Services.AddScoped<ICtHoaDonRepository, CtHoaDonRepository>();
builder.Services.AddScoped<ICtdonDhRepository, CtdonDhRepository>();
builder.Services.AddScoped<ICtphieuHoanRepository, CtphieuHoanRepository>();
builder.Services.AddScoped<ICtphieuNghiemThuRepository, CtphieuNghiemThuRepository>();
builder.Services.AddScoped<ICtphieuNhapNvlRepository, CtphieuNhapNvlRepository>();
builder.Services.AddScoped<ICtphieuXuatNvlRepository, CtphieuXuatNvlRepository>();
builder.Services.AddScoped<ICtphieuXuatSpRepository, CtphieuXuatSpRepository>();
builder.Services.AddScoped<ICtphieuYcsxRepository, CtphieuYcsxRepository>();
builder.Services.AddScoped<ICtpnhangHoanRepository, CtpnhangHoanRepository>();
builder.Services.AddScoped<IDanhMucChiRepository, DanhMucChiRepository>();
builder.Services.AddScoped<IDanhMucThuRepository, DanhMucThuRepository>();
builder.Services.AddScoped<IDonDhRepository, DonDhRepository>();
builder.Services.AddScoped<IHinhAnhQcRepository, HinhAnhQcRepository>();
builder.Services.AddScoped<IHoaDonRepository, HoaDonRepository>();
builder.Services.AddScoped<IHopDongRepository, HopDongRepository>();
builder.Services.AddScoped<IKhachHangRepository, KhachHangRepository>();
builder.Services.AddScoped<ILoSanPhamRepository, LoSanPhamRepository>();
builder.Services.AddScoped<ILoaiKhRepository, LoaiKhRepository>();
builder.Services.AddScoped<ILoaiSpRepository, LoaiSpRepository>();
builder.Services.AddScoped<IMauMaSpRepository, MauMaSpRepository>();
builder.Services.AddScoped<INguyenVatLieuRepository, NguyenVatLieuRepository>();
builder.Services.AddScoped<INhaCungCapRepository, NhaCungCapRepository>();
builder.Services.AddScoped<IPhieuChiRepository, PhieuChiRepository>();
builder.Services.AddScoped<IPhieuChiCongNoRepository, PhieuChiCongNoRepository>();
builder.Services.AddScoped<IPhieuHoanRepository, PhieuHoanRepository>();
builder.Services.AddScoped<IPhieuNghiemThuRepository, PhieuNghiemThuRepository>();
builder.Services.AddScoped<IPhieuNhapNvlRepository, PhieuNhapNvlRepository>();
builder.Services.AddScoped<IPhieuNhapSpRepository, PhieuNhapSpRepository>();
builder.Services.AddScoped<IPhieuThuRepository, PhieuThuRepository>();
builder.Services.AddScoped<IPhieuThuCongNoRepository, PhieuThuCongNoRepository>();
builder.Services.AddScoped<IPhieuXuatNvlRepository, PhieuXuatNvlRepository>();
builder.Services.AddScoped<IPhieuXuatSpRepository, PhieuXuatSpRepository>();
builder.Services.AddScoped<IPhieuYcsxRepository, PhieuYcsxRepository>();
builder.Services.AddScoped<IPhieuktklRepository, PhieuktklRepository>();
builder.Services.AddScoped<IPhuCapRepository, PhuCapRepository>();
builder.Services.AddScoped<IPnhangHoanRepository, PnhangHoanRepository>();
builder.Services.AddScoped<IQtcongTacRepository, QtcongTacRepository>();
builder.Services.AddScoped<ISanPhamRepository, SanPhamRepository>();
builder.Services.AddScoped<ITaiKhoanRepository, TaiKhoanRepository>();
builder.Services.AddScoped<IThongTinNhanVienRepository, ThongTinNhanVienRepository>();
builder.Services.AddScoped<IUuDaiRepository, UuDaiRepository>();


var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();
app.MapControllers();
app.Run();
