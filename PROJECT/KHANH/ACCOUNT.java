package com.example;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class ACCOUNT {
    private String idAccount;
    private String Username;
    private String Password;
    private String Gmail;
    private String Phone;
    private String DateOfBirth;
    private String accountBalance;

    public ACCOUNT() {
    }

    public ACCOUNT(String DateOfBirth, String Gmail, String Password, String idAccount, String accountBalance) {
        this.DateOfBirth = DateOfBirth;
        this.Gmail = Gmail;
        this.Password = Password;
        this.idAccount = idAccount;
        this.accountBalance = accountBalance;
    }

    public String getIdAccount() {return idAccount;}
    public void setIdAccount(String idAccount) {this.idAccount = idAccount;}

    public String getUsername() {return Username;}
    public void setUsername(String Username) {this.Username = Username;}

    public String getPassword() {return Password;}
    public void setPassword(String Password) {this.Password = Password;}

    public String getGmail() {return Gmail;}
    public void setGmail(String Gmail) {this.Gmail = Gmail;}

    public String getPhone() {return Phone;}
    public void setPhone(String phone) {Phone = phone;}

    public String getDateOfBirth() {return DateOfBirth;}
    public void setDateOfBirth(String DateOfBirth) {this.DateOfBirth = DateOfBirth;}

    public String getAccountBalance() {return accountBalance;}
    public void setAccountBalance(String accountBalance) {this.accountBalance = accountBalance;}

    public String phuongthucngaunhien(int dodai) {
        String kitusotaikhoan = "0123456789";
        SecureRandom chuoingaunhien = new SecureRandom();
        if (dodai > kitusotaikhoan.length()) {
            throw new IllegalArgumentException("Do dai vuot qua soluong duy nhat co san");
        }
        Set<Character> sotaikhoanDuyNhat = new HashSet<>();
        StringBuilder sb = new StringBuilder(dodai);

        while (sotaikhoanDuyNhat.size() < dodai) {
            char KituRamDom = kitusotaikhoan.charAt(chuoingaunhien.nextInt(kitusotaikhoan.length()));
            if (sotaikhoanDuyNhat.add(KituRamDom)) {
                sb.append(KituRamDom);
            }
        }
        return sb.toString();
    }
    
    public boolean kiemTraDoManhMatKhau(String matKhau){
        return matKhau.length() >= 6 && 
               matKhau.matches(".*[a-zA-Z]+.*") && // Có ít nhất một chữ cái
               matKhau.matches(".*[0-9]+.*") &&    // Có ít nhất một số
               matKhau.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]+.*"); // Có ít nhất một ký tự đặc biệt
    }

    public boolean kiemTraSoDienThoai(String sodienthoai) {
        return sodienthoai.matches("^0[0-9]{9}$"); // Chấp nhận số điện thoại có 10 chữ số
    }

    public boolean kiemTraDinhDangGmail(String gmail) {
        return gmail.matches("^[a-zA-Z0-9._%+-]+@(gmail\\.com|admin\\.com)$");
    }
}
