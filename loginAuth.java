package com.login;

import java.util.Scanner;

public class loginAuth {
    public String auth() {

        Scanner sc = new Scanner(System.in);
        loginDAO dao = new loginDAO();
        System.out.println("1.New user");
        System.out.println("2.Existing user.");
        int user = sc.nextInt();
        sc.nextLine();

if (user==1) {
    System.out.println("Enter New Username:");
    String user_name = sc.nextLine();


    System.out.println("Enter new password:");
    String password = sc.nextLine();
    dao.register(user_name, password);
    System.out.println("Please Login  now\n");
}
else {
    System.out.println("You Have Already Account.");
}

        System.out.println("Enter Username: ");
        String user_name = sc.nextLine();

        System.out.println("Enter Password:");
        String password = sc .nextLine();

       if (dao.loginCheck(user_name,password)){
           System.out.println("login Successful");
       }
       else {
           System.out.println("Login failed");
           System.exit(0);
       }
        return user_name;
    }

    public static void main(String[] args) {
        loginAuth log = new loginAuth();
        log.auth();
    }

    }

