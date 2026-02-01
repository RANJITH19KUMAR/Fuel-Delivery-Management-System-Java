package com.admin;

import com.dbconnection.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminDAO {

    public boolean adminLogin(String admin_name, String password){
        String sql ="select * from admin where admin_name =? and password=?";

        try{
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,admin_name);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error in Adminlogin check");
        }
        return false;
    }
    public void viewOrders(){
        String sql="select o.order_id,u.user_id,u.user_name,f.fuel_name,o.quantity,o.amount,o.Time_Date  from orders o join fuel_type f on o.fuel_id = f.fuel_id join users u on o.user_id = u.user_id ORDER BY o.Time_Date asc";

        try{
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("--------Your Order Details---------");


            while (rs.next()){

                System.out.println("\nOrder ID: " +rs.getInt("order_id") +"|" +
                        "\nUser ID: " +rs.getInt("user_id")+ "|" +
                        "\nUserName: " +rs.getString("user_name")+ "|" +
                        "\nFuelName: " +rs.getString("fuel_name") + "|" +
                        "\nQuantity: " +rs.getDouble("quantity")+ "|" +
                        "\nAmount: " +rs.getDouble("amount") + "|"+
                        "\nTime-Date: " +rs.getTimestamp("Time_Date"));
            }


        } catch (SQLException e) {
            System.out.println("Error in View Order");
        }
    }
}
