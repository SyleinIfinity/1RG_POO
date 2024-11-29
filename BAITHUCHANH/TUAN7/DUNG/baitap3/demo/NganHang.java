package demo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NganHang {
   private ArrayList<TaiKhoan> danhSachTaiKhoan;

    public NganHang() {
        danhSachTaiKhoan = new ArrayList<>();
    }

    // Kiểm tra số điện thoại đã tồn tại trong file
    public boolean kiemTraSoDienThoaiTonTai(String soDienThoai) {
        try (BufferedReader br = new BufferedReader(new FileReader("dsTaiKhoan.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length == 4 && parts[3].trim().equals(soDienThoai)) {
                    return true; // Số điện thoại đã tồn tại
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
        return false;
    }

    public void themCapTaiKhoan(TaiKhoanThanhToan tkThanhToan, TaiKhoanTietKiem tkTietKiem) {
        // Kiểm tra số điện thoại
        if (kiemTraSoDienThoaiTonTai(tkThanhToan.getSoDienThoai())) {
            System.out.println("Tao tai khoan that bai, so dien thoai da ton tai");
            return;
        }

        danhSachTaiKhoan.add(tkThanhToan);
        danhSachTaiKhoan.add(tkTietKiem);
        ghiThongTinTaiKhoan(tkThanhToan);
    }

    private void ghiThongTinTaiKhoan(TaiKhoan tk) {
        int stt = danhSachTaiKhoan.size() / 2; // Số thứ tự dựa trên số tài khoản đã thêm
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dsTaiKhoan.txt", true))) {
            writer.write(stt + " | " + tk.getSoTaiKhoan() + " | " + tk.getChuTaiKhoan() + " | " + tk.getSoDienThoai());
            writer.newLine(); // Xuống dòng sau khi ghi
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }


    public TaiKhoanThanhToan timTaiKhoanThanhToan(String soTaiKhoan) {
        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk instanceof TaiKhoanThanhToan && tk.getSoTaiKhoan().equals(soTaiKhoan)) {
                return (TaiKhoanThanhToan) tk;
            }
        }
        return null;
    }

    public TaiKhoanTietKiem timTaiKhoanTietKiem(String soTaiKhoan) {
        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk instanceof TaiKhoanTietKiem && tk.getSoTaiKhoan().equals(soTaiKhoan)) {
                return (TaiKhoanTietKiem) tk;
            }
        }
        return null;
    }

    public void inDanhSachTaiKhoan() {
        System.out.println("\nDanh sach tai khoan:");
        System.out.println("STT | So tai khoan | Chu tai khoan | So dien thoai | So du thanh toan");
        System.out.println("---------------------------------------------------------------------");
        int stt = 1;
        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk instanceof TaiKhoanThanhToan) {
                System.out.printf("%3d | %-12s | %-13s | %-13s | %,12.0f\n",
                    stt++,
                    tk.getSoTaiKhoan(),
                    tk.getChuTaiKhoan(),
                    tk.getSoDienThoai(),
                    tk.getSoDu());
            }
        }
    }

    public void chuyenTien(String soTKGui, String soTKNhan, double soTien) {
        TaiKhoanThanhToan tkGui = timTaiKhoanThanhToan(soTKGui);
        TaiKhoanThanhToan tkNhan = timTaiKhoanThanhToan(soTKNhan);
    
        if (tkGui == null || tkNhan == null) {
            System.out.println("Khong tim thay tai khoan.");
            return;
        }
    
        if (tkGui.chuyenTien(tkNhan, soTien)) {
            System.out.println("Chuyen tien thanh cong.");
            // Ghi lịch sử giao dịch
            NganHang.ghiGiaoDich(tkGui.getChuTaiKhoan(), tkNhan.getChuTaiKhoan(), 
                soTien, "Chuyen tien");
        }
    }



    ////////////////////////////////////////////////////////
    private static final String FILENAME = "lichSuGiaoDich.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void ghiGiaoDich(String nguoiGui, String nguoiNhan, double soTien, String loaiGiaoDich) {
        LocalDateTime thoiGian = LocalDateTime.now();
        String thoiGianStr = thoiGian.format(formatter);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME, true))) {
            String giaoDich = String.format("%s | %s | %s | %,.0f VND | %s",
                    thoiGianStr, nguoiGui, nguoiNhan, soTien, loaiGiaoDich);
            writer.write(giaoDich);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Loi khi ghi lich su giao dich: " + e.getMessage());
        }
    }

    public static List<String> docLichSuGiaoDich(String chuTaiKhoan) {
        List<String> lichSu = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length >= 2 && parts[1].trim().equals(chuTaiKhoan)) {
                    lichSu.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi doc lich su giao dich: " + e.getMessage());
        }
        return lichSu;
    }
    ////////////////////////////////////////////////////////////
    public boolean xoaTaiKhoan(String soTaiKhoan) {
        // Xóa khỏi ArrayList
        boolean daXoa = false;
        danhSachTaiKhoan.removeIf(tk -> {
            if (tk.getSoTaiKhoan().equals(soTaiKhoan)) {
                return true;
            }
            return false;
        });
    
        // Cập nhật lại file
        try (BufferedReader reader = new BufferedReader(new FileReader("dsTaiKhoan.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("dsTaiKhoan_temp.txt"))) {
            
            String line;
            int stt = 1;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                if (parts.length >= 2 && !parts[1].trim().equals(soTaiKhoan)) {
                    // Ghi lại các tài khoản khác với số thứ tự mới
                    writer.write(stt + " | " + parts[1] + " | " + parts[2] + " | " + parts[3]);
                    writer.newLine();
                    stt++;
                    daXoa = true;
                }
            }
        } catch (IOException e) {
            System.out.println("Loi khi cap nhat file: " + e.getMessage());
            return false;
        }
    
        // Đổi tên file tạm thành file chính
        try {
            java.io.File oldFile = new java.io.File("dsTaiKhoan.txt");
            java.io.File newFile = new java.io.File("dsTaiKhoan_temp.txt");
            if (oldFile.exists()) {
                oldFile.delete();
            }
            newFile.renameTo(oldFile);
        } catch (Exception e) {
            System.out.println("Loi khi doi ten file: " + e.getMessage());
            return false;
        }
    
        return daXoa;
    }
}