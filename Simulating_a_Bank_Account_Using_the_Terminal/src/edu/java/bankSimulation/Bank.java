package edu.java.bankSimulation;

import java.util.Scanner;

public class Bank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("--------------------------------------");
        System.out.println("Sign-up");
        System.out.println("--------------------------------------");

        System.out.println("Name");
        String name = scan.nextLine();
        System.out.println("------------");
        System.out.println("Agency");
        String agency = scan.nextLine();
        System.out.println("------------");
        System.out.println("Account Number:");
        int number = scan.nextInt();

        // Consuming pending line break
        scan.nextLine();

        System.out.println("---> Creating... <---");
        Account clientAccount = new Account(number, agency, name);

        System.out.println("--------------------------------------");
        System.out.println("\nDo you want to make a withdrawal ?");
        System.out.println("( Y / n )  for yes use Y in uppercase");
        String isToWithdraw = scan.nextLine();

        if (isToWithdraw.equals("Y")) {
            System.out.println("Withdrawal amount:");
            double withdrawalRequested = scan.nextDouble();
            clientAccount.toWithdraw(withdrawalRequested);
        }

        System.out.println("--------------------------------------");
        System.out.println("Thank you for your preference");
        scan.close();
    }
}