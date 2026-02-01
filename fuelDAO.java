package com.fuels;

import com.dbconnection.dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class fuelDAO {
    public double getFuelPrice (String fuel_name) {
        double price = 0;
        String sql = "select price_per_liter from fuel_type where fuel_name=?";
        try {
            Connection con = dbconnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fuel_name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                price = rs.getDouble("price_per_liter");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error in FuelType.");
        }
        return price;
    }



}
