package BAITHUCHANH.TUAN7.KHANH.BT3;
import java.util.*;

public class Product_7_3 {
    static double TienGui;
    static double TienRut;
    static String MKnew;
    static String Kiemtra;
    static Scanner sc;
    static int spt1;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.printf("Nhap vao so luong tai khoan ngan hang: ");
        spt1 = sc.nextInt();
        TKnganhang[] TK73 = new TKnganhang[spt1];
                for(int i= 0; i < spt1; i++){
            TK73[i] = new TKnganhang();
            System.out.println("Nhap vao ds " + (i+1));
            TK73[i].NHAP();

        }
        System.out.println("        Danh sach thong tin tai khoan");
        for (int i = 0; i < TK73.length; i++) {
            System.out.println("Danh sach thu "+ (i+1));
            TK73[i].XUAT();
        }
        //Tìm tài khoản muốn chỉnh sửa
        int vitri = -1;
        System.out.printf("\nNhap vao so tai khoan muon sua IN4: ");
        long SoTaiKhoan = sc.nextLong();
        sc.nextLine();
        do {
            for (int i = 0; i < spt1; i++) {
                if (TK73[i].getSOTK() == SoTaiKhoan) {
                    vitri = i;
                }
            }
            if (vitri == -1) {
                System.out.println("So tai khoan khong ton tai, moi nhap lai.");
                System.out.printf("Nhap vao so tai khoan muon chinh sua: ");
                SoTaiKhoan = sc.nextLong();
            }
        } while (vitri == -1);
        //Kiểm tra mk nhập vào
        int soLanNhapSai = 0;
        sc.nextLine();
        System.out.printf("\nNhap mat khau ngan hang: ");
        Kiemtra = sc.nextLine();
        do
        {
            soLanNhapSai++;
            if ((!Kiemtra.equals(TK73[vitri].getMK()) && soLanNhapSai <=3)){
                System.out.printf("Mat khau cu nhap sai, moi nhap lai: ");
                System.out.printf("\nNhap mat khau hien tai: ");
                Kiemtra = sc.nextLine();
            }
            if ((!Kiemtra.equals(TK73[vitri].getMK()) && soLanNhapSai >3)){
                System.out.println("Ban da nhap sai qua 3 lan. Tai khoan bi tam khoa");
                return;
            }
        }while((!Kiemtra.equals(TK73[vitri].getMK())  && soLanNhapSai <=3));
        System.out.println("Nhap mat khau thanh cong!");
        int TuyChon;
        do {
            System.out.println("------MENU-----MENU-----MENU---------");
            System.out.println("|1. Rut tien                        |");
            System.out.println("|2. Gui tien                        |");
            System.out.println("|3. Doi mat khau                    |");
            System.out.println("|0. Thoat chuong trinh              |");
            System.out.println("------MENU-----MENU-----MENU---------");
            System.out.println("Nhap vao tuy chon cua ban: ");
            TuyChon = sc.nextInt();
            switch (TuyChon) {
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                case 1:
                    System.out.printf("Nhap vao So tien Withdraw($): ");
                    TienRut = sc.nextDouble();
                    do {
                        if (TK73[vitri].getSODU() <= TienRut) {
                            System.out.printf("So Du khong du de rut, moi nhap lai:\n");
                            System.out.printf("Nhap vao so tien chuyen: ");
                            TienRut = sc.nextDouble();
                        }
                    } while (TK73[vitri].getSODU() <= TienRut);
                    TK73[vitri].RUTTIEN(TienRut);
                    TK73[vitri].KiemTraSoDu();
                    break;
                case 2:
                    int TuyChon2;
                    System.out.println("------MENU-----MENU-----MENU-------------");
                    System.out.println("|1. Nap tien vao TK ca nhan             |");
                    System.out.println("|2. Gui tien sang tk trong danh sach    |");
                    System.out.println("|3. Gui tien sang tk ngoai danh sach    |");
                    System.out.println("|0. Thoat chuong trinh                  |");
                    System.out.println("------MENU-----MENU-----MENU-------------");
                    System.out.println("Nhap vao tuy chon cua ban: ");
                    TuyChon2 = sc.nextInt();
                    switch (TuyChon2) {
                        case 0:
                            System.out.println("Ket thuc chuong trinh.");
                            break;
                        case 1: //Vào tài khoản bản thân
                            System.out.printf("Nhap so tien gui: ");
                            TienGui = sc.nextDouble();
                            TK73[vitri].GUITIEN(TienGui);
                            TK73[vitri].KiemTraSoDu();
                            TK73[vitri].XUAT();
                            break;
                        case 2: //Vào tài khoản trong danh sách
                            long soTKnhan;
                            double tienChuyen;
                            System.out.printf("Nhap so tai khoan nhan: ");
                            soTKnhan = sc.nextLong();
                            int vitriNhan = -1;
                            do {
                                for (int i = 0; i < TK73.length; i++) {
                                    if (TK73[i].getSOTK() == soTKnhan) {
                                        vitriNhan = i;
                                    }
                                }
                                if (vitriNhan == -1) {
                                    System.out.println("So tai khoan khong co trong danh sach, moi nhap lai.");
                                    System.out.printf("Nhap vao so tai khoan nhan: ");
                                    soTKnhan = sc.nextLong();
                                }
                            } while (vitriNhan == -1);
                            System.out.printf("Nhap vao so tien chuyen: ");
                            tienChuyen = sc.nextDouble();
                            do {
                                if (TK73[vitri].getSODU() <= tienChuyen) {
                                    System.out.printf("So Du khong du de chuyen, moi nhap lai:\n");
                                    System.out.printf("Nhap vao so tien chuyen: ");
                                    tienChuyen = sc.nextDouble();
                                }
                            } while (TK73[vitri].getSODU() <= tienChuyen);
                            TK73[vitri].RUTTIEN(tienChuyen);
                            TK73[vitriNhan].GUITIEN(tienChuyen);
                            System.out.println("        Danh sach thong tin tai khoan");
                            for (int i = 0; i < TK73.length; i++) {
                                System.out.println("Danh sach thu "+ (i+1));
                                TK73[i].XUAT();
                            }
                            break;
                        case 3: //Vào tài khoản ngoài danh sách
                            double tienChuyenN;
                            int vitriNhanN = -1;
                            System.out.println("Nhap thong tin tai khoan moi:");
                            TKnganhang taiKhoanMoi = new TKnganhang();
                                taiKhoanMoi.NHAP();
                            if (spt1 >= TK73.length) {
                                TKnganhang[] newTK73 = new TKnganhang[TK73.length + 1];
                                for (int i = 0; i < TK73.length; i++) {
                                    newTK73[i] = TK73[i];
                                }
                                TK73 = newTK73; 
                            }
                            TK73[spt1] = taiKhoanMoi;
                            spt1++;
                            for (int i = 0; i < TK73.length; i++) {
                                System.out.printf("\n\nDanh sach thu %d:", (i+1));
                                TK73[i].XUAT();
                            }
                            System.out.println("\n");
                            for (int i = 0; i < TK73.length; i++) {
                                if (TK73[i].getSOTK() == taiKhoanMoi.getSOTK()) {
                                    vitriNhanN = i;
                                }
                            }
                            System.out.printf("Nhap vao so tien chuyen: ");
                            tienChuyenN = sc.nextDouble();
                            do {
                                if (TK73[vitri].getSODU() <= tienChuyenN) {
                                    System.out.printf("So Du khong du de chuyen, moi nhap lai:\n");
                                    System.out.printf("Nhap vao so tien chuyen: ");
                                    tienChuyenN = sc.nextDouble();
                                }
                            } while (TK73[vitri].getSODU() <= tienChuyenN);
                            TK73[vitri].RUTTIEN(tienChuyenN);
                            TK73[vitriNhanN].GUITIEN(tienChuyenN);
                            System.out.println("        Danh sach thong tin tai khoan");
                            for (int i = 0; i < TK73.length; i++) {
                                System.out.println("Danh sach thu "+ (i+1));
                                TK73[i].XUAT();
                            }
                            break;
                        default:
                            break;
                    }
                case 3:
                    sc.nextLine();
                    System.out.printf("\nNhap mat khau hien tai: ");
                    Kiemtra = sc.nextLine();
                    do
                    {
                        if (!Kiemtra.equals(TK73[vitri].getMK())) {
                            System.out.printf("Mat khau cu nhap sai, moi nhap lai: ");
                            System.out.printf("\nNhap mat khau hien tai: ");
                            Kiemtra = sc.nextLine();
                        }
                    }while(!Kiemtra.equals(TK73[vitri].getMK()));
                    System.out.printf("\nNhap mat khau moi: ");
                    MKnew = sc.nextLine();
                    TK73[vitri].doiMatKhau(MKnew);
                    break;
                default:
                    System.out.println("Tuy khong Hop le. Vui long nhap lai.");
                    break;
            }
        } while (TuyChon !=0);
    }
}
