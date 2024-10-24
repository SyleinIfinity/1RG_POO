package LOPTHUCHANH.TUAN8.KHANH.BT2;
import java.util.*;

public class Product_8_2 {
    static String dongvat;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.printf("Danh sach Loai Nhan Vien:\nVanPhong, SanXuat\n");
        System.out.printf("Nhap vao loai:");
        dongvat = sc.nextLine();
        NhanVienSanXuat NVSX = new NhanVienSanXuat();
        NhanVienVanPhong NVVP = new NhanVienVanPhong();
        if(dongvat.equalsIgnoreCase("San Xuat")){
            NVSX.NHAP();
            NVSX.XUAT();      
        } else if (dongvat.equalsIgnoreCase("VanPhong")) {
            NVVP.NHAP();
            NVVP.XUAT();
        } else {
            System.out.println("Nhan vien nhap vao ngoai danh sach");
        }
    }
}
