package BAITHUCHANH.TUAN3;
import java.util.*;

public class BT6 {
    public static void main(String[] args) {
        Scanner KHANH = new Scanner(System.in);
        System.out.printf("Xin moi nhap vao phep tinh toan can su dung(+,-,*,/): ");
        char Pheptoan = KHANH.next().charAt(0);
        System.out.printf("Nhap vao gia tri a: ");
        double giatri_a = KHANH.nextDouble();
        System.out.printf("Nhap vao gia tri b: ");
        double giatri_b = KHANH.nextDouble();
        double Ketqua = (Pheptoan == '+')?(giatri_a+giatri_b):
                        (Pheptoan == '-')?(giatri_a-giatri_b):
                        (Pheptoan == '*')?(giatri_a*giatri_b):
                        (Pheptoan == '/')?(giatri_a/giatri_b):Double.NaN;
        if (Double.isNaN(Ketqua)) {
            System.out.println("Phép tính không hợp lệ hoặc chia cho 0");
        } else {
            System.out.printf("%f %c %f = %.3f", giatri_a, Pheptoan,  giatri_b, Ketqua);
        }
        KHANH.close();
    }
}
// 6.	Viết chương trình thực hiện các phép tính cơ bản (cộng, trừ, nhân, chia)
//      dựa trên lựa chọn của người dùng