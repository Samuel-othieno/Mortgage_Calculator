package com.mortgage;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Scanner;

public class Calculator {
    static boolean isCompany = false;
    static short dateOfBirth;
    static short currentYear;
    static byte age;
    static String name;
    static String address;
    static final byte percent = 100;
    static final byte monthsInAYear = 12;
    static float monthlyInterest;
    static float annualInterest;
    static int numberOfPayment;
    static double mortgage;
    static int principal;
    static String helloWorld = " welcome to your most trusted Mortgage Calculator.";
    static String getStarted = "Lets get started, shall we?";
    static byte years;
    static String mortgageCalculated;




    static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            try {

                System.out.print("Enter name: ");
                name =  scanner.nextLine().toUpperCase().trim();

                if (name.isEmpty()){
                    throw new IllegalArgumentException("Enter your name");
                }
                break;
                
            }catch (Exception e){
                System.out.println("Something went wrong, please try again");
            }
        }

        System.out.println("Hello " + name + helloWorld);
        System.out.println(getStarted);

        while (true){
            try {
                System.out.print("Enter amount: ");
                principal = scanner.nextInt();
                scanner.nextLine();

                if (principal >= 10_000_000 && principal <= 1_000_000_000)
                    break;

            }catch (Exception e){
                System.out.println("Something went wrong.");

            }finally {
                System.out.println("Please try again");
            }
        }

        while (true){
            System.out.print("Enter period(Years): ");
            years = scanner.nextByte();
            scanner.nextLine();

            if (years >= 1 && years <= 60){
                numberOfPayment = years * monthsInAYear;
                break;
            }
            System.out.print("Enter value between 1 to 60 years");
        }

        while (true){
            System.out.print("Enter Annual Interest: ");
            annualInterest = scanner.nextFloat();
            scanner.nextLine();

            if (annualInterest >=1 && annualInterest <= 30){
                monthlyInterest = annualInterest / percent / monthsInAYear;
                break;
            }
            System.out.print("Enter a value between 1% to 30% ");
        }

        mortgage = principal
                * monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment)
                /Math.pow(1 + monthlyInterest, numberOfPayment) - 1;

        mortgageCalculated = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println(mortgageCalculated);

        scanner.close();
    }
}
