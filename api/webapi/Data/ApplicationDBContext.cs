using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using webapi.Models;

namespace webapi.Data;

public partial class ApplicationDBContext : DbContext
{
    public ApplicationDBContext()
    {
    }

    public ApplicationDBContext(DbContextOptions<ApplicationDBContext> options)
        : base(options)
    {
    }

    public virtual DbSet<BacLuong> BacLuongs { get; set; }

    public virtual DbSet<BaoHiem> BaoHiems { get; set; }

    public virtual DbSet<BoPhan> BoPhans { get; set; }

    public virtual DbSet<ChienDich> ChienDiches { get; set; }

    public virtual DbSet<ChinhSach> ChinhSaches { get; set; }

    public virtual DbSet<ChucVu> ChucVus { get; set; }

    public virtual DbSet<Cong> Congs { get; set; }

    public virtual DbSet<CtHoaDon> CtHoaDons { get; set; }

    public virtual DbSet<CtdonDh> CtdonDhs { get; set; }

    public virtual DbSet<CtphieuHoan> CtphieuHoans { get; set; }

    public virtual DbSet<CtphieuNghiemThu> CtphieuNghiemThus { get; set; }

    public virtual DbSet<CtphieuNhapNvl> CtphieuNhapNvls { get; set; }

    public virtual DbSet<CtphieuXuatNvl> CtphieuXuatNvls { get; set; }

    public virtual DbSet<CtphieuXuatSp> CtphieuXuatSps { get; set; }

    public virtual DbSet<CtphieuYcsx> CtphieuYcsxes { get; set; }

    public virtual DbSet<CtpnhangHoan> CtpnhangHoans { get; set; }

    public virtual DbSet<DanhMucChi> DanhMucChis { get; set; }

    public virtual DbSet<DanhMucThu> DanhMucThus { get; set; }

    public virtual DbSet<DonDh> DonDhs { get; set; }

    public virtual DbSet<HinhAnhQc> HinhAnhQcs { get; set; }

    public virtual DbSet<HoaDon> HoaDons { get; set; }

    public virtual DbSet<HopDong> HopDongs { get; set; }

    public virtual DbSet<KhachHang> KhachHangs { get; set; }

    public virtual DbSet<LoSanPham> LoSanPhams { get; set; }

    public virtual DbSet<LoaiKh> LoaiKhs { get; set; }

    public virtual DbSet<LoaiSp> LoaiSps { get; set; }

    public virtual DbSet<MauMaSp> MauMaSps { get; set; }

    public virtual DbSet<NguyenVatLieu> NguyenVatLieus { get; set; }

    public virtual DbSet<NhaCungCap> NhaCungCaps { get; set; }

    public virtual DbSet<PhieuChi> PhieuChis { get; set; }

    public virtual DbSet<PhieuChiCongNo> PhieuChiCongNos { get; set; }

    public virtual DbSet<PhieuHoan> PhieuHoans { get; set; }

    public virtual DbSet<PhieuNghiemThu> PhieuNghiemThus { get; set; }

    public virtual DbSet<PhieuNhapNvl> PhieuNhapNvls { get; set; }

    public virtual DbSet<PhieuNhapSp> PhieuNhapSps { get; set; }

    public virtual DbSet<PhieuThu> PhieuThus { get; set; }

    public virtual DbSet<PhieuThuCongNo> PhieuThuCongNos { get; set; }

    public virtual DbSet<PhieuXuatNvl> PhieuXuatNvls { get; set; }

    public virtual DbSet<PhieuXuatSp> PhieuXuatSps { get; set; }

    public virtual DbSet<PhieuYcsx> PhieuYcsxes { get; set; }

    public virtual DbSet<Phieuktkl> Phieuktkls { get; set; }

    public virtual DbSet<PhuCap> PhuCaps { get; set; }

    public virtual DbSet<PnhangHoan> PnhangHoans { get; set; }

    public virtual DbSet<QtcongTac> QtcongTacs { get; set; }

    public virtual DbSet<SanPham> SanPhams { get; set; }

    public virtual DbSet<TaiKhoan> TaiKhoans { get; set; }

    public virtual DbSet<ThongTinNhanVien> ThongTinNhanViens { get; set; }

