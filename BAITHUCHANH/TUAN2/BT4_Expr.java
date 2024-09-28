package BAITHUCHANH.TUAN2;
import java.util.*;
public class BT4_Expr {
    public static void main(String[] args) {
        //Lãi suất sẽ cộng vào số dư mỗi tháng.
        Scanner sc = new Scanner(System.in);
        System.out.printf("Please enter your deposite amount:");
        double TienGui = sc.nextDouble();

        System.out.printf("Please enter the annual LaiSuatNam rate: ");
        double LaiSuatNam = sc.nextDouble();

        System.out.printf("Nhap so thang gui: ");
        int SoThangGui = sc.nextInt();
        
        double TongLaiDonSauChuKy = TienGui*((LaiSuatNam/100)/12)*SoThangGui;
        double TongLaiKepSauChuKy = (TienGui * Math.pow((1 + ((LaiSuatNam/100)/12)), SoThangGui)) - TienGui;
        double TienGocCuoiKy_LaiDon =  TienGui + TongLaiDonSauChuKy;
        double TienGocCuoiKy_LaiKep =  TienGui + TongLaiKepSauChuKy;
        System.out.println("Tong lai don nhan duoc sau chu ky: " + TongLaiDonSauChuKy);
        System.out.println("Tong tien goc nhan duoc sau chu kỳ lai don: " + TienGocCuoiKy_LaiDon);
        System.out.println("Tong lai kep nhan duoc sau chu kỳ: " + TongLaiKepSauChuKy);
        System.out.println("Tong tien goc nhan duoc sau chu ky lai kep la: " + TienGocCuoiKy_LaiKep);
        sc.close();
    }
}
