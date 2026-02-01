package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbconnection.dbconnection;

public class  loginDAO {
    public void register(String user_name, String password){
        String sql="insert into users (user_name,password) values  (?,?)";

        try{
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,user_name);
            ps.setString(2,password);
            ps.executeUpdate();

            System.out.println("User Register Successfull.");

        } catch (Exception e) {
            System.out.println("Error in register.");
            System.exit(0);
            e.printStackTrace();
        }
    }

    public boolean loginCheck(String  user_name, String password){
        String sql = "select user_id from users where user_name=? and password=? ";

        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,user_name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

            return rs.next();


        } catch (SQLException e) {
            System.out.println("Error in login.");
            System.exit(0);
        }
        return false;
    }
}
