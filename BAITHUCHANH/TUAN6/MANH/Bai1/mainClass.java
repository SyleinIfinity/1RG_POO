package Bai1;
import java.util.*;
public class mainClass {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String A = sc.nextLine();
        double R = sc.nextDouble();
        tron hinh1 = new tron(A, R);
        hinh1.Xuat();
        String B = sc.nextLine();
        double Ro = sc.nextDouble();
        double D = sc.nextDouble();
        chunhat hinh2 = new chunhat(B,D,Ro);
        hinh2.XuatCN();
    }
    
}
