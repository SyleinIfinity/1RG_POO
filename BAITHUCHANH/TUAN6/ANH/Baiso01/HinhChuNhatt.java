package BAITHUCHANH.TUAN6.Baiso01;

import java.util.*;

public class HinhChuNhatt {
    private double chieuDai;
    private double chieuRong;
    static Scanner sc;
    public double getChieuDai(){
        return this.chieuDai;
    }
    public double getChieuRong(){
        return this.chieuRong;
    }
    public double chuVi(){
        return (chieuDai + chieuRong)*2;
    }
    public double dienTich(){
        return chieuDai*chieuRong;
    }
    public void NHAP(){
        sc = new Scanner(System.in);
        System.out.println("Nhap chieu dai va chieu rong: ");
        this.chieuDai = sc.nextDouble();
        this.chieuRong = sc.nextDouble();
    }
    public void XUAT(){
        System.out.println("Chu vi = " + chuVi());
        System.out.println("Dien tich = " + dienTich());
    }
}
