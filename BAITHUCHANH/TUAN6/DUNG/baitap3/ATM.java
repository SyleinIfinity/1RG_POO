import java.util.*;

public class ATM {
    private long STK;
    private String ChuTK;
    private double SoDu;
    private double TienGui; 
    private double TienRut; 
    static Scanner sc;

    public long GetSTK(){
        return this.STK;
    }
    public String GetChuTK(){
        return this.ChuTK;
    }
    public double GetSoDU(){
        return this.SoDu;
    }
    public double GetTienGui(){
        return this.TienGui;
    }
    public double GetTienRut(){
        return this.TienRut;
    }

    public void GuiTien(){
        this.SoDu = this.SoDu + this.TienGui;
    }
    public void RutTien(){
        this.SoDu = this.SoDu - this.TienRut;
    }
    public double  SoDuTK(){
        return this.SoDu;
    }
    public void NhapThongTin(){
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao so tai khoan: ");
        this.STK = sc.nextLong();
        sc.nextLine();
        System.out.printf("Nhap vao chu tai khoan: ");
        this.ChuTK = sc.nextLine();
        System.out.printf("Nhap vao so du: ");
        this.SoDu = sc.nextDouble();
    }
    public void NhapTienGui(){
        System.out.printf("Nhap vao so tien gui: ");
        TienGui = sc.nextDouble();
    }
    public void NhapTienRut(){
        do
        {
            System.out.printf("Nhap vao so tien rut: ");
            TienRut = sc.nextDouble();
            if (this.SoDu < TienRut)
                System.out.printf("Ban ngheo vai, dung ao tuong minh giau nua, nhap lai so tien minh co di thang ngheo doi nay.");
        }
        while (this.SoDu < TienRut);
    }
    public void Xuat(){
        System.out.printf("%s %20s %20.2f\n", this.STK, this.ChuTK, this.SoDu);
    }
    public void XuatSoDu(){
        System.out.printf("%20.2f $\n", this.SoDu);
    }
}
