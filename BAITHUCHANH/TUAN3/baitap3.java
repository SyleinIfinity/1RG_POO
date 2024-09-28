import java.util.Scanner;

public class baitap3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap he so a: ");
        double a = sc.nextDouble();
        System.out.print("Nhap he so b: ");
        double b = sc.nextDouble();
        System.out.print("Nhap he so c: ");
        double c = sc.nextDouble();
        
        double delta, x1, x2, x;

        if (a == 0)
        {
            if (b == 0)
                System.out.println("Phuong trinh vo nghiem");
            else
            {
                x = -c / b;
                System.out.println("Phuong trinh co nghiem x = " + x);
            }
        } 
        else 
        {
            delta = b * b - 4 * a * c;
            if (delta > 0) 
            {
                x1 = (-b + Math.sqrt(delta)) / (2 * a);
                x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Phuong trinh co 2 nghiem phan biet: x1 = " + String.format("%.2f", x1) + " va x2 = " + String.format("%.2f", x2));
            }
            else if (delta == 0)
            {
                x = -b / (2 * a);
                System.out.println("Phuong trinh co nghiem kep: x = " + x);
            }
            else
            {
                System.out.println("Phuong trinh vo nghiem");
            }
        }

        sc.close();
    }
}