    public virtual DbSet<UuDai> UuDais { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseSqlServer("Data Source=TRANHUY;Initial Catalog=erp_database;Integrated Security=True;Trust Server Certificate=True");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<BacLuong>(entity =>
        {
            entity.HasKey(e => e.MaBl).HasName("PK__BacLuong__272475AFECF2919C");

            entity.ToTable("BacLuong");

            entity.Property(e => e.MaBl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaBL");
            entity.Property(e => e.Hsluong).HasColumnName("HSLuong");
            entity.Property(e => e.HsphuCap).HasColumnName("HSPhuCap");
            entity.Property(e => e.LuongCb).HasColumnName("LuongCB");
        });

        modelBuilder.Entity<BaoHiem>(entity =>
        {
            entity.HasKey(e => e.MaBaoHiem).HasName("PK__BaoHiem__AACE9D889C1C6E6E");

            entity.ToTable("BaoHiem");

            entity.Property(e => e.MaBaoHiem)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.NoiDungBh)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("NoiDungBH");
            entity.Property(e => e.TenBaoHiem)
                .HasMaxLength(100)
                .IsUnicode(false);

            entity.HasMany(d => d.MaNvs).WithMany(p => p.MaBaoHiems)
                .UsingEntity<Dictionary<string, object>>(
                    "NvBaoHiem",
                    r => r.HasOne<ThongTinNhanVien>().WithMany()
                        .HasForeignKey("MaNv")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__NV_BaoHiem__MaNV__5812160E"),
                    l => l.HasOne<BaoHiem>().WithMany()
                        .HasForeignKey("MaBaoHiem")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__NV_BaoHie__MaBao__571DF1D5"),
                    j =>
                    {
                        j.HasKey("MaBaoHiem", "MaNv").HasName("PK__NV_BaoHi__18BCC0F871D322BF");
                        j.ToTable("NV_BaoHiem");
                        j.IndexerProperty<string>("MaBaoHiem")
                            .HasMaxLength(10)
                            .IsUnicode(false);
                        j.IndexerProperty<string>("MaNv")
                            .HasMaxLength(10)
                            .IsUnicode(false)
                            .HasColumnName("MaNV");
                    });
        });

        modelBuilder.Entity<BoPhan>(entity =>
        {
            entity.HasKey(e => e.MaBp).HasName("PK__BoPhan__272475ABB62BDB57");

            entity.ToTable("BoPhan");

            entity.Property(e => e.MaBp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaBP");
            entity.Property(e => e.Sdt)
                .HasMaxLength(15)
                .IsUnicode(false)
                .HasColumnName("SDT");
            entity.Property(e => e.TenBp)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("TenBP");
        });

        modelBuilder.Entity<ChienDich>(entity =>
        {
            entity.HasKey(e => e.MaCd).HasName("PK__ChienDic__27258E04F37A6F98");

            entity.ToTable("ChienDich");

            entity.Property(e => e.MaCd)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaCD");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.NgayKetThuc)
                .HasMaxLength(500)
                .IsUnicode(false);
            entity.Property(e => e.TenCd)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("TenCD");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.ChienDiches)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__ChienDich__MaNV__7B5B524B");
        });

        modelBuilder.Entity<ChinhSach>(entity =>
        {
            entity.HasKey(e => e.MaChinhSach).HasName("PK__ChinhSac__82663E30F11C2E59");

            entity.ToTable("ChinhSach");

            entity.Property(e => e.MaChinhSach)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.NoiDungCs)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("NoiDungCS");
            entity.Property(e => e.TenChinhSach)
                .HasMaxLength(100)
                .IsUnicode(false);

            entity.HasMany(d => d.MaNvs).WithMany(p => p.MaChinhSaches)
                .UsingEntity<Dictionary<string, object>>(
                    "NvChinhSach",
                    r => r.HasOne<ThongTinNhanVien>().WithMany()
                        .HasForeignKey("MaNv")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__NV_ChinhSa__MaNV__5FB337D6"),
                    l => l.HasOne<ChinhSach>().WithMany()
                        .HasForeignKey("MaChinhSach")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__NV_ChinhS__MaChi__5EBF139D"),
                    j =>
                    {
                        j.HasKey("MaChinhSach", "MaNv").HasName("PK__NV_Chinh__30146340290C9EFC");
                        j.ToTable("NV_ChinhSach");
                        j.IndexerProperty<string>("MaChinhSach")
                            .HasMaxLength(10)
                            .IsUnicode(false);
                        j.IndexerProperty<string>("MaNv")
                            .HasMaxLength(10)
                            .IsUnicode(false)
                            .HasColumnName("MaNV");
                    });
        });

