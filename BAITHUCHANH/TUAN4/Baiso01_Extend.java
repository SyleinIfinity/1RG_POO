import java.util.*;

public class Baiso01_Extend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap n : ");
        int n = sc.nextInt();
        int a = Sum(n);
        System.out.println(a);
        sc.close();
    }
    public static int Sum(int n){
        if(n == 0)
            return n;
        else 
            return n + Sum( n - 1 );
    }
}
