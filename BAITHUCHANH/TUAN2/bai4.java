
import java.util.*;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so tien gui (VND): ");
        int soTienGoi = sc.nextInt();
        System.out.print("Nhap lai suat hang nam (%): ");
        int laiSuatHangNam = sc.nextInt();
        System.out.print("Nhap so thang gui: ");
        int soThangGoi = sc.nextInt();
        int laiSuat = (int) (soTienGoi * (laiSuatHangNam / 100.0) * (soThangGoi / 12.0));
        int soTienCuoiKy = soTienGoi + laiSuat;
        System.out.printf("So tien lai: %d VND\n", laiSuat);
        System.out.printf("So tien goc cuoi ky: %d VND", soTienCuoiKy);
        System.out.printf("So tien goc cuoi ky: %d VND", soTienCuoiKy);
        sc.close();
    }
}
