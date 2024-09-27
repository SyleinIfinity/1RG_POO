package BAITHUCHANH.TUAN6;

import java.util.Scanner;

public class BT1 {
    public class HinhChuNhat {
        static Scanner sc;
        static double ChieuDai;
        static double ChieuRong;
        static double ChuVi;
        static double DienTich;
        public static void main(String[] args) {
            sc = new Scanner(System.in);
            System.out.println("Nhap vao chieu rong, chieu dai: ");
            ChieuDai = sc.nextDouble();
            System.out.printf("Chu vi= %f", ChuVi());
        }
        public static double ChuVi(){
            return (ChieuDai+ChieuRong)*2;
        }
        public static double DienTich() {
            return ChieuDai*ChieuRong;
        }
    
    }
    public class SinhVien {
        
        
    }
}
