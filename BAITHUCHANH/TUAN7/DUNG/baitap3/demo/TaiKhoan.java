package demo;
import java.util.Scanner;

public abstract class TaiKhoan {
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected String matKhau;
    protected double soDu;
    protected String maPin;
    protected String soDienThoai;

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, String matKhau, double soDu, String soDienThoai) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.matKhau = matKhau;
        this.soDu = soDu;
        this.soDienThoai = soDienThoai;
    }

    // Getters và Setters
    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public double getSoDu() {
        return soDu;
    }

    public String getMaPin() {
        return maPin;
    }

    public void setMaPin(String maPin) {
        this.maPin = maPin;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        if (kiemTraSoDienThoai(soDienThoai)) {
            this.soDienThoai = soDienThoai;
        }
    }

    // Phương thức kiểm tra mật khẩu hợp lệ

    public boolean kiemTraMatKhauu(String matKhau) {
        if (matKhau.length() < 6) {
            return false; // Độ dài tối thiểu là 6 ký tự
        }
    
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;
    
        for (char c : matKhau.toCharArray()) { //chuyển matkhau thành mảng ký tự
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;                    
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }
    
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar; // Tất cả các điều kiện phải thỏa mãn
    }

    // Phương thức nhập mã PIN
    public boolean nhapMaPin(Scanner scanner) {
        System.out.print("Nhap ma PIN: ");
        String pinNhap = scanner.nextLine();
        if (pinNhap.equals(maPin)) {
            return true;
        }
        System.out.println("Ma PIN khong dung.");
        return false;
    }

    // Thêm phương thức kiểm tra số điện thoại hợp lệ
    public static boolean kiemTraSoDienThoai(String soDienThoai) {
        return soDienThoai.matches("^[0-9]{10}$");
    }

    // Các phương thức abstract
    public abstract void napTien(double soTien);
    public abstract boolean rutTien(double soTien);
}