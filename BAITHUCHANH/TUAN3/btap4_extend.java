package BAITHUCHANH.TUAN3;
import java.util.*;

public class btap4_extend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong phan tu:");
        int spt = sc.nextInt();
        System.out.println("Nhap vao cac so:");
        double So[] = new double[spt];
        for(int i = 0; i < spt; i++){
            So[i] = sc.nextDouble();
        }
        double Min= So[0];
        // double Max= So[0];
        for(int i = 0; i < spt; i++)
            if(So[i] < Min)
                Min = So[i];
        System.out.println("So nho nhat la: " + Min);
        sc.close();
    }
}