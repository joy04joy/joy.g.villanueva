package com.accenture.java.coding.assessment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class trainee {
    public static void main (String[] args) throws ParseException {
        String path = "C:\\Users\\result.csv";
        String line = "";
        BufferedReader br;
        int minute, hour;
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");
        Date eight = parser.parse("8:00");


        System.out.print("Call time: 8:00");
        System.out.print("\n");
        System.out.print("\n");


        try {
            br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) !=null){
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
