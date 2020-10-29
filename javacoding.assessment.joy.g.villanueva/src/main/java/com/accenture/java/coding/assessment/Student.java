package com.accenture.java.coding.assessment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Student {

    private static Scanner x;

    public static void main(String args[]) {

        int minute, hour;
        String EID;
        GregorianCalendar time = new GregorianCalendar();

        Scanner input = new Scanner(System.in);
        Scanner user_input = new Scanner(System.in);

        String filepath = "C:\\Users\\result.csv";
        boolean found =false;


            while (true) {
                    System.out.print("Enter EID to Time In: ");
                    EID = user_input.next();
                    System.out.print("\n");

                try {
                    x = new Scanner(new File(filepath));
                    x.useDelimiter("[,\n]");

                        while(x.hasNext() && !found)
                        {
                            EID = x.next();

                            if(EID.equals(EID))
                            {
                             found = true;
                            }
                        }
                        if (found)
                            {
                            System.out.println("EID Already Time in");
                            }

                            System.out.print("Do you want to add more? (y/n): ");
                            String c = input.nextLine();
                            System.out.print("\n");

                        if (c.equalsIgnoreCase("y")) {
                            System.out.print("Enter EID to Time In: ");
                            EID = user_input.next();
                            System.out.print("\n");
                        }

                            if (c.equalsIgnoreCase("n")) {
                                System.out.print("Attendance list saved to result.csv");
                                break;
                            }


                } catch (Exception e) {}

                    System.out.print("Time in successful. EID Added.\n");
                    System.out.print("EID: " + EID);

                    minute = time.get(Calendar.MINUTE);
                    hour = time.get(Calendar.HOUR);
                    System.out.print("\n");

                    System.out.println("Time in: " + hour + " : " + minute);
                    System.out.print("\n");

                    System.out.print("Do you want to add more? (y/n): ");
                    String c = input.nextLine();
                    System.out.print("\n");

                        try {
                            FileWriter fw = new FileWriter("C:\\Users\\result.csv",true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter pw = new PrintWriter(bw);

                            pw.println(EID + "," + hour + ":" + minute);
                            pw.flush();
                            pw.close();
                        } catch (Exception e) {}

                if (c.equalsIgnoreCase("n")) {
                    System.out.print("Attendance list saved to result.csv");
                    break;
                    }
        }
    }


}



