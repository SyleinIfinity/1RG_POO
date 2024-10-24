package LOPTHUCHANH.TUAN8.KHANH.BT2;
import java.util.*;

public class NhanVienVanPhong extends NhanVien{
    private double LuongCB;
    private double HeSo;

    public double LuongCB(){
        return this.LuongCB;
    }

    public double heSoLuong(){
        return this.HeSo;
    }

    public NhanVienVanPhong(){
        super();
    }

    public double LuongNV(){
        return LuongCB*HeSo;
    }

    public void NHAP(){
        super.NHAP();
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao ma nhan vien        : ");
        this.maNV = sc.nextLine();
        System.out.printf("Nhap vao ten nhan vien       : ");
        this.tenNV = sc.nextLine();
        System.out.printf("Nhap vao LuongCB of Nhan Vien: ");
        this.LuongCB = sc.nextDouble();
        System.out.printf("Nhap vao heso luong nhan vien: ");
        this.HeSo = sc.nextDouble();
    }

    public void XUAT(){
        System.out.printf("\nma nhan vien la              : %s  ", maNV());
        System.out.printf("\nten nhan vien la             : %s  ", tenNV());
        System.out.printf("\nLuongCB of Nhan Vien         : %.3f  ", LuongCB());
        System.out.printf("\nhe so luong nhan vien        : %.3f", heSoLuong());
        System.out.printf("\nLuong nhan vien %s nhan duoc : %.3f", tenNV(), LuongNV());
    }
    
}
