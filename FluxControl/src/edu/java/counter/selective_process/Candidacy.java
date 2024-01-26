package edu.java.counter.selective_process;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Candidacy {
    public static void main(String[] args) {
        analizeCandidate(1900.0);
        analizeCandidate(2000.0);
        analizeCandidate(2200.0);

        System.out.println("-----------------------");

        selectionCandidates();

        System.out.println("-----------------------");

        printCandidates();

        System.out.println("-----------------------");

        String[] candidates = {"João", "José", "Camila", "Fernando", "Isabel"};
        for (String candidate : candidates) {
            calling(candidate);
        }
    }
    static void calling(String candidate) {
        int attemps = 1;
        boolean continueTrying = true;
        boolean answered = false;

        do {
            answered = toMeet();
            continueTrying = !answered;
            if (continueTrying) {
                attemps++;
            } else {
                System.out.println("Contact made successfully");
            }
        } while (continueTrying && attemps < 3);

        if (answered) {
            System.out.println("We managed to contact " + candidate + " in " + attemps + " attempt");
        } else {
            System.out.println("We were unable to contact " + candidate + ", " + attemps + " attempts were made");
        }
    }

    static boolean toMeet() {
        return new Random().nextInt(3)==1;
    }

    static void printCandidates() {
        String[] candidates = {"João", "José", "Camila", "Fernando", "Isabel"};

        System.out.println("Printing selected candidates");

//        for (int i =0; i < candidates.length; i++) {
//            System.out.println("the " + candidates[i] + " is the " + (i+1));
//        }

        for (String candidate : candidates) {
            System.out.println("the selected candidate " + candidate);
        }
    }

    static void selectionCandidates() {
        String[] candidates = {"João", "Maria", "Pedro", "Ana", "Carlos", "Mariana", "José", "Camila", "Fernando", "Isabel"};

        int selectedCandidates = 0;
        int currentCandidate = 0;
        double baseSalary = 2000.0;
        while (selectedCandidates < 5 && currentCandidate < candidates.length) {
            String candidate = candidates[currentCandidate];
            double salaryExpectation = valueExpectation();

            System.out.println("Candidate " + candidate + " has a salary target of " + salaryExpectation);
            if (baseSalary > salaryExpectation) {
                System.out.println(candidate + " was selected for the position");
                selectedCandidates++;
            }
            currentCandidate++;
        }
    }

    static double valueExpectation() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analizeCandidate(double salaryExpectation) {
        double baseSalary = 2000.0;

        if (baseSalary > salaryExpectation) {
            System.out.println("Call the candidate");
        } else if (baseSalary == salaryExpectation) {
            System.out.println("Call the candidate with a counter offer");
        } else {
            System.out.println("Awaiting results from other candidates");
        }
    }
}
