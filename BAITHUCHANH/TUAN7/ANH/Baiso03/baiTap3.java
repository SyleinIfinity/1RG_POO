import java.util.*;

public class baiTap3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập thông tin tài khoản từ người dùng
        System.out.print("Nhap so tai khoan: ");
        String soTaiKhoan = scanner.nextLine();

        System.out.print("Nhap chu tai khoan: ");
        String chuTaiKhoan = scanner.nextLine();

        System.out.print("Nhap so du: ");
        double soDu = scanner.nextDouble();

        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.next();

        // Tạo đối tượng TaiKhoan
        taiKhoan taiKhoan = new taiKhoan(soTaiKhoan, chuTaiKhoan, soDu, matKhau);

        // Kiểm tra số dư ban đầu
        taiKhoan.kiemTraSoDu();

        // Gửi tiền
        System.out.print("Nhap so tien muon gui: ");
        double soTienGui = scanner.nextDouble();
        taiKhoan.guiTien(soTienGui);

        // Rút tiền
        System.out.print("Nhap so tien muon rut: ");
        double soTienRut = scanner.nextDouble();
        taiKhoan.rutTien(soTienRut);

        // Kiểm tra số dư sau khi thực hiện giao dịch
        taiKhoan.kiemTraSoDu();

        // Đổi mật khẩu
        System.out.print("Nhap mat khau moi: ");
        String matKhauMoi = scanner.next();
        taiKhoan.doiMatKhau(matKhauMoi);
        
        scanner.close();
    }
}