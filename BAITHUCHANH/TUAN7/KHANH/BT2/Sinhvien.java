package BAITHUCHANH.TUAN7.KHANH.BT2;
import java.util.*;

public class Sinhvien {
    private long Masv;
    private String Name;
    private String Date;
    private double DiemTB;
    private String HocLuc;
    static Scanner sc;
    static String Trunggian;
    public long getMASV(){
        return this.Masv;
    }
    public String getNAME(){
        return this.Name;
    }
    public String getDATE(){
        return this.Date;
    }
    public double getDIEMTB(){
        return this.DiemTB;
    }
    public String getHOCLUC(){
        return this.HocLuc;
    }

    public void NHAP(){
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao MASV: ");
        this.Masv = sc.nextLong();
        sc.nextLine();
        System.out.printf("Nhap vao NAME: ");
        this.Name = sc.nextLine();
        System.out.printf("Nhap vao DATE: ");
        this.Date = sc.nextLine();
        System.out.printf("Nhap vao DIEMTB: ");
        this.DiemTB = sc.nextDouble();
    }
    public void XUAT(){
        System.out.printf("\nMASV: %10d", getMASV());
        System.out.printf("\nNAME: %10s", getNAME());
        System.out.printf("\nNGAY SINH: %10s", getDATE());
        System.out.printf("\nDIEM TRUNG BINH: %10.2f", getDIEMTB());
        XEPLOAI();
        System.out.printf("\nHOC LUC: %10s", getHOCLUC());
    }
    private void XEPLOAI() {
        if (this.DiemTB >= 8.5) {
            this.HocLuc = "Gioi";
        } else
            if (this.DiemTB >= 7) {
                this.HocLuc = "Kha";
            } else
                if (this.DiemTB >= 5) {
                    this.HocLuc = "Trung binh";
                } else {
                    this.HocLuc = "Yeu";
                }
    }
}
