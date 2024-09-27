package BAITHUCHANH.TUAN5;

import java.util.Scanner;

public class BT5_Expr {
    static Scanner sc;
    static int [] ds;
    static int spt;
    static int i;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao so luong phan tu: ");
        spt = sc.nextInt();
        System.out.println("Nhap vao cac phan tu: ");
        ds = new int[spt];
        NHAP();
        System.out.println("Danh sach cac phan tu: ");
        XUAT();
    }
    static void NHAP(){
        for(i=0; i < spt; i++){
            ds[i] = sc.nextInt();
        }
    }
    static void XUAT(){
        for(i=0; i < spt; i++){
            System.out.printf("%d ", ds[i]);
        }
    }
}
