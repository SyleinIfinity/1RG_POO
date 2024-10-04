package BAITHUCHANH.TUAN6.KHANH.BT1;

import java.util.*;

public class hinhchunhat {
        private double ChieuDai;
        private double ChieuRong;
        static Scanner sc;
        
        public double GetChieudai(){
            return this.ChieuDai;
        }
        public double getChieuRong(){
            return this.ChieuRong;
        }

        public double ChuVi(){
            return (ChieuDai+ChieuRong)*2;
        }
        public double DienTich() {
            return ChieuDai*ChieuRong;
        }

        public void NHAP(){
            sc = new Scanner(System.in);
            System.out.println("Nhap vao Chieu dai và Chieu rong: ");
            this.ChieuDai = sc.nextDouble();
            this.ChieuRong = sc.nextDouble();
        }
        public void XUAT(){
            System.out.println("ban kinh= " + ChuVi());
            System.out.println("DienTich= " + DienTich());
        }
}
