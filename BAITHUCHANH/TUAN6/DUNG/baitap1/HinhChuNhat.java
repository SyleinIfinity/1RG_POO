import java.util.*;

public class HinhChuNhat {
    private double ChieuDai;
    private double ChieuRong;
    static Scanner sc;
    public double GetChieuDai(){
        return this.ChieuDai;
    }
    public double GetChieuRong(){
        return this.ChieuRong;
    }
    public double ChuVi(){
        return (ChieuDai + ChieuRong) *2;
    }
    public double DienTich(){
        return (ChieuDai * ChieuRong);
    }
    public void Nhap(){
        sc = new Scanner (System.in);
        System.out.print("Nhap vao chieu dai: ");
        this.ChieuDai = sc.nextDouble();
        System.out.print("Nhap vao chieu rong: ");
        this.ChieuRong = sc.nextDouble();
    }
    public void Xuat (){
        System.out.println("Chu vi = " +ChuVi());
        System.out.println("Dien Tich = " +DienTich());       
    }
}
