package com.example;
// package com.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

// import com.example.ILOGINCALLBACK;

public class REGISTERFRAME {
    private JFrame frame;
    private JTextField UsernameField;
    private JTextField emailField;
    private JTextField numberField;
    private JPasswordField passwordField;
    private JSpinner dateSpinner;
    private ILOGINCALLBACK callback;
    public REGISTERFRAME(ILOGINCALLBACK callback) {
        this.callback = callback;
        frame = new JFrame("Register");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 260);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel Usernamelabel = new JLabel("Username:");
        Usernamelabel.setBounds(30, 30, 100, 25);
        UsernameField = new JTextField();
        UsernameField.setBounds(130, 30, 130, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(30, 60, 100, 25);
        emailField = new JTextField();
        emailField.setBounds(130, 60, 130, 25);

        JLabel phoneLabel = new JLabel("Phone: ");
        phoneLabel.setBounds(30, 90, 100, 25);
        numberField = new JTextField(10);
        numberField.setBounds(130, 90, 130, 25);

        JLabel pwLabel = new JLabel("Password: ");
        pwLabel.setBounds(30, 120, 100, 25);
        passwordField = new JPasswordField(10);
        passwordField.setBounds(130, 120, 130, 25);

        JLabel dateLabel = new JLabel("Date of Birth: ");
        dateLabel.setBounds(30, 150, 130, 25);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        dateSpinner = new JSpinner(
                new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setValue(calendar.getTime());
        dateSpinner.setBounds(130, 150, 130, 25);

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(15, 180, 120, 25);
        registerButton.setFocusPainted(false);
        loginButton.setBounds(150, 180, 120, 25);
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(e -> {
            SETUP SETUP = new SETUP(callback);
            SETUP.setVisible(true);
            frame.dispose();
        });
        registerButton.addActionListener(new RegisterAction());

        frame.add(Usernamelabel);
        frame.add(UsernameField);
        frame.add(dateLabel);
        frame.add(dateSpinner);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(phoneLabel);
        frame.add(numberField);
        frame.add(pwLabel);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(registerButton);
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getNumberField() {
        return numberField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    private class RegisterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = UsernameField.getText();
            String email = emailField.getText();
            String phone = numberField.getText();
            String password = new String(passwordField.getPassword());
            Date date = (Date) dateSpinner.getValue();
            String birthDay = String.format("%1$td/%1$tm/%1$tY", date);
            ACCOUNT account = new ACCOUNT();
    
            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                // Kiểm tra xem email đã tồn tại hay chưa
                String checkEmailSql = "SELECT * FROM CUSTOMER WHERE Email = ?";
                PreparedStatement checkEmailStmt = connection.prepareStatement(checkEmailSql);
                checkEmailStmt.setString(1, email);
                ResultSet emailResultSet = checkEmailStmt.executeQuery();
    
                if (emailResultSet.next()) {
                    JOptionPane.showMessageDialog(frame, "Email are already exist.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Dừng nếu email đã tồn tại
                }
    
                // Nếu email chưa tồn tại, tiếp tục kiểm tra thông tin khác
                if (!username.isEmpty() && account.kiemTraDinhDangGmail(email) &&
                    account.kiemTraDoManhMatKhau(password) && account.kiemTraSoDienThoai(phone) &&
                    !birthDay.isEmpty()) {
                    
                    // Chèn thông tin người dùng mới
                    String procSql = "{CALL pr_TaoDongMoi(?, ?)}";
                    CallableStatement callableStatement = connection.prepareCall(procSql);
                    callableStatement.setString(1, "Customer");
                    callableStatement.registerOutParameter(2, Types.VARCHAR);
                    callableStatement.execute();
                    String newCustomerID = callableStatement.getString(2);
                    
                    String updateSql = "UPDATE Customer SET NameCust = ?, C_Password = ?, Email = ?, Phone = ?, DateOfBirth = ? WHERE CustomerID = ?";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(updateSql);
                    preparedStatement2.setString(1, username);
                    preparedStatement2.setString(2, password);
                    preparedStatement2.setString(3, email);
                    preparedStatement2.setString(4, phone);
                    preparedStatement2.setString(5, birthDay);
                    preparedStatement2.setString(6, newCustomerID); // Sử dụng CustomerID mới chèn
                    int rowAffected = preparedStatement2.executeUpdate();
                    if (rowAffected > 0) {
                        callback.onLoginSuccess("Customer", newCustomerID, false);
                        frame.dispose();
                        JOptionPane.showMessageDialog(frame, "Register successful.");
                    }
                } else if (username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty() || birthDay.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Tất cả thông tin không được để trống.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!account.kiemTraDinhDangGmail(email)) {
                    JOptionPane.showMessageDialog(frame, "Email phải chứa '@gmail.com'.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!account.kiemTraDoManhMatKhau(password)) {
                    JOptionPane.showMessageDialog
                    (frame, "Mật khẩu nhập sai định dạng, mật khẩu phải gồm:" + "\n" +
                            "+Tối thiểu 6 kí tự." + "\n" + //
                            "+Có chứa chữ cái." + "\n" + //
                            "+Có chứa số." + "\n" +  //
                            "+Có chứa kí tự đặc biệt." + //
                            "", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!account.kiemTraSoDienThoai(phone)) {
                    JOptionPane.showMessageDialog(frame, "Số điện thoại chỉ chấp nhận 10 số và bắt đầu bằng '0'.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    
}
