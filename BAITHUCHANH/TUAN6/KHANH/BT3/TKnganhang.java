package BAITHUCHANH.TUAN6.KHANH.BT3;

import java.util.Scanner;

public class TKnganhang {
    private long SoTK;
    private String ChuTK;
    private double SoDu;
    static Scanner sc;
    private double Deposite;
    private double Withdraw;

    public long getSOTK(){
        return this.SoTK;
    }
    public String getCHUTK(){
        return this.ChuTK;
    }
    public double getSODU(){
        return this.SoDu;
    }
    public double getDEPOSITE(){
        return this.Deposite;
    }
    public double getWITHDRAW(){
        return this.Withdraw;
    }
    public double CheckBanlance(){
        return this.SoDu;
    }

    public void GUITIEN(){
        this.SoDu = this.SoDu + Deposite;
    }

    public void RUTTIEN(){
        this.SoDu = this.SoDu - Withdraw;
    }

    public void NHAPALL(){
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao So Tai Khoan: ");
        this.SoTK = sc.nextLong();
        sc.nextLine();
        System.out.printf("Nhap vao Chu Tai Khoan: ");
        this.ChuTK = sc.nextLine();
        System.out.printf("Nhap vao So Du: ");
        this.SoDu = sc.nextDouble();
    }

    public void NHAPDEPOSITE(){
        System.out.printf("Nhap vao So tien deposite($): ");
        Deposite = sc.nextDouble();
    }
    
    public void NHAPWITHDRAW(){
        do {
            System.out.printf("Nhap vao So tien Withdraw($): ");
            Withdraw = sc.nextDouble();
            if (this.SoDu < Withdraw) {
                System.out.printf("So Du khong du de rut, moi nhap lai:\n");
            }
        } while (this.SoDu < Withdraw);
    }   

    public void XUATALL(){
        System.out.printf("%d %20s %20.2f\n", this.SoTK, this.ChuTK, this.SoDu);
    }
    public void XUATSODU(){
        System.out.printf("%20.2f $\n", this.SoDu);
    }
}
