import java.text.DecimalFormat;

public class Main_1 {
    public static void main(String[] args) {
        HinhTron hinhTron = new HinhTron();
        hinhTron.nhapBanKinh();
        
        // In ra ket qua
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println("Ban kinh: " + hinhTron.getBanKinh());
        System.out.println("Chu vi: " + df.format(hinhTron.tinhChuVi()));
        System.out.println("Dien tich: " + df.format(hinhTron.tinhDienTich()));
    }
}