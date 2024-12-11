import java.text.DecimalFormat;
import java.util.*;

public class taiKhoan {
    // Thuộc tính
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private String matKhau;

    // Constructor
    public taiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) 
    {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    // Phương thức gửi tiền
    public void guiTien(double soTien) 
    {
        if (soTien > 0) 
        {
            soDu += soTien;
            System.out.println("Da gui " + dinhDangSo(soTien) + ". So du hien tai: " + dinhDangSo(soDu));
        } else 
        {
            System.out.println("So tien gui khong hop le.");
        }
    }

    // Phương thức rút tiền
    public void rutTien(double soTien) 
    {
        if (soTien > 0 && soTien <= soDu) 
        {
            soDu -= soTien;
            System.out.println("Da rut " + dinhDangSo(soTien) + ". So du hien tai: " + dinhDangSo(soDu));
        } else 
        {
            System.out.println("So tien rut khong hop le.");
        }
    }

    // Phương thức kiểm tra số dư
    public double kiemTraSoDu() 
    {
        System.out.println("So du hien tai: " + dinhDangSo(soDu));
        return soDu;
    }

    // Phương thức đổi mật khẩu
    public void doiMatKhau(String matKhauMoi) {
        if (matKhauMoi.equals(matKhau)) 
        {
            System.out.println("Mat khau moi khong duoc trung mat khau cu.");
            System.out.print("Nhap lai mat khau moi: ");
            Scanner scanner = new Scanner(System.in);
            matKhauMoi = scanner.next();  // Nhập lại mật khẩu mới
            doiMatKhau(matKhauMoi); // Gọi lại phương thức để kiểm tra mật khẩu mới
        } else {
            this.matKhau = matKhauMoi;
            System.out.println("Mat khau da duoc thay doi thanh cong.");
        }
    }

    // Phương thức định dạng số
    private String dinhDangSo(double so) 
    {
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        return formatter.format(so);
    }

    // Getter cho số tài khoản
    public String getSoTaiKhoan() 
    {
        return soTaiKhoan;
    }

    // Getter cho chủ tài khoản
    public String getChuTaiKhoan() 
    {
        return chuTaiKhoan;
    }
}
