package BAITHUCHANH.TUAN6.KHANH;
import BAITHUCHANH.TUAN6.KHANH.BT1.*;
import BAITHUCHANH.TUAN6.KHANH.BT2.*;
import BAITHUCHANH.TUAN6.KHANH.BT3.*;
import java.util.*;

public class Product {
    static int n;
    static Scanner sc;
    public static void main(String[] BaoDong) {
        sc = new Scanner(System.in);
        System.out.println("Ban muon xem bai may(BT1,BT2,BT3): ");
        n = sc.nextInt();
        switch (n) {
            case 1:
                Product_6_1.main(BaoDong);
                break;
            case 2:
                Product_6_2.main(BaoDong);
                break;
            default:
                Product_6_3.main(BaoDong);
                break;
        }
    }
}
