package Bai1;

import java.util.Scanner;

public class chunhat extends Hinh {
    private double cd;
    private double cr;
    static Scanner sc;
    public chunhat(String A, double CD, double CR){
        super(A);
        this.cr = CR;
        this.cd = CD;
    }
    public double Chuvi(){
        return ((this.cd + this.cr) * 2);
    }
    public double DienTich(){
        return this.cr * this.cd;
    }
    public void XuatCN(){
        super.XUAT();
        System.out.printf("Chu vi hinh la: %.3f", Chuvi());
        System.out.printf("\nDien tich la: %.3f\n", DienTich());
    }
}
