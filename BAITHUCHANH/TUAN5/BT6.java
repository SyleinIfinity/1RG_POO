package BAITHUCHANH.TUAN5;

import java.util.*;

public class BT6 {
    static Scanner sc;
    static int [] ds;
    static int spt;
    static int i;
    static int j;
    static int X;
    static int Y;
    static int VTadd;
    static int VTdelete;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao so luong phan tu: ");
        spt = sc.nextInt();
        System.out.println("Nhap vao gia tri cac phan tu: ");
        ds = new int[spt+2];
        NHAP();
        System.out.println("Danh sach cac phan tu: ");
        XUAT();
        // 
        System.out.printf("\nNhap vao vi tri phan tu muon them: ");
        VTadd = sc.nextInt();
        System.out.printf("Nhap vao gia tri phan tu muon them: ");
        X = sc.nextInt();
        THEMPT();
        System.out.println("Danh sach sau khi them phan tu: ");
        XUAT();
        //
        System.out.printf("\nNhap vao gia tri phan tu muon xoa: ");
        Y = sc.nextInt();
        XOAPT();
        System.out.println("Danh sach sau khi xoa phan tu: ");
        XUAT();
    }
    static void NHAP(){
        for(i=1; i <= spt; i++){
            ds[i] = sc.nextInt();
        }
    }
    static void XUAT(){
        for(i=1; i <= spt; i++){
            System.out.printf("%d ", ds[i]);
        }
    }
    // static void SAPXEP(){
    //     for(int i = 1; i <= spt-1; i++)
    //         for(j = i+1; j <= spt; j++){
    //             if(ds[i] < ds[j]){
    //                 int TG = ds[i];
    //                 ds[i] = ds[j];
    //                 ds[j] = TG;
    //             }
    //         }
    // }
    static void THEMPT(){
        for(i=spt; i >= VTadd; i--){
            ds[i+1] = ds[i];
        }
        ds[VTadd] = X;
        spt++;
    }
    static void XOAPT(){
        i=1;
        while (i<=spt) {
            if(ds[i] == Y){
                VTdelete = i;
                for(j=VTdelete; j <=spt-1; j++){
                    ds[j] = ds[j+1];
                }
                spt--;
            } else {
                i++;
            }
        }
    }
}