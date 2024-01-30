package edu.java.counter;

import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first parameter");
        int parameterOne = scan.nextInt();
        System.out.println("Enter the second parameter");
        int parameterTwo = scan.nextInt();
        scan.close();

        try {
            count(parameterOne, parameterTwo);

        }catch (InvalidParametersException exception) {
            System.err.println(exception.getMessage());
        }

    }
    static void count(int firstParameter, int secondParameter ) throws InvalidParametersException {
        if (firstParameter > secondParameter) {
            throw new InvalidParametersException("The second parameter must be greater than the first");
        }
        int counter = secondParameter - firstParameter;

        for (int i = 1; i <= counter; i++) {
            System.out.println("counting... " + i);
        }
    }
}