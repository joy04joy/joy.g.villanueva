package com.accenture.java.coding.assessment;

import java.io.*;
import java.security.MessageDigest;
import java.util.Scanner;

public class EncryptedLogin {

    private static Scanner x;
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        String chos, lol="3";

        while(true) {
            System.out.println("=========================================");
            System.out.println("Enter number of selected task:");
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");
            System.out.println("=========================================");
            System.out.print("Select Task: ");

            chos = input.next();

                if (chos.equals("1")) {
                EncryptedLogin.Register();
                } else if(chos.equals("2") ) {
                EncryptedLogin.Login();
                }

                if(lol.equalsIgnoreCase("3")) {
                    break;
                }
        }

    }

    private static void Login() throws FileNotFoundException {

        Scanner name = new Scanner(System.in);
        String Username, Password;
        StringBuilder sb = new StringBuilder();
        String go, gerl = "3";
        Scanner input = new Scanner(System.in);

        System.out.println("\n");
        System.out.println("=== Login ===");
        System.out.print("Enter Username: ");
        Username = name.next();
        System.out.print("Enter Password: ");
        Password = name.next();

        try {
            FileWriter fw = new FileWriter("C:\\Users\\result.csv",true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            System.out.print("Login successful\n");
            System.out.println("Username    : " + Username);
            System.out.println("Encrypted Password  : " + sb.toString());
            pw.flush();
            pw.close();
        } catch (Exception e) {}
            System.out.print("Invalid Credentials\n");


        while(true) {
            System.out.println("=========================================");
            System.out.println("Enter number of selected task:");
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");
            System.out.println("=========================================");
            System.out.print("Select Task: ");
            go = input.next();


            if(go.equals("2") ) {
                EncryptedLogin.Login();
            } else if(go.equals("1") ) {
                EncryptedLogin.Register();
            }

            if(gerl.equalsIgnoreCase("3")) {
                break;
            }

        }

    }

    private static void Register() throws FileNotFoundException {

        String filepath = "C:\\Users\\listOfAccounts";
        boolean found =false;
        Scanner input = new Scanner(System.in);
        String ngek, ngi = "3";
        Scanner name = new Scanner(System.in);
        String Username, Password;
        String algorithm = "SHA";

        System.out.println("\n");
        System.out.println("=== Register ===");
        System.out.print("Enter Username: ");
        Username = name.nextLine();

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                Username = x.next();

                if (Username.equals(Username)) {
                    found = true;
                }
            }
            if (found) {
                System.out.println("Sorry, username already taken.");
            }
        } catch (Exception e) {}

        System.out.print("Enter Password: ");
        Password = name.nextLine();

        byte[] plainText = Username.getBytes();

        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);

            md.reset();
            md.update(plainText);
            byte[] encodedPassword = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < encodedPassword.length; i++) {
                if ((encodedPassword[i] & 0xff) < 0x10) {
                    sb.append("0");
                }

                sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
            }

            System.out.println("New account successfully registered");
            System.out.println("Username    : " + Username);
            System.out.println("Encrypted   : " + sb.toString());

            try {
                FileWriter fw = new FileWriter("C:\\Users\\listOfAccounts.csv", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println(Username + "," + sb );
                pw.flush();
                pw.close();
            } catch (Exception e) {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        while(true) {
            System.out.println("=========================================");
            System.out.println("Enter number of selected task:");
            System.out.println("1 - Register");
            System.out.println("2 - Login");
            System.out.println("3 - Exit");
            System.out.println("=========================================");
            System.out.print("Select Task: ");
            ngek = input.next();


                if(ngek.equals("2") ) {
                EncryptedLogin.Login();
                } else if(ngek.equals("1") ) {
                EncryptedLogin.Register();
                }

            if(ngi.equalsIgnoreCase("3")) {
                break;
            }

        }
    }

}

