package demo;
import java.util.ArrayList;
public class TaiKhoanThanhToan extends TaiKhoan {
    private double phiGiaoDich;
    private NganHang nganHang;

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, String matKhau, 
                            double soDu, double phiGiaoDich, String soDienThoai) {
        super(soTaiKhoan, chuTaiKhoan, matKhau, soDu, soDienThoai);
        this.phiGiaoDich = phiGiaoDich;
    }

    @Override
    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Nap tien thanh cong. So du moi: " + soDu);
            // Ghi lịch sử giao dịch cho người nạp
            nganHang.ghiGiaoDich(chuTaiKhoan, chuTaiKhoan, soTien, "Nap tien");
        }
    }
    
    @Override
    public boolean rutTien(double soTien) {
        if (soTien <= 0) {
            System.out.println("So tien rut khong hop le.");
            return false;
        }
        
        if (soTien > soDu) {
            System.out.println("So du khong du.");
            return false;
        }
    
        soDu -= soTien;
        System.out.println("Rut tien thanh cong. So du moi: " + soDu);
        // Ghi lịch sử giao dịch cho người rút
        nganHang.ghiGiaoDich(chuTaiKhoan, chuTaiKhoan, soTien, "Rut tien");
        return true;
    }

    public boolean chuyenTien(TaiKhoanThanhToan tkNhan, double soTien) {
        double tongTien = soTien + phiGiaoDich;
        if (soTien > 0 && soDu >= tongTien) {
            soDu -= tongTien;
            tkNhan.soDu += soTien; // Chỉ cập nhật số dư, không gọi napTien()
            // Ghi lịch sử giao dịch chỉ cho người chuyển
            nganHang.ghiGiaoDich(chuTaiKhoan, tkNhan.getChuTaiKhoan(), soTien, "Chuyen tien");
            System.out.println("Chuyen tien thanh cong.");
            return true;
        } else {
            System.out.println("So du khong du hoac so tien chuyen khong hop le.");
            return false;
        }
    }

    // Thêm phương thức xem lịch sử giao dịch
    public void xemLichSuGiaoDich() {
        ArrayList<String> lichSu = (ArrayList<String>) nganHang.docLichSuGiaoDich(this.chuTaiKhoan);
        if (lichSu.isEmpty()) {
            System.out.println("Khong co lich su giao dich nao.");
        } else {
            System.out.println("\nLich su giao dich cua " + this.chuTaiKhoan + ":");
            for (String giaoDich : lichSu) {
                System.out.println(giaoDich);
            }
        }
    }
    
}