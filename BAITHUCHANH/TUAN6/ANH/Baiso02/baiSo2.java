package ANH.Baiso02;
//package BAITHUCHANH.TUAN6;

import java.util.*;

public class baiSo2 {
    public static void main(String[] args) {
        List<SinhVien> danhSachSinhVien = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            SinhVien sv = new SinhVien();
            sv.NHAP();
            danhSachSinhVien.add(sv);

            System.out.print("Ban co muon nhap them sinh vien? (y/n): ");
            String choice = sc.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                break; // Thoát khỏi vòng lặp nếu không muốn nhập thêm
            }
        }
        
        SinhVien.sapXepTheoDiemTrungBinh(danhSachSinhVien);
        
        System.out.println("Danh sach sinh vien sau khi sap xep:");
        for (SinhVien sv : danhSachSinhVien) {
            sv.IN();
        }
        
        sc.close();
    }
}