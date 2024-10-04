import java.util.*;

public class XuongDucBanh_6_3 {
    static Scanner sc;
    public static void main(String[] args) {
        ATM kh = new ATM();
        kh.NhapThongTin();
        kh.Xuat();
        kh.NhapTienGui();
        kh.GuiTien();
        System.out.println("So du tai khoan sau khi gui tien: ");
        kh.XuatSoDu();

        kh.NhapTienRut();
        kh.RutTien();
        System.out.println("So du tai khoan sau khi rut: ");
        kh.XuatSoDu();
    }
}
