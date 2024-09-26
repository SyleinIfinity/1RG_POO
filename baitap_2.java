import java.util.Scanner;

public class baitap_2 {
    public static void main(String[] args) {
        float dtb;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap diem trung binh: ");
        dtb = sc.nextFloat();
        if (dtb > 8.0)
            System.out.println("Gioi");
        else if (dtb >= 6.5 && dtb <= 8.0)
            System.out.println("Kha");
        else if (dtb >= 5.0 && dtb < 6.5)
            System.out.println("Trung binh");
        else
            System.out.println("Yeu");
        sc.close();
    }
}
