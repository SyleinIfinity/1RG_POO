package LOPTHUCHANH.TUAN8.KHANH.BT2;
import java.util.*;

public class NhanVienSanXuat extends NhanVien {
    private int SoLuong;
    private double DonGia;

    public int SoLuongSP(){
        return this.SoLuong;
    }

    public double DonGiaSP(){
        return this.DonGia;
    }

    public NhanVienSanXuat(){
        super();
    }

    public double LuongNV(){
        return SoLuong*DonGia;
    }

    public void NHAP(){
        super.NHAP();
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao ma nhan vien        : ");
        this.maNV = sc.nextLine();
        System.out.printf("Nhap vao ten nhan vien       : ");
        this.tenNV = sc.nextLine();
        System.out.printf("Nhap vao so luong SP lam duoc: ");
        this.SoLuong = sc.nextInt();
        System.out.printf("Nhap vao don gia SP lam duoc : ");
        this.DonGia = sc.nextDouble();
    }

    public void XUAT(){
        System.out.printf("\nma nhan vien        : %s  ", maNV());
        System.out.printf("\nten nhan vien       : %s  ", tenNV());
        System.out.printf("\nso luong SP lam duoc: %d  ", SoLuongSP());
        System.out.printf("\ndon gia SP lam duoc : %.3f", DonGiaSP());
        System.out.printf("\nLuong nhan vien %s nhan duoc: %.3f", tenNV(), LuongNV());
    }
    
}
