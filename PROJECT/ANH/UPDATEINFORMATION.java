package com.example;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import org.jdatepicker.impl.UtilCalendarModel;

public class UPDATEINFORMATION {
    private JFrame frame;
    private ACCOUNT account;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JRadioButton customerRadio;
    private JRadioButton adminRadio;
    private final ILOGINCALLBACK callback;
    private static boolean statuLogin = false;
    private static String idUser;
    private static String role;
    private JTextField Input;
    private JSpinner Input2;
    private JButton Input3;
    private JComboBox<String> Input4;
    private boolean canSendOTP = true;
    private String OTP;
    private Double accountBalance = 0.0;
    
    public static boolean isStatuLogin() {
        return statuLogin;
    }
    public static void setStatuLogin(boolean statuLogin) {
        UPDATEINFORMATION.statuLogin = statuLogin;
    }

    public static String getIdUser() {
        return idUser;
    }
    public static void setIdUser(String idUser) {
        UPDATEINFORMATION.idUser = idUser;
    }

    public static String getRole() {
        return role;
    }
    public static void setRole(String role) {
        UPDATEINFORMATION.role = role;
    }

    public JTextField getInput() {
        return Input;
    }

    public void setInput(JTextField input) {
        Input = input;
    }

    public JSpinner getInput2() {
        return Input2;
    }
    public void setInput2(JSpinner input2) {
        Input2 = input2;
    }

    public JButton getInput3() {
        return Input3;
    }
    public void setInput3(JButton input3) {
        Input3 = input3;
    }

    public JComboBox<String> getInput4() {
        return Input4;
    }
    public void setInput4(JComboBox<String> Input4) {
        this.Input4 = Input4;
    }

