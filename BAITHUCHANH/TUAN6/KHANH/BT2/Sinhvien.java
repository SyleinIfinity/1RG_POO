package BAITHUCHANH.TUAN6.KHANH.BT2;

import java.util.*;

public class Sinhvien {
    private long Masv;
    private String Name;
    private String Date;
    private double DiemTB;
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
        System.out.printf("%s %20s %20s %20.2f\n", this.Masv, this.Name, this.Date, this.DiemTB);
    }

    public static void SAPXEP(Sinhvien[] DSSinhvien) {
        //Sử dụng Method Reference
        Arrays.sort(DSSinhvien, Comparator.comparingDouble(Sinhvien::getDIEMTB).reversed());

        // //Sử dụng Lambda Expression
        // Arrays.sort(DSSinhvien, (sv1, sv2) -> Double.compare(sv2.getDIEMTB(), sv1.getDIEMTB()));
    }

    // // Sử dụng Collections Framework
    // public void sapXep(List<Sinhvien> DSSinhvien) {
    //     DSSinhvien.sort(Comparator.comparingDouble(Sinhvien::getDIEMTB).reversed());
    // }
    
}
