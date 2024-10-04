import java.util.*;
public class XuongDucBanh_6_2 {
    static Scanner scc;
    static int spt;
    static int i;
    static int j;

    public static void main(String[] args) {
        scc = new Scanner (System.in);
        System.out.print("Nhap vao so luong sinh vien:");
        spt = scc.nextInt();
        SinhVien[] DSSinhVien = new SinhVien[spt];
        for (i=0; i< spt; i++){
            DSSinhVien[i] = new SinhVien();
            System.out.println("\nNhap vao sv " + (i+1));
            DSSinhVien[i].Nhap();
        }

        SinhVien.SAPXEP(DSSinhVien);
        System.out.println("MaSV                Ho & ten            Ngay sinh           Diem TB");
        for (SinhVien sv : DSSinhVien){
            sv.Xuat();
        }
    }
}
