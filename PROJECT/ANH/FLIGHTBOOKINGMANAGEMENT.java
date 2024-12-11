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

    public static void main(String[] args) {
        // DASHBOARD dashboard = new DASHBOARD(null);
        // SwingUtilities.invokeLater(() -> {
        //     dashboard.setVisible(true);
        // });

        DASHBOARD_ADMIN sAdmin = new DASHBOARD_ADMIN(null,"A002","Admin");
        SwingUtilities.invokeLater(() -> {
            sAdmin.setVisible(true);
        });
        
        DASHBOARD_USERS sAdminn = new DASHBOARD_USERS(null, "C004", "Customer");
        SwingUtilities.invokeLater(() -> {
            sAdminn.setVisible(true);
        });
    }
}

/*
INSERT INTO SEATNUMBER (idSeat, numberSeat, idSeatType, StatusSeat)
VALUES
--ghế A
    ('SN01', 1, 'ST1', 'enable'),
    ('SN02', 2, 'ST1', 'enable'),
    ('SN03', 3, 'ST1', 'enable'),
    ('SN04', 4, 'ST1', 'enable'),
    ('SN05', 5, 'ST1', 'enable'),
    ('SN06', 6, 'ST1', 'enable'),
--ghế B
    ('SN07', 1, 'ST2', 'enable'),
    ('SN08', 2, 'ST2', 'enable'),
    ('SN09', 3, 'ST2', 'enable'),
    ('SN10', 4, 'ST2', 'enable'),
    ('SN11', 5, 'ST2', 'enable'),
    ('SN12', 6, 'ST2', 'enable'),
-- Ghế C
    ('SN13', 1, 'ST3', 'enable'),
    ('SN14', 2, 'ST3', 'enable'),
    ('SN15', 3, 'ST3', 'enable'),
    ('SN16', 4, 'ST3', 'enable'),
    ('SN17', 5, 'ST3', 'enable'),
    ('SN18', 6, 'ST3', 'enable'),

-- Ghế D
    ('SN19', 1, 'ST4', 'enable'),
    ('SN20', 2, 'ST4', 'enable'),
    ('SN21', 3, 'ST4', 'enable'),
    ('SN22', 4, 'ST4', 'enable'),
    ('SN23', 5, 'ST4', 'enable'),
    ('SN24', 6, 'ST4', 'enable'),
--Ghế E
    ('SN25', 1, 'ST5', 'enable'),
    ('SN26', 2, 'ST5', 'enable'),
    ('SN27', 3, 'ST5', 'enable'),
    ('SN28', 4, 'ST5', 'enable'),
    ('SN29', 5, 'ST5', 'enable'),
    ('SN30', 6, 'ST5', 'enable');
    */

