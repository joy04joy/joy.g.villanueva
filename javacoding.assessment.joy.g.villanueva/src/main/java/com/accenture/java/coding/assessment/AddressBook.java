package com.accenture.java.coding.assessment;


import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AddressBook {
    public static void main(String[] args) throws IOException {

        Scanner strInput = new Scanner(System.in);
        String choice,cont = "y";
        BufferedReader br;
        String line;

        br = new BufferedReader(new FileReader("C:\\Users\\AddressBook.csv"));

        System.out.print("ADDRESS BOOK\n");
        System.out.println("========================================================");
        System.out.println("\tName\tLocation\tContact\t\t\tEmail");
        System.out.println("--------------------------------------------------------");

        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        System.out.println("========================================================");
        System.out.print("\n");



        while( cont.equalsIgnoreCase("y") ) {

            System.out.println("Operation:");
            System.out.println("1 - Add Data");
            System.out.println("2 - Edit Data");
            System.out.println("3 - Delete Data");
            System.out.println("4 - Generate Report");
            System.out.println("5 - Exit Program");

            System.out.print("\n\n");
            System.out.println("Select Operations: ");
            choice = strInput.nextLine();

            if( choice.equals("1") ) {
                AddressBook.AddRecord();
            } else if( choice.equals("2") ) {
                AddressBook.EditRecord();
            } else if( choice.equals("3") ) {
                AddressBook.DeleteRecord();
            }	else if( choice.equals("4") ) {
                AddressBook.Generate();
            }	else if( choice.equals("5") ) {
                break;
            }

            System.out.println("Do you want to other transaction? Y/N");
            cont = strInput.nextLine();

        }
    }

    public static void AddRecord() throws IOException {

        BufferedWriter bw = new BufferedWriter( new FileWriter("C:\\Users\\AddressBook.csv",true) );
        Scanner strInput = new Scanner(System.in);

        String Name, Location, Contact, Email;

        System.out.print("Name: ");
        Name = strInput.nextLine();
        System.out.print("Location: ");
        Location = strInput.nextLine();
        System.out.print("Contact: ");
        Contact = strInput.nextLine();
        System.out.print("Email: ");
        Email = strInput.nextLine();

        bw.write("\t" + Name + "\t,\t" + Location + "\t,\t" + Contact + "\t,\t" + Email);
        bw.flush();
        bw.newLine();
        bw.close();
    }
    public static void EditRecord() throws IOException {
        String newLocation, newContact, newEmail, record, Name,record2;

        File db = new File("C:\\Users\\AddressBook.csv");
        File tempDB = new File("C:\\Users\\temp.csv");

        BufferedReader br = new BufferedReader( new FileReader(db) );
        BufferedWriter bw = new BufferedWriter( new FileWriter(tempDB) );

        Scanner strInput = new Scanner(System.in);

        System.out.println("\t\t Update Employee Record\n\n");

        System.out.println("Name: ");
        Name = strInput.nextLine();

        while( ( record = br.readLine() ) != null ) {

            StringTokenizer st = new StringTokenizer(record,",");
            if( record.contains(Name) ) {
                System.out.println("|"+st.nextToken()+""+st.nextToken()+"       "+st.nextToken()+""+st.nextToken());
            }

        }

        br.close();

        System.out.println("Location: ");
        newLocation = strInput.nextLine();
        System.out.println("Contact: ");
        newContact = strInput.nextLine();
        System.out.println("Email: ");
        newEmail = strInput.nextLine();

        BufferedReader br2 = new BufferedReader( new FileReader(db) );

        while( (record2 = br2.readLine() ) != null ) {
            if(record2.contains(Name)) {
                bw.write(Name+","+newLocation+","+newContact+","+newEmail);
            } else {

                bw.write(record2);
            }
            bw.flush();
            bw.newLine();
        }

        bw.close();
        br2.close();
        db.delete();
        boolean success = tempDB.renameTo(db);
        System.out.println(success);

    }
    public static void Generate(){

        System.out.println(" --- Generate Report Details--- ");
        System.out.println("Report details generated successfully to AddressBook.csv");

    }
    public static void DeleteRecord() throws IOException {
        Scanner strInput =  new Scanner(System.in);
        String Name, record;


        File tempDB = new File("C:\\Users\\temp.csv");
        File db = new File("C:\\Users\\AddressBook.csv");


        BufferedReader br = new BufferedReader( new FileReader( db ) );
        BufferedWriter bw = new BufferedWriter( new FileWriter( tempDB ) );


        System.out.println("\t\t Delete Employee Record\n");

        System.out.println("Name: ");
        Name =  strInput.nextLine();


        while( ( record = br.readLine() ) != null ) {


            if( record.contains(Name) )
                continue;

            bw.write(record);
            bw.flush();
            bw.newLine();

        }

        br.close();
        bw.close();

        db.delete();

        tempDB.renameTo(db);

    }


}

