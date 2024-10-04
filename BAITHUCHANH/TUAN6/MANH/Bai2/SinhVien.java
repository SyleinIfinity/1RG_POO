package Bai2;
import java.util.*;
public class SinhVien {
    private String MaSv;
    private String Ten;
    private String Brt;
    private float dtb; 
    private Scanner sc = new Scanner(System.in);
    public SinhVien(){
       
    }
    public float getDtb() {
        return dtb;
    }
    public void Nhap(){
        System.out.print("Nhap ma sinh vien: ");
        this.MaSv = sc.nextLine();
        System.out.print("Nhap ten sinh vien: ");
        this.Ten = sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        this.Brt = sc.nextLine();
        System.out.print("Nhap diem trung binh: ");
        this.dtb = sc.nextFloat();
    }

    public void XuatSV(){
        System.out.println("Ten Sinh Vien la : " + this.Ten);
        System.out.println("Ma Sinh Vien la : " + this.MaSv);
        System.out.println("Ngay sinh : " + this.Brt);
        System.out.println("Diem trung binh la : " + this.dtb);
    }

}
