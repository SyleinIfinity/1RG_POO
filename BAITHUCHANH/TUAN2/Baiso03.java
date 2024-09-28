// package BAITHUCHANH.TUAN2;

import java.util.Scanner;
public class Baiso03 {
    public static void main(String[] args) {
        int x, y, tong, hieu, tich, du;
        double thuong;
        Scanner dataInput = new Scanner(System.in);
        
        System.out.println("Nhap so thu nhat: ");
        x = dataInput.nextInt();
        
        System.out.println("Nhap so thu hai: ");
        y = dataInput.nextInt();
        tong = x + y;
        hieu = x - y;
        tich = x * y;

        System.out.println("Tong cua " + x + " va " + y + " la " + tong);
        System.out.println("Hieu cua " + x + " tru di " + y + " la " + hieu);
        System.out.println("Tich cua " + x + " va " + y + " la " + tich);

        if (y != 0) {
            thuong = (double) x / y;
            thuong = Math.round(thuong * 100.0) / 100.0;
            du = x % y;
            System.out.println("Thuong cua " + x + " chia cho " + y + " la " + thuong);
            System.out.println("Phan du cua " + x + " chia cho " + y + " la " + du);
        } else {
            System.out.println("Khong the chia cho 0");
        }
        dataInput.close();
    }
}
