package Bai1;
import java.util.*;

public class tron extends Hinh {
    private double bk;
    static Scanner sc;
    public double Chuvi(){
        return Math.PI*2*this.bk;
    }
    public double DienTich(){
        return Math.PI*Math.pow(this.bk, 2);
    }
    public tron(String A, double R){
        super(A);
        this.bk = R;
    }
    public void Xuat(){
        super.XUAT();
        System.out.println("Ban kinh la: " + this.bk);
        System.out.printf("Chu vi hinh la: %.3f", Chuvi());
        System.out.printf("\nDien tich la: %.3f", DienTich());
    }
}