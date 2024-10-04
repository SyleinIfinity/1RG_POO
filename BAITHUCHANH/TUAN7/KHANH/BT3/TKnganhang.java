package BAITHUCHANH.TUAN7.KHANH.BT3;
import java.util.*;

public class TKnganhang {
    private long SoTK;
    private String ChuTK;
    private double SoDu;
    private String password;
    static Scanner sc;
    private String newMK;

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
    public String newMK(){
        return this.password = newMK;
    }

    public void NHAPALL(){
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
    public void NHAPNEWMK(){
        System.out.printf("\nNhap mat khau muon doi: ");
        this.newMK = sc.nextLine();
    }

    public void XUATALL(){
        System.out.printf("\nSo tai khoan: %20d", getSOTK());
        System.out.printf("\nTen chu tai khoan: %20s", getCHUTK());
        System.out.printf("\nMat khau ngan hang: %20s", getMK());
        System.out.printf("\nSo du tai khoan: %20.3f", getSODU());
    }
    public void XUATNEWMK(){
        System.out.printf("\nMat khau moi la: %s", newMK());
    }
}
