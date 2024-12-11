import java.util.Scanner;

public class SinhVien {
    // Thuoc tinh
    public String maSV;          
    public String ten;           
    public String ngaySinh;      
    public double diemTrungBinh; 
    public String hocLuc;        

    
    public SinhVien() {
        
    }
    
    public double getDiemTrungBinh() 
    {
        return this.diemTrungBinh;
    }

    //nhap thong tin sinh vien
    public void nhapThongTin() 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ma sinh vien: ");
        this.maSV = scanner.nextLine();

        System.out.print("Nhap ten sinh vien: ");
        this.ten = scanner.nextLine();

        System.out.print("Nhap ngay sinh (dd/MM/yyyy): ");
        this.ngaySinh = scanner.nextLine();

        System.out.print("Nhap diem trung binh: ");
        double diemNhap = scanner.nextDouble();
        setDiemTrungBinh(diemNhap); 
        scanner.close();
    }

    // diem trung binh
    public void setDiemTrungBinh(double diemTrungBinh) 
    {
        if (diemTrungBinh >= 0 && diemTrungBinh <= 10) 
        {
            this.diemTrungBinh = diemTrungBinh;
            xepLoai();
        } 
        else 
            System.out.println("Diem trung binh phai nam trong khoang 0 den 10.");
        
    }

    // xep loai
    public void xepLoai() 
    {
        if (diemTrungBinh >= 8)
            this.hocLuc = "Gioi";
        else if (diemTrungBinh >= 6.5)
            this.hocLuc = "Kha";
        else if (diemTrungBinh >= 5)
            this.hocLuc = "Trung Binh";
        else
            this.hocLuc = "Yeu";
    
    }


    public String getHocLuc() 
    {
        return this.hocLuc;
    }

    // in
    public void inThongTin() {
        System.out.println("Ma SV: " + this.maSV + ", Ten: " + this.ten + ", Ngay sinh: " + this.ngaySinh + 
                           ", Diem TB: " + this.diemTrungBinh + ", Hoc luc: " + this.hocLuc);
    }
}