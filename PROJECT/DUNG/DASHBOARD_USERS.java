package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
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

public class DASHBOARD_USERS {
    private JFrame frame;
    private ILOGINCALLBACK callback;
    private static boolean statuLogin = false;
    private static String idUser;
    private static String role;
    private JButton item_1_1;
    private JButton item_2;
    private JButton item_3;
    private JButton item_4;
    private JButton item_5;
    private JButton item_6;
    private JButton item_7;
    private JButton item_8;
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
    private final Font TimesNewRoman_30 = new Font("Times New Roman", Font.BOLD, 50);
    private final Font TimesNewRoman_20 = new Font("Times New Roman", Font.BOLD, 20);
    private final Font TimesNewRoman_15 = new Font("Times New Roman", Font.BOLD, 15);
    private final Font TimesNewRoman_10 = new Font("Times New Roman", Font.BOLD, 10);

    public static boolean isStatuLogin() {
        return statuLogin;
    }
    public static void setStatuLogin(boolean statuLogin) {
        DASHBOARD_USERS.statuLogin = statuLogin;
    }

    public static String getIdUser() {
        return idUser;
    }
    public static void setIdUser(String idUser) {
        DASHBOARD_USERS.idUser = idUser;
    }

    public static String getRole() {
        return role;
    }
    public static void setRole(String role) {
        DASHBOARD_USERS.role = role;
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

    public DASHBOARD_USERS(ILOGINCALLBACK callback, String IDUser, String Role){
        this.callback = callback;
        setIdUser(IDUser);
        setRole(Role);

        frame = new JFrame("Anderson Airline");
        frame.setIconImage(logoIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1000);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        item_1_1    = getButton(getRole(),190,40);
        item_2      = getButton("Dashboard",190,40);
        item_3      = getButton("Book tickets",190,40);
        item_4      = getButton("Ticket Information",190,40);
        item_5      = getButton("Deposit money", 190,40);
        item_6      = getButton("Withdraw money", 190,40);
        item_8      = getButton("Exit",190,40);

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

        item_1_1.addActionListener(new item11Action());
        item_2.addActionListener(new item2Action());
        item_3.addActionListener(new item3Action());
        item_4.addActionListener(new item4Action());
        item_5.addActionListener(new item5Action());
        item_6.addActionListener(new item6Action());
        item_8.addActionListener(new item8Action());

        Menu_Top.add(item_1_1);
        Menu_Left.add(item_2);
        Menu_Left.add(item_3);
        Menu_Left.add(item_4);
        Menu_Left.add(item_5);
        Menu_Left.add(item_6);
        Menu_Left.add(item_8);

        frame.add(Menu_Top, BorderLayout.NORTH);
        frame.add(Menu_Left, BorderLayout.WEST);
        frame.add(Menu_Content, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private class item11Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());
            JPanel Top = new JPanel();
            Top.setLayout(new FlowLayout(FlowLayout.LEFT));
            Top.setBackground(Color_4);
            System.out.println(getIdUser());
            System.out.println(getRole());
            
            ACCOUNT account = new ACCOUNT();

            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                String sql = "SELECT * From Customer Where CustomerID = ?";
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
                    account.setAccountBalance(resultSet.getString(7));
                }

            } catch (Exception f) {
                // TODO: handle exception
            }

            JPanel no0 = getPanel("Account information Page", 960);
            JPanel no1 = getPanel("ID user", account.getIdAccount(),200,300,50);
            JPanel no2 = getPanel("Name", account.getUsername(),"Change name",200,300,150,50);
            JButton Bno2 = getInput3();
            JPanel no3 = getPanel("Password", account.getPassword(),"Change PassW",200,300,150,50);
            JButton Bno3 = getInput3();
            JPanel no4 = getPanel("Email", account.getGmail(),"Change Email",200,300,150,50);
            JButton Bno4 = getInput3();
            JPanel no5 = getPanel("Phone number", account.getPhone(),200,300,50);
            JButton Bno5 = getInput3();
            JPanel no6 = getPanel("Date of birth", account.getDateOfBirth(),200,300,50);
            JPanel no7 = getPanel("Account Balance", account.getAccountBalance(),200,300,50);

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
            //     update.ChangeName("Change name");
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

            // Bno4.addActionListener((ActionEvent f)->{
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
            //     update.ChangeGmail("Change Gmail");
            //     actionPerformed(e);
            // });


