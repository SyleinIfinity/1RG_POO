package BAITHUCHANH.TUAN5;

import java.util.Scanner;

public class BT6_Extend {
    static Scanner sc;
    static int [] ds;
    static int spt;
    static int i;
    static int j;
    static int X;
    static int Vitri;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao so luong phan tu: ");
        spt = sc.nextInt();
        System.out.println("Nhap vao gia tri cac phan tu: ");
        ds = new int[spt];
        NHAP();
        System.out.println("Danh sach cac phan tu: ");
        XUAT();
        System.out.println("Nhap vao vi tri phan tu muon them: ");
        Vitri = sc.nextInt();
        System.out.println("Nhap vao gia tri phan tu muon them: ");
        X = sc.nextInt();
        // FIND(X);
    }
    static void NHAP(){
        for(i=0; i < spt; i++){
            ds[i] = sc.nextInt();
        }
    }
    static void XUAT(){
        for(int i=0; i < spt; i++){
            System.out.printf("%d ");
        }
    }
    static void SAPXEP(){
        for(int i = 0; i < spt-1; i++)
            for(j = i+1; j < spt; j++){
                if(ds[i] < ds[j]){
                    int TG = ds[i];
                    ds[i] = ds[j];
                    ds[j] = TG;
                }
            }
            XUAT();
    }
    static void FIND(int X){
        boolean found = false;
        for(int i = 0; i < spt; i++){
            if(X == ds[i]){
                found = true;
            }
        }
        if(found){
            System.out.println("tim thay");
        }else{
            System.out.println("chua thay");  
        }
    }
    static void THEMPT(){
        Vitri = sc.nextInt();
        for(i=spt-1; i <= Vitri; i--){
            ds[i+1] = ds[i];
        }
        spt++;
    }
}
