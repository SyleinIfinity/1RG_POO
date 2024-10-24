import java.util.Scanner;

public class TaiKhoan {
    // Thuộc tính
    public String soTaiKhoan;    
    public String chuTaiKhoan;   
    public double soDu;         
    private String matKhau;        

    
    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    // nhập thông tin
    public void nhapThongTin() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so tai khoan: ");
        this.soTaiKhoan = scanner.nextLine();

        System.out.print("Nhap chu tai khoan: ");
        this.chuTaiKhoan = scanner.nextLine();

        System.out.print("Nhap so du: ");
        this.soDu = scanner.nextDouble();
        scanner.nextLine(); // Đọc bỏ dòng mới

        System.out.print("Nhap mat khau: ");
        this.matKhau = scanner.nextLine();
    }

    // Phương thức đổi mật khẩu
    public void doiMatKhau() {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Ban co muon doi mat khau (y/n)? ");
            String traLoi = scanner.nextLine();

            if (traLoi.equalsIgnoreCase("y")) {
                System.out.print("Nhap mat khau cu: ");
                String matKhauCu = scanner.nextLine();

                if (matKhauCu.equals(matKhau)) {
                    System.out.print("Nhap mat khau moi: ");
                    String matKhauMoi = scanner.nextLine();
                    this.matKhau = matKhauMoi; // Thay đổi mật khẩu
                    System.out.println("Doi mat khau thanh cong.");
                    break;
                } else {
                    System.out.println("Mat khau cu khong dung. Vui long nhap lai.");
                }
            } else if (traLoi.equalsIgnoreCase("n")) {
                System.out.println("Khong doi mat khau.");
                break;
            } else {
                System.out.println("Lua chon khong hop le. Vui long nhap 'y' hoac 'n'.");
            }
        }
    }

    // in
    public void inThongTin() {
        System.out.println("So tai khoan: " + this.soTaiKhoan);
        System.out.println("Chu tai khoan: " + this.chuTaiKhoan);
        System.out.println("So du: " + this.soDu);
    }
}