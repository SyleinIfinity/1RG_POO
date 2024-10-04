import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SinhVien {
    private long MaSV;
    private String HoTen;
    private String NgaySinh;
    private double DiemTB;
    static Scanner sc;

    public long GetMaSV(){
        return this.MaSV;
    }
    public String GetHoTen(){
        return this.HoTen;
    }public String GetNgaySinh(){
        return this.NgaySinh;
    }public double GetDiemTB(){
        return this.DiemTB;
    }
    public void Nhap(){
        sc = new Scanner (System.in);
        System.out.printf("Nhap vao ma sinh vien: ");
        this.MaSV = sc.nextLong();
        sc.nextLine();
        System.out.printf("Nhap Ho va ten: ");
        this.HoTen = sc.nextLine();
        System.out.printf("Nhap Ngay sinh: ");
        this.NgaySinh = sc.nextLine();
        System.out.printf("Nhap Diem trung binh: ");
        this.DiemTB = sc.nextDouble();
    }
    public void Xuat(){
        System.out.printf("%s %20s %20s %20.2f\n", this.MaSV, this.HoTen, this.NgaySinh, this.DiemTB);
    }
    public static void SAPXEP(SinhVien[] DSSinhVien){
        Arrays.sort(DSSinhVien, Comparator.comparingDouble(SinhVien::GetDiemTB).reversed());
    }
}
