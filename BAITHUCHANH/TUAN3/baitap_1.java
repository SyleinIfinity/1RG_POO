// package BAITHUCHANH.TUAN3;
import java.util.Scanner;
public class baitap_1 {
    public static void main(String[] args) {
        int a;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so bat ky: ");
        a = sc.nextInt();
        if (a<0)
            System.out.println("So " + a + " la so am");
        else if (a>0)
            System.out.println("So " + a + " la so duong");
        else 
            System.out.println("La so " + a);
        sc.close();
    }
}
//bai tuan may á...tuan 3 ok