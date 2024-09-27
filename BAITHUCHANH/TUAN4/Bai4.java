import java.util.*;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap n : ");
        int n = sc.nextInt();
        String a = (n > 1 && (Test(n, n - 1) == 1 || n == 2)) ? "Day la so nguyen to." : "Day khong phai so nguyen to.";
        System.out.println(a);
        sc.close();
    }
    public static int Test(int n, int a) {
        if (a == 1)
            return 1;
        if (n % a == 0 )
            return 0;
        else
            return Test(n, a - 1);
    }
}