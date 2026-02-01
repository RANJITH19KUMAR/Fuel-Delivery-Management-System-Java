package com.order;

import com.dbconnection.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class orderDAO {
    public void placedOrder(int user_id, int fuel_id, double quantity, double amount){
        String sql = "insert into orders (user_id,fuel_id,quantity,amount) values(?,?,?,?)";
        try{
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con. prepareStatement(sql);
            ps.setInt(1,user_id);
            ps.setInt(2,fuel_id);
            ps.setDouble(3,quantity);
            ps.setDouble(4,amount);
            ps.executeUpdate();

            System.out.println("order successfull.");

        } catch (Exception e) {
            System.out.println("Error in order");
            e.printStackTrace();

        }
    }

    public static int getUserIdByName(String user_name) {

        String sql = "select user_id   from users where user_name=?";
        int user_id = 0;
        try {
            
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user_name);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user_id = rs.getInt("user_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user_id;
    }
    
    public static int getFuelIdByName(String fuel_name){
        String sql = "select fuel_id from fuel_type where fuel_name=?";
        int fuel_id =0;
        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,fuel_name);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                fuel_id = rs.getInt("fuel_id");
            }
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fuel_id;
    }
    public double getOrderAmount(int order_id){
        String sql="select amount from orders where order_id=?";
        double amount =0;
         
        try{
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,order_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                amount = rs.getDouble("amount");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return amount;
    }
}
