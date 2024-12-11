package demo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat;
    private int kyHan;
    private LocalDate ngayMoTaiKhoan;
    private LocalDate ngayDenHan;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, String matKhau, 
                           double laiSuat, int kyHan, String ngayMoTaiKhoan, String soDienThoai) {
        super(soTaiKhoan, chuTaiKhoan, matKhau, 0, soDienThoai);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
        this.ngayMoTaiKhoan = LocalDate.parse(ngayMoTaiKhoan);
    }

    @Override
    public void napTien(double soTien) {
        if (soTien > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nChon ky han gui tiet kiem:");
            System.out.println("1. 1 thang (3.5%/nam)");
            System.out.println("2. 2 thang (3.7%/nam)");
            System.out.println("3. 3 thang (3.8%/nam)");
            System.out.println("4. 6 thang (4.7%/nam)");
            System.out.println("5. 9 thang (4.8%/nam)");
            System.out.println("6. 12 thang (5.2%/nam)");
            System.out.println("7. 18 thang (5.4%/nam)");
            System.out.println("8. 24 thang (5.7%/nam)");
            System.out.println("9. 36 thang (6.0%/nam)");
            System.out.print("Chon ky han (1-9): ");
            
            int choice = scanner.nextInt();
            setKyHanVaLaiSuat(choice);
            
            soDu = soTien;
            ngayMoTaiKhoan = LocalDate.now();
            ngayDenHan = ngayMoTaiKhoan.plusMonths(kyHan);
            
            System.out.println("\nThong tin gui tiet kiem:");
            System.out.println("So tien gui: " + String.format("%,.0f", soDu) + " VND");
            System.out.println("Ky han: " + kyHan + " thang");
            System.out.println("Lai suat: " + laiSuat + "%/nam");
            System.out.println("Ngay gui: " + ngayMoTaiKhoan.format(formatter));
            System.out.println("Ngay den han: " + ngayDenHan.format(formatter));
            
            double tienLai = tinhTienLai();
            double tongTien = soDu + tienLai;
            System.out.println("Tien lai du kien: " + String.format("%,.0f", tienLai) + " VND");
            System.out.println("Tong tien nhan du kien: " + String.format("%,.0f", tongTien) + " VND");
        } else {
            System.out.println("So tien nap khong hop le.");
        }
    }

    private void setKyHanVaLaiSuat(int choice) {
        switch (choice) {
            case 1: kyHan = 1; laiSuat = 3.5; break;
            case 2: kyHan = 2; laiSuat = 3.7; break;
            case 3: kyHan = 3; laiSuat = 3.8; break;
            case 4: kyHan = 6; laiSuat = 4.7; break;
            case 5: kyHan = 9; laiSuat = 4.8; break;
            case 6: kyHan = 12; laiSuat = 5.2; break;
            case 7: kyHan = 18; laiSuat = 5.4; break;
            case 8: kyHan = 24; laiSuat = 5.7; break;
            case 9: kyHan = 36; laiSuat = 6.0; break;
            default: kyHan = 1; laiSuat = 3.5;
        }
    }

    public double tinhTienLai() {
        return soDu * (laiSuat / 100) * (kyHan / 12.0);
    }

    @Override
    public boolean rutTien(double soTien) {
        LocalDate ngayHienTai = LocalDate.now();
        if (ngayHienTai.isBefore(ngayDenHan)) {
            System.out.println("Chua den ngay dao han. Khong the rut tien.");
            return false;
        }
        
        if (soTien > 0 && soDu >= soTien) {
            soDu -= soTien;
            System.out.println("Rut tien thanh cong. So du moi: " + String.format("%,.0f", soDu) + " VND");
            return true;
        } else {
            System.out.println("So du khong du hoac so tien rut khong hop le.");
            return false;
        }
    }
}