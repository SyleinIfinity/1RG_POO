import java.util.*;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = new String[10]; 
        for(int i = 0 ; i < 10 ; i++){
            a[i] = "";
            for(int j = 1 ; j <=10 ; j++){
                a[i] += String.format("|  %2d x %2d = %3d  |", j, i + 1, (i+1)*j);
            }
        }
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(a[i]);
        }
        System.out.println(a);
        sc.close();
    }
}