package Bai2;
import java.util.*;
public class mainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Nhap so Sinh Vien : ");
        int a = sc.nextInt();
        SinhVien[] HS = new SinhVien[a];
        
        for(int i = 0 ; i < HS.length; i++){
            System.out.printf("Nhap thong tin Sinh Vien thu : %d \n", i+1);
            HS[i]= new SinhVien();
            HS[i].Nhap();
        }
       
        SinhVien b = new SinhVien();
        System.out.println(a);
        for(int i = 0 ; i < HS.length ; i++){
            for(int j = 0 ; j < HS.length-1; j++){
                if (HS[j].getDtb() < HS[j+1].getDtb()) {
                   b = HS[j+1];
                    HS[j+1]= HS[j];
                    HS[j] = b;
                }
            }
        }
         for(int i = 0 ; i < HS.length; i++){
            HS[i].XuatSV();
        }
        sc.close();
    }
  
}
 