    public String getOTP() {
        return OTP;
    }
    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    
    public UPDATEINFORMATION(ILOGINCALLBACK callback, String IDUser, String role) {
        this.callback = callback;
        setIdUser(IDUser);
        setRole(role);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void ChangeName(String Content){
        frame = new JFrame("Change the Username");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        JPanel no1 = getPanel("Enter ID",150,150,35);
        JTextField Cno1 = getInput();
        JPanel no2 = getPanel("Old name",150,150,35);
        JTextField Cno2 = getInput();
        JPanel no3 = getPanel("New name",150,150,35);
        JTextField Cno3 = getInput();
        JPanel no4 = getPanel("Password",150,150,35);
        JTextField Cno4 = getInput();
        JButton Bno5 = getButton(Content,200, 35);


        frame.add(no1);
        frame.add(no2);
        frame.add(no3);
        frame.add(no4);
        frame.add(Bno5);
        
        Bno5.addActionListener((ActionEvent e) ->{
            String ID    = Cno1.getText();
            String OName = Cno2.getText();
            String NName = Cno3.getText();
            String PassW = Cno4.getText();

            account = new ACCOUNT();
            if (ID.isEmpty() || OName.isEmpty() || NName.isEmpty() || PassW.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all information", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else {
                try {
                    Connection connection1 = SQLSERVERHANDLE.getConnection();
                    // Cập nhật thông tin khách hàng
                    if (getRole().equals("Admin")) {
                        String selectSql1 = "Select AdminID, nameAdmin, A_Password From Admin WHERE AdminID = ?";
    
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSql1);
                        preparedStatement1.setString(1, getIdUser());
        
                        ResultSet resultSet = preparedStatement1.executeQuery();
                        if (resultSet.next()) {
                            this.account.setUsername(resultSet.getString(2));
                            this.account.setPassword(resultSet.getString(3));
                            if (ID.equals(getIdUser()) && OName.equals(account.getUsername()) && PassW.equals(account.getPassword())) {
                                try {
                                    Connection connection2 = SQLSERVERHANDLE.getConnection();
                                    // Cập nhật thông tin khách hàng
                                    String selectSql2 = "Update Admin Set nameAdmin = ? From Admin WHERE AdminID = ?";
                    
                                    PreparedStatement preparedStatement2 = connection2.prepareStatement(selectSql2);
                                    preparedStatement2.setString(1, NName);
                                    preparedStatement2.setString(2, getIdUser());
        
                                    int rowAffected = preparedStatement2.executeUpdate();
                                    if (rowAffected > 0) {
                                        JOptionPane.showMessageDialog(frame, "Change name sucess.");
                                        frame.dispose();
                                    }
        
                                } catch (HeadlessException | SQLException ei) {
                                    // TODO: handle exception
                                }
        
                            }
                        }
                    }
                    if(getRole().equals("Customer")) {
                        String selectSql1 = "Select CustomerID, nameCust, C_Password From Customer WHERE CustomerID = ?";
    
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSql1);
                        preparedStatement1.setString(1, getIdUser());
        
                        ResultSet resultSet = preparedStatement1.executeQuery();
                        if (resultSet.next()) {
                            String name = resultSet.getString(2);
                            String pass = resultSet.getString(3);
                            if (ID.equals(getIdUser()) && OName.equals(name) && PassW.equals(pass)) {
                                try {
                                    Connection connection3 = SQLSERVERHANDLE.getConnection();
                                    // Cập nhật thông tin khách hàng
                                    String selectSql3 = "Update Customer Set nameCust = ? From Customer WHERE CustomerID = ?";
                    
                                    PreparedStatement preparedStatement3 = connection3.prepareStatement(selectSql3);
                                    preparedStatement3.setString(1, NName);
                                    preparedStatement3.setString(2, getIdUser());
        
                                    int rowAffected = preparedStatement3.executeUpdate();
                                    if (rowAffected > 0) {
                                        JOptionPane.showMessageDialog(frame, "Change name sucess.");
                                        frame.dispose();
                                    }
        
                                } catch (HeadlessException | SQLException ei) {
                                    // TODO: handle exception
                                }
        
                            }
                        }
                    }
                } catch (HeadlessException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
            
        });

        frame.setVisible(true);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void ChangePassWord(String Content){
        System.out.println(getIdUser());
        frame = new JFrame("Change the Username");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 330);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        account = new ACCOUNT();

        JPanel no1 = getPanel("Enter ID",150,150,35);
        JTextField Cno1 = getInput();
        JPanel no2 = getPanel("Email",150,150,35);
        JTextField Cno2 = getInput();
        JPanel no3 = getPanel("OLD password",150,150,35);
        JTextField Cno3 = getInput();
        JPanel no4 = getPanel("NEW password",150,150,35);
        JTextField Cno4 = getInput();
        JPanel no5 = getPanel("OTP", 100, 100, 35);
        JTextField Cno5 = getInput();
        JButton Bno5 = getButton("Send", 90, 35);
        JButton Bno6 = getButton(Content,200, 35);

        frame.add(no1);
        frame.add(no2);
        frame.add(no3);
        frame.add(no4);
        frame.add(no5);
        frame.add(Bno5);
        frame.add(Bno6);

        Bno5.addActionListener((ActionEvent e) -> {
            String Email = Cno2.getText();
            System.out.println(Email);
            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                if (Email.contains("@sv.ute.udn.vn")) {
                    String selectSql = "Select AdminID, Email, A_Password From Admin WHERE AdminID = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                    preparedStatement.setString(1, getIdUser());

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String A = resultSet.getString(2);
                        System.out.println("Email:" + A);
                        if (Email.equals(A)) {
                            if (canSendOTP) {
                                String random = account.phuongthucngaunhien(4);
                                try {
                                    new GMailer().sendMain(random, Email);
                                } catch (Exception f) {
                                    f.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                setOTP(random);
                                canSendOTP = false;
                                startTimer(Bno5); // Bắt đầu bộ đếm thời gian
                            } else {
                                JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect Email", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    String selectSql = "Select CustomerID, Email, C_Password From Customer WHERE CustomerID = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                    preparedStatement.setString(1, getIdUser());

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String A = resultSet.getString(2);
                        System.out.println("Email:" + A);
                        if (Email.equals(A)) {
                            if (canSendOTP) {
                                String random = account.phuongthucngaunhien(4);
                                try {
                                    new GMailer().sendMain(random, Email);
                                } catch (Exception f) {
                                    f.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                setOTP(random);
                                canSendOTP = false;
                                startTimer(Bno5); // Bắt đầu bộ đếm thời gian
                            } else {
                                JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect Email", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } catch (Exception f) {
                f.printStackTrace();
            }

        });

        Bno6.addActionListener((ActionEvent e) ->{
            String ID    = Cno1.getText();
            String Email = Cno2.getText();
            String OLDpass = Cno3.getText();
            String NEWpass = Cno4.getText();
            String OTPcode = Cno5.getText();

            if (ID.isEmpty() || Email.isEmpty() || OLDpass.isEmpty() || NEWpass.isEmpty() || OTPcode.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all information", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Connection connection1 = SQLSERVERHANDLE.getConnection();
                    // Cập nhật thông tin khách hàng
                    if (getRole().equals("Admin")) {
                        String selectSql1 = "Select AdminID, Email, A_Password From Admin WHERE AdminID = ?";
    
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSql1);
                        preparedStatement1.setString(1, getIdUser());
        
                        ResultSet resultSet = preparedStatement1.executeQuery();
                        if (resultSet.next()) {
                            this.account.setGmail(resultSet.getString(2));
                            this.account.setPassword(resultSet.getString(3));
                            if (ID.equals(getIdUser()) && Email.equals(account.getGmail()) && 
                                OLDpass.equals(account.getPassword()) && !NEWpass.equals(OLDpass) &&
                                account.kiemTraDoManhMatKhau(NEWpass) &&
                                OTPcode.equals(getOTP()))
                            {
                                try {
                                    Connection connection2 = SQLSERVERHANDLE.getConnection();
                                    // Cập nhật thông tin khách hàng
                                    String selectSql2 = "Update Admin Set A_Password = ? From Admin WHERE AdminID = ?";
                    
                                    PreparedStatement preparedStatement2 = connection2.prepareStatement(selectSql2);
                                    preparedStatement2.setString(1, NEWpass);
                                    preparedStatement2.setString(2, getIdUser());
        
                                    int rowAffected = preparedStatement2.executeUpdate();
                                    if (rowAffected > 0) {
                                        JOptionPane.showMessageDialog(frame, "Change password sucess.");
                                        frame.dispose();
                                    }
        
                                } catch (HeadlessException | SQLException ei) {
                                    ei.printStackTrace();
                                }
                            } else if (!ID.equals(getIdUser())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect IDUser", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (!OLDpass.equals(account.getPassword())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect OLD password", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (NEWpass.equals(OLDpass)) {
                                JOptionPane.showMessageDialog(frame, "New passwword canot be the same as the old password", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (!account.kiemTraDoManhMatKhau(NEWpass)) {
                                JOptionPane.showMessageDialog
                                (frame, "Mật khẩu nhập sai định dạng, mật khẩu phải gồm:" + "\n" +
                                        "+Tối thiểu 6 kí tự." + "\n" + //
                                        "+Có chứa chữ cái." + "\n" + //
                                        "+Có chứa số." + "\n" +  //
                                        "+Có chứa kí tự đặc biệt." + //
                                        "", "Error", JOptionPane.ERROR_MESSAGE);
                            }else if (!OTPcode.equals(getOTP())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect OTP", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    else if(getRole().equals("Customer")) {
                        String selectSql1 = "Select CustomerID, Email, C_Password From Customer WHERE CustomerID = ?";
    
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSql1);
                        preparedStatement1.setString(1, getIdUser());
        
                        ResultSet resultSet = preparedStatement1.executeQuery();
                        if (resultSet.next()) {
                            String Emaill = resultSet.getString(2);
                            String pass = resultSet.getString(3);
                            if (ID.equals(getIdUser()) && Email.equals(Emaill) && 
                            OLDpass.equals(pass) && !NEWpass.equals(OLDpass) &&
                            account.kiemTraDoManhMatKhau(NEWpass) &&
                            OTPcode.equals(getOTP()))
                            {
                                try {
                                    Connection connection3 = SQLSERVERHANDLE.getConnection();
                                    // Cập nhật thông tin khách hàng
                                    String selectSql3 = "Update Customer Set C_Password = ? From Customer WHERE CustomerID = ?";
                    
                                    PreparedStatement preparedStatement3 = connection3.prepareStatement(selectSql3);
                                    preparedStatement3.setString(1, NEWpass);
                                    preparedStatement3.setString(2, getIdUser());
        
                                    int rowAffected = preparedStatement3.executeUpdate();
                                    if (rowAffected > 0) {
                                        JOptionPane.showMessageDialog(frame, "Change password sucess.");
                                        frame.dispose();
                                    }
                                } catch (HeadlessException | SQLException ei) {
                                    ei.printStackTrace();
                                }
                            } else if (!ID.equals(getIdUser())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect IDUser", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (!OLDpass.equals(pass)) {
                                JOptionPane.showMessageDialog(frame, "Incorrect OLD password", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (NEWpass.equals(OLDpass)) {
                                JOptionPane.showMessageDialog(frame, "New passwword canot be the same as the old password", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (!account.kiemTraDoManhMatKhau(NEWpass)) {
                                JOptionPane.showMessageDialog
                                (frame, "Mật khẩu nhập sai định dạng, mật khẩu phải gồm:" + "\n" +
                                        "+Tối thiểu 6 kí tự." + "\n" + //
                                        "+Có chứa chữ cái." + "\n" + //
                                        "+Có chứa số." + "\n" +  //
                                        "+Có chứa kí tự đặc biệt." + //
                                        "", "Error", JOptionPane.ERROR_MESSAGE);
                            }else if (!OTPcode.equals(getOTP())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect OTP", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } catch (HeadlessException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void RecoveryPassWord(String Content){
        System.out.println(getIdUser());
        frame = new JFrame("Change the Username");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        account = new ACCOUNT();

        JPanel no2 = getPanel("Email",150,150,35);
        JTextField Cno2 = getInput();
        JPanel no3 = getPanel("Phone number",150,150,35);
        JTextField Cno3 = getInput();
        JPanel no4 = getPanel("NEW password",150,150,35);
        JTextField Cno4 = getInput();
        JPanel no5 = getPanel("OTP", 100, 100, 35);
        JTextField Cno5 = getInput();
        JButton Bno5 = getButton("Send", 90, 35);
        JButton Bno6 = getButton(Content,200, 35);

        frame.add(no2);
        frame.add(no3);
        frame.add(no4);
        frame.add(no5);
        frame.add(Bno5);
        frame.add(Bno6);

        Bno5.addActionListener((ActionEvent e) -> {
            String Email = Cno2.getText();
            System.out.println(Email);
            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                if (Email.contains("@sv.ute.udn.vn")) {
                    String selectSql = "Select AdminID, Email, A_Password From Admin WHERE Email = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                    preparedStatement.setString(1, Email);

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String A = resultSet.getString(2);
                        System.out.println("Email:" + A);
                        if (Email.equals(A)) {
                            if (canSendOTP) {
                                String random = account.phuongthucngaunhien(4);
                                try {
                                    new GMailer().sendMain(random, Email);
                                } catch (Exception f) {
                                    f.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                setOTP(random);
                                canSendOTP = false;
                                startTimer(Bno5); // Bắt đầu bộ đếm thời gian
                            } else {
                                JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect Email", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    String selectSql = "Select CustomerID, Email, C_Password From Customer WHERE Email = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                    preparedStatement.setString(1, Email);

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String A = resultSet.getString(2);
                        System.out.println("Email:" + A);
                        if (Email.equals(A)) {
                            if (canSendOTP) {
                                String random = account.phuongthucngaunhien(4);
                                try {
                                    new GMailer().sendMain(random, Email);
                                } catch (Exception f) {
                                    f.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                setOTP(random);
                                canSendOTP = false;
                                startTimer(Bno5); // Bắt đầu bộ đếm thời gian
                            } else {
                                JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect Email", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } catch (Exception f) {
                f.printStackTrace();
            }

        });

        Bno6.addActionListener((ActionEvent e) ->{
            String Email   = Cno2.getText();
            String Phone = Cno3.getText();
            String NEWpass = Cno4.getText();
            String OTPcode = Cno5.getText();

            System.out.println(OTPcode);


            if (Email.isEmpty() || Phone.isEmpty() || NEWpass.isEmpty() || OTPcode.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all information", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Connection connection1 = SQLSERVERHANDLE.getConnection();
                    // Cập nhật thông tin khách hàng
                    if (Email.contains("@sv.ute.udn.vn")) {
                        String selectSql1 = "Select AdminID, Email, A_Password, Phone From Admin WHERE Email = ?";
    
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSql1);
                        preparedStatement1.setString(1, Email);
        
                        ResultSet resultSet = preparedStatement1.executeQuery();
                        if (resultSet.next()) {
                            this.account.setIdAccount(resultSet.getString(1));
                            this.account.setGmail(resultSet.getString(2));
                            this.account.setPassword(resultSet.getString(3));
                            this.account.setPhone(resultSet.getString(4));
                            if (Email.equals(account.getGmail()) && 
                                Phone.equals(account.getPhone()) &&
                                account.kiemTraDoManhMatKhau(NEWpass) &&
                                OTPcode.equals(getOTP()))
                            {
                                try {
                                    Connection connection2 = SQLSERVERHANDLE.getConnection();
                                    // Cập nhật thông tin khách hàng
                                    String selectSql2 = "Update Admin Set A_Password = ? From Admin WHERE AdminID = ?";
                    
                                    PreparedStatement preparedStatement2 = connection2.prepareStatement(selectSql2);
                                    preparedStatement2.setString(1, NEWpass);
                                    preparedStatement2.setString(2, account.getIdAccount());
        
                                    int rowAffected = preparedStatement2.executeUpdate();
                                    if (rowAffected > 0) {
                                        JOptionPane.showMessageDialog(frame, "Change password sucess.");
                                        frame.dispose();
                                    }
        
                                } catch (HeadlessException | SQLException ei) {
                                    ei.printStackTrace();
                                }
                            } else if (!Phone.equals(account.getPhone())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect Phone number", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (!account.kiemTraDoManhMatKhau(NEWpass)) {
                                JOptionPane.showMessageDialog
                                (frame, "Password entered in wrong format, password must include:" + "\n" +
                                        "+Tối thiểu 6 kí tự." + "\n" + //
                                        "+Có chứa chữ cái." + "\n" + //
                                        "+Có chứa số." + "\n" +  //
                                        "+Có chứa kí tự đặc biệt." + //
                                        "", "Error", JOptionPane.ERROR_MESSAGE);
                            }else if (!OTPcode.equals(getOTP())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect OTP", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    if(Email.contains("@gmail.com")) {
                        String selectSql1 = "Select CustomerID, Email, C_Password, Phone From Customer WHERE Email = ?";
    
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSql1);
                        preparedStatement1.setString(1, Email);
        
                        ResultSet resultSet = preparedStatement1.executeQuery();
                        if (resultSet.next()) {
                            String Emaill   = resultSet.getString(2);
                            String id     = resultSet.getString(1);
                            String SDT      = resultSet.getString(4);
                            if (Email.equals(Emaill) && 
                                Phone.equals(SDT) &&
                                account.kiemTraDoManhMatKhau(NEWpass) &&
                                OTPcode.equals(getOTP()))
                            {
                                try {
                                    Connection connection3 = SQLSERVERHANDLE.getConnection();
                                    // Cập nhật thông tin khách hàng
                                    String selectSql3 = "Update Customer Set C_Password = ? From Customer WHERE CustomerID = ?";
                    
                                    PreparedStatement preparedStatement3 = connection3.prepareStatement(selectSql3);
                                    preparedStatement3.setString(1, NEWpass);
                                    preparedStatement3.setString(2, id);
        
                                    int rowAffected = preparedStatement3.executeUpdate();
                                    if (rowAffected > 0) {
                                        JOptionPane.showMessageDialog(frame, "Change password sucess.");
                                        frame.dispose();
                                    }
        
                                } catch (HeadlessException | SQLException ei) {
                                    ei.printStackTrace();
                                }
                            } else if (!Phone.equals(SDT)) {
                                JOptionPane.showMessageDialog(frame, "Incorrect Phone number", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (!account.kiemTraDoManhMatKhau(NEWpass)) {
                                JOptionPane.showMessageDialog
                                (frame, "Password entered in wrong format, password must include:" + "\n" +
                                        "+Tối thiểu 6 kí tự." + "\n" + //
                                        "+Có chứa chữ cái." + "\n" + //
                                        "+Có chứa số." + "\n" +  //
                                        "+Có chứa kí tự đặc biệt." + //
                                        "", "Error", JOptionPane.ERROR_MESSAGE);
                            }else if (!OTPcode.equals(getOTP())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect OTP", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } catch (HeadlessException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }

    public void Choose(String A, String B){
        System.out.println(getIdUser());
        frame = new JFrame("Change the Username");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());
        account = new ACCOUNT();

        
        try {
            Connection connection = SQLSERVERHANDLE.getConnection();
            String sql = "SELECT accountBalance From Customer Where CustomerID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, getIdUser());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                accountBalance = Double.valueOf(resultSet.getString(1));
            }

        } catch (Exception f) {
            // TODO: handle exception
        }

        ArrayList<String> Sclass = new ArrayList<>();
        ArrayList<String> Snumber = new ArrayList<>();
        Sclass.clear();
        Snumber.clear();
        try {
            Connection connection = SQLSERVERHANDLE.getConnection();
            String sql = "SELECT * From SEATCLASS";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                Sclass.add(resultSet.getString(2));
            }            
        } catch (Exception f) {
            // TODO: handle exception
        }

        String[] seatclass = Sclass.toArray(String[]::new);
        String[] option = {"Một Chiều"};
        // String[] option = {"Khứ Hồi","Một Chiều"};

        JPanel no1 = getPanelPlace("Loại vé", option, 150,150,30);
        JComboBox Cno1 = getInput4();
        JPanel no3 = getPanelPlace("Hạng vé",seatclass,150,150,35);
        JComboBox Cno3 = getInput4();

        Cno3.addActionListener((ActionEvent e) ->{
            Snumber.clear(); // Xóa danh sách trước khi thêm mới
            try {
                Connection connection2 = SQLSERVERHANDLE.getConnection();
                String sql2 =   " Select distinct (T.nameSeatType + N.numberSeat) " +
                                " FROM SEATTYPE T, SEATNUMBER N , SEATCLASS C " +
                                " Where N.idSeatType = T.idSeatType " +
                                " AND T.idSeatClass = C.idSeatClass " +
                                " AND C.nameSeatClass = ? " +
                                " AND N.idSeat not in (select distinct idSeat from TICKET Where FlightID = ?) ";
                PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
                preparedStatement2.setString(1, (String) Cno3.getSelectedItem());
                preparedStatement2.setString(2, A);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                
                while(resultSet2.next()) {
                    Snumber.add(resultSet2.getString(1));
                }
            } catch (Exception f) {
                f.printStackTrace();
            }

            // Cập nhật JComboBox cho số vé
            String[] seatnumber = Snumber.toArray(new String[0]);
            JComboBox<String> Cno4 = getInput4();
            Cno4.removeAllItems(); // Xóa các mục cũ
            for (String number : seatnumber) {
                Cno4.addItem(number); // Thêm các mục mới
            }
        });

        JPanel no4 = getPanelPlace("số ghế",new String[0],150,150,35);
        JComboBox Cno4 = getInput4();
        JButton Bno6 = getButton(B,200, 35);

        Bno6.addActionListener((ActionEvent e) ->{
            LocalDateTime ThoiGian = LocalDateTime.now();
            DateTimeFormatter FormTT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // int soluong = Integer.parseInt(Cno2.getText());
            String FlightID = A;
            String CustomerID = getIdUser();
            String idSeat = "";
            String BookingDate = ThoiGian.format(FormTT);
            String TypeTicket = (String) Cno1.getSelectedItem();
            try {
                Connection connection2 = SQLSERVERHANDLE.getConnection();
                String sql2 = " Select distinct  N.idSeat" +
                                " From SEATTYPE T, SEATNUMBER N, SEATCLASS C " +
                                " Where N.idSeatType = T.idSeatType " +
                                " AND T.idSeatClass = C.idSeatClass " +
                                " AND (T.nameSeatType + N.numberSeat) = ? ";
                PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
                preparedStatement2.setString(1, (String) Cno4.getSelectedItem());
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                
                if(resultSet2.next()) {
                    // Snumber.add(resultSet2.getString(1));
                    idSeat = resultSet2.getString(1);
                }
            } catch (Exception f) {
                f.printStackTrace();
            }

            if (TypeTicket.equals("Một Chiều")) {
                try {
                    Connection connection11 = SQLSERVERHANDLE.getConnection();
                    String selectSql11 = "SELECT available, Maximum FROM FLIGHT WHERE FlightID = ?";
                    PreparedStatement preparedStatement11 = connection11.prepareStatement(selectSql11);
                    preparedStatement11.setString(1, FlightID);

                    ResultSet resultSet11 = preparedStatement11.executeQuery();

                    if (resultSet11.next()) {
                        int available   = Integer.parseInt(resultSet11.getString(1));
                        int Maximum     = Integer.parseInt(resultSet11.getString(2));
                        if (available >= Maximum) {
                            JOptionPane.showMessageDialog(frame, "Hết slot ghế rồi, đi chuyến khác đi.");
                            frame.dispose();
                        } else {
                            Connection connection5 = SQLSERVERHANDLE.getConnection();
                            // Khai báo thủ tục với tham số đầu ra
                            String procSql = "{CALL pr_TaoDongMoi(?, ?)}";
                            CallableStatement callableStatement = connection5.prepareCall(procSql);
                            callableStatement.setString(1, "TICKET");
                            callableStatement.registerOutParameter(2, Types.VARCHAR);
                            callableStatement.execute();
                            String newID = callableStatement.getString(2);
                            
                            String updateSql = "UPDATE TICKET " +
                                               "SET FlightID = ?, CustomerID = ?, " +
                                               "idSeat = ?, BookingDate = ?, " +
                                               "TypeTicket = ? " +
                                               "WHERE TicketID = ?";
                            PreparedStatement preparedStatement5 = connection5.prepareStatement(updateSql);
                            preparedStatement5.setString(1, FlightID);
                            preparedStatement5.setString(2, CustomerID);
                            preparedStatement5.setString(3, idSeat);
                            preparedStatement5.setString(4, BookingDate);
                            preparedStatement5.setString(5, TypeTicket);
                            preparedStatement5.setString(6, newID);
                    
                            int rowAffected = preparedStatement5.executeUpdate();
                            
                            if (rowAffected > 0) {
                                Connection connection = SQLSERVERHANDLE.getConnection();
                                String selectSql1 = "SELECT Price FROM TICKET WHERE TicketID = ?";
                                PreparedStatement preparedStatement = connection.prepareStatement(selectSql1);
                                preparedStatement.setString(1, newID);
                                ResultSet resultSet3 = preparedStatement.executeQuery();
                                
                                if (resultSet3.next()) {
                                    Double PriceTicket = Double.valueOf(resultSet3.getString(1));
                                    if (accountBalance < PriceTicket) {
                                        JOptionPane.showMessageDialog(frame, "Số dư không đủ để đặt vé.", "ERROR", JOptionPane.ERROR_MESSAGE);
                                        
                                        // Xóa vé vừa tạo nếu số dư không đủ
                                        String deleteSql = "DELETE FROM TICKET WHERE TicketID = ?";
                                        try (PreparedStatement preparedStatement0 = connection.prepareStatement(deleteSql)) {
                                            preparedStatement0.setString(1, newID);
                                            int rowAffected0 = preparedStatement0.executeUpdate();
                    
                                            if (rowAffected0 > 0) {
                                                JOptionPane.showMessageDialog(frame, "Đã hủy đặt vé.!");
                                            }
                                        } catch (SQLException gg) {
                                            gg.printStackTrace();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(frame, "Booking successful.");
                                        frame.dispose();
                                    }
                                }
                            }
                        }
                    }
                } catch (HeadlessException | SQLException ex) {
                    ex.printStackTrace();
                }
            }

        });


        frame.add(no1);
        // frame.add(no2);
        frame.add(no3);
        frame.add(no4);
        // frame.add(no5);
        frame.add(Bno6);
        frame.setVisible(true);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public void ChangeGmail(String Content){
        System.out.println(getIdUser());
        frame = new JFrame("Change Gmail");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 330);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new FlowLayout());

        account = new ACCOUNT();

        JPanel no1 = getPanel("Enter ID",150,150,35);
        JTextField Cno1 = getInput();
        JPanel no2 = getPanel("OLD Email",150,150,35);
        JTextField Cno2 = getInput();
        JPanel no4 = getPanel("NEW Email",150,150,35);
        JTextField Cno4 = getInput();
        JPanel no5 = getPanel("OTP OLDgmail", 120, 80, 35);
        JTextField Cno5 = getInput();
        JButton Bno5 = getButton("Send", 80, 35);
        JPanel no55 = getPanel("OTP NEWgmail", 120, 80, 35);
        JTextField Cno55 = getInput();
        JButton Bno55 = getButton("Send", 80, 35);
        JButton Bno6 = getButton(Content,200, 35);

        frame.add(no1);
        frame.add(no2);
        frame.add(no4);
        frame.add(no5);
        frame.add(Bno5);
        frame.add(no55);
        frame.add(Bno55);
        frame.add(Bno6);

        Bno5.addActionListener((ActionEvent e) -> {
            String Email = Cno2.getText();
            System.out.println(Email);
            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                if (Email.contains("@sv.ute.udn.vn")) {
                    String selectSql = "Select AdminID, Email, A_Password From Admin WHERE AdminID = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                    preparedStatement.setString(1, getIdUser());

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String A = resultSet.getString(2);
                        System.out.println("Email:" + A);
                        if (Email.equals(A)) {
                            if (canSendOTP) {
                                String random = account.phuongthucngaunhien(4);
                                try {
                                    new GMailer().sendMain(random, Email);
                                } catch (Exception f) {
                                    f.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                setOTP(random);
                                canSendOTP = false;
                                startTimer(Bno5); // Bắt đầu bộ đếm thời gian
                            } else {
                                JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect Email", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    String selectSql = "Select CustomerID, Email, C_Password From Customer WHERE CustomerID = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                    preparedStatement.setString(1, getIdUser());

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String A = resultSet.getString(2);
                        System.out.println("Email:" + A);
                        if (Email.equals(A)) {
                            if (canSendOTP) {
                                String random = account.phuongthucngaunhien(4);
                                try {
                                    new GMailer().sendMain(random, Email);
                                } catch (Exception f) {
                                    f.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                setOTP(random);
                                canSendOTP = false;
                                startTimer(Bno5); // Bắt đầu bộ đếm thời gian
                            } else {
                                JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect Email", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } catch (Exception f) {
                f.printStackTrace();
            }

        });

        Bno55.addActionListener((ActionEvent e) -> {
            String Email    = Cno2.getText();
            String EmailNew = Cno4.getText();
            System.out.println(Email);

            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                if (Email.contains("@sv.ute.udn.vn")) {
                    if (EmailNew.contains("@sv.ute.udn.vn")) {
                        String selectSql = "Select AdminID, Email, A_Password From Admin WHERE AdminID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                        preparedStatement.setString(1, getIdUser());
    
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            String A = resultSet.getString(2);
                            System.out.println("Email:" + A);
                            if (Email.equals(A)) {
                                if (canSendOTP) {
                                    String random = account.phuongthucngaunhien(4);
                                    try {
                                        new GMailer().sendMain(random, Email);
                                    } catch (Exception f) {
                                        f.printStackTrace();
                                    }
                                    JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                    setOTP(random);
                                    canSendOTP = false;
                                    startTimer(Bno55); // Bắt đầu bộ đếm thời gian
                                } else {
                                    JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(frame, "Incorrect Email", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Admin Email must in include \"@sv.ute.udn.vn\" ", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    if (EmailNew.contains("@gmail.com")) {
                        String selectSql = "Select CustomerID, Email, C_Password From Customer WHERE CustomerID = ?";
                        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                        preparedStatement.setString(1, getIdUser());
    
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            String A = resultSet.getString(2);
                            System.out.println("Email:" + A);
                            if (Email.equals(A)) {
                                if (canSendOTP) {
                                    String random = account.phuongthucngaunhien(4);
                                    try {
                                        new GMailer().sendMain(random, Email);
                                    } catch (Exception f) {
                                        f.printStackTrace();
                                    }
                                    JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                    setOTP(random);
                                    canSendOTP = false;
                                    startTimer(Bno55); // Bắt đầu bộ đếm thời gian
                                } else {
                                    JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                                }
                            } else {
                                JOptionPane.showMessageDialog(frame, "Incorrect Email", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Admin Email must in include \"@sv.ute.udn.vn\" ", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception f) {
                f.printStackTrace();
            }

        });

        Bno6.addActionListener((ActionEvent e) ->{
            String ID    = Cno1.getText();
            String Email = Cno2.getText();
            String NEWgmail = Cno4.getText();
            String OTPcode = Cno5.getText();

            if (ID.isEmpty() || Email.isEmpty() || NEWgmail.isEmpty() || OTPcode.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all information", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Connection connection1 = SQLSERVERHANDLE.getConnection();
                    // Cập nhật thông tin khách hàng
                    if (getRole().equals("Admin")) {
                        String selectSql1 = "Select AdminID, Email, A_Password From Admin WHERE AdminID = ?";
    
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSql1);
                        preparedStatement1.setString(1, getIdUser());
        
                        ResultSet resultSet = preparedStatement1.executeQuery();
                        if (resultSet.next()) {
                            this.account.setGmail(resultSet.getString(2));
                            this.account.setPassword(resultSet.getString(3));
                            if (ID.equals(getIdUser()) && Email.equals(account.getGmail()) &&
                                account.kiemTraDinhDangGmail(NEWgmail) &&
                                OTPcode.equals(getOTP()))
                            {
                                try {
                                    Connection connection2 = SQLSERVERHANDLE.getConnection();
                                    // Cập nhật thông tin khách hàng
                                    String selectSql2 = "Update Admin Set Email = ? From Admin WHERE AdminID = ?";
                    
                                    PreparedStatement preparedStatement2 = connection2.prepareStatement(selectSql2);
                                    preparedStatement2.setString(1, NEWgmail);
                                    preparedStatement2.setString(2, getIdUser());
        
                                    int rowAffected = preparedStatement2.executeUpdate();
                                    if (rowAffected > 0) {
                                        JOptionPane.showMessageDialog(frame, "Change Gmail sucess.");
                                        frame.dispose();
                                    }
        
                                } catch (HeadlessException | SQLException ei) {
                                    ei.printStackTrace();
                                }
                            } else if (!ID.equals(getIdUser())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect IDUser", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (NEWgmail.equals(Email)) {
                                JOptionPane.showMessageDialog(frame, "New passwword canot be the same as the old password", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (!NEWgmail.contains("@sv.ute.udn.vn")) {
                                JOptionPane.showMessageDialog(frame, "Email phải chứa '@gmail.com'.", "Error", JOptionPane.ERROR_MESSAGE);
                            } else if (!OTPcode.equals(getOTP())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect OTP", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    else if(getRole().equals("Customer")) {
                        String selectSql1 = "Select CustomerID, Email, C_Password From Customer WHERE CustomerID = ?";
    
                        PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSql1);
                        preparedStatement1.setString(1, getIdUser());
        
                        ResultSet resultSet = preparedStatement1.executeQuery();
                        if (resultSet.next()) {
                            String Emaill = resultSet.getString(2);
                            String pass = resultSet.getString(3);
                            if (ID.equals(getIdUser()) && Email.equals(Emaill) &&
                            account.kiemTraDinhDangGmail(NEWgmail) &&
                            OTPcode.equals(getOTP()))
                            {
                                try {
                                    Connection connection3 = SQLSERVERHANDLE.getConnection();
                                    // Cập nhật thông tin khách hàng
                                    String selectSql3 = "Update Customer Set Email = ? From Customer WHERE CustomerID = ?";
                    
                                    PreparedStatement preparedStatement3 = connection3.prepareStatement(selectSql3);
                                    preparedStatement3.setString(1, NEWgmail);
                                    preparedStatement3.setString(2, getIdUser());
        
                                    int rowAffected = preparedStatement3.executeUpdate();
                                    if (rowAffected > 0) {
                                        JOptionPane.showMessageDialog(frame, "Change Gmail sucess.");
                                        frame.dispose();
                                    }
                                } catch (HeadlessException | SQLException ei) {
                                    ei.printStackTrace();
                                }
                            } else if (!ID.equals(getIdUser())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect IDUser", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (NEWgmail.equals(Email)) {
                                JOptionPane.showMessageDialog(frame, "New passwword canot be the same as the old password", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else if (!account.kiemTraDinhDangGmail(NEWgmail)) {
                                JOptionPane.showMessageDialog(frame, "Email phải chứa '@gmail.com'.", "Error", JOptionPane.ERROR_MESSAGE);
                            }else if (!OTPcode.equals(getOTP())) {
                                JOptionPane.showMessageDialog(frame, "Incorrect OTP", "ERROR", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                } catch (HeadlessException | SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        frame.setVisible(true);
    }










    public JButton getButton(String B, int width, int height){
        JButton A = new JButton(B);
        A.setPreferredSize(new Dimension(width, height));
        A.setHorizontalAlignment(SwingConstants.CENTER);
        A.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        A.setOpaque(false);
        A.setFont(new Font("Times New Roman", Font.BOLD, 15));
        return A;
    }

    public JLabel getLabel(String AA, int width, int height){
        JLabel A = new JLabel(AA);
        A.setPreferredSize(new Dimension(width, height));
        A.setHorizontalAlignment(SwingConstants.CENTER);
        A.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        // A.setOpaque(false);
        A.setFont(new Font("Times New Roman", Font.BOLD, 15));
        return A;
    }

    public JTextField getTextField(int width, int height){
        JTextField A = new JTextField();
        A.setPreferredSize(new Dimension(width, height));
        A.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        // A.setOpaque(false);
        A.setFont(new Font("Times New Roman", Font.BOLD, 15));
        return A;
    }

    public JPanel getPanel(String A, int width1, int width2, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color.BLUE);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width1, height));
        label1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        label1.setForeground(Color.YELLOW);
    
        JTextField Tlabel1 = new JTextField();
        Tlabel1.setPreferredSize(new Dimension(width2, height));
        setInput(Tlabel1);

        Group.add(label1);
        Group.add(Tlabel1);
    
        return Group;
    }

    public JPanel getPanelPlace(String A,String[] B, int width1,int width2, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color.BLUE);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width1, height));
        label1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        label1.setForeground(Color.YELLOW);
        JComboBox<String> cityComboBox = new JComboBox<>(B);
        cityComboBox.setPreferredSize(new Dimension(width2, height));
        cityComboBox.setFont(new Font("Times New Roman", Font.BOLD, 15));
        setInput4(cityComboBox);
        
        Group.add(label1);
        Group.add(cityComboBox);

        return Group;
    }



    private void startTimer(JButton Bno5) {
        // Tạo Timer với thời gian 30 giây
        Timer timer;
        timer = new Timer(30000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                canSendOTP = true; // Cho phép gửi OTP sau 30 giây
                Bno5.setEnabled(true); // Kích hoạt lại nút Send OTP
                ((Timer) evt.getSource()).stop(); // Dừng Timer
            }
        });
        timer.setRepeats(false); // Chỉ chạy một lần
        timer.start(); // Bắt đầu Timer
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
