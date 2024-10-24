package BAITHUCHANH.TUAN8.KHANH.BT1;
import java.util.*;

public class Chim extends DongVat{
    private String tiengkeu;
    static Scanner sc;

    public String getTiengKeu(){
        return this.tiengkeu;
    }

    public Chim(){
        super();
    }

    public void NHAP(){
        super.NHAP();
        sc = new Scanner(System.in);
        System.out.printf("Nhap ten dong vat: ");
        this.TenDV = sc.nextLine();
        System.out.printf("Nhap tuoi cua %s: ", this.TenDV);
        this.TuoiDV = sc.nextInt();
        System.out.printf("Tieng keu : ");
        this.tiengkeu = sc.nextLine();
    }

    public void XUAT(){
        super.XUAT();
        System.out.printf("\nTen cua dong vat la: %s", tenDV());
        System.out.printf("\nTuoi tho cua %s la : %d", tenDV(), tuoiDV());
        System.out.printf("\nTieng keu cua %s la: %s", tenDV(), getTiengKeu());
    }

}
