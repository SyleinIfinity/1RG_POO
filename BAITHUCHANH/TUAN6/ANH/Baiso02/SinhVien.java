package ANH.Baiso02;
//package BAITHUCHANH.TUAN6;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class SinhVien {
    private double maSinhVien;
    private String ten;
    private Date ngaySinh;
    private double diemTrungBinh;
    static Scanner sc = new Scanner(System.in);

    public double getMaSinhVien() {
        return this.maSinhVien;
    }

    public String getTen() {
        return this.ten;
    }

    public Date getNgaySinh() {
        return this.ngaySinh;
    }

    public double getDiemTrungBinh() {
        return this.diemTrungBinh;
    }

    public void NHAP() {
        System.out.println("Nhap thong tin sinh vien: ");
        System.out.print("Ma sinh vien: ");
        this.maSinhVien = sc.nextDouble();
        sc.nextLine(); // Clear input buffer
        System.out.print("Ten: ");
        this.ten = sc.nextLine();
        
        // Nhập ngày sinh với xử lý ngoại lệ
        while (true) {
            System.out.print("Ngay sinh (dd/MM/yyyy): ");
            String dateInput = sc.nextLine();
            try {
                this.ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(dateInput);
                break; // Thoát khỏi vòng lặp nếu nhập thành công
            } catch (ParseException e) {
                System.out.println("Ngay sinh khong hop le! Vui long nhap lai.");
            }
        }

        System.out.print("Diem trung binh: ");
        this.diemTrungBinh = sc.nextDouble();
        sc.nextLine(); // Clear input buffer
    }

    public void IN() {
        System.out.println("Ma sinh vien: " + this.maSinhVien);
        System.out.println("Ten: " + this.ten);
        System.out.println("Ngay sinh: " + new SimpleDateFormat("dd/MM/yyyy").format(this.ngaySinh));
        System.out.println("Diem trung binh: " + this.diemTrungBinh);
    }

    public static void sapXepTheoDiemTrungBinh(List<SinhVien> danhSach) {
        Collections.sort(danhSach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Double.compare(sv2.getDiemTrungBinh(), sv1.getDiemTrungBinh());
            }
        });
    }
}

