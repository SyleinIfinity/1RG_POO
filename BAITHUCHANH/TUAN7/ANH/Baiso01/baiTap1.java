//package BAITHUCHANH.TUAN7.ANH.Baiso01;
import java.util.Scanner;

public class baiTap1 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Nhập bán kính hình tròn từ người dùng
        double banKinh;
        do 
        {
            System.out.print("Nhap ban kinh hinh tron: ");
            banKinh = scanner.nextDouble();
        } while (banKinh <= 0);

        // Tạo một đối tượng Hình tròn với bán kính vừa nhập
        hinhTron hinhTron = new hinhTron(banKinh);

        // Thực hiện chức năng
        hinhTron.tinhChuViVaDienTich();

        scanner.close();
    }
}
