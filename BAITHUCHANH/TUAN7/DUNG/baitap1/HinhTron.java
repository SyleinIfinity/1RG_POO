import java.util.Scanner;

public class HinhTron {

    public double banKinh;


    public HinhTron() {
        
    }

    // Phuong thuc thiet lap ban Kinh
    public void setBanKinh(double banKinh) 
    {
        if (banKinh > 0)
            this.banKinh = banKinh;
        else
            System.out.println("Ban kinh phai lon hon 0. Ban kinh khong duoc thiet lap.");
    
    }

    public double getBanKinh() {
        return this.banKinh;
    }

    //chu vi
    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }

    //dien tich
    public double tinhDienTich() {
        return Math.PI * Math.pow(banKinh, 2);
    }

    // Phuong thuc nhap banKinh
    public void nhapBanKinh() 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ban kinh hinh tron: ");
        double banKinhNhap = sc.nextDouble();
        setBanKinh(banKinhNhap);
        sc.close();
    }
    
}