package BAITHUCHANH.TUAN2;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class BT4_pro {
    public static void main(String[] args) {
        //Lãi suất sẽ cộng vào số dư mỗi tháng.
        Scanner sc = new Scanner(System.in);
        System.out.printf("Xin moi nhap vao so tien can gui:"); //nhập tiền
        double Money = sc.nextDouble();
        System.out.printf("Xin moi nhap vao lai suat hang nam: "); //nhập lãi hằng năm
        double interest = sc.nextDouble();
        System.out.printf("Xin moi nhap vao thang bat dau gui: "); // tháng bắt đầu
        int ThangBegin = sc.nextInt();
        System.out.printf("Xin moi nhap vao nam gui: ");//năm gửi
        int Nambegin = sc.nextInt();
        System.out.printf("Xin moi nhap vao thang ket thuc: "); //tháng kết húc
        int ThangEndALL = sc.nextInt();
        System.out.printf("Xin moi nhap vao nam ket thuc: "); //năm kết thúc
        int NamEndALL = sc.nextInt();
        boolean Check = true;
        int SothangALL = (int) Hamso3(ThangBegin, Nambegin, ThangEndALL, NamEndALL);
        System.out.printf("tong so thang gui ca chu ky la: %d", SothangALL);
        double LaiTongCacChuky = Hamso1(Money, interest, ThangBegin, Nambegin, ThangEndALL, NamEndALL) - Money;
        double TongtienALLthang = Money + LaiTongCacChuky;
        System.out.printf("\nTong lai ca chu ky: %.2f", LaiTongCacChuky);
        System.out.printf("\nTien goc nhan duoc cuoi chu ky: %.2f", TongtienALLthang);
        System.out.printf("\nBan co muon rut tien giua chung ko(Yes/No): ");
        while (Check) {
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("yes")) {
                System.out.printf("Xin moi nhap vao thang ket thuc: "); //tháng kết thúc giữa chu kỳ
                int ThangEndPART = sc.nextInt();
                System.out.printf("Xin moi nhap vao nam ket thuc: "); //năm kết thúc giữa chu kỳ
                int NamEndPART = sc.nextInt();
                // Hamso2(Money, interest, ThangBegin, Nambegin, ThangEndPART, NamEndPART);
                int SothangPART = (int) Hamso3(ThangBegin, Nambegin, ThangEndPART, NamEndPART);
                double LaiSuatNchuky = Hamso1(Money, interest, ThangBegin, Nambegin, ThangEndPART, NamEndPART) - Money;
                double TongtienNthang = Money + LaiSuatNchuky;
                System.out.printf("\nTong so thang sau B chu ky la: %d", SothangPART);
                System.out.println("");
                System.out.printf("Tong lai suat sau %d chu ky la: %.2f", SothangPART, LaiSuatNchuky);
                System.out.printf("\nTien goc nhan duoc sau %d chu ky la: %.2f", SothangPART, TongtienNthang);
                break;
            }
            if (input.equals("no")) {
                System.out.println("Chuong trinh ket thuc");
                break;
            }
        }
        sc.close();
    }
    //hàm tính lãi suất kép: compound interest ~ cpi
    public static double Hamso1(double M, double In, int beginM, int beginY, int endM, int endY) {
        double LaiSuatKep = 0;
        int SothangALL = (int) Hamso3(beginM, beginY, endM, endY);
        for(int i = 1; i <= SothangALL; i++){
            LaiSuatKep = M*Math.pow((1+((In/100)/12)), i);
        }        
        return LaiSuatKep;
    }
    //hàm in thông tin lãi, tiền tổng hàng tháng
    public static void Hamso2(double M, double In, int beginM, int beginY, int endM, int endY) {
        double LaiSuatKep = 0;
        int SothangPART = (int) Hamso3(beginM, beginY, endM, endY);
        for(int i = 1; i <= SothangPART; i++){
            LaiSuatKep = M*Math.pow((1+((In/100)/12)), i);
            System.out.println("Lai nhan duoc thang thu " + i + " la: " + LaiSuatKep);
            System.out.println("Tong tien thang thu " + i + " la: " + (M + LaiSuatKep));
            System.out.println("   ");
        }
    }
    // Hàm đếm số tháng trong khoảng thời gian
public static long Hamso3(int beginM, int beginY, int endM, int endY) {
        //LocalDate là 1 lớp trong java
        //Dùng để đại diện cho ngày cụ thể (không bao gồm múi giờ trong ngày) theo định dạng yyyy-mm-dd
        //Phương thức: of(year, month,  day): Tạo 1 dối tượng từ năm tháng cụ thể
        LocalDate startTime = LocalDate.of(beginY, beginM, 1);
        LocalDate endTime = LocalDate.of(endY, endM, 1);
        //ChronoUnit là hằng số trong enum, theo đơn vị chỉ định tại hàm này là tháng
        return ChronoUnit.MONTHS.between(startTime, endTime);
    }
    
}