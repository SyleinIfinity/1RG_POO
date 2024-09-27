package BAITHUCHANH.TUAN4;
import java.util.*;

public class BT5 {
    static Scanner sc;
    static int A;
    static int B;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao hai so nguyen: ");
        A = sc.nextInt();
        B = sc.nextInt();
        System.out.printf("Uoc chung lon nhat la : %d", UCLN(A, B));
        System.out.printf("\nBoi chung nho nhat la : %d", BCNN(A, B));
    }
    static int UCLN(int X, int Y){
        if(X == Y){
            return X;
        } else{
            if(X > Y){
                return UCLN(X - Y, Y);
            } else{
                return UCLN(X,Y - X);
            }
        }
    }
    static int BCNN(int X, int Y){
        return (X*Y)/UCLN(X, Y);
    }
}
