package BAITHUCHANH.TUAN7.KHANH.BT3;
import java.util.*;

public class TKnganhang {
    private long SoTK;
    private String ChuTK;
    private double SoDu;
    private String password;
    static Scanner sc;

    public long getSOTK(){
        return this.SoTK;
    }
    public String getCHUTK(){
        return this.ChuTK;
    }
    public double getSODU(){
        return this.SoDu;
    }
    public String getMK(){
        return this.password;
    }
    public void setSOTK(long tkmoi){
        this.SoTK = tkmoi;
    }
    public void doiMatKhau(String newMK){
        this.password = newMK;
    }
    public void GUITIEN(Double TienGui){
        this.SoDu = this.SoDu + TienGui;
    }
    
    public void RUTTIEN(Double TienRut){
        this.SoDu = this.SoDu - TienRut;
    }

    public void NHAP(){
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao So Tai Khoan: ");
        this.SoTK = sc.nextLong();
        sc.nextLine();
        System.out.printf("Nhap vao Chu Tai Khoan: ");
        this.ChuTK = sc.nextLine();
        System.out.printf("Nhap vao mat khau ngan hang: ");
        this.password = sc.nextLine();
        System.out.printf("Nhap vao So Du: ");
        this.SoDu = sc.nextDouble();
        sc.nextLine();
    }

    public void XUAT(){
        System.out.printf("\nSo tai khoan       : %d", getSOTK());
        System.out.printf("\nTen chu tai khoan  : %s", getCHUTK());
        System.out.printf("\nMat khau ngan hang : %s", getMK());
        System.out.printf("\nSo du tai khoan    : %.3f", getSODU());
    }
    public void KiemTraSoDu(){
        System.out.printf("\nSo du hien tai    : %.3f", getSODU());
    }
}
