package com.payment;

import com.dbconnection.dbconnection;
import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class paymentDAO {
    public boolean paymentMode(int order_id,int user_id, double paid_amount, String payment_method,String status){
        String sql="insert into payments(order_id,user_id,paid_amount,payment_method,status) values =(?,?,?,?,?)";

        try{
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,order_id);
            ps.setInt(2,user_id);
            ps.setDouble(3,paid_amount);
            ps.setString(4,payment_method);
            ps.setString(5,status);

            ps.executeUpdate();
            System.out.println("Payment Stored in database");

        } catch (SQLException e) {
            System.out.println("Error in payment");
            e.printStackTrace();
        }

        return false;
    }
}
