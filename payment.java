package com.payment;

import com.order.orderDAO;

import java.util.Scanner;

public class payment {
    protected String cash;

    public boolean paymentService(int order_id, int user_id) {
        Scanner sc = new Scanner(System.in);
        orderDAO odao = new orderDAO();
        paymentDAO pdao = new paymentDAO();

         double paid_amount = odao.getOrderAmount(order_id);
        System.out.println("Total amount to pay " + paid_amount);
        System.out.println("Select payment method (upi/card/cash).");
        String payment_method = sc.nextLine().toLowerCase();

        if (payment_method.equals("upi") || payment_method.equals("card")) {
            System.out.println("Confirm payment " + paid_amount + "(yes/no):");
            String confirm = sc.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                pdao.paymentMode(order_id, user_id, paid_amount, payment_method, "success");
                System.out.println("Payment Successfull.");
                return true;
            } else {
                pdao.paymentMode(order_id, user_id, paid_amount, payment_method, "Failed");
                System.out.println("Payment failed.");
                return false;
            }
        } else if (payment_method.equals("cash")) {
            pdao.paymentMode(order_id, user_id, paid_amount, "Cash", "Pending");
            System.out.println("Cash on delivery selected");
            return true;
        } else {
            System.out.println("Invalid payment option");
            System.exit(0);
        }
        return false;
    }


}
