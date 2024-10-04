package Bai1;

import java.util.Scanner;

public class Hinh {
    protected String tenHinh;
    protected Scanner sc = new Scanner(System.in);
    public String getHinh()
    {
        return this.tenHinh;
    }
    public void setTenHinh(String A)
    {
        this.tenHinh = A;
    }
    public Hinh(){
        sc = new Scanner(System.in);
    }
    public Hinh(String A){
        this.tenHinh = A;
        sc = new Scanner(System.in);
    }
    public void Nhap(){
        System.out.println("Nhap ten hinh : ");
        this.tenHinh = sc.nextLine();
    }
    public void XUAT(){
        System.out.println( "Ten hinh là : " + this.tenHinh);
    }
}


