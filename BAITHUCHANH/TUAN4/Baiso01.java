
// package BAITHUCHANH.TUAN4;
import java.util.*;

public class Baiso01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao so phan tu: ");
        int n = sc.nextInt();
        int s = 0;
        for (int i = 1; i <= n; i++) {
            s = s + i;
        }
        System.out.println("Tong la: " + s);
        sc.close();
    }

}
