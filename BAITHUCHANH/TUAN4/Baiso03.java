//package BAITHUCHANH.TUAN4;
import java.util.*;

public class Baiso03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so nguyen duong: ");
        int n = sc.nextInt();
        int s = 1;
        for (int i = 1; i <= n; i++) {
            s = s*i;
        }
        System.out.println("Giai thua cua " + n + " la: " + s);
        sc.close();
    }
    
}
