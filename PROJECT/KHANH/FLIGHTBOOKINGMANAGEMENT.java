package com.example;
// package com.example;

// import java.sql.Connection;
// import java.sql.ResultSet;
// import java.sql.Statement;
import java.util.Scanner;

import javax.swing.SwingUtilities;

// import com.example.DASHBOARD_USERS;

public class FLIGHTBOOKINGMANAGEMENT {
    // Mã màu chữ ANSI
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String GRAY = "\u001B[90m";

    // Mã màu nền ANSI
    public static final String BLACK_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String YELLOW_BG = "\u001B[43m";
    public static final String BLUE_BG = "\u001B[44m";
    public static final String MAGENTA_BG = "\u001B[45m";
    public static final String CYAN_BG = "\u001B[46m";
    public static final String WHITE_BG = "\u001B[47m";
    static Scanner sc = new Scanner(System.in);

    private static boolean statuLogin = false;
    private static String idUser;
    private static String role;

    public static void main(String[] args)
	{
        DASHBOARD dashboard = new DASHBOARD(null);
        SwingUtilities.invokeLater(() -> {
            dashboard.setVisible(true);
        });

        // DASHBOARD_ADMIN sAdmin = new DASHBOARD_ADMIN(null,"A002","Admin");
        // SwingUtilities.invokeLater(() -> {
        //     sAdmin.setVisible(true);
        // });
        
        // DASHBOARD_USERS sAdminn = new DASHBOARD_USERS(null, "C004", "Customer");
        // SwingUtilities.invokeLater(() -> {
        //     sAdminn.setVisible(true);
        // });
    }
}