package com.mortgage;

public class Calculator {

    public static void main(String[] args) {

        Methods methods = new Methods();

        methods.userName();

        while (true) {
            methods.principal();
            methods.mortgagePeriod();
            methods.annualInterest();
            methods.mortgageCalculated();

            while (true){

                System.out.println("\n Would you like to calcaulate another mortgage?)");
                System.out.print("(Yes/No): ");
                String choice = methods.scanner.nextLine().trim().toLowerCase();

                switch (choice) {
                    case "yes":
                        break;

                    case "no":
                        System.out.println("Thank you for using the Mortgage Calculator. Goodbye!");
                        methods.scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please type Yes or No.");
                }
                break;
            }
        }
    }
}
