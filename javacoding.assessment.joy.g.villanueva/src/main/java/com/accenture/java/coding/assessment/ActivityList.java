package com.accenture.java.coding.assessment;

import java.io.IOException;
import java.util.Scanner;

public class ActivityList {

    public static void main(String[] args) throws IOException {

        Scanner strInput = new Scanner(System.in);
        String choice,cont = "y";

        while( cont.equalsIgnoreCase("y") ) {

            System.out.println("LIST OF ACTIVITIES: [Junit, Termination, Collection, Concurrency, Naming Conventions]");
            System.out.println("Choose activity from 1 to 5 | Press 0 to terminate | Press R to view result");

            System.out.print("\n");
            choice = strInput.nextLine();

            if( choice.equals("1") ) {
                ActivityList.JUnit();
            } else if( choice.equals("2") ) {
                ActivityList.Termination();
            } else if( choice.equals("3") ) {
                ActivityList.Collection();
            }	else if( choice.equals("4") ) {
                ActivityList.Concurrency();
            }	else if( choice.equals("5") ) {
                ActivityList.NamingConvention();
            }   else if(choice.equals("0") ) {
                break;
            }

            System.out.println("Do you want to other transaction? Y/N");
            cont = strInput.nextLine();

        }
    }

    public static void JUnit() throws IOException {
        System.out.println("Chosen Activities: [JUnit]");
    }
    public static void Termination() throws IOException {
        System.out.println("Chosen Activities: [Termination]");
    }
    public static void Collection(){
        System.out.println("Chosen Activities: [Collection]");
    }
    public static void Concurrency() throws IOException {
        System.out.println("Chosen Activities: [Concurrency]");
    }
    public static void NamingConvention() throws IOException {
        System.out.println("Chosen Activities: [Naming Convention]");
    }


}

