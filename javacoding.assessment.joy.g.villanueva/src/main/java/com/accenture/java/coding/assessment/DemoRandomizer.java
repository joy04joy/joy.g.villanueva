package com.accenture.java.coding.assessment;

import java.io.*;

public class DemoRandomizer {
    public static void main (String[] args) throws IOException {

        BufferedReader br;
        String line;
        String EID = new String(), LateTime = new String(), DemoTime = new String();

        br = new BufferedReader(new FileReader("C:\\Users\\demolist.csv"));
        BufferedWriter bw = new BufferedWriter( new FileWriter("C:\\Users\\demolist.csv",true) );

        System.out.println("=== PRESENT PARTICIPANTS ===");
        System.out.println("-----------------------------------------------------");
        System.out.println("Position\t EID\t\t\tLate Time\tDemo Time");
        System.out.println("-----------------------------------------------------\n");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        bw.write("\t" + EID + "\t,\t" + LateTime + "\t,\t" + DemoTime);
        bw.flush();
        bw.newLine();
        bw.close();


    }
}
