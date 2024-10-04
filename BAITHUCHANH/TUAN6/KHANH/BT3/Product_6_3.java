package BAITHUCHANH.TUAN6.KHANH.BT3;

import java.util.*;

public class Product_6_3 {
    static Scanner sc;
    public static void main(String[] args) {
        TKnganhang User = new TKnganhang();
        User.NHAPALL();
        User.XUATALL();
        User.NHAPDEPOSITE();
        User.GUITIEN();
        System.out.println("Balance sau khi gui tien:");
        User.XUATSODU();

        User.NHAPWITHDRAW();
        User.RUTTIEN();
        System.out.println("\nBalance sau khi rut tien: ");
        User.XUATSODU();
    }
}
