package BAITHUCHANH.TUAN4;

import java.util.*;

public class BT4_Extend {
    static Scanner sc;
    static int x;
    static void main(String[] args) {
        sc = new Scanner(System.in);
        do {
            System.out.printf("Nhap vao so: ");
            x = sc.nextInt();
            if(KTRA(x) == 1){
                System.out.printf("So %d la so nguyen to.", x);
            } else {
                System.out.printf("So %d khong phai la so nguyen to.", x);
            }
            System.out.printf("\n");
        } while (KTRA(x) == 0);
    }
    static int KTRA(int n) {
        if (n <= 1){
            return 0;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return 0;
        }
        return 1;
    }
}
