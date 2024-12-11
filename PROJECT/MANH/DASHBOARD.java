package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class DASHBOARD {
    private JFrame frame;
    private ILOGINCALLBACK callback;
    private static boolean statuLogin = false;
    private static String idUser;
    private static String role;
    private JButton item_1;
    private JButton item_2;
    private JPanel Menu_Top;
    private JPanel Menu_Left;
    private JPanel Menu_Content;

    private ImageIcon logoIcon = new ImageIcon("C:\\Users\\TUFadmin\\OneDrive - University of Technology and Education (1)\\Desktop\\demo\\src\\main\\resources\\Logo.png");
    private final Color Color_1 = new Color(255, 187, 0);
    private final Color Color_2 = new Color(89, 63, 222);
    private final Color Color_3 = new Color(33, 93, 63);
    private final Font TimesNewRoman_30 = new Font("Times New Roman", Font.BOLD, 30);
    private final Font TimesNewRoman_20 = new Font("Times New Roman", Font.BOLD, 20);
    private final Font TimesNewRoman_15 = new Font("Times New Roman", Font.BOLD, 15);

    public DASHBOARD(ILOGINCALLBACK callback){
        this.callback = callback;
        frame = new JFrame("Anderson Airline");
        frame.setIconImage(logoIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        item_1      = getButton("Sign in - Sign up",190);
        item_2      = getButton("Dashboard",190);

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
        item_2.addActionListener(new item2Action());

        Menu_Top.add(item_1);
        Menu_Left.add(item_2);

        frame.add(Menu_Top, BorderLayout.NORTH);
        frame.add(Menu_Left, BorderLayout.WEST);
        frame.add(Menu_Content, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private class item1Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            SETUP loginFrame = new SETUP(new ILOGINCALLBACK() {
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
            });

            SwingUtilities.invokeLater(() -> {
                loginFrame.setVisible(true);
            });

            // Sử dụng SwingWorker để chờ trạng thái đăng nhập
            SwingWorker<Void, Void> worker;
            worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() {
                    while (!statuLogin) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException f) {
                            f.printStackTrace();
                        }
                    }
                    return null;
                }
                @Override
                protected void done() {
                    JOptionPane.showMessageDialog(new JOptionPane(), "Đăng nhập thành công id" + role + ": " + idUser);
                    if (statuLogin && role.equals("Customer")) {
                        frame.dispose();
                        DASHBOARD_USERS dashboard = new DASHBOARD_USERS(new ILOGINCALLBACK() {
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
                        }, idUser, role);
                        System.out.println(statuLogin);
                        System.out.println(idUser);
                        SwingUtilities.invokeLater(() -> {
                            dashboard.setVisible(true);
                        });
                    } else {
                        frame.dispose();
                        DASHBOARD_ADMIN dashboard = new DASHBOARD_ADMIN(new ILOGINCALLBACK() {
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
                        }, idUser, role);
                        System.out.println(statuLogin);
                        System.out.println(idUser);
                        SwingUtilities.invokeLater(() -> {
                            dashboard.setVisible(true);
                        });
                    }
                }
            };

            worker.execute(); // Khởi động worker
        }
    }

    private class item2Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            Menu_Content.removeAll();
            Menu_Content.setLayout(new BorderLayout());

            Image scaledImage = logoIcon.getImage().getScaledInstance(500, 90, Image.SCALE_SMOOTH);
            ImageIcon scaledLogoIcon = new ImageIcon(scaledImage);
            JLabel label1 = new JLabel(scaledLogoIcon);
            label1.setBounds(30,10,500,90);
            
            JLabel label2 = new JLabel("<html><pre>Tết Ất kỷ 2025<br>       BAY HẠNH PHÚC<br>                 TẾT YÊU THƯƠNG</pre></html>\"");
            label2.setBounds(10,110,560,100);
            label2.setFont(TimesNewRoman_30);
            label2.setForeground(Color_1);

            Menu_Content.add(label1);
            Menu_Content.add(label2);

            Menu_Content.revalidate();
            Menu_Content.repaint();
        }
        
    }

    public JButton getButton(String B, int width){
        JButton A = new JButton(B);
        A.setPreferredSize(new Dimension(width, 40));
        A.setHorizontalAlignment(SwingConstants.CENTER);
        A.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
        A.setOpaque(false);
        A.setFont(TimesNewRoman_20);
        return A;
    }

    public JPanel getPanel(String A, int width) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(width, 40));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setFont(TimesNewRoman_30);
        label1.setForeground(Color.YELLOW);
    
        Group.add(label1);
        return Group;
    }
    
    public void resetUserState() {
        statuLogin = false;
        idUser = "";
        role = "";
    }

    public JPanel getPanel(String A) {
        JPanel Group = new JPanel();
        Group.setLayout(new FlowLayout());
        Group.setBackground(Color_3);

        JLabel label1 = new JLabel(A);
        label1.setPreferredSize(new Dimension(100, 30));
        label1.setFont(TimesNewRoman_20);
        label1.setForeground(Color.YELLOW);
    
        JTextField Tlabel1 = new JTextField();
        Tlabel1.setPreferredSize(new Dimension(160, 30));
    
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
        label1.setForeground(Color.YELLOW);
        JComboBox<String> cityComboBox = new JComboBox<>(B);
        cityComboBox.setPreferredSize(new Dimension(width2, height));
        cityComboBox.setFont(TimesNewRoman_15);

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
        dateLabel.setForeground(Color.YELLOW);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -18);
        JSpinner dateSpinner = new JSpinner(
                new SpinnerDateModel(calendar.getTime(), null, null, Calendar.DAY_OF_MONTH));
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setValue(calendar.getTime());
        dateSpinner.setPreferredSize(new Dimension(width2, height));

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

        JButton Btn = getButton(C, width3);
        Btn.setPreferredSize(new Dimension(width3, height));

        Group.add(label1);
        Group.add(Tlabel1);
        Group.add(Btn);
        return Group;
    }

    public void setVisible(boolean b) {
        frame.setVisible(b);
    }
}
