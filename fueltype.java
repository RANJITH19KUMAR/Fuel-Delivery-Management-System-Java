package com.fuels;

import com.order.orderDAO;

import java.util.Scanner;

public  class fueltype {

    public double showfuel(int user_id){
        Scanner sc = new Scanner(System.in);

        fuelDAO dao = new fuelDAO();
        orderDAO orders = new orderDAO();

        double price = 0,quantity = 0,amount =0;
       

        System.out.println("Select fuel name:");
        System.out.println("petrol");
        System.out.println("diesel");
        String fuel_name = sc.nextLine();


                System.out.println("Enter quantity: ");
                quantity = sc.nextDouble();

                price = dao.getFuelPrice(fuel_name);
                amount = price * quantity;

                int fuel_id = orderDAO.getFuelIdByName(fuel_name);

                System.out.println("You have selected " + fuel_name);
                System.out.println("Price per liter " + price);
                System.out.println("Total Amount " + amount);
                orders.placedOrder(user_id,fuel_id,quantity,amount);

                System.exit(0);


        return price;
    }


    public static void main(String[] args) {
    int user_id =1;
    fueltype f = new fueltype();
        f.showfuel(user_id);
    }

}
