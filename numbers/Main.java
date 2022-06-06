package numbers;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Amazing Numbers!");

        boolean flag = true;
        printAvailableOperations();
        while (flag) {
            System.out.println("Enter a request: ");
            String option = scanner.nextLine();
            if (option.equals("0")) {
                flag = false;
                System.out.println("Goodbye!");
            } else if (option.contains(" ")) {
                checkListOfNumbers(option.split(" "));
            } else {
                checkSingleNumber(Long.parseLong(option));
            }
        }

    }

    public static void printAvailableOperations() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "\t * the first parameter represents a starting number\n" +
                "\t * the second parameter shows how many consecutive numbers are to be printed\n" +
                "- enter 0 to exit.");
    }

    public static void checkListOfNumbers(String[] arguments) {
        long startingNumber = Long.parseLong(arguments[0]);
        long amountToCheck = Long.parseLong(arguments[1]);
        if (checkNaturalNumber(startingNumber)) {
            if (checkNaturalNumber(amountToCheck)) {
                for (long i = startingNumber; i < startingNumber + amountToCheck; i++) {
                    checkNumber(i);
                }
            } else {
                System.out.println("The second parameter should be a natural number.");
            }
        } else {
            System.out.println("The first parameter should be a natural number or zero.");
        }

    }

    public static void checkNumber(long n) {

        if (checkNaturalNumber(n)) {
            ArrayList<String> processingResult = new ArrayList<>();
            if (isBuzzNumber(n)) processingResult.add("buzz");
            if (isDuckNumber(n)) processingResult.add("duck");
            if (isPalindrome(n)) processingResult.add("palindromic");
            if (isGapfulNumber(n)) processingResult.add("gapful");
            if (isEven(n)) processingResult.add("even");
            if (isOdd(n)) processingResult.add("odd");
            System.out.print(n + " is ");
            for (int i = 0; i < processingResult.size(); i++) {
                if (i == processingResult.size() - 1) {
                    System.out.print(processingResult.get(i));
                    System.out.println();
                } else {
                    System.out.print(processingResult.get(i) + ", ");
                }
            }
        } else {
            System.out.println("The first parameter should be a natural number or zero.");
        }
    }

    public static void checkSingleNumber(long n) {
        if (checkNaturalNumber(n)) {
            System.out.println("Properties of " + n);
            System.out.println("\tbuzz: " + isBuzzNumber(n));
            System.out.println("\tduck: " + isDuckNumber(n));
            System.out.println("\tpalindromic: " + isPalindrome(n));
            System.out.println("\tgapful: " + isGapfulNumber(n));
            System.out.println("\teven: " + isEven(n));
            System.out.println("\todd: " + isOdd(n));
        } else {
            System.out.println("The first parameter should be a natural number or zero.");
        }
    }

    public static boolean checkNaturalNumber(long n) {
        return n >= 0;
    }

    public static boolean isBuzzNumber(long n) {
        return isDivisibleBySeven(n) || lastDigitIsSeven(n);
    }

    public static boolean isEven(long n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(long n) {
        return n % 2 != 0;
    }

    public static boolean isDivisibleBySeven(long n) {
        return n % 7 == 0;
    }

    public static boolean lastDigitIsSeven(long n) {
        long temp = n % 10;
        return temp == 7;
    }

    public static boolean isDuckNumber(long n) {
        String number = n + "";
        return number.contains("0");
    }

    public static boolean isPalindrome(long n) {
        String number = n + "";
        String toCompare = new StringBuilder(number).reverse().toString();

        return number.equals(toCompare);
    }

    public static boolean hasThreeDigits(long n) {
        return n > 99;
    }

    public static long getFirstAndLastDigit(long n) {
        long firstAndLast = n % 10;
        while (n >= 10) {
            n /= 10;
        }
        firstAndLast = (n * 10) + firstAndLast;
        return firstAndLast;
    }

    public static boolean isGapfulNumber(long n) {
        if (hasThreeDigits(n)) {
            return n % getFirstAndLastDigit(n) == 0;
        }
        return false;
    }
}
