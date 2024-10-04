package BAITHUCHANH.TUAN6.KHANH.BT2;
import java.util.*;

public class Product_6_2 {
    static Scanner SCC;
    static int spt;
    static int i;
    static int j;
    public static void main(String[] args) {
        SCC = new Scanner(System.in);
        System.out.println("Nhap vao so luong sinh vien: ");
        spt = SCC.nextInt();
        Sinhvien[] DSSinhvien = new Sinhvien[spt];
        for(i= 0; i < spt; i++){
            DSSinhvien[i] = new Sinhvien();
            System.out.println("Nhap vao ds " + (i+1));
            DSSinhvien[i].NHAP();
        }

        Sinhvien.SAPXEP(DSSinhvien);
        System.out.println("MaSV                    Name                    Date                    DiemTB");
        for(Sinhvien sv : DSSinhvien){
            sv.XUAT();
        }
    }
}
