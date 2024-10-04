package ANH.Baiso03;
import java.util.*;

public class TaiKhoan {
    private String soTaiKhoan;
    private String chuTaiKhoan;
    private double soDu;
    private static Scanner sc = new Scanner(System.in);

    public String getSoTaiKhoan() {
        return this.soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return this.chuTaiKhoan;
    }

    public double getSoDu() {
        return this.soDu;
    }

    public void NHAP() {
        System.out.println("Nhap so tai khoan: ");
        this.soTaiKhoan = sc.nextLine();
        System.out.println("Nhap chu tai khoan: ");
        this.chuTaiKhoan = sc.nextLine();
        System.out.println("Nhap so du: ");
        this.soDu = sc.nextDouble();
        sc.nextLine(); // Đọc bỏ dòng mới
    }

    public void guiTien() {
        System.out.println("Nhap so tien muon gui: ");
        double tienGui = sc.nextDouble();
        if (tienGui > 0) {
            soDu += tienGui;
            System.out.println("So du hien tai: " + soDu);
        } else {
            System.out.println("So tien gui khong hop le!");
        }
    }

    public void rutTien() {
        System.out.println("Nhap so tien muon rut: ");
        double tienRut = sc.nextDouble();
        if (tienRut > 0 && tienRut <= soDu) {
            soDu -= tienRut;
            System.out.println("So du con lai sau khi rut la: " + soDu);
        } else {
            System.out.println("So tien rut khong hop le!");
        }
    }
}