            Top.add(no0);
            Top.add(no1);
            Top.add(no2);
            Top.add(no3);
            Top.add(no4);
            Top.add(no5);
            Top.add(no6);
            Top.add(no7);
            Menu_Content.add(Top, BorderLayout.CENTER);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item2Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            JPanel center = new JPanel();
            center.setLayout(new FlowLayout());
            center.setBackground(Color_4);

            Image scaledImage = logoIcon.getImage().getScaledInstance(960, 230, Image.SCALE_SMOOTH);
            ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);
            JLabel label1 = new JLabel(scaledLogoIcon);
            label1.setBounds(50,10,500,90);
            
            JLabel label2 = new JLabel("<html><pre>Tết Ất kỷ 2025<br>       BAY HẠNH PHÚC<br>                 TẾT YÊU THƯƠNG</pre></html>\"");
            label2.setBounds(10,110,560,100);
            label2.setFont(TimesNewRoman_30);
            label2.setForeground(Color_1);

            JLabel label3 = new JLabel();
            JLabel label4 = new JLabel();
            JLabel label5 = new JLabel();
            JLabel label6 = new JLabel();

            center.add(label1);
            center.add(label2);
            center.add(label3);
            center.add(label4);
            center.add(label5);
            center.add(label6);
            center.add(label6);

            Menu_Content.add(center);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
        
    }

    private class item3Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            JPanel Top = new JPanel();
            Top.setLayout(new FlowLayout());
            Top.setPreferredSize(new Dimension(550, 250));
            Top.setBackground(Color_4);

            JPanel Bottom  = new JPanel();
            Bottom.setLayout(new FlowLayout(FlowLayout.LEFT));
            Bottom.setBackground(Color.GREEN);

            ArrayList<String> AIRID2 = new ArrayList<>();
            ArrayList<String> CITY2 = new ArrayList<>();
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
            String[] cities = CITY2.toArray(String[]::new);

            
            
            JPanel no0 = getPanel("Booking Page", 960);
            JPanel no3 = getPanelPlace("Điểm đi", AIRID,150,250,50);
            JComboBox Cno3 = getInput4();
            JPanel no4 = getPanelPlace("Điểm đến", cities,150,250,50);
            JComboBox Cno4 = getInput4();
            JPanel no5 = getPanelTime("Từ ngày",150,250,50);
            JSpinner Cno5 = getInput2();
            JPanel no6 = getPanelTime("Đến ngày",150,250,50);
            JSpinner Cno6 = getInput2();
            JButton SearchBtn = getButton("Search",300, 40);

            Top.add(no0);
            Top.add(no3);
            Top.add(no5);
            Top.add(no4);
            Top.add(no6);
            Top.add(SearchBtn);

            SearchBtn.addActionListener((ActionEvent f) ->{
                Bottom.removeAll();

                FLIGHT flight = new FLIGHT();
                String A = null;
                try {
                    Connection connection = SQLSERVERHANDLE.getConnection();
                    String sql = "SELECT * From AIRPORT Where AirportName = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, (String) Cno3.getSelectedItem());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    
                    if(resultSet.next()) {
                        flight.setAirportID(resultSet.getString(1));
                        A = resultSet.getString(1);
                    }

                    Connection connection2 = SQLSERVERHANDLE.getConnection();
                    String sql2 = "SELECT * From CITY Where nameCiTy = ?";
                    PreparedStatement preparedStatement2 = connection2.prepareStatement(sql2);
                    preparedStatement2.setString(1, (String) Cno4.getSelectedItem());
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    
                    if(resultSet2.next()) {
                        flight.setCityID(resultSet2.getString(1));
                    }
                    connection.close();
                } catch (SQLException fx) {
                    fx.printStackTrace();
                } 
                System.out.println(flight.getAirportID());
                System.out.println(flight.getCityID());

                Date dateValue = (Date) Cno5.getValue();
                LocalDateTime Datego = dateValue.toInstant()
                                                .atZone(ZoneId.systemDefault())
                                                .toLocalDateTime();
                Date dateValues = (Date) Cno6.getValue();
                LocalDateTime Datecome = dateValues.toInstant()
                                                .atZone(ZoneId.systemDefault())
                                                .toLocalDateTime();
                DateTimeFormatter FormTT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                System.out.println(Datego);

                try {
                    Connection connection1 = SQLSERVERHANDLE.getConnection();

                    String selectSQL = "Select F.FlightID, F.FlightNumber, A.AirportName, C.nameCiTy, F.DepartureTime, F.ArrivalTime, F.DefaultPrice, F.available, F.Maximum " +
                                        "FROM FLIGHT F, AIRPORT A, CITY C " +
                                        "Where F.AirportID = A.AirportID "+ 
                                        "AND F.CityID = C.CityID " +
                                        "AND F.AirportID = '" + flight.getAirportID() + "' " +
                                        "AND C.CityID = '" + flight.getCityID() + "' " +
                                        "AND F.DepartureTime >= ? " +
                                        "AND F.ArrivalTime <= ? ";
                                
                    PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSQL);
                    preparedStatement1.setTimestamp(1, Timestamp.valueOf(Datego)); // Chuyển đổi LocalDateTime thành Timestamp
                    preparedStatement1.setTimestamp(2, Timestamp.valueOf(Datecome)); 
                    ResultSet resultSet1 = preparedStatement1.executeQuery();
                    JPanel headers = getPanelF("FlightID",
                                        "FlightNumber",
                                        "DeparturePoint",
                                        "ArrivalPoint",
                                        "DepartureDay",
                                        "ArrivalDay",
                                        "DefaultPrice",
                                        "available",
                                        "Maximum",
                                        "Action",
                                         90, 0, 40);
                    Bottom.add(headers);
                    while (resultSet1.next()) {
                        JPanel con = getPanelF(resultSet1.getString(1),
                                                resultSet1.getString(2),
                                                resultSet1.getString(3),
                                                resultSet1.getString(4),
                                                resultSet1.getString(5),
                                                resultSet1.getString(6),
                                                resultSet1.getString(7),
                                                resultSet1.getString(8),
                                                resultSet1.getString(9),
                                                "ACtion",
                                                90, 70, 40);
                        JButton Click = getInput3();
                        String AAA = resultSet1.getString(1);
                        String DateBook = resultSet1.getString(5);
                        Click.addActionListener((ActionEvent g) -> {
                            LocalDateTime ThoiGian = LocalDateTime.now(); // Ngày hiện tại
                            String today = ThoiGian.format(FormTT);
                            System.out.println(today + "---" + DateBook);
                            int kiemtraa = today.compareTo(DateBook);
                            System.out.println(kiemtraa);
                            // So sánh DateBook với ThoiGian
                            if (kiemtraa > 0) {
                                JOptionPane.showMessageDialog(frame, "Không thể đặt vé cho thời gian trong quá khứ. Vui lòng thử lại.", "ERROR", JOptionPane.ERROR_MESSAGE);
                            } else {
                                // Tiếp tục với quy trình đặt vé
                                UPDATEINFORMATION update = new UPDATEINFORMATION(new ILOGINCALLBACK() {
                                    @Override
                                    public void onLoginSuccess(String r, String stk, boolean stt) {
                                        statuLogin = stt;
                                        idUser = stk;
                                        role = r;
                                    }
                        
                                    @Override
                                    public void onLoginFailure(String message) {
                                        System.out.println("Đăng nhập thất bại: " + message);
                                    }
                                }, getIdUser(), getRole());
                                update.Choose(AAA, "BOOK");
                                Bottom.revalidate();
                                Bottom.repaint();
                            }
                        });
                        
                        Bottom.add(con);
                    }
                    Bottom.revalidate();
                    Bottom.repaint();

                } catch (Exception eii) {
                    eii.printStackTrace();
                }
            });

            Menu_Content.add(Top, BorderLayout.NORTH);
            Menu_Content.add(Bottom, BorderLayout.CENTER);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item4Action implements ActionListener{
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
                                    " AND T.idSeat = N.idSeat "+ 
                                    " AND T.CustomerID = ? ";
                            
                PreparedStatement preparedStatement1 = connection1.prepareStatement(selectSQL);
                preparedStatement1.setString(1, getIdUser());
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
                            String selectSql = "Select CustomerID, Email, C_Password From Customer WHERE CustomerID = ?";
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
        scrollPane.setPreferredSize(new Dimension(970, 880));

        // Tạo JPanel chính
        JPanel group = new JPanel();
        group.setLayout(new BorderLayout());
        group.setBackground(Color_3);
        
        // Thêm bảng vào JPanel
        group.add(scrollPane, BorderLayout.CENTER);

        return group;
    }

    private class item5Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            JPanel Wrapper = new JPanel();
            Wrapper.setLayout(new FlowLayout());
            Wrapper.setBackground(Color_4);

            ACCOUNT account = new ACCOUNT();

            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                String sql = "SELECT * From Customer Where CustomerID = ?";
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
                    account.setAccountBalance(resultSet.getString(7));
                }

            } catch (Exception f) {
                // TODO: handle exception
            }


            JPanel no0 = getPanel("DEPOSITE MONEY PAGE", 750);
            JPanel no1 = getPanel("ID User", account.getIdAccount(),300,250,30);
            JPanel no2 = getPanel("UserName", account.getUsername(),300,250,30);
            JPanel no3 = getPanel("Account balance", account.getAccountBalance(),300,250,30);
            JPanel no4 = getPanel("Nhập vào ID user", 300,250,30);
            JTextField Cno4 = getInput();
            JPanel no5 = getPanel("Nhập vào gmail", 300,250,30);
            JTextField Cno5 = getInput();
            JPanel no6 = getPanel("Nhập số tiền nạp", 300,250,30);
            JTextField Cno6 = getInput();
            JPanel no7 = getPanel("Nhập OTP xác nhận", 300,108,30);
            JTextField Cno7 = getInput();
            JButton Bno1 = getButton("Send", 140, 40);
            JButton Bno2 = getButton("DEPOSITE",450, 40);

            Bno1.addActionListener((ActionEvent f) ->{
                String Email = Cno5.getText();
                System.out.println(Email);
                try {
                    Connection connection = SQLSERVERHANDLE.getConnection();
                    String selectSql = "Select CustomerID, Email, C_Password From Customer WHERE Email = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                    preparedStatement.setString(1, Email);

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String mailer = resultSet.getString(2);
                        if (Email.equals(mailer)) {
                            if (canSendOTP) {
                                String random = account.phuongthucngaunhien(4);
                                try {
                                    new GMailer().sendMain(random, Email);
                                } catch (Exception i) {
                                    i.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                setOTP(random);
                                canSendOTP = false;
                                startTimer(Bno1); // Bắt đầu bộ đếm thời gian
                            } else {
                                JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect Email", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (Exception g) {
                    g.printStackTrace();
                }
            });

            Bno2.addActionListener((ActionEvent f) ->{
                String ID = Cno4.getText();
                String Email = Cno5.getText();
                String Money = Cno6.getText();
                String OTP = Cno7.getText();

                if (ID.equals(getIdUser()) && Email.equals(account.getGmail()) && OTP.equals(getOTP())) {
                    try {
                        Connection connection = SQLSERVERHANDLE.getConnection();
                        
                        String updateSql =  " UPDATE CUSTOMER " +
                                            " SET AccountBalance =AccountBalance + ? " +
                                            " Where CustomerID = ? ";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
                        preparedStatement.setString(1, Money);
                        preparedStatement.setString(2, ID);

                        int rowAffected = preparedStatement.executeUpdate();

                        if (rowAffected > 0) {
                            JOptionPane.showMessageDialog(frame, "Nạp tiền thành công. !!");
                        }

                    } catch (Exception g) {
                        // TODO: handle exception
                    }
                } else if (ID.isEmpty() || Email.isEmpty() || Money.isEmpty() || OTP.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Hãy điền đủ thông tin", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (!ID.equals(getIdUser())) {
                    JOptionPane.showMessageDialog(frame, "ID người dùng sai rồi kìa", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (!Email.equals(account.getGmail())) {
                    JOptionPane.showMessageDialog(frame, "Email nhập vào không đúng", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (!OTP.equals(getOTP())) {
                    JOptionPane.showMessageDialog(frame, "OTP sai rồi kìa", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (account.kiemTraLaSo(Cno6)) {
                    JOptionPane.showMessageDialog(frame, "Số tiền nhập vào không đúng định dạng số", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            });

            Wrapper.add(no0);
            Wrapper.add(no1);
            Wrapper.add(no2);
            Wrapper.add(no3);
            Wrapper.add(no4);
            Wrapper.add(no5);
            Wrapper.add(no6);
            Wrapper.add(no7);
            Wrapper.add(Bno1);
            Wrapper.add(Bno2);


            Menu_Content.add(Wrapper, BorderLayout.CENTER);
            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item6Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            JPanel Wrapper = new JPanel();
            Wrapper.setLayout(new FlowLayout());
            Wrapper.setBackground(Color_4);

            ACCOUNT account = new ACCOUNT();

            try {
                Connection connection = SQLSERVERHANDLE.getConnection();
                String sql = "SELECT * From Customer Where CustomerID = ?";
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
                    account.setAccountBalance(resultSet.getString(7));
                }

            } catch (Exception f) {
                // TODO: handle exception
            }


            JPanel no0 = getPanel("WITHDRAW MONEY PAGE", 750);
            JPanel no1 = getPanel("ID User", account.getIdAccount(),300,250,30);
            JPanel no2 = getPanel("UserName", account.getUsername(),300,250,30);
            JPanel no3 = getPanel("Account balance", account.getAccountBalance(),300,250,30);
            JPanel no4 = getPanel("Nhập vào ID user", 300,250,30);
            JTextField Cno4 = getInput();
            JPanel no5 = getPanel("Nhập vào gmail", 300,250,30);
            JTextField Cno5 = getInput();
            JPanel no6 = getPanel("Nhập số tiền rút", 300,250,30);
            JTextField Cno6 = getInput();
            JPanel no7 = getPanel("Nhập OTP xác nhận", 300,108,30);
            JTextField Cno7 = getInput();
            JButton Bno1 = getButton("Send", 140, 40);
            JButton Bno2 = getButton("WITHDRAW",450, 40);

            Bno1.addActionListener((ActionEvent f) ->{
                String Email = Cno5.getText();
                System.out.println(Email);
                try {
                    Connection connection = SQLSERVERHANDLE.getConnection();
                    String selectSql = "Select CustomerID, Email, C_Password From Customer WHERE Email = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
                    preparedStatement.setString(1, Email);

                    ResultSet resultSet = preparedStatement.executeQuery();
                    if (resultSet.next()) {
                        String mailer = resultSet.getString(2);
                        if (Email.equals(mailer)) {
                            if (canSendOTP) {
                                String random = account.phuongthucngaunhien(4);
                                try {
                                    new GMailer().sendMain(random, Email);
                                } catch (Exception i) {
                                    i.printStackTrace();
                                }
                                JOptionPane.showMessageDialog(frame, "OTP code has been sent to your gmail");
                                setOTP(random);
                                canSendOTP = false;
                                startTimer(Bno1); // Bắt đầu bộ đếm thời gian
                            } else {
                                JOptionPane.showMessageDialog(frame, "You can send OTP again after 30 seconds.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect Email", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } catch (Exception g) {
                    g.printStackTrace();
                }
            });

            Bno2.addActionListener((ActionEvent f) ->{
                String ID = Cno4.getText();
                String Email = Cno5.getText();
                String Money = Cno6.getText();
                String OTP = Cno7.getText();
                Double Money2 = Double.valueOf(Cno6.getText());
                Double AccountBalance = Double.valueOf(account.getAccountBalance());

                if (ID.equals(getIdUser()) && Email.equals(account.getGmail()) && OTP.equals(getOTP())) {
                    try {
                        Connection connection = SQLSERVERHANDLE.getConnection();
                        
                        String updateSql =  " UPDATE CUSTOMER " +
                                            " SET AccountBalance =AccountBalance - ? " +
                                            " Where CustomerID = ? ";
                        PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
                        preparedStatement.setString(1, Money);
                        preparedStatement.setString(2, ID);

                        int rowAffected = preparedStatement.executeUpdate();

                        if (rowAffected > 0) {
                            JOptionPane.showMessageDialog(frame, "Rút tiền thành công. !!");
                        }

                    } catch (Exception g) {
                        // TODO: handle exception
                    }
                } else if (ID.isEmpty() || Email.isEmpty() || Money.isEmpty() || OTP.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Hãy điền đủ thông tin", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (!ID.equals(getIdUser())) {
                    JOptionPane.showMessageDialog(frame, "ID người dùng sai rồi kìa", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (!Email.equals(account.getGmail())) {
                    JOptionPane.showMessageDialog(frame, "Email nhập vào không đúng", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (!OTP.equals(getOTP())) {
                    JOptionPane.showMessageDialog(frame, "OTP sai rồi kìa", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (account.kiemTraLaSo(Cno6)) {
                    JOptionPane.showMessageDialog(frame, "Số tiền nhập vào không đúng định dạng số", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (Money2 > AccountBalance) {
                    JOptionPane.showMessageDialog(frame, "Số tiền rút vượt quá số dư", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            });

            Wrapper.add(no0);
            Wrapper.add(no1);
            Wrapper.add(no2);
            Wrapper.add(no3);
            Wrapper.add(no4);
            Wrapper.add(no5);
            Wrapper.add(no6);
            Wrapper.add(no7);
            Wrapper.add(Bno1);
            Wrapper.add(Bno2);


            Menu_Content.add(Wrapper, BorderLayout.CENTER);
            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
    }

    private class item8Action implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            int choice = JOptionPane.showConfirmDialog(Menu_Content, "Bạn chắc chắn muốn Đăng Xuất?", "Xác nhận Đăng Xuất", JOptionPane.YES_NO_OPTION);
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

    public JPanel getPanel(String A, String B, String C, String D, String E, String F, String G, int width, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width, height));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(TimesNewRoman_10);

        JLabel label2 = new JLabel(B);
        label2.setPreferredSize(new Dimension(width, height));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(TimesNewRoman_10);

        JLabel label3 = new JLabel(C);
        label3.setPreferredSize(new Dimension(width, height));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(TimesNewRoman_10);

        JLabel label4 = new JLabel(D);
        label4.setPreferredSize(new Dimension(width, height));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(TimesNewRoman_10);

        JLabel label5 = new JLabel(E);
        label5.setPreferredSize(new Dimension(width, height));
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setFont(TimesNewRoman_10);

        JLabel label6 = new JLabel(F);
        label6.setPreferredSize(new Dimension(width, height));
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setFont(TimesNewRoman_10);

        JLabel label7 = new JLabel(G);
        label7.setPreferredSize(new Dimension(width, height));
        label7.setHorizontalAlignment(SwingConstants.CENTER);
        label7.setFont(TimesNewRoman_10);
    
        Group.add(label1);
        Group.add(label2);
        Group.add(label3);
        Group.add(label4);
        Group.add(label5);
        Group.add(label6);
        Group.add(label7);
        return Group;
    }

    public JPanel getPanelF(String A, String B, String C, String D, String E, String F, String G, String H, String I, String J, int width, int width2, int height) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width, height));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(TimesNewRoman_10);

        JLabel label2 = new JLabel(B);
        label2.setPreferredSize(new Dimension(width, height));
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setFont(TimesNewRoman_10);

        JLabel label3 = new JLabel(C);
        label3.setPreferredSize(new Dimension(width, height));
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setFont(TimesNewRoman_10);

        JLabel label4 = new JLabel(D);
        label4.setPreferredSize(new Dimension(width, height));
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setFont(TimesNewRoman_10);

        JLabel label5 = new JLabel(E);
        label5.setPreferredSize(new Dimension(width, height));
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        label5.setFont(TimesNewRoman_10);

        JLabel label6 = new JLabel(F);
        label6.setPreferredSize(new Dimension(width, height));
        label6.setHorizontalAlignment(SwingConstants.CENTER);
        label6.setFont(TimesNewRoman_10);

        JLabel label7 = new JLabel(G);
        label7.setPreferredSize(new Dimension(width, height));
        label7.setHorizontalAlignment(SwingConstants.CENTER);
        label7.setFont(TimesNewRoman_10);

        JLabel label8 = new JLabel(H);
        label8.setPreferredSize(new Dimension(width, height));
        label8.setHorizontalAlignment(SwingConstants.CENTER);
        label8.setFont(TimesNewRoman_10);

        JLabel label9 = new JLabel(I);
        label9.setPreferredSize(new Dimension(width, height));
        label9.setHorizontalAlignment(SwingConstants.CENTER);
        label9.setFont(TimesNewRoman_10);

        JButton label10 = new JButton(J);
        label10.setPreferredSize(new Dimension(width2, height));
        label10.setHorizontalAlignment(SwingConstants.CENTER);
        label10.setFont(TimesNewRoman_10);
        setInput3(label10);
    
        Group.add(label1);
        Group.add(label2);
        Group.add(label3);
        Group.add(label4);
        Group.add(label5);
        Group.add(label6);
        Group.add(label7);
        Group.add(label8);
        Group.add(label9);
        Group.add(label10);

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
        Group.add(cityComboBox);

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
        label1.setFont(TimesNewRoman_20);
        label1.setForeground(Color.BLACK);
    
        JLabel Tlabel1 = new JLabel(B);
        Tlabel1.setPreferredSize(new Dimension(width2, height));
        Tlabel1.setFont(TimesNewRoman_20);
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
