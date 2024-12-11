package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// import com.example.ILOGINCALLBACK;
// import com.example.REGISTERFRAME;

public class SETUP {
    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;
    private String StoredID;
    private final ILOGINCALLBACK callback;

    // Biến tĩnh để lưu trạng thái khóa
    private static boolean isLocked = false;
    // private static String GmailBlocked;
    private static ArrayList<String> GmailBlockedList = new ArrayList<>();

    public String getStoredID() {
        return StoredID;
    }

    public void setStoredID(String StoredID) {
        this.StoredID = StoredID;
    }

    public SETUP(ILOGINCALLBACK callback) {
        this.callback = callback;
        frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);


        // Tạo các thành phần
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 30, 100, 25);
        emailField = new JTextField();
        emailField.setBounds(130, 30, 130, 25);
        String Email = emailField.getText();

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(30, 70, 100, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 70, 130, 25);

        // Nút "Quên mật khẩu"
        JButton forgotPasswordButton = new JButton("Quên mật khẩu?");
        forgotPasswordButton.setBounds(30, 110, 200, 25);
        forgotPasswordButton.setFocusPainted(false);
        forgotPasswordButton.addActionListener(e -> {
            UPDATEINFORMATION recovery = new UPDATEINFORMATION(callback, null, null);
            recovery.RecoveryPassWord("Change password");
            // Sau khi khôi phục thành công
            isLocked = false; // Reset trạng thái khóa
            GmailBlockedList.remove(emailField.getText()); // Loại bỏ Gmail vừa khôi phục
            // JOptionPane.showMessageDialog(frame, "Mật khẩu đã được khôi phục thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        loginButton.setBounds(15, 160, 120, 25);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new LoginAction());
        registerButton.setBounds(150, 160, 120, 25);
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(e -> {
            REGISTERFRAME REGISTERFRAME = new REGISTERFRAME(callback);
            REGISTERFRAME.setVisible(true);
            frame.dispose();
        });

        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(forgotPasswordButton);
        frame.add(loginButton);
        frame.add(registerButton);
    }

    private class LoginAction implements ActionListener {
        private int loginAttempts = 0; // Biến đếm số lần đăng nhập

        @Override
        public void actionPerformed(ActionEvent e) {
            ACCOUNT account = new ACCOUNT();
            account.setGmail(emailField.getText());
            account.setPassword(new String(passwordField.getPassword()));

            // Kiểm tra nếu email và mật khẩu không được để trống
            if (account.getGmail().isEmpty() || account.getPassword().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Email and Password cannot be blank.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (GmailBlockedList.contains(account.getGmail())) {
                JOptionPane.showMessageDialog(frame, "Tài khoản đã bị khóa. Vui lòng chọn 'Quên mật khẩu' để khôi phục.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String pass = null;
            try {
                Connection connection = SQLSERVERHANDLE.getConnection();

                if (account.getGmail().contains("@gmail.com")) {
                    String sql1 = "SELECT CustomerID, C_Password FROM CUSTOMER WHERE Email = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql1);
                    preparedStatement.setString(1, account.getGmail());
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        pass = resultSet.getString(2);
                        if (account.getPassword().equals(pass)) {
                            callback.onLoginSuccess("Customer", resultSet.getString(1), (resultSet != null));
                            setStoredID(resultSet.getString(1));
                            frame.dispose();
                        } else {
                            loginAttempts++; // Tăng biến đếm khi mật khẩu không đúng
                            handleFailedLogin(account.getGmail());
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Email không tồn tại.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if (account.getGmail().contains("@sv.ute.udn.vn")) {
                    String sql2 = "SELECT AdminID, A_Password FROM ADMIN WHERE Email = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql2);
                    preparedStatement.setString(1, account.getGmail());

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        pass = resultSet.getString(2);
                        if (account.getPassword().equals(pass)) {
                            callback.onLoginSuccess("Admin", resultSet.getString(1), (resultSet != null));
                            // GmailBlockedList.remove(account.getGmail());
                            setStoredID(resultSet.getString(1));
                            frame.dispose();
                        } else {
                            loginAttempts++; // Tăng biến đếm khi mật khẩu không đúng
                            handleFailedLogin(account.getGmail());
                        }
                    } else {
                        JOptionPane.showMessageDialog(frame, "Email does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        private void handleFailedLogin(String Email) {
            if (loginAttempts >= 5) {
                GmailBlockedList.add(Email);
                JOptionPane.showMessageDialog(frame, "Bạn đã nhập sai mật khẩu quá 5 lần. Tài khoản đã bị khóa. Chọn 'Quên mật khẩu' để khôi phục.", "Error", JOptionPane.ERROR_MESSAGE);
                frame.revalidate();
                frame.repaint();
            } else {
                JOptionPane.showMessageDialog(frame, "Mật khẩu không chính xác. Bạn đã nhập sai " + 
                                                loginAttempts + " lần." + "\n" + "Nhập quá 5 lần thì tài khoản sẽ bị khóa.",
                                             "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}