        modelBuilder.Entity<ChucVu>(entity =>
        {
            entity.HasKey(e => e.MaCv).HasName("PK__ChucVu__27258E76FAC17549");

            entity.ToTable("ChucVu");

            entity.Property(e => e.MaCv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaCV");
            entity.Property(e => e.MaBl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaBL");
            entity.Property(e => e.TenCv)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("TenCV");

            entity.HasOne(d => d.MaBlNavigation).WithMany(p => p.ChucVus)
                .HasForeignKey(d => d.MaBl)
                .HasConstraintName("FK__ChucVu__MaBL__403A8C7D");
        });

        modelBuilder.Entity<Cong>(entity =>
        {
            entity.HasKey(e => new { e.MaNv, e.ThangNam }).HasName("PK__Cong__9A69E444F0F19F55");

            entity.ToTable("Cong");

            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.ThangNam)
                .HasMaxLength(6)
                .IsUnicode(false);
            entity.Property(e => e.MaBl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaBL");

            entity.HasOne(d => d.MaBlNavigation).WithMany(p => p.Congs)
                .HasForeignKey(d => d.MaBl)
                .HasConstraintName("FK__Cong__MaBL__4BAC3F29");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.Congs)
                .HasForeignKey(d => d.MaNv)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__Cong__MaNV__4AB81AF0");
        });

        modelBuilder.Entity<CtHoaDon>(entity =>
        {
            entity.HasKey(e => new { e.MaHd, e.MaSp }).HasName("PK__CT_HoaDo__F557F661466A2A9B");

            entity.ToTable("CT_HoaDon");

            entity.Property(e => e.MaHd)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaHD");
            entity.Property(e => e.MaSp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaSP");

            entity.HasOne(d => d.MaHdNavigation).WithMany(p => p.CtHoaDons)
                .HasForeignKey(d => d.MaHd)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CT_HoaDon__MaHD__1F98B2C1");

            entity.HasOne(d => d.MaSpNavigation).WithMany(p => p.CtHoaDons)
                .HasForeignKey(d => d.MaSp)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CT_HoaDon__MaSP__208CD6FA");
        });

        modelBuilder.Entity<CtdonDh>(entity =>
        {
            entity.HasKey(e => new { e.MaDdh, e.MaSp }).HasName("PK__CTDonDH__EFFA9885C39178F7");

            entity.ToTable("CTDonDH");

            entity.Property(e => e.MaDdh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaDDH");
            entity.Property(e => e.MaSp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaSP");

            entity.HasOne(d => d.MaDdhNavigation).WithMany(p => p.CtdonDhs)
                .HasForeignKey(d => d.MaDdh)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTDonDH__MaDDH__17F790F9");

            entity.HasOne(d => d.MaSpNavigation).WithMany(p => p.CtdonDhs)
                .HasForeignKey(d => d.MaSp)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTDonDH__MaSP__18EBB532");
        });

        modelBuilder.Entity<CtphieuHoan>(entity =>
        {
            entity.HasKey(e => new { e.MaPh, e.MaSp }).HasName("PK__CTPhieuH__F557B77B7C4ACD97");

            entity.ToTable("CTPhieuHoan");

            entity.Property(e => e.MaPh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPH");
            entity.Property(e => e.MaSp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaSP");
            entity.Property(e => e.LyDoHoan)
                .HasMaxLength(255)
                .IsUnicode(false);

            entity.HasOne(d => d.MaPhNavigation).WithMany(p => p.CtphieuHoans)
                .HasForeignKey(d => d.MaPh)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuHoa__MaPH__2739D489");

            entity.HasOne(d => d.MaSpNavigation).WithMany(p => p.CtphieuHoans)
                .HasForeignKey(d => d.MaSp)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuHoa__MaSP__282DF8C2");
        });

        modelBuilder.Entity<CtphieuNghiemThu>(entity =>
        {
            entity.HasKey(e => new { e.MaPnt, e.SoLo }).HasName("PK__CTPhieuN__F1202B3EE79932E8");

            entity.ToTable("CTPhieuNghiemThu");

            entity.Property(e => e.MaPnt)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPNT");
            entity.Property(e => e.SoLo)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.KetQuaNt)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("KetQuaNT");

            entity.HasOne(d => d.MaPntNavigation).WithMany(p => p.CtphieuNghiemThus)
                .HasForeignKey(d => d.MaPnt)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuNg__MaPNT__778AC167");

            entity.HasOne(d => d.SoLoNavigation).WithMany(p => p.CtphieuNghiemThus)
                .HasForeignKey(d => d.SoLo)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuNgh__SoLo__787EE5A0");
        });

        modelBuilder.Entity<CtphieuNhapNvl>(entity =>
        {
            entity.HasKey(e => new { e.MaPnnvl, e.MaNvl }).HasName("PK__CTPhieuN__2468742DDCABA96F");

            entity.ToTable("CTPhieuNhapNVL");

            entity.Property(e => e.MaPnnvl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPNNVL");
            entity.Property(e => e.MaNvl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNVL");
            entity.Property(e => e.Dvt)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("DVT");
            entity.Property(e => e.Hsd).HasColumnName("HSD");
            entity.Property(e => e.Nsx).HasColumnName("NSX");
            entity.Property(e => e.Slnhap).HasColumnName("SLNhap");

            entity.HasOne(d => d.MaNvlNavigation).WithMany(p => p.CtphieuNhapNvls)
                .HasForeignKey(d => d.MaNvl)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuNh__MaNVL__32AB8735");

            entity.HasOne(d => d.MaPnnvlNavigation).WithMany(p => p.CtphieuNhapNvls)
                .HasForeignKey(d => d.MaPnnvl)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuNh__MaPNN__31B762FC");
        });

        modelBuilder.Entity<CtphieuXuatNvl>(entity =>
        {
            entity.HasKey(e => new { e.MaPxnvl, e.MaNvl }).HasName("PK__CTPhieuX__F590FDE6FD2AD086");

            entity.ToTable("CTPhieuXuatNVL");

            entity.Property(e => e.MaPxnvl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPXNVL");
            entity.Property(e => e.MaNvl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNVL");

            entity.HasOne(d => d.MaNvlNavigation).WithMany(p => p.CtphieuXuatNvls)
                .HasForeignKey(d => d.MaNvl)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuXu__MaNVL__395884C4");

            entity.HasOne(d => d.MaPxnvlNavigation).WithMany(p => p.CtphieuXuatNvls)
                .HasForeignKey(d => d.MaPxnvl)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuXu__MaPXN__3864608B");
        });

        modelBuilder.Entity<CtphieuXuatSp>(entity =>
        {
            entity.HasKey(e => new { e.MaPxsp, e.MaSp }).HasName("PK__CTPhieuX__9CD235C53DCBB6A2");

            entity.ToTable("CTPhieuXuatSP");

            entity.Property(e => e.MaPxsp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPXSP");
            entity.Property(e => e.MaSp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaSP");

            entity.HasOne(d => d.MaPxspNavigation).WithMany(p => p.CtphieuXuatSps)
                .HasForeignKey(d => d.MaPxsp)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuXu__MaPXS__46B27FE2");

            entity.HasOne(d => d.MaSpNavigation).WithMany(p => p.CtphieuXuatSps)
                .HasForeignKey(d => d.MaSp)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuXua__MaSP__47A6A41B");
        });

        modelBuilder.Entity<CtphieuYcsx>(entity =>
        {
            entity.HasKey(e => new { e.MaYc, e.MaSp }).HasName("PK__CTPhieuY__F55161A4EAFCAE44");

            entity.ToTable("CTPhieuYCSX");

            entity.Property(e => e.MaYc)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaYC");
            entity.Property(e => e.MaSp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaSP");
            entity.Property(e => e.SoLuongSx).HasColumnName("SoLuongSX");

            entity.HasOne(d => d.MaSpNavigation).WithMany(p => p.CtphieuYcsxes)
                .HasForeignKey(d => d.MaSp)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuYCS__MaSP__6B24EA82");

            entity.HasOne(d => d.MaYcNavigation).WithMany(p => p.CtphieuYcsxes)
                .HasForeignKey(d => d.MaYc)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPhieuYCS__MaYC__6A30C649");
        });

        modelBuilder.Entity<CtpnhangHoan>(entity =>
        {
            entity.HasKey(e => new { e.MaPnhh, e.MaSp }).HasName("PK__CTPNHang__62E323D81943E952");

            entity.ToTable("CTPNHangHoan");

            entity.Property(e => e.MaPnhh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPNHH");
            entity.Property(e => e.MaSp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaSP");

            entity.HasOne(d => d.MaPnhhNavigation).WithMany(p => p.CtpnhangHoans)
                .HasForeignKey(d => d.MaPnhh)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPNHangH__MaPNH__4E53A1AA");

            entity.HasOne(d => d.MaSpNavigation).WithMany(p => p.CtpnhangHoans)
                .HasForeignKey(d => d.MaSp)
                .OnDelete(DeleteBehavior.ClientSetNull)
                .HasConstraintName("FK__CTPNHangHo__MaSP__4F47C5E3");
        });

        modelBuilder.Entity<DanhMucChi>(entity =>
        {
            entity.HasKey(e => e.MaDmt).HasName("PK__DanhMucC__3D8821A1A593C39D");

            entity.ToTable("DanhMucChi");

            entity.Property(e => e.MaDmt)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaDMT");
            entity.Property(e => e.TenDmt)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("TenDMT");
        });

        modelBuilder.Entity<DanhMucThu>(entity =>
        {
            entity.HasKey(e => e.MaDmt).HasName("PK__DanhMucT__3D8821A158F61996");

            entity.ToTable("DanhMucThu");

            entity.Property(e => e.MaDmt)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaDMT");
            entity.Property(e => e.TenDmt)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("TenDMT");
        });

        modelBuilder.Entity<DonDh>(entity =>
        {
            entity.HasKey(e => e.MaDdh).HasName("PK__DonDH__3D88C80431349531");

            entity.ToTable("DonDH");

            entity.Property(e => e.MaDdh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaDDH");
            entity.Property(e => e.MaKh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaKH");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.TinhTrang)
                .HasMaxLength(50)
                .IsUnicode(false);

            entity.HasOne(d => d.MaKhNavigation).WithMany(p => p.DonDhs)
                .HasForeignKey(d => d.MaKh)
                .HasConstraintName("FK__DonDH__MaKH__14270015");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.DonDhs)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__DonDH__MaNV__151B244E");
        });

        modelBuilder.Entity<HinhAnhQc>(entity =>
        {
            entity.HasKey(e => e.MaAnhQc).HasName("PK__HinhAnhQ__B99466BFFDFD2D25");

            entity.ToTable("HinhAnhQC");

            entity.Property(e => e.MaAnhQc)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaAnhQC");
            entity.Property(e => e.HinhAnhQc1)
                .HasColumnType("text")
                .HasColumnName("HinhAnhQC");
            entity.Property(e => e.MaCd)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaCD");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.MoTa)
                .HasMaxLength(50)
                .IsUnicode(false);

            entity.HasOne(d => d.MaCdNavigation).WithMany(p => p.HinhAnhQcs)
                .HasForeignKey(d => d.MaCd)
                .HasConstraintName("FK__HinhAnhQC__MaCD__0D7A0286");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.HinhAnhQcs)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__HinhAnhQC__MaNV__0E6E26BF");
        });

        modelBuilder.Entity<HoaDon>(entity =>
        {
            entity.HasKey(e => e.MaHd).HasName("PK__HoaDon__2725A6E026D31A17");

            entity.ToTable("HoaDon");

            entity.Property(e => e.MaHd)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaHD");
            entity.Property(e => e.MaDdh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaDDH");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.NgayLapHd).HasColumnName("NgayLapHD");
            entity.Property(e => e.TinhTrangHd)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("TinhTrangHD");

            entity.HasOne(d => d.MaDdhNavigation).WithMany(p => p.HoaDons)
                .HasForeignKey(d => d.MaDdh)
                .HasConstraintName("FK__HoaDon__MaDDH__1BC821DD");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.HoaDons)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__HoaDon__MaNV__1CBC4616");
        });

        modelBuilder.Entity<HopDong>(entity =>
        {
            entity.HasKey(e => e.MaHopDong).HasName("PK__HopDong__36DD434282A79EFC");

            entity.ToTable("HopDong");

            entity.Property(e => e.MaHopDong)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.TenHopDong)
                .HasMaxLength(100)
                .IsUnicode(false);
            entity.Property(e => e.VanBan).HasColumnType("text");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.HopDongs)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__HopDong__MaNV__47DBAE45");
        });

        modelBuilder.Entity<KhachHang>(entity =>
        {
            entity.HasKey(e => e.MaKh).HasName("PK__KhachHan__2725CF1E25AD9686");

            entity.ToTable("KhachHang");

            entity.Property(e => e.MaKh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaKH");
            entity.Property(e => e.DiaChi)
                .HasMaxLength(255)
                .IsUnicode(false);
            entity.Property(e => e.Email)
                .HasMaxLength(100)
                .IsUnicode(false);
            entity.Property(e => e.MaLoaiKh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaLoaiKH");
            entity.Property(e => e.Sdt)
                .HasMaxLength(15)
                .IsUnicode(false)
                .HasColumnName("SDT");
            entity.Property(e => e.TenKh)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("TenKH");

            entity.HasOne(d => d.MaLoaiKhNavigation).WithMany(p => p.KhachHangs)
                .HasForeignKey(d => d.MaLoaiKh)
                .HasConstraintName("FK__KhachHang__MaLoa__114A936A");
        });

        modelBuilder.Entity<LoSanPham>(entity =>
        {
            entity.HasKey(e => e.SoLo).HasName("PK__LoSanPha__BC3CCBED856F71FF");

            entity.ToTable("LoSanPham");

            entity.Property(e => e.SoLo)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.Hsd).HasColumnName("HSD");
            entity.Property(e => e.MaSp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaSP");
            entity.Property(e => e.MaYc)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaYC");
            entity.Property(e => e.Nsx).HasColumnName("NSX");
            entity.Property(e => e.SoLuongSp).HasColumnName("SoLuongSP");

            entity.HasOne(d => d.MaSpNavigation).WithMany(p => p.LoSanPhams)
                .HasForeignKey(d => d.MaSp)
                .HasConstraintName("FK__LoSanPham__MaSP__70DDC3D8");

            entity.HasOne(d => d.MaYcNavigation).WithMany(p => p.LoSanPhams)
                .HasForeignKey(d => d.MaYc)
                .HasConstraintName("FK__LoSanPham__MaYC__6FE99F9F");
        });

        modelBuilder.Entity<LoaiKh>(entity =>
        {
            entity.HasKey(e => e.MaLoaiKh).HasName("PK__LoaiKH__12250B7EF642ADBB");

            entity.ToTable("LoaiKH");

            entity.Property(e => e.MaLoaiKh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaLoaiKH");
            entity.Property(e => e.TenLoaiKh)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("TenLoaiKH");
        });

        modelBuilder.Entity<LoaiSp>(entity =>
        {
            entity.HasKey(e => e.MaLoai).HasName("PK__LoaiSP__730A575921E19734");

            entity.ToTable("LoaiSP");

            entity.Property(e => e.MaLoai)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.TenLoai)
                .HasMaxLength(100)
                .IsUnicode(false);
        });

        modelBuilder.Entity<MauMaSp>(entity =>
        {
            entity.HasKey(e => e.MaAnhSp).HasName("PK__MauMaSP__B9947560A93A0B1D");

            entity.ToTable("MauMaSP");

            entity.Property(e => e.MaAnhSp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaAnhSP");
            entity.Property(e => e.HinhAnhSp)
                .HasColumnType("text")
                .HasColumnName("HinhAnhSP");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.MaSp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaSP");
            entity.Property(e => e.MoTa)
                .HasMaxLength(50)
                .IsUnicode(false);

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.MauMaSps)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__MauMaSP__MaNV__0A9D95DB");

            entity.HasOne(d => d.MaSpNavigation).WithMany(p => p.MauMaSps)
                .HasForeignKey(d => d.MaSp)
                .HasConstraintName("FK__MauMaSP__MaSP__09A971A2");
        });

        modelBuilder.Entity<NguyenVatLieu>(entity =>
        {
            entity.HasKey(e => e.MaNvl).HasName("PK__NguyenVa__3A197864A1BAEDAC");

            entity.ToTable("NguyenVatLieu");

            entity.Property(e => e.MaNvl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNVL");
            entity.Property(e => e.GhiChu)
                .HasMaxLength(255)
                .IsUnicode(false);
            entity.Property(e => e.TenNvl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("TenNVL");
        });

        modelBuilder.Entity<NhaCungCap>(entity =>
        {
            entity.HasKey(e => e.MaNcc).HasName("PK__NhaCungC__3A185DEB5DF6A3F4");

            entity.ToTable("NhaCungCap");

            entity.Property(e => e.MaNcc)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNCC");
            entity.Property(e => e.DiaChi)
                .HasMaxLength(255)
                .IsUnicode(false);
            entity.Property(e => e.Email)
                .HasMaxLength(100)
                .IsUnicode(false);
            entity.Property(e => e.Sdt)
                .HasMaxLength(15)
                .IsUnicode(false)
                .HasColumnName("SDT");
            entity.Property(e => e.TenNcc)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("TenNCC");
        });

        modelBuilder.Entity<PhieuChi>(entity =>
        {
            entity.HasKey(e => e.MaPhieuChi).HasName("PK__PhieuChi__00AC0F198493D0E0");

            entity.ToTable("PhieuChi");

            entity.Property(e => e.MaPhieuChi)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.MaDmc)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaDMC");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.NoiDung)
                .HasMaxLength(255)
                .IsUnicode(false);

            entity.HasOne(d => d.MaDmcNavigation).WithMany(p => p.PhieuChis)
                .HasForeignKey(d => d.MaDmc)
                .HasConstraintName("FK__PhieuChi__MaDMC__59C55456");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuChis)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuChi__MaNV__5AB9788F");
        });

        modelBuilder.Entity<PhieuChiCongNo>(entity =>
        {
            entity.HasKey(e => e.MaPccn).HasName("PK__PhieuChi__54B176FDB3BD9DD3");

            entity.ToTable("PhieuChiCongNo");

            entity.Property(e => e.MaPccn)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPCCN");
            entity.Property(e => e.MaNcc)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNCC");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.NoiDung)
                .HasMaxLength(255)
                .IsUnicode(false);

            entity.HasOne(d => d.MaNccNavigation).WithMany(p => p.PhieuChiCongNos)
                .HasForeignKey(d => d.MaNcc)
                .HasConstraintName("FK__PhieuChiC__MaNCC__6166761E");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuChiCongNos)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuChiCo__MaNV__625A9A57");
        });

        modelBuilder.Entity<PhieuHoan>(entity =>
        {
            entity.HasKey(e => e.MaPh).HasName("PK__PhieuHoa__2725E7FA93F2A30B");

            entity.ToTable("PhieuHoan");

            entity.Property(e => e.MaPh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPH");
            entity.Property(e => e.MaDdh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaDDH");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");

            entity.HasOne(d => d.MaDdhNavigation).WithMany(p => p.PhieuHoans)
                .HasForeignKey(d => d.MaDdh)
                .HasConstraintName("FK__PhieuHoan__MaDDH__236943A5");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuHoans)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuHoan__MaNV__245D67DE");
        });

        modelBuilder.Entity<PhieuNghiemThu>(entity =>
        {
            entity.HasKey(e => e.MaPnt).HasName("PK__PhieuNgh__3AE3E780CAF90094");

            entity.ToTable("PhieuNghiemThu");

            entity.Property(e => e.MaPnt)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPNT");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.MaYc)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaYC");
            entity.Property(e => e.NgayNt).HasColumnName("NgayNT");
            entity.Property(e => e.VanBan).HasColumnType("text");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuNghiemThus)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuNghie__MaNV__74AE54BC");

            entity.HasOne(d => d.MaYcNavigation).WithMany(p => p.PhieuNghiemThus)
                .HasForeignKey(d => d.MaYc)
                .HasConstraintName("FK__PhieuNghie__MaYC__73BA3083");
        });

        modelBuilder.Entity<PhieuNhapNvl>(entity =>
        {
            entity.HasKey(e => e.MaPnnvl).HasName("PK__PhieuNha__77C9E3AB026D724F");

            entity.ToTable("PhieuNhapNVL");

            entity.Property(e => e.MaPnnvl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPNNVL");
            entity.Property(e => e.MaNcc)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNCC");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.MaYc)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaYC");

            entity.HasOne(d => d.MaNccNavigation).WithMany(p => p.PhieuNhapNvls)
                .HasForeignKey(d => d.MaNcc)
                .HasConstraintName("FK__PhieuNhap__MaNCC__2EDAF651");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuNhapNvls)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuNhapN__MaNV__2DE6D218");

            entity.HasOne(d => d.MaYcNavigation).WithMany(p => p.PhieuNhapNvls)
                .HasForeignKey(d => d.MaYc)
                .HasConstraintName("FK__PhieuNhapN__MaYC__2CF2ADDF");
        });

        modelBuilder.Entity<PhieuNhapSp>(entity =>
        {
            entity.HasKey(e => e.MaPnsp).HasName("PK__PhieuNha__B0913A68BA1622C2");

            entity.ToTable("PhieuNhapSP");

            entity.Property(e => e.MaPnsp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPNSP");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuNhapSps)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuNhapS__MaNV__3C34F16F");

            entity.HasMany(d => d.SoLos).WithMany(p => p.MaPnsps)
                .UsingEntity<Dictionary<string, object>>(
                    "CtphieuNhapSp",
                    r => r.HasOne<LoSanPham>().WithMany()
                        .HasForeignKey("SoLo")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__CTPhieuNha__SoLo__40058253"),
                    l => l.HasOne<PhieuNhapSp>().WithMany()
                        .HasForeignKey("MaPnsp")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__CTPhieuNh__MaPNS__3F115E1A"),
                    j =>
                    {
                        j.HasKey("MaPnsp", "SoLo").HasName("PK__CTPhieuN__7B52F6D64813C046");
                        j.ToTable("CTPhieuNhapSP");
                        j.IndexerProperty<string>("MaPnsp")
                            .HasMaxLength(10)
                            .IsUnicode(false)
                            .HasColumnName("MaPNSP");
                        j.IndexerProperty<string>("SoLo")
                            .HasMaxLength(10)
                            .IsUnicode(false);
                    });
        });

        modelBuilder.Entity<PhieuThu>(entity =>
        {
            entity.HasKey(e => e.MaPhieuThu).HasName("PK__PhieuThu__1D8B9C69D4098A61");

            entity.ToTable("PhieuThu");

            entity.Property(e => e.MaPhieuThu)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.MaDmt)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaDMT");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.NoiDung)
                .HasMaxLength(255)
                .IsUnicode(false);

            entity.HasOne(d => d.MaDmtNavigation).WithMany(p => p.PhieuThus)
                .HasForeignKey(d => d.MaDmt)
                .HasConstraintName("FK__PhieuThu__MaDMT__55F4C372");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuThus)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuThu__MaNV__56E8E7AB");
        });

        modelBuilder.Entity<PhieuThuCongNo>(entity =>
        {
            entity.HasKey(e => e.MaPtcn).HasName("PK__PhieuThu__B3095E350CA3285C");

            entity.ToTable("PhieuThuCongNo");

            entity.Property(e => e.MaPtcn)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPTCN");
            entity.Property(e => e.MaKh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaKH");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.NoiDung)
                .HasMaxLength(255)
                .IsUnicode(false);

            entity.HasOne(d => d.MaKhNavigation).WithMany(p => p.PhieuThuCongNos)
                .HasForeignKey(d => d.MaKh)
                .HasConstraintName("FK__PhieuThuCo__MaKH__5D95E53A");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuThuCongNos)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuThuCo__MaNV__5E8A0973");
        });

        modelBuilder.Entity<PhieuXuatNvl>(entity =>
        {
            entity.HasKey(e => e.MaPxnvl).HasName("PK__PhieuXua__A6316A602EB04F4F");

            entity.ToTable("PhieuXuatNVL");

            entity.Property(e => e.MaPxnvl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPXNVL");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuXuatNvls)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuXuatN__MaNV__3587F3E0");
        });

        modelBuilder.Entity<PhieuXuatSp>(entity =>
        {
            entity.HasKey(e => e.MaPxsp).HasName("PK__PhieuXua__4EA06544366D0044");

            entity.ToTable("PhieuXuatSP");

            entity.Property(e => e.MaPxsp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPXSP");
            entity.Property(e => e.MaDdh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaDDH");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");

            entity.HasOne(d => d.MaDdhNavigation).WithMany(p => p.PhieuXuatSps)
                .HasForeignKey(d => d.MaDdh)
                .HasConstraintName("FK__PhieuXuat__MaDDH__42E1EEFE");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuXuatSps)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuXuatS__MaNV__43D61337");
        });

        modelBuilder.Entity<PhieuYcsx>(entity =>
        {
            entity.HasKey(e => e.MaYc).HasName("PK__PhieuYCS__272331250CBB087E");

            entity.ToTable("PhieuYCSX");

            entity.Property(e => e.MaYc)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaYC");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.NgayBd).HasColumnName("NgayBD");
            entity.Property(e => e.NgayKt).HasColumnName("NgayKT");
            entity.Property(e => e.VanBan).HasColumnType("text");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PhieuYcsxes)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PhieuYCSX__MaNV__6754599E");
        });

        modelBuilder.Entity<Phieuktkl>(entity =>
        {
            entity.HasKey(e => e.MaPhieuKtkl).HasName("PK__phieuktk__8F85A1C491153286");

            entity.ToTable("phieuktkl");

            entity.Property(e => e.MaPhieuKtkl)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPhieuKTKL");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.NoiDung)
                .HasMaxLength(100)
                .IsUnicode(false);
            entity.Property(e => e.SoTienKtkl).HasColumnName("SoTienKTKL");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.Phieuktkls)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__phieuktkl__MaNV__4E88ABD4");
        });

        modelBuilder.Entity<PhuCap>(entity =>
        {
            entity.HasKey(e => e.MaPhuCap).HasName("PK__PhuCap__F97D97382D9CF010");

            entity.ToTable("PhuCap");

            entity.Property(e => e.MaPhuCap)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.NoiDungPc)
                .HasMaxLength(255)
                .IsUnicode(false)
                .HasColumnName("NoiDungPC");
            entity.Property(e => e.TenPhuCap)
                .HasMaxLength(100)
                .IsUnicode(false);

            entity.HasMany(d => d.MaNvs).WithMany(p => p.MaPhuCaps)
                .UsingEntity<Dictionary<string, object>>(
                    "NvPhuCap",
                    r => r.HasOne<ThongTinNhanVien>().WithMany()
                        .HasForeignKey("MaNv")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__NV_PhuCap__MaNV__5BE2A6F2"),
                    l => l.HasOne<PhuCap>().WithMany()
                        .HasForeignKey("MaPhuCap")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__NV_PhuCap__MaPhu__5AEE82B9"),
                    j =>
                    {
                        j.HasKey("MaPhuCap", "MaNv").HasName("PK__NV_PhuCa__4B0FCA485C6BC57E");
                        j.ToTable("NV_PhuCap");
                        j.IndexerProperty<string>("MaPhuCap")
                            .HasMaxLength(10)
                            .IsUnicode(false);
                        j.IndexerProperty<string>("MaNv")
                            .HasMaxLength(10)
                            .IsUnicode(false)
                            .HasColumnName("MaNV");
                    });
        });

        modelBuilder.Entity<PnhangHoan>(entity =>
        {
            entity.HasKey(e => e.MaPnhh).HasName("PK__PNHangHo__B0917359C6E3BACB");

            entity.ToTable("PNHangHoan");

            entity.Property(e => e.MaPnhh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaPNHH");
            entity.Property(e => e.MaDdh)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaDDH");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");

            entity.HasOne(d => d.MaDdhNavigation).WithMany(p => p.PnhangHoans)
                .HasForeignKey(d => d.MaDdh)
                .HasConstraintName("FK__PNHangHoa__MaDDH__4A8310C6");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.PnhangHoans)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__PNHangHoan__MaNV__4B7734FF");
        });

        modelBuilder.Entity<QtcongTac>(entity =>
        {
            entity.HasKey(e => e.MaQt).HasName("PK__QTCongTa__2725F85A46138581");

            entity.ToTable("QTCongTac");

            entity.Property(e => e.MaQt)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaQT");
            entity.Property(e => e.MaBp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaBP");
            entity.Property(e => e.MaCv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaCV");
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.ThoiGianBd).HasColumnName("ThoiGianBD");
            entity.Property(e => e.ThoiGianKt).HasColumnName("ThoiGianKT");

            entity.HasOne(d => d.MaBpNavigation).WithMany(p => p.QtcongTacs)
                .HasForeignKey(d => d.MaBp)
                .HasConstraintName("FK__QTCongTac__MaBP__44FF419A");

            entity.HasOne(d => d.MaCvNavigation).WithMany(p => p.QtcongTacs)
                .HasForeignKey(d => d.MaCv)
                .HasConstraintName("FK__QTCongTac__MaCV__440B1D61");

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.QtcongTacs)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__QTCongTac__MaNV__4316F928");
        });

        modelBuilder.Entity<SanPham>(entity =>
        {
            entity.HasKey(e => e.MaSp).HasName("PK__SanPham__2725081C6ABF4E21");

            entity.ToTable("SanPham");

            entity.Property(e => e.MaSp)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaSP");
            entity.Property(e => e.Klt)
                .HasMaxLength(20)
                .IsUnicode(false)
                .HasColumnName("KLT");
            entity.Property(e => e.MaLoai)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.TenSp)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("TenSP");
            entity.Property(e => e.ThanhPhan)
                .HasMaxLength(500)
                .IsUnicode(false);

            entity.HasOne(d => d.MaLoaiNavigation).WithMany(p => p.SanPhams)
                .HasForeignKey(d => d.MaLoai)
                .HasConstraintName("FK__SanPham__SoLuong__6477ECF3");
        });

        modelBuilder.Entity<TaiKhoan>(entity =>
        {
            entity.HasKey(e => e.Username).HasName("PK__TaiKhoan__536C85E5A1862A78");

            entity.ToTable("TaiKhoan");

            entity.Property(e => e.Username)
                .HasMaxLength(20)
                .IsUnicode(false);
            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.Password)
                .HasMaxLength(20)
                .IsUnicode(false);

            entity.HasOne(d => d.MaNvNavigation).WithMany(p => p.TaiKhoans)
                .HasForeignKey(d => d.MaNv)
                .HasConstraintName("FK__TaiKhoan__MaNV__398D8EEE");
        });

        modelBuilder.Entity<ThongTinNhanVien>(entity =>
        {
            entity.HasKey(e => e.MaNv).HasName("PK__ThongTin__2725D70A776533A1");

            entity.ToTable("ThongTinNhanVien");

            entity.Property(e => e.MaNv)
                .HasMaxLength(10)
                .IsUnicode(false)
                .HasColumnName("MaNV");
            entity.Property(e => e.GioiTinh)
                .HasMaxLength(3)
                .IsUnicode(false);
            entity.Property(e => e.QueQuan)
                .HasMaxLength(50)
                .IsUnicode(false);
            entity.Property(e => e.Sdt)
                .HasMaxLength(15)
                .IsUnicode(false)
                .HasColumnName("SDT");
            entity.Property(e => e.Tdhv)
                .HasMaxLength(50)
                .IsUnicode(false)
                .HasColumnName("TDHV");
            entity.Property(e => e.TenNv)
                .HasMaxLength(100)
                .IsUnicode(false)
                .HasColumnName("TenNV");
        });

        modelBuilder.Entity<UuDai>(entity =>
        {
            entity.HasKey(e => e.MaUuDai).HasName("PK__UuDai__9650302A7373100B");

            entity.ToTable("UuDai");

            entity.Property(e => e.MaUuDai)
                .HasMaxLength(10)
                .IsUnicode(false);
            entity.Property(e => e.NoiDungUuDai)
                .HasMaxLength(255)
                .IsUnicode(false);

            entity.HasMany(d => d.MaCds).WithMany(p => p.MaUuDais)
                .UsingEntity<Dictionary<string, object>>(
                    "UuDaiChienDich",
                    r => r.HasOne<ChienDich>().WithMany()
                        .HasForeignKey("MaCd")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__UuDai_Chie__MaCD__06CD04F7"),
                    l => l.HasOne<UuDai>().WithMany()
                        .HasForeignKey("MaUuDai")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__UuDai_Chi__MaUuD__05D8E0BE"),
                    j =>
                    {
                        j.HasKey("MaUuDai", "MaCd").HasName("PK__UuDai_Ch__C42268CA45F7335D");
                        j.ToTable("UuDai_ChienDich");
                        j.IndexerProperty<string>("MaUuDai")
                            .HasMaxLength(10)
                            .IsUnicode(false);
                        j.IndexerProperty<string>("MaCd")
                            .HasMaxLength(10)
                            .IsUnicode(false)
                            .HasColumnName("MaCD");
                    });

            entity.HasMany(d => d.MaLoaiKhs).WithMany(p => p.MaUuDais)
                .UsingEntity<Dictionary<string, object>>(
                    "UuDaiLoaiKh",
                    r => r.HasOne<LoaiKh>().WithMany()
                        .HasForeignKey("MaLoaiKh")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__UuDai_Loa__MaLoa__02FC7413"),
                    l => l.HasOne<UuDai>().WithMany()
                        .HasForeignKey("MaUuDai")
                        .OnDelete(DeleteBehavior.ClientSetNull)
                        .HasConstraintName("FK__UuDai_Loa__MaUuD__02084FDA"),
                    j =>
                    {
                        j.HasKey("MaUuDai", "MaLoaiKh").HasName("PK__UuDai_Lo__6772609DC5742520");
                        j.ToTable("UuDai_LoaiKH");
                        j.IndexerProperty<string>("MaUuDai")
                            .HasMaxLength(10)
                            .IsUnicode(false);
                        j.IndexerProperty<string>("MaLoaiKh")
                            .HasMaxLength(10)
                            .IsUnicode(false)
                            .HasColumnName("MaLoaiKH");
                    });
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
