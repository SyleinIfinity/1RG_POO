package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSERVERHANDLE {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QUANLYBANVE;encrypt=true;trustServerCertificate=true";
            String user = "khanh123";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connect Success!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error Connect");
        }
            return connection;
    }

    public static void insertData(String insertSql) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertSql);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error insert!!!");
        }
    }

    public static void updateData(String updateSql) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
            preparedStatement.executeUpdate(updateSql);
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteData(String deleteSql) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeUpdate(deleteSql);
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}