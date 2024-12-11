package demo;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NganHang nganHang = new NganHang();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n====== NGÂN HÀNG ======");
            System.out.println("|1. Admin              |");
            System.out.println("|2. User               |");
            System.out.println("|0. Thoat              |");
            System.out.print("Chon vai tro: ");

            int vaiTro = scanner.nextInt();
            scanner.nextLine();

            if (vaiTro == 0) {
                System.out.println("Thoat chuong trinh.");
                scanner.close();
                return;
            }

            switch (vaiTro) {
                case 1: // Admin
                    while (true) {
                        System.out.println("\n======= MENU ADMIN =======");
                        System.out.println("|1. Tao cap tai khoan moi |");
                        System.out.println("|2. In danh sach tai khoan|");
                        System.out.println("|3. Xoa tai khoan         |");
                        System.out.println("|0. Quay lai              |");
                        System.out.print("Chon chuc nang: ");
                
                        int luaChonAdmin = scanner.nextInt();
                        scanner.nextLine();
                
                        if (luaChonAdmin == 0) {
                            break;
                        }
                
                        switch (luaChonAdmin) {
                            case 1:
                                String soTaiKhoan = "TK" + String.format("%06d", (int)(Math.random() * 1000000));
                                
                                System.out.print("Nhap ten chu tai khoan: ");
                                String chuTaiKhoan = scanner.nextLine();
                                System.out.print("Nhap mat khau: ");
                                String matKhau = scanner.nextLine();

                                String soDienThoai;
                                while (true) {
                                    System.out.print("Nhap so dien thoai (10 so): ");
                                    soDienThoai = scanner.nextLine();
                                    if (TaiKhoan.kiemTraSoDienThoai(soDienThoai)) {
                                        break;
                                    } else {
                                        System.out.println("So dien thoai khong hop le. Vui long nhap 10 so.");
                                    }
                                }

                                // Kiểm tra xem số điện thoại đã tồn tại trong file hay chưa
                                if (nganHang.kiemTraSoDienThoaiTonTai(soDienThoai)) {
                                    System.out.println("Tao tai khoan that bai, so dien thoai da ton tai");
                                    break; // Quay lại menu admin
                                }

                                // Tạo tài khoản thanh toán
                                TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan(soTaiKhoan, chuTaiKhoan, matKhau, 0, 1100, soDienThoai);

                                // Tạo tài khoản tiết kiệm
                                TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem(soTaiKhoan, chuTaiKhoan, matKhau, 3.5, 1, LocalDate.now().toString(), soDienThoai);

                                // Thêm tài khoản vào ngân hàng
                                nganHang.themCapTaiKhoan(tkThanhToan, tkTietKiem);

                                // Nếu tài khoản đã được thêm thành công, thông báo
                                System.out.println("Da tao cap tai khoan thanh cong:");
                                System.out.println("So tai khoan: " + soTaiKhoan);
                                System.out.println("Chu tai khoan: " + chuTaiKhoan);
                                System.out.println("So dien thoai: " + soDienThoai);
                                break;
                            case 2:
                                nganHang.inDanhSachTaiKhoan();
                                break;
                            case 3: // Xóa tài khoản
                                System.out.print("Nhap so tai khoan can xoa: ");
                                String soTKXoa = scanner.nextLine();
                                
                                // Kiểm tra tài khoản tồn tại
                                TaiKhoanThanhToan tkCanXoa = nganHang.timTaiKhoanThanhToan(soTKXoa);
                                if (tkCanXoa == null) {
                                    System.out.println("Khong tim thay tai khoan!");
                                    break;
                                }

                                // Xác nhận xóa
                                System.out.print("Ban co chac chan muon xoa tai khoan nay? (Y/N): ");
                                String xacNhan = scanner.nextLine();
                                if (xacNhan.equalsIgnoreCase("Y")) {
                                    if (nganHang.xoaTaiKhoan(soTKXoa)) {
                                        System.out.println("Da xoa tai khoan thanh cong!");
                                    } else {
                                        System.out.println("Xoa tai khoan that bai!");
                                    }
                                }
                                break;
                            default:
                                System.out.println("Lua chon khong hop le.");
                        }
                    }
                    break;

                case 2: // User
                    System.out.print("Nhap so tai khoan: ");
                    String soTaiKhoanUser = scanner.nextLine();
                    System.out.print("Nhap mat khau: ");
                    String matKhauUser = scanner.nextLine();

                    // Kiểm tra tài khoản
                    TaiKhoanThanhToan tkThanhToan = nganHang.timTaiKhoanThanhToan(soTaiKhoanUser);
                    TaiKhoanTietKiem tkTietKiem = nganHang.timTaiKhoanTietKiem(soTaiKhoanUser);

                    if (tkThanhToan == null || !tkThanhToan.getMatKhau().equals(matKhauUser)) {
                        System.out.println("So tai khoan hoac mat khau khong dung.");
                        break;
                    }

                    // Kiểm tra và thiết lập mã PIN nếu chưa có
                    if (tkThanhToan.getMaPin() == null || tkThanhToan.getMaPin().isEmpty()) {
                        while (true) {
                            System.out.print("Nhap ma PIN moi (4 so): ");
                            String maPin = scanner.nextLine();
                            if (maPin.matches("\\d{4}")) {
                                tkThanhToan.setMaPin(maPin);
                                tkTietKiem.setMaPin(maPin);
                                break;
                            } else {
                                System.out.println("Ma PIN phai la 4 chu so.");
                            }
                        }
                    }

                    while (true) {
                        System.out.println("\n======= MENU USER =======");
                        System.out.println("|1. Nap tien             |");
                        System.out.println("|2. Rut tien             |");
                        System.out.println("|3. Kiem tra so du       |");
                        System.out.println("|4. Chuyen tien          |");
                        System.out.println("|5. Doi mat khau         |");
                        System.out.println("|6. Xem lich su giao dich|");
                        System.out.println("|0. Thoat                |");
                        System.out.print("Chon chuc nang: ");

                        int luaChonUser = scanner.nextInt();
                        scanner.nextLine();

                        if (luaChonUser == 0) {
                            break;
                        }

                        switch (luaChonUser) {
                            case 1: // Nạp tiền
                                System.out.println("Chon loai tai khoan:");
                                System.out.println("1. Tai khoan thanh toan");
                                System.out.println("2. Tai khoan tiet kiem");
                                int loaiTK = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Nhap so tien nap: ");
                                double soTienNap = scanner.nextDouble();
                                scanner.nextLine();

                                if (soTienNap <= 0) {
                                    System.out.println("So tien nap khong hop le.");
                                    break;
                                }

                                if (tkThanhToan.nhapMaPin(scanner)) {
                                    if (loaiTK == 1) {
                                        tkThanhToan.napTien(soTienNap);
                                    } else if (loaiTK == 2) {
                                        tkTietKiem.napTien(soTienNap);
                                    }
                                }
                                break;

                            case 2: // Rút tiền
                                System.out.println("Chon loai tai khoan:");
                                System.out.println("1. Tai khoan thanh toan");
                                System.out.println("2. Tai khoan tiet kiem");
                                loaiTK = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Nhap so tien rut: ");
                                double soTienRut = scanner.nextDouble();
                                scanner.nextLine();

                                if (soTienRut <= 0) {
                                    System.out.println("So tien rut khong hop le.");
                                    break;
                                }

                                if (tkThanhToan.nhapMaPin(scanner)) {
                                    if (loaiTK == 1) {
                                        tkThanhToan.rutTien(soTienRut);
                                    } else if (loaiTK == 2) {
                                        tkTietKiem.rutTien(soTienRut);
                                    }
                                }
                                break;

                            case 3: // Kiểm tra số dư
                                System.out.println("So du tai khoan thanh toan: " + 
                                    tkThanhToan.getSoDu());
                                System.out.println("So du tai khoan tiet kiem: " + 
                                    tkTietKiem.getSoDu());
                                break;

                            case 4: // Chuyển tiền
                                System.out.print("Nhap so tai khoan nguoi nhan: ");
                                String soTKNhan = scanner.nextLine();
                                System.out.print("Nhap so tien chuyen: ");
                                double soTienChuyen = scanner.nextDouble();
                                scanner.nextLine();

                                if (soTienChuyen <= 0) {
                                    System.out.println("So tien chuyen khong hop le.");
                                    break;
                                }

                                if (tkThanhToan.nhapMaPin(scanner)) {
                                    nganHang.chuyenTien(soTaiKhoanUser, soTKNhan, soTienChuyen);
                                }
                                break;

                            case 5: // Đổi mật khẩu
                                System.out.print("Nhap mat khau cu: ");
                                String matKhauCu = scanner.nextLine();
                                if (!tkThanhToan.getMatKhau().equals(matKhauCu)) {
                                    System.out.println("Mat khau cu khong dung.");
                                    break;
                                }

                                String matKhauMoi;
                                while (true) {
                                    System.out.print("Nhap mat khau moi: ");
                                    matKhauMoi = scanner.nextLine();
                                    if (!tkThanhToan.kiemTraMatKhauu(matKhauMoi)) {
                                        System.out.println("Mat khau moi khong hop le. " +
                                            "Can it nhat 6 ky tu, bao gom chu hoa, " +
                                            "chu thuong, so va ky tu dac biet.");
                                    } else {
                                        break;
                                    }
                                }

                                System.out.print("Nhap lai mat khau moi: ");
                                String matKhauMoiLai = scanner.nextLine();
                                if (!matKhauMoi.equals(matKhauMoiLai)) {
                                    System.out.println("Mat khau moi khong khop.");
                                    break;
                                }

                                // Cập nhật mật khẩu cho cả 2 loại tài khoản
                                tkThanhToan.setMatKhau(matKhauMoi);
                                tkTietKiem.setMatKhau(matKhauMoi);
                                System.out.println("Doi mat khau thanh cong.");
                                break;
                            
                            case 6: // Xem lịch sử giao dịch
                                tkThanhToan.xemLichSuGiaoDich();
                            
                            break;
                            default:
                                System.out.println("Lua chon khong hop le.");
                        }
                    }
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
            }
        }
    }
}