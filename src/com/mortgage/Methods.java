package com.mortgage;

import java.text.NumberFormat;
import java.util.Scanner;

public class Methods {

    Scanner scanner = new Scanner(System.in);

    String name;
    final byte percent = 100;
    final byte monthsInAYear = 12;
    float monthlyInterest;
    float annualInterest;
    int numberOfPayment;
    double mortgage;
    int principal;
    String helloWorld = " welcome to your most trusted Mortgage Calculator.";
    String getStarted = "Lets get started, shall we?";
    byte years;
    String mortgageCalculated;

    public void userName() {
        while (true) {
            try {

                System.out.print("Enter name: ");
                name = scanner.nextLine().toUpperCase().trim();

                if (name.isEmpty() || name.matches("\\d+")) {
                    throw new IllegalArgumentException("Enter your name");
                }
                break;

            } catch (Exception e) {
                System.out.println("Something went wrong, please try again");
            }
        }
        System.out.println("Hello " + name + helloWorld);
        System.out.println(getStarted);
    }

    public void principal() {
        while (true) {
            try {
                System.out.print("Enter amount: ");
                principal = scanner.nextInt();
                scanner.nextLine();

                if (principal >= 10_000_000 && principal <= 1_000_000_000) {
                    break;
                } else {
                    System.out.println("Enter a value between 1,000,000 and 1,000,000,000 ");
                }

            } catch (Exception e) {
                System.out.println("Something went wrong. Please try again");
                scanner.nextLine();
            }
        }
    }

    public void mortgagePeriod() {
        try {
            while (true) {
                System.out.print("Enter period(Years): ");
                years = scanner.nextByte();
                scanner.nextLine();

                if (years >= 1 && years <= 60) {
                    numberOfPayment = years * monthsInAYear;
                    break;
                }
                System.out.print("Enter value between 1 to 60 years");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong. Please try again");
            scanner.nextLine();
        }
    }

    public void annualInterest() {
        try {
            while (true) {
                System.out.print("Enter Annual Interest: ");
                annualInterest = scanner.nextFloat();
                scanner.nextLine();

                if (annualInterest >= 1 && annualInterest <= 30) {
                    monthlyInterest = annualInterest / percent / monthsInAYear;
                    break;
                }
                System.out.print("Enter a value between 1% to 30% ");
            }
        } catch (Exception e) {
            System.out.println("Something went wrong. Please try again");
            scanner.nextLine();
        }
    }

    public void mortgageCalculated() {
        try {
            mortgage = principal
                    * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayment))
                    / (Math.pow(1 + monthlyInterest, numberOfPayment) - 1);

            mortgageCalculated = NumberFormat.getCurrencyInstance().format(mortgage);

            System.out.println("\n--- Mortgage Summary ---");
            System.out.println("Principal: " + NumberFormat.getCurrencyInstance().format(principal));
            System.out.println("Period: " + years + " years(" + numberOfPayment + " months)");
            System.out.println("Annual Interest Rate: " + annualInterest + "%");
            System.out.println("Monthly Payment: " + mortgageCalculated);

        } catch (Exception e) {
            System.out.println("Something went wrong. Please try again");
            scanner.nextLine();
        }
    }
}