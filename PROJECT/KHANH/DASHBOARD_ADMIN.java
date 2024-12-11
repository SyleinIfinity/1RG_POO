package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class DASHBOARD_ADMIN {
    private JFrame frame;
    private ILOGINCALLBACK callback;
    private static boolean statuLogin = false;
    private static String idUser;
    private static String role;
    private JButton item_1;
    private JButton item_1_1;
    private JButton item_2;
    private JButton item_3;
    private JButton item_4;
    private JButton item_5;
    private JButton item_6;
    private JButton item_7;
    private JButton item_8;
    private JButton item_9;
    private JButton item_10;
    private JPanel Menu_Top;
    private JPanel Menu_Left;
    private JPanel Menu_Content;
    private JTextField Input;
    private JSpinner Input2;
    private JButton Input3;
    private JComboBox<String> Input4;
    private boolean canSendOTP = true;
    private String OTP;

    private ImageIcon logoIcon = new ImageIcon("C:\\Users\\TUFadmin\\OneDrive - University of Technology and Education (1)\\Desktop\\demo\\src\\main\\resources\\Logo.png");
    private final Color Color_1 = new Color(255, 187, 0);
    private final Color Color_2 = new Color(89, 63, 222);
    private final Color Color_3 = new Color(242, 255, 210);
    private final Color Color_4 = new Color(106, 69, 33);
    private final Font Font_1 = new Font("Times New Roman", Font.BOLD, 19);
    private final Font TimesNewRoman_30 = new Font("Times New Roman", Font.BOLD, 30);
    private final Font TimesNewRoman_20 = new Font("Times New Roman", Font.BOLD, 20);
    private final Font TimesNewRoman_15 = new Font("Times New Roman", Font.BOLD, 15);
    private final Font TimesNewRoman_10 = new Font("Times New Roman", Font.BOLD, 10);

    
    public static String getIdUser() {
        return idUser;
    }
    public static void setIdUser(String idUser) {
        DASHBOARD_ADMIN.idUser = idUser;
    }

    public static String getRole() {
        return role;
    }
    public static void setRole(String role) {
        DASHBOARD_ADMIN.role = role;
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


    public DASHBOARD_ADMIN(ILOGINCALLBACK callback, String idUser, String role){
        setRole(role);
        setIdUser(idUser);

        frame = new JFrame("Anderson Airline");
        frame.setIconImage(logoIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 800);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        item_1      = getButton("Add User account",190, 40);
        item_1_1    = getButton(getRole(),190, 40);
        item_2      = getButton("Remove UserAccount",190, 40);
        item_3      = getButton("Add Flight",190, 40);
        item_4      = getButton("Remove Flight",190, 40);
        // item_5      = getButton("Add Seat Number", 190, 40);
        // item_6      = getButton("Remove Seat Number", 190, 40);
        item_7      = getButton("Add Airport", 190, 40);
        item_8      = getButton("Remove Airport", 190, 40);
        item_9      = getButton("Drop ticket", 190, 40);
        item_10     = getButton("Exit",190, 40);

        {
            Menu_Top = new JPanel();
            Menu_Top.setPreferredSize(new Dimension(800, 50));
            Menu_Top.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            Menu_Top.setOpaque(true);
            Menu_Top.setLayout(new FlowLayout(FlowLayout.RIGHT));
            Menu_Top.setBackground(Color_2);
    
            Menu_Left = new JPanel();
            Menu_Left.setPreferredSize(new Dimension(200, 550));
            Menu_Left.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            Menu_Left.setOpaque(true);
            Menu_Left.setBackground(Color_1);
            
            Menu_Content = new JPanel();
            Menu_Content.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            Menu_Content.setOpaque(true);
            Menu_Content.setBackground(Color_3);
        }

        item_1.addActionListener(new item1Action());
        item_1_1.addActionListener(new item11Action());
        item_2.addActionListener(new item2Action());
        item_3.addActionListener(new item3Action());
        item_4.addActionListener(new item4Action());
        // item_5.addActionListener(new item5Action());
        // item_6.addActionListener(new item6Action());
        item_7.addActionListener(new item7Action());
        item_8.addActionListener(new item8Action());
        item_9.addActionListener(new item9Action());
        item_10.addActionListener(new item10Action());

        Menu_Left.add(item_1);
        Menu_Top.add(item_1_1);
        Menu_Left.add(item_2);
        Menu_Left.add(item_3);
        Menu_Left.add(item_4);
        // Menu_Left.add(item_5);
        // Menu_Left.add(item_6);
        Menu_Left.add(item_7);
        Menu_Left.add(item_8);
        Menu_Left.add(item_9);
        Menu_Left.add(item_10);

        frame.add(Menu_Top, BorderLayout.NORTH);
        frame.add(Menu_Left, BorderLayout.WEST);
        frame.add(Menu_Content, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class item1Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new FlowLayout());

            JPanel no0 = getPanel("ADD FLIGHT PAGE", 600);
            JPanel no1 = getPanel("Name",200,250,40);
            JTextField Cno1 = getInput();
            JPanel no2 = getPanel("Email",200,250,40);
            JTextField Cno2 = getInput();
            JPanel no3 = getPanel("Phone",200,250,40);
            JTextField Cno3 = getInput();
            JPanel no4 = getPanel("Password",200,250,40);
            JTextField Cno4 = getInput();
            JPanel no5 = getPanelTime("Date of birth", 200,250, 40);
            JSpinner Cno5 = getInput2();
            JButton no6 = getButton("Add account",550, 60);
            
            Menu_Content.add(no0);
            Menu_Content.add(no1);
            Menu_Content.add(no2);
            Menu_Content.add(no3);
            Menu_Content.add(no4);
            Menu_Content.add(no5);
            Menu_Content.add(no6);
            
            no6.addActionListener((ActionEvent f)->{
                ACCOUNT account = new ACCOUNT();
                String Name = Cno1.getText();
                System.out.println(Name);
                String email = Cno2.getText();
                System.out.println(email);
                String Phone = Cno3.getText();
                System.out.println(Phone);
                String PassW = Cno4.getText();
                System.out.println(PassW);
                Date date = (Date) Cno5.getValue();
                String DofB = String.format("%1$td/%1$tm/%1$tY", date);
                // System.out.println(DofB);

                try {
                    Connection connectionq = SQLSERVERHANDLE.getConnection();
                    // Kiểm tra xem email đã tồn tại hay chưa
                    String checkEmailSql = "SELECT * FROM CUSTOMER WHERE Email = ?";
                    PreparedStatement checkEmailStmt = connectionq.prepareStatement(checkEmailSql);
                    checkEmailStmt.setString(1, email);
                    ResultSet emailResultSet = checkEmailStmt.executeQuery();
        
                    if (emailResultSet.next()) {
                        JOptionPane.showMessageDialog(frame, "Email are already exist.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Dừng nếu email đã tồn tại
                    }

                    if (!Name.isEmpty() && account.kiemTraDinhDangGmail(email) &&
                    account.kiemTraDoManhMatKhau(PassW) && account.kiemTraSoDienThoai(Phone) &&
                    !DofB.isEmpty())
                    {
                        if (email.contains("@admin.com")) {
                            try {
                                Connection connection = SQLSERVERHANDLE.getConnection();
                                // String grantSql = "GRANT INSERT ON dbo.CUSTOMER TO [khanh123];";
                                // Statement stmt = connection.createStatement();
                                // stmt.execute(grantSql);
                                // Khai báo thủ tục với tham số đầu ra
                                String procSql = "{CALL pr_TaoDongMoi(?, ?)}"; // Sử dụng cú pháp CallableStatement
                                CallableStatement callableStatement = connection.prepareCall(procSql);
                                callableStatement.setString(1, "Admin");
                                callableStatement.registerOutParameter(2, Types.VARCHAR); // Đăng ký tham số đầu ra
                                // Thực thi thủ tục
                                callableStatement.execute();
                                // Lấy CustomerID mới chèn
                                String newAdminID = callableStatement.getString(2);
                                // Cập nhật thông tin khách hàng
                                String updateSql = "UPDATE Admin SET nameAdmin = ?, A_Password = ?, Email = ?, Phone = ?, DateOfBirth = ? WHERE AdminID = ?";
                                PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
                                preparedStatement.setString(1, Name);
                                preparedStatement.setString(2, PassW);
                                preparedStatement.setString(3, email);
                                preparedStatement.setString(4, Phone);
                                preparedStatement.setString(5, DofB);
                                preparedStatement.setString(6, newAdminID); // Sử dụng CustomerID mới chèn
            
                                int rowAffected = preparedStatement.executeUpdate();
                                if (rowAffected > 0) {
                                    JOptionPane.showMessageDialog(frame, "Add Admin successful.");
                                }
                            } catch (HeadlessException | SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                        else
                        {
                            try {
                                Connection connection = SQLSERVERHANDLE.getConnection();
                                // String grantSql = "GRANT INSERT ON dbo.CUSTOMER TO [khanh123];";
                                // Statement stmt = connection.createStatement();
                                // stmt.execute(grantSql);
                                // Khai báo thủ tục với tham số đầu ra
                                String procSql = "{CALL pr_TaoDongMoi(?, ?)}"; // Sử dụng cú pháp CallableStatement
                                CallableStatement callableStatement = connection.prepareCall(procSql);
                                callableStatement.setString(1, "Customer");
                                callableStatement.registerOutParameter(2, Types.VARCHAR); // Đăng ký tham số đầu ra
                                // Thực thi thủ tục
                                callableStatement.execute();
                                // Lấy CustomerID mới chèn
                                String newCustomerID = callableStatement.getString(2);
                                // Cập nhật thông tin khách hàng
                                String updateSql = "UPDATE Customer SET NameCust = ?, C_Password = ?, Email = ?, Phone = ?, DateOfBirth = ?, accountBalance = 0.0 WHERE CustomerID = ?";
                                PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
                                preparedStatement.setString(1, Name);
                                preparedStatement.setString(2, PassW);
                                preparedStatement.setString(3, email);
                                preparedStatement.setString(4, Phone);
                                preparedStatement.setString(5, DofB);
                                preparedStatement.setString(6, newCustomerID); // Sử dụng CustomerID mới chèn
            
                                int rowAffected = preparedStatement.executeUpdate();
                                if (rowAffected > 0) {
                                    JOptionPane.showMessageDialog(frame, "Add user successful.");
                                }
                            } catch (HeadlessException | SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    } else if (Name.isEmpty() || email.isEmpty() || Phone.isEmpty() || PassW.isEmpty() || DofB.isEmpty()) {
                        JOptionPane.showMessageDialog(frame, "All information cannot be empty.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    } else if(!account.kiemTraDinhDangGmail(email)) {
                        JOptionPane.showMessageDialog(frame, "Gmail must be contained '@gmail.com'.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                    } else if (!account.kiemTraDoManhMatKhau(PassW)) {
                        JOptionPane.showMessageDialog
                        (frame, "Mật khẩu nhập sai định dạng, mật khẩu phải gồm:" + "\n" +
                                "+Tối thiểu 6 kí tự." + "\n" + //
                                "+Có chứa chữ cái." + "\n" + //
                                "+Có chứa số." + "\n" +  //
                                "+Có chứa kí tự đặc biệt." + //
                                "", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (!account.kiemTraSoDienThoai(Phone)) {
                        JOptionPane.showMessageDialog(frame, "Phone accepts only 10 numbers and starts with '0'.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            });

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item11Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());
            JPanel Wrapper = new JPanel();
            Wrapper.setLayout(new FlowLayout(FlowLayout.LEFT));
            Wrapper.setBackground(Color_4);
            System.out.println(getIdUser());
            System.out.println(getRole());
            
            ACCOUNT account = new ACCOUNT();

            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                String sql = "SELECT * From Admin Where AdminID = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, getIdUser());
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    account.setIdAccount(resultSet.getString(1));
                    account.setUsername(resultSet.getString(2));
                    account.setPassword(resultSet.getString(3));
                    account.setGmail(resultSet.getString(4));
                    account.setPhone(resultSet.getString(5));
                    account.setDateOfBirth(resultSet.getString(6));
                }

            } catch (Exception f) {
                // TODO: handle exception
            }

            JPanel no0 = getPanel("Account information Page", 761);
            JPanel no1 = getPanel("ID user", account.getIdAccount(),130,250,30);
            JPanel no2 = getPanel("Name", account.getUsername(),"Change name",130,250,150,30);
            JButton Bno2 = getInput3();
            JPanel no3 = getPanel("Password", account.getPassword(),"Change PassW",130,250,150,30);
            JButton Bno3 = getInput3();
            JPanel no4 = getPanel("Email", account.getGmail(),130,250,30);
            JButton Bno4 = getInput3();
            JPanel no5 = getPanel("Phone number", account.getPhone(),130, 250,30);
            JButton Bno5 = getInput3();
            JPanel no6 = getPanel("Date of birth", account.getDateOfBirth(),130,250,30);

            // Bno2.addActionListener((ActionEvent f) ->{
            //     UPDATEINFORMATION update = new UPDATEINFORMATION(new ILOGINCALLBACK() {
            //         @Override
            //         public void onLoginSuccess(String r, String stk, boolean stt) {
            //             statuLogin = stt;
            //             idUser = stk;
            //             role = r;
            //         }

            //         @Override
            //         public void onLoginFailure(String message) {
            //             System.out.println("Đăng nhập thất bại: " + message);
            //         }
            //     }, getIdUser(), getRole());
            //     update.ChangeName("Change Name");
            //     Menu_Content.revalidate();
            //     Menu_Content.repaint();
            // });

            // Bno3.addActionListener((ActionEvent f) ->{
            //     UPDATEINFORMATION update = new UPDATEINFORMATION(new ILOGINCALLBACK() {
            //         @Override
            //         public void onLoginSuccess(String r, String stk, boolean stt) {
            //             statuLogin = stt;
            //             idUser = stk;
            //             role = r;
            //         }
            //         @Override
            //         public void onLoginFailure(String message) {
            //             System.out.println("Đăng nhập thất bại: " + message);
            //         }
            //     }, getIdUser(), getRole());
            //     update.ChangePassWord("Change Pass");
            //     Menu_Content.revalidate();
            //     Menu_Content.repaint();
            // });


            Wrapper.add(no0);
            Wrapper.add(no1);
            Wrapper.add(no2);
            Wrapper.add(no3);
            Wrapper.add(no4);
            Wrapper.add(no5);
            Wrapper.add(no6);
            Menu_Content.add(Wrapper, BorderLayout.CENTER);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item2Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            JPanel Center = new JPanel();
            Center.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.ORANGE));
            Center.setLayout(new FlowLayout(FlowLayout.LEFT));
            Center.setBackground(Color.PINK);
                try {
                    Connection connection = SQLSERVERHANDLE.getConnection();
                    String selectSql = "SELECT * FROM Customer";
                    PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            
                    ResultSet resultSet = preparedStatement.executeQuery();
                    Center.removeAll();
                    JPanel Jno2 = getPanel(
                        "CustomerID",
                        "Name",
                        "PassW",
                        "Email",
                        "Phone",
                        "Dofb",
                        "Balance",
                        50,90, 200, 80,0, 40
                    );
                    Center.add(Jno2);
                    if (resultSet.next()) {
                        do {
                            JPanel Jno1 = getPanel(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                50,90, 200, 80, 80, 40
                            );
                            String IDUsers = resultSet.getString(1);
                            Center.add(Jno1);
                            Center.revalidate();
                            Center.repaint();
                            JButton Bno3 = getInput3();
                            Bno3.addActionListener((ActionEvent g)->{
                                String IDUser = IDUsers;
                                int choice = JOptionPane.showConfirmDialog(Menu_Content, "Are you sure you want to delete this user?", "Confirm deletion", JOptionPane.YES_NO_OPTION);
                                if (choice == JOptionPane.YES_OPTION) {
                                    try {
                                        Connection connection2 = SQLSERVERHANDLE.getConnection();
                                        String DeleteSql = "DELETE FROM Customer WHERE CustomerID = ?";
                                        PreparedStatement preparedStatement2 = connection2.prepareStatement(DeleteSql);
                                        preparedStatement2.setString(1, IDUser);
                                
                                        int rowAffected = preparedStatement2.executeUpdate();
                                        Center.removeAll();
                                        if (rowAffected > 0) {
                                            JOptionPane.showMessageDialog(frame, "Delete success!!");
                                        }
                                        Center.revalidate();
                                        Center.repaint();
                                        actionPerformed(e);
                                    } catch (SQLException exi) {
                                        exi.printStackTrace(); // In ra thông báo lỗi chi tiết
                                    }
                                }
                            });
                        } while (resultSet.next());
                    }
                    Center.revalidate();
                    Center.repaint();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            // Menu_Content.add(Top, BorderLayout.NORTH);
            Menu_Content.add(Center, BorderLayout.CENTER);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item3Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            ArrayList<String> AIRID2 = new ArrayList<>();
            ArrayList<String> CITY2 = new ArrayList<>();
            AIRID2.clear();
            CITY2.clear();
            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                String sql = "SELECT * From AIRPORT";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                
                while(resultSet.next()) {
                    AIRID2.add(resultSet.getString(2));
                }

                Connection connection2 = SQLSERVERHANDLE.getConnection();
                String sql2 = "SELECT * From CITY";
                PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                
                
                while(resultSet2.next()) {
                    CITY2.add(resultSet2.getString(2));
                }
                
            } catch (Exception f) {
                // TODO: handle exception
            }
            String[] AIRID = AIRID2.toArray(String[]::new);
            String[] CITY = CITY2.toArray(String[]::new);

            JPanel Wrapper = new JPanel();
            Wrapper.setLayout(new FlowLayout());
            Wrapper.setPreferredSize(new Dimension(550, 0));
            Wrapper.setBackground(Color_4);

            JPanel no0 = getPanel("ADD FLIGHT PAGE", 600);
            JPanel no1 = getPanel("Flight Number", 250,180,30);
            JTextField Cno1 = getInput();
            JPanel no2 = getPanelPlace("Departure Place",AIRID,250,180,30);
            JComboBox Cno2 = getInput4();
            JPanel no3 = getPanelPlace("Arrival Place", CITY,250,180,30);
            JComboBox Cno3 = getInput4();
            JPanel no4 = getPanelTime2("Departure Time",250,180,30);
            JSpinner Cno4 = getInput2();
            JPanel no5 = getPanelTime2("Arrival Time",250,180,30);
            JSpinner Cno5 = getInput2();
            JPanel no6 = getPanel("Default Price",250,180,30);
            JTextField Cno6 = getInput();
            JButton addBtn = getButton("Add Flight",350, 40);
            Wrapper.add(no0);
            Wrapper.add(no1);
            Wrapper.add(no2);
            Wrapper.add(no3);
            Wrapper.add(no4);
            Wrapper.add(no5);
            Wrapper.add(no6);
            Wrapper.add(addBtn);

            addBtn.addActionListener((ActionEvent f)->{
                FLIGHT flight = new FLIGHT();
                String A = null;
                try {
                    Connection connection = SQLSERVERHANDLE.getConnection();
                    String sql = "SELECT * From AIRPORT Where AirportName = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, (String) Cno2.getSelectedItem());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    
                    if(resultSet.next()) {
                        flight.setAirportID(resultSet.getString(1));
                        A = resultSet.getString(3);
                    }

                    Connection connection2 = SQLSERVERHANDLE.getConnection();
                    String sql2 = "SELECT * From CITY Where nameCiTy = ?";
                    PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
                    preparedStatement2.setString(1, (String) Cno3.getSelectedItem());
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    
                    if(resultSet2.next()) {
                        flight.setCityID(resultSet2.getString(1));
                    }
                    connection.close();
                } catch (SQLException fx) {
                    // TODO: handle exception
                } 
                
                flight.setFlightNumber(Cno1.getText());
                Date selectedDateD = (Date) Cno4.getValue();
                Date selectedDateR = (Date) Cno5.getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                flight.setDepartureTime(dateFormat.format(selectedDateD));
                flight.setArrivalTime(dateFormat.format(selectedDateR));
                flight.setDefaultPrice(Cno6.getText());

                if (flight.getCityID().equals(A)) {
                    JOptionPane.showMessageDialog(frame, "Take-off and landing locations cannot be the same.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if (flight.getFlightNumber().length() > 5) {
                        JOptionPane.showMessageDialog(frame, "Flight number enter 5 character only!!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (Cno1.getText().isEmpty() || dateFormat.format(selectedDateD).isEmpty() || 
                        dateFormat.format(selectedDateR).isEmpty() || Cno6.getText().isEmpty() ||
                        flight.getAirportID().isEmpty() || flight.getCityID().isEmpty()) {
                            JOptionPane.showMessageDialog(frame, "Please fill in all information!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            try 
                            {
                                Connection connection5 = SQLSERVERHANDLE.getConnection();
                                // Khai báo thủ tục với tham số đầu ra
                                String procSql = "{CALL pr_TaoDongMoi(?, ?)}";
                                CallableStatement callableStatement = connection5.prepareCall(procSql);
                                callableStatement.setString(1, "FLIGHT");
                                callableStatement.registerOutParameter(2, Types.VARCHAR);
                                callableStatement.execute();
                                String newID = callableStatement.getString(2);
                                String updateSql = "UPDATE FLIGHT "+
                                                "SET FlightNumber = ?, AirportID = ?,"+
                                                " CityID = ?, DepartureTime = ?,"+
                                                "ArrivalTime = ?, DefaultPrice = ?"+
                                                " WHERE FlightID = ?";
                                PreparedStatement preparedStatement5 = connection5.prepareStatement(updateSql);
                                preparedStatement5.setString(1, flight.getFlightNumber());
                                preparedStatement5.setString(2, flight.getAirportID());
                                preparedStatement5.setString(3, flight.getCityID());
                                preparedStatement5.setString(4, flight.getDepartureTime());
                                preparedStatement5.setString(5, flight.getArrivalTime());
                                preparedStatement5.setString(6, flight.getDefaultPrice());
                                preparedStatement5.setString(7, newID);
    
                                int rowAffected = preparedStatement5.executeUpdate();
                                if (rowAffected > 0) {
                                    JOptionPane.showMessageDialog(frame, "Add Flight successful.");
                                }
                            } catch (HeadlessException | SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }

                }
            });
            Menu_Content.add(Wrapper, BorderLayout.CENTER);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item4Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            JPanel Center = new JPanel();
            Center.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.ORANGE));
            Center.setLayout(new FlowLayout(FlowLayout.LEFT));
            Center.setBackground(Color.PINK);
            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                String selectSql = "SELECT * FROM FLIGHT";
                PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        
                ResultSet resultSet = preparedStatement.executeQuery();
                Center.removeAll();
                JPanel Jno2 = getPanel22(
                            "FlightID",
                            "FlightNumber",
                            "AirportID",
                            "CityID",
                            "Departure Time",
                            "Arrival Time",
                            "Default Price",
                            60,150, 0, 100, 40
                        );
                Center.add(Jno2, FlowLayout.LEFT);
                if (resultSet.next()) {
                    do {
                        JPanel Jno1 = getPanel22(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            60,150, 80, 100, 40
                        );
                        String IDUsers = resultSet.getString(1);
                        Center.add(Jno1);
                        Center.revalidate();
                        Center.repaint();
                        JButton Bno3 = getInput3();
                        Bno3.addActionListener((ActionEvent g)->{
                            String IDUser = IDUsers;
                            int choice = JOptionPane.showConfirmDialog(Menu_Content, "Are you sure you want to delete this Flight?", "Confirm deletion", JOptionPane.YES_NO_OPTION);
                            if (choice == JOptionPane.YES_OPTION) {
                                try {
                                    Connection connection2 = SQLSERVERHANDLE.getConnection();
                                    String DeleteSql = "DELETE FROM FLIGHT WHERE FlightID = ?";
                                    PreparedStatement preparedStatement2 = connection2.prepareStatement(DeleteSql);
                                    preparedStatement2.setString(1, IDUser);
                            
                                    int rowAffected = preparedStatement2.executeUpdate();
                                    Center.removeAll();
                                    if (rowAffected > 0) {
                                        JOptionPane.showMessageDialog(frame, "Delete success!!");
                                    }
                                    Center.revalidate();
                                    Center.repaint();
                                    actionPerformed(e);
                                } catch (SQLException exi) {
                                    // exi.printStackTrace(); // In ra thông báo lỗi chi tiết
                                }
                            }
                        });
                    } while (resultSet.next());
                }
                Center.revalidate();
                Center.repaint();
            } catch (SQLException ex) {
                // ex.printStackTrace();
            }

            // Menu_Content.add(Top, BorderLayout.NORTH);
            Menu_Content.add(Center, BorderLayout.CENTER);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item5Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());
            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item6Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());
            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }
    
    private class item7Action implements ActionListener{
        @Override
        @SuppressWarnings("CallToPrintStackTrace")
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            ArrayList<String> CITY2 = new ArrayList<>();
            try {
                Connection connection2 = SQLSERVERHANDLE.getConnection();
                String sql2 = "SELECT * From CITY";
                PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
                ResultSet resultSet2 = preparedStatement2.executeQuery();
                
                while(resultSet2.next()) {
                    CITY2.add(resultSet2.getString(2));
                }
            } catch (SQLException f) {
                // TODO: handle exception
            }
            String[] CITY = CITY2.toArray(String[]::new);

            JPanel Wrapper = new JPanel();
            Wrapper.setLayout(new FlowLayout());
            Wrapper.setPreferredSize(new Dimension(550, 0));
            Wrapper.setBackground(Color_4);

            JPanel no0 = getPanel("ADD AIRPORT PAGE", 600);
            JPanel no1 = getPanel("Airport name", 200,350,50);
            no1.setFont(TimesNewRoman_30);
            JTextField Cno1 = getInput();
            Cno1.setFont(TimesNewRoman_30);
            JPanel no3 = getPanelPlace("City", CITY,200,350,50);
            no3.setFont(TimesNewRoman_30);
            JComboBox Cno3 = getInput4();
            Cno3.setFont(TimesNewRoman_30);
            JButton addBtn = getButton("Add Airport",350, 50);
            addBtn.setFont(TimesNewRoman_30);
            Wrapper.add(no0);
            Wrapper.add(no1);
            Wrapper.add(no3);
            Wrapper.add(addBtn);

            addBtn.addActionListener((ActionEvent f)->{
                AIRPORT Aiport = new AIRPORT();
                String A = null;
                String B = null;
                try {
                    Connection connection = SQLSERVERHANDLE.getConnection();
                    String sql = "SELECT AirportName From AIRPORT Where AirportName = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, (String) Cno1.getText());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()) {
                        A = resultSet.getString(1);
                    }

                    Connection connection2 = SQLSERVERHANDLE.getConnection();
                    String sql2 = "SELECT * From CITY Where nameCiTy = ?";
                    PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
                    preparedStatement2.setString(1, (String) Cno3.getSelectedItem());
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    
                    if(resultSet2.next()) {
                        Aiport.setCityID(resultSet2.getString(1));
                        B = resultSet2.getString(1);
                    }
                } catch (SQLException fx) {
                    fx.printStackTrace();
                }
                Aiport.setAirportName(Cno1.getText());

                if (Cno1.getText().isEmpty() || B.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all information", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    if (Aiport.getAirportName().equals(A)) {
                        JOptionPane.showMessageDialog(frame, Aiport.getAirportName() + " already exists", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        try {
                            Connection connection = SQLSERVERHANDLE.getConnection();
    
                            String procSql = "{CALL pr_TaoDongMoi(?, ?)}";
                            CallableStatement callableStatement = connection.prepareCall(procSql);
                            callableStatement.setString(1, "AIRPORT");
                            callableStatement.registerOutParameter(2, Types.VARCHAR);
                            callableStatement.execute();
                            String newID = callableStatement.getString(2);
                            String updateSql = "UPDATE AIRPORT "+
                                            "Set AirportName = ?,"+
                                            " CityID = ? "+
                                            " WHERE AirportID = ?";
                            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
                            preparedStatement.setString(1, Aiport.getAirportName());
                            preparedStatement.setString(2, B);
                            preparedStatement.setString(3, newID);
    
                            int rowAffected = preparedStatement.executeUpdate();
                            if (rowAffected > 0) {
                                JOptionPane.showMessageDialog(frame, "Add Airport successful.");
                            }
                        } catch (HeadlessException | SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                    
                }
                

            });

            Menu_Content.add(Wrapper, BorderLayout.CENTER);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item8Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            JPanel Center = new JPanel();
            Center.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.ORANGE));
            Center.setLayout(new FlowLayout(FlowLayout.LEFT));
            Center.setBackground(Color.PINK);
            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                String selectSql = "SELECT * FROM AIRPORT";
                PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        
                ResultSet resultSet = preparedStatement.executeQuery();
                Center.removeAll();
                JPanel Jno2 = getPanel(
                            "AirportID",
                            "Aiport Name",
                            "CityID",
                            150,350,150,0, 50
                        );
                Center.add(Jno2);
                if (resultSet.next()) {
                    do {
                        JPanel Jno1 = getPanel(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            150,350,150,100, 50
                        );
                        String IDUsers = resultSet.getString(1);
                        Center.add(Jno1);
                        Center.revalidate();
                        Center.repaint();
                        JButton Bno3 = getInput3();
                        Bno3.addActionListener((ActionEvent g)->{
                            String IDUser = IDUsers;
                            int choice = JOptionPane.showConfirmDialog(Menu_Content, "Are you sure you want to delete this Flight?", "Confirm deletion", JOptionPane.YES_NO_OPTION);
                            if (choice == JOptionPane.YES_OPTION) {
                                try {
                                    Connection connection2 = SQLSERVERHANDLE.getConnection();
                                    String DeleteSql = "DELETE FROM AIRPORT WHERE AirportID = ?";
                                    PreparedStatement preparedStatement2 = connection2.prepareStatement(DeleteSql);
                                    preparedStatement2.setString(1, IDUser);
                            
                                    int rowAffected = preparedStatement2.executeUpdate();
                                    Center.removeAll();
                                    if (rowAffected > 0) {
                                        JOptionPane.showMessageDialog(frame, "Delete success!!");
                                    }
                                    Center.revalidate();
                                    Center.repaint();
                                    actionPerformed(e);
                                } catch (SQLException exi) {
                                    // exi.printStackTrace(); // In ra thông báo lỗi chi tiết
                                }
                            }
                        });
                    } while (resultSet.next());
                }
                Center.revalidate();
                Center.repaint();
            } catch (SQLException ex) {
                // ex.printStackTrace();
            }

            // Menu_Content.add(Top, BorderLayout.NORTH);
            Menu_Content.add(Center, BorderLayout.CENTER);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

private class item9Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            JPanel Bottom  = new JPanel();
            Bottom.setLayout(new FlowLayout(FlowLayout.LEFT));
            Bottom.setBackground(Color.GREEN);
            
            FLIGHT flight = new FLIGHT();
            ACCOUNT account = new ACCOUNT();
            DateTimeFormatter FormTT = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            ArrayList<String[]> DataList = new ArrayList<>();
            try {
                Connection connection1 = SQLSERVERHANDLE.getConnection();

                String selectSQL =  " Select T.TicketID, C.NameCust, F.FlightNumber, T.TypeTicket, "+
                                    " SC.nameSeatClass, (ST.nameSeatType + N.numberSeat), "+
                                    " T.BookingDate, F.DepartureTime, AR.AirportName, "+ 
                                    " (Select AirportName from AIRPORT Where AIRPORT.CityID = F.CityID), T.Price "+
                                    " From TICKET T, FLIGHT F, AIRPORT AR, "+ 
                                    " CUSTOMER C, SEATTYPE ST, SEATNUMBER N, SEATCLASS SC "+
                                    " Where T.FlightID = F.FlightID "+ 
                                    " AND T.CustomerID = C.CustomerID "+ 
                                    " AND F.AirportID = AR.AirportID "+ 
                                    " AND N.idSeatType = ST.idSeatType "+ 
                                    " AND ST.idSeatClass = SC.idSeatClass "+ 
                                    " AND T.idSeat = N.idSeat ";
                            
                PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSQL);
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                String[] headers = {"FlightID",
                                    "Tên khách hàng",
                                    "Số chuyến bay",
                                    "Loại vé",
                                    "Hạng vé",
                                    "Số ghế",
                                    "ngày đặt vé",
                                    "ngày bay",
                                    "Điểm xuất phát",
                                    "Điểm đến",
                                    "Giá vé"};
                while (resultSet1.next()) {
                    String[] content =  {resultSet1.getString(1),
                                        resultSet1.getString(2),
                                        resultSet1.getString(3),
                                        resultSet1.getString(4),
                                        resultSet1.getString(5),
                                        resultSet1.getString(6),
                                        resultSet1.getString(7),
                                        resultSet1.getString(8),
                                        resultSet1.getString(9),
                                        resultSet1.getString(10),
                                        resultSet1.getString(11)};
                    DataList.add(content);
                }
                JPanel list = getTablePanel(headers, DataList);
                Bottom.add(list);
                Bottom.revalidate();
                Bottom.repaint();

            } catch (Exception eii) {
                eii.printStackTrace();
            }

            JPanel Top = new JPanel();
            Top.setLayout(new FlowLayout());
            Top.setPreferredSize(new Dimension(960, 60));
            Top.setBackground(Color.ORANGE);
    
            JLabel Text = new JLabel("Mời bạn nhập vào ID vé máy bay muốn hủy");
            Text.setPreferredSize(new Dimension(250, 30));

            JTextField deleteField = new JTextField();
            deleteField.setPreferredSize(new Dimension(170, 30));

            JButton deleteButton = new JButton("Hủy vé");
            deleteButton.setPreferredSize(new Dimension(100, 30));

            JLabel Text2 = new JLabel("Nhập OTP xác nhận ");
            Text2.setPreferredSize(new Dimension(120, 30));
            JTextField otpField = new JTextField();
            otpField.setPreferredSize(new Dimension(100, 30));
            JButton otpButton = new JButton("Xác nhận");
            otpButton.setPreferredSize(new Dimension(100, 30));
            Text2.setVisible(false);
            otpField.setVisible(false);
            otpButton.setVisible(false);

            // Thêm hành động cho nút hủy vé
            deleteButton.addActionListener((ActionEvent g) -> {
                String searchText = deleteField.getText();
                if (searchText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Vui lòng nhập vào ID vé cần xóa","ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean exists = false;
                    for (String[] row : DataList) {
                        if (row.length > 0 && row[0].equals(searchText)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        try {
                            Connection connection = SQLSERVERHANDLE.getConnection();
                            String selectSql = "Select AdminID, Email, A_Password From ADMIN WHERE AdminID = ?";
                            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                            preparedStatement.setString(1, getIdUser());
        
                            ResultSet resultSet = preparedStatement.executeQuery();
        
                            if (resultSet.next()) {
                                String AA = resultSet.getString(2);
                                if (canSendOTP) {
                                    String random = account.phuongthucngaunhien(4);
                                    try {
                                        new GMailer().sendMain(random, AA);
                                    } catch (Exception f) {
                                        f.printStackTrace();
                                    }
                                    JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                    setOTP(random);
                                    canSendOTP = false;
                                    startTimer(deleteButton); // Bắt đầu bộ đếm thời gian
                                } else {
                                    JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                                }
                            }
                        } catch (Exception f) {
                            f.printStackTrace();
                        }
                        Text2.setVisible(true);
                        otpField.setVisible(true);
                        otpButton.setVisible(true);
        
                        otpButton.addActionListener((ActionEvent f) ->{
                            try {
                                Connection connection = SQLSERVERHANDLE.getConnection();
                                String deleteSql = "Delete TICKET WHERE TicketID = ?";
                                PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
                                preparedStatement.setString(1, searchText);
        
                                int rowAffected = preparedStatement.executeUpdate();
                                if (rowAffected > 0) {
                                    JOptionPane.showMessageDialog(frame, "Delete success. !");
                                }
                            } catch (Exception eo) {
                                // TODO: handle exception
                            }
                            actionPerformed(e);
                        });
                    } else {
                        JOptionPane.showMessageDialog(frame, "ID nhập vào sai !!","ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                }

                System.out.println("Huy thanh cong " + searchText);
            });
    
            // Thêm các thành phần vào JPanel
            Top.add(Text);
            Top.add(deleteField);
            Top.add(deleteButton);
            Top.add(Text2);
            Top.add(otpField);
            Top.add(otpButton);
            

            Menu_Content.add(Top, BorderLayout.NORTH);
            Menu_Content.add(Bottom, BorderLayout.CENTER);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    public JPanel getTablePanel(String[] headers, ArrayList<String[]> dataList) {

        // Chuyển đổi ArrayList<String[]> thành String[][]
        String[][] data = new String[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }

        DefaultTableModel model = new DefaultTableModel(data, headers) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép chỉnh sửa ô
            }
        };

        JTable table = new JTable(model);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        table.setRowHeight(30);

        // Tự động điều chỉnh kích thước cột
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            int width = 0;
            for (int j = 0; j < table.getRowCount(); j++) {
                TableCellRenderer renderer = table.getCellRenderer(j, i);
                Component comp = table.prepareRenderer(renderer, j, i);
                width = Math.max(width, comp.getPreferredSize().width);
            }
            // Cộng thêm một khoảng trống cho thẩm mỹ
            table.getColumnModel().getColumn(i).setPreferredWidth(width + 10);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(770, 730));

        // Tạo JPanel chính
        JPanel group = new JPanel();
        group.setLayout(new BorderLayout());
        group.setBackground(Color_3);
        
        // Thêm bảng vào JPanel
        group.add(scrollPane, BorderLayout.CENTER);

        return group;
    }

    private class item10Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int choice = JOptionPane.showConfirmDialog(Menu_Content, "Are you sure you want to exit?", "Confirm Exit!!", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                frame.dispose();
                DASHBOARD dashboard = new DASHBOARD(callback);
                dashboard.resetUserState();
                SwingUtilities.invokeLater(() -> {
                    dashboard.setVisible(true);
                });
            }
        }
    }

    public JButton getButton(String B, int width, int height){
        JButton A = new JButton(B);
        A.setPreferredSize(new Dimension(width, height));
        A.setHorizontalAlignment(SwingConstants.CENTER);
        A.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        A.setOpaque(false);
        A.setFont(TimesNewRoman_20);
        return A;
    }

    public JLabel getLabel(String AA, int width, int height){
        JLabel A = new JLabel(AA);
        A.setPreferredSize(new Dimension(width, height));
        A.setHorizontalAlignment(SwingConstants.CENTER);
        A.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        // A.setOpaque(false);
        A.setFont(TimesNewRoman_20);
        return A;
    }

    public JTextField getTextField(int width, int height){
        JTextField A = new JTextField();
        A.setPreferredSize(new Dimension(width, height));
        A.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        // A.setOpaque(false);
        A.setFont(TimesNewRoman_20);
        return A;
    }

    public JPanel getPanel(String A, String B, String D, int width1, int width2, int width3, int width4, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width1, height));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(TimesNewRoman_30);

        JLabel label2 = new JLabel(B);
        label2.setPreferredSize(new Dimension(width2, height));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(TimesNewRoman_30);

        JLabel label4 = new JLabel(D);
        label4.setPreferredSize(new Dimension(width3, height));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(TimesNewRoman_30);

        JButton Bno8 = getButton("Delete", width4, height);
        Bno8.setFont(TimesNewRoman_20);
        setInput3(Bno8);
    
        Group.add(label1);
        Group.add(label2);
        Group.add(label4);
        Group.add(Bno8);
        return Group;
    }

    public JPanel getPanel(String A, String B, String C, String D, String E, String F, String G,
                    int width1, int width2, int width3, int width4, int width5, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width1, height));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(TimesNewRoman_15);

        JLabel label2 = new JLabel(B);
        label2.setPreferredSize(new Dimension(width2, height));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(TimesNewRoman_15);

        JLabel label3 = new JLabel(C);
        label3.setPreferredSize(new Dimension(width2, height));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(TimesNewRoman_15);

        JLabel label4 = new JLabel(D);
        label4.setPreferredSize(new Dimension(width3, height));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(TimesNewRoman_15);

        JLabel label5 = new JLabel(E);
        label5.setPreferredSize(new Dimension(width4, height));
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setFont(TimesNewRoman_15);

        JLabel label6 = new JLabel(F);
        label6.setPreferredSize(new Dimension(width4, height));
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setFont(TimesNewRoman_15);

        JLabel label7 = new JLabel(G);
        label7.setPreferredSize(new Dimension(width1, height));
        label7.setHorizontalAlignment(SwingConstants.CENTER);
        label7.setFont(TimesNewRoman_15);

        JButton Bno8 = getButton("Delete", width5, height);
        Bno8.setFont(TimesNewRoman_20);
        setInput3(Bno8);
    
        Group.add(label1);
        Group.add(label2);
        Group.add(label3);
        Group.add(label4);
        Group.add(label5);
        Group.add(label6);
        Group.add(label7);
        Group.add(Bno8);
        return Group;
    }

    public JPanel getPanel22(String A, String B, String C, String D, String E, String F, String G,
                    int width1, int width2,int width3, int width4, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width1, height));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(TimesNewRoman_15);

        JLabel label2 = new JLabel(B);
        label2.setPreferredSize(new Dimension(width1, height));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(TimesNewRoman_15);

        JLabel label3 = new JLabel(C);
        label3.setPreferredSize(new Dimension(width1, height));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(TimesNewRoman_15);

        JLabel label4 = new JLabel(D);
        label4.setPreferredSize(new Dimension(width1, height));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(TimesNewRoman_15);

        JLabel label5 = new JLabel(E);
        label5.setPreferredSize(new Dimension(width2, height));
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setFont(TimesNewRoman_15);

        JLabel label6 = new JLabel(F);
        label6.setPreferredSize(new Dimension(width2, height));
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setFont(TimesNewRoman_15);

        JLabel label7 = new JLabel(G);
        label7.setPreferredSize(new Dimension(width4, height));
        label7.setHorizontalAlignment(SwingConstants.CENTER);
        label7.setFont(TimesNewRoman_15);

        JButton Bno8 = getButton("Delete", width3, height);
        Bno8.setFont(TimesNewRoman_10);
        setInput3(Bno8);
    
        Group.add(label1);
        Group.add(label2);
        Group.add(label3);
        Group.add(label4);
        Group.add(label5);
        Group.add(label6);
        Group.add(label7);
        Group.add(Bno8);
        return Group;
    }

    public JPanel getPanel(String A, int width) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width, 40));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(TimesNewRoman_30);
        label1.setForeground(Color.BLACK);
    
        Group.add(label1);
        return Group;
    }

    public JPanel getPanel(String A, int width1, int width2, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width1, height));
        label1.setFont(TimesNewRoman_20);
        label1.setForeground(Color.BLACK);
    
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
        Group.setBackground(Color_3);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width1, height));
        label1.setFont(TimesNewRoman_20);
        label1.setForeground(Color.BLACK);
        JComboBox<String> cityComboBox = new JComboBox<>(B);
        cityComboBox.setPreferredSize(new Dimension(width2, height));
        cityComboBox.setFont(TimesNewRoman_15);
        setInput4(cityComboBox);

        Group.add(label1);
        Group.add(cityComboBox); // Thay JTextField bằng JComboBox

        return Group;
    }

    public JPanel getPanelTime(String A, int width1,int width2, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel dateLabel = new JLabel(A);
        dateLabel.setPreferredSize(new Dimension(width1, height));
        dateLabel.setFont(TimesNewRoman_20);
        dateLabel.setForeground(Color.BLACK);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        JSpinner dateSpinner = new JSpinner(
                new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setValue(calendar.getTime());
        dateSpinner.setPreferredSize(new Dimension(width2, height));
        setInput2(dateSpinner);

        Group.add(dateLabel);
        Group.add(dateSpinner);

        return Group;
    }
    
    public JPanel getPanelTime2(String A, int width1,int width2, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel dateLabel = new JLabel(A);
        dateLabel.setPreferredSize(new Dimension(width1, height));
        dateLabel.setFont(TimesNewRoman_20);
        dateLabel.setForeground(Color.BLACK);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        JSpinner dateSpinner = new JSpinner(
                new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd HH:mm:ss");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setValue(calendar.getTime());
        dateSpinner.setPreferredSize(new Dimension(width2, height));
        setInput2(dateSpinner);

        Group.add(dateLabel);
        Group.add(dateSpinner);

        return Group;
    }


    public JPanel getPanel(String A, String B, int width1,int width2, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout(FlowLayout.LEFT));
        Group.setBackground(null);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width1, height));
        label1.setFont(TimesNewRoman_15);
        label1.setForeground(Color.BLACK);
    
        JLabel Tlabel1 = new JLabel(B);
        Tlabel1.setPreferredSize(new Dimension(width2, height));
        Tlabel1.setFont(TimesNewRoman_15);
        Tlabel1.setForeground(Color.BLACK);

        Group.add(label1);
        Group.add(Tlabel1);
    
        return Group;
    }

    public JPanel getPanel(String A, String B, String C, int width1,int width2, int width3, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout(FlowLayout.LEFT));
        Group.setBackground(null);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width1, height));
        label1.setFont(TimesNewRoman_15);
        label1.setForeground(Color.BLACK);
    
        JLabel Tlabel1 = new JLabel(B);
        Tlabel1.setPreferredSize(new Dimension(width2, height));
        Tlabel1.setFont(TimesNewRoman_15);
        Tlabel1.setForeground(Color.BLACK);

        JButton Btn = getButton(C, width3, 40);
        Btn.setPreferredSize(new Dimension(width3, height));
        setInput3(Btn);

        Group.add(label1);
        Group.add(Tlabel1);
        Group.add(Btn);
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
