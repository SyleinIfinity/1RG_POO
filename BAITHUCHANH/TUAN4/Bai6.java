import java.util.*;
public class Bai6 {
    static String c = "So nay la so doi xung";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so : ");
        int a = sc.nextInt();
        String numberStr = String.format("%s", a); 
        int[] b = new int[numberStr.length()];
        for (int i = 0; i < numberStr.length(); i++) {
            b[i] = Character.getNumericValue(numberStr.charAt(i));
        }
        for(int i = 0 ; i <= ( b.length - 1 ) / 2; i++){
            if(b[i] != b[b.length - 1 - i]){
                c = "So nay khong doi xung";
            }
        }
        System.out.println(c);
        sc.close();
    }
}
