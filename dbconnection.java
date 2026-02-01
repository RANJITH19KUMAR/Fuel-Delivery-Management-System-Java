package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection{
    private static final String url="jdbc:mysql://localhost:3306/fueldb";
    private static final String user="root";
    private static final String password="Ranjith03@#";

    public static Connection getConnection()  {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database Connection Failed!!");
            e.printStackTrace();
        }
        return con;
    }

    public static void main(String[] args) {
        System.out.println("Database connected");
    }
}