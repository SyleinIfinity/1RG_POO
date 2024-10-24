import java.util.Scanner;

public class Main_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        TaiKhoan taiKhoan = new TaiKhoan("", "", 0.0, ""); 

        taiKhoan.nhapThongTin();

        // In thông tin tài khoản
        taiKhoan.inThongTin();

        // Đổi mật khẩu
        taiKhoan.doiMatKhau();

        scanner.close();
    }
}