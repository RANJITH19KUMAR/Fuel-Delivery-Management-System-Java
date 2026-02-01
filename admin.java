package com.admin;

import java.util.Scanner;


public class admin {
    public void adminMain() {
        Scanner sc = new Scanner(System.in);
        adminDAO dao = new adminDAO();

        System.out.println("Enter Admin Name: ");
        String admin_name = sc.nextLine();

        System.out.println("Enter Admin Password: ");
        String password = sc.nextLine();

        if (dao.adminLogin(admin_name, password)) {
            System.out.println("Login Succesfull..");

                System.out.println("------------This Admin Menu------------");
            System.out.println("If you want View Orders(1-Yes, 2-No): ");
                int choice = sc.nextInt();

               switch(choice){
                   case 1:
                       dao.viewOrders();
                       break;
                   case 2:
                       System.out.println("Admin logged out..");
                       System.exit(0);

                   default:
                       System.out.println("Invalid choice.");
               }
            }
        }

        static void main (String[]args){
            admin a = new admin();
            a.adminMain();
        }
    }
