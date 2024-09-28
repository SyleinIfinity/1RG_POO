import java.util.*;

public class baitap4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so phan tu cua mang: ");
        int n = scanner.nextInt();

        int[] a = new int[n];

        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu thu " + (i + 1) + ": ");
            a[i] = scanner.nextInt();
        }

        int ObjectMax = a[0];
        int AMax = 1;

        for (int i = 0; i < n; i++) {
            int dem = 1;
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    dem++;
                }
            }
            if (dem > AMax) {
                AMax = dem;
                ObjectMax = a[i];
            }
        }

        System.out.println("Phần tử xuất hiện nhiều nhất là: " + ObjectMax);
        System.out.println("Số lần xuất hiện: " + AMax);
    }
}
