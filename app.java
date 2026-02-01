package com.zoo;

import com.admin.admin;
import com.delivery.delivery;
import com.fuels.fueltype;
import com.login.loginAuth;
import com.payment.payment;
import com.user.users;

public class app {
    public static void main(String[] args) {
        int otp =0;

        loginAuth log = new loginAuth();
        String user_name = log.auth();

        if (user_name != null){
            users use = new users();
            use.showUser(user_name);
        }


        System.out.println("--------***---------");
        fueltype fuel = new fueltype();
        int user_id=0;
        int order_id = (int) fuel.showfuel(user_id);
        System.out.println("--------***---------");


        payment pay = new payment();
        boolean payDone = pay.paymentService(order_id,user_id);
        if (!payDone){
            System.out.println("Order cancelled due for payment failure.");
            System.exit(0);
        }

        delivery del = new delivery();
        del.showLocation();
        System.out.println("--------***---------");


        System.out.println("=== Admin Panel Check ===");
        admin a = new admin();
        a.adminMain();

        System.out.println("--------***---------");
        del.verifyOtp(otp);
        System.out.println("--------***---------");





    }
}
