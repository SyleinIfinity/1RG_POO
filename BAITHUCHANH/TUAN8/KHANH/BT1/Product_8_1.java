package BAITHUCHANH.TUAN8.KHANH.BT1;
import java.util.*;

public class Product_8_1 {
    static String dongvat;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.printf("Danh sach DV hien tai:\nMeo, Cho, Chim.\n");
        System.out.printf("Nhap vao ten DV:");
        dongvat = sc.nextLine();
        Meo cat = new Meo();
        Cho dog = new Cho();
        Chim bird = new Chim();
        if(dongvat.equalsIgnoreCase("Meo")){
            cat.NHAP();
            cat.XUAT();      
        } else if (dongvat.equalsIgnoreCase("Cho")) {
            dog.NHAP();
            dog.XUAT();
        } else if (dongvat.equalsIgnoreCase("Chim")) {
            bird.NHAP();
            bird.XUAT();
        } else{
            System.out.println("Dong vat nhap vao ngoai danh sach");
        }
    }
}
