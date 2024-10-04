package BAITHUCHANH.TUAN7.KHANH.BT1;
import java.util.*;

public class hinhtron {
    private double bk;
    static Scanner sc;
    public double getBK(){
        return this.bk;
    }
    public double Chuvi(){
        return Math.PI*2*this.bk;
    }
    public double DienTich(){
        return Math.PI*Math.pow(this.bk, this.bk);
    }
    public void NHAP(){
        System.out.printf("Nhap vao ban kinh: ");
        sc = new Scanner(System.in);
        while (getBK() <= 0) {
            this.bk = sc.nextDouble();
            if (getBK() <= 0) {
                System.out.printf("ban kinh chi nhan gia tri duong, moi nhap lai.\n");
            }
        }
    }
    public void XUAT(){
        System.out.printf("Ban kinh hinh tron: %f\n", getBK());
        System.out.printf("Chu vi hinh tron: %f\n", Chuvi());
        System.out.printf("Dien tich hinh tron: %f\n", DienTich());
    }
}
