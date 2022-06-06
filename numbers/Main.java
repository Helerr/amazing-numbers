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
                String[] properties = option.split(" ");
                if (properties.length == 2) {
                    checkListOfNumbers(properties);
                } else if (properties.length == 3) {
                    checkNumbersWithSpecificProperty(properties);
                } else if (properties.length == 4) {
                    if (propertiesAreValid(properties)) {
                        long number = Long.parseLong(properties[0]);
                        int amount = Integer.parseInt(properties[1]);
                        String firstProperty = properties[2].toLowerCase();
                        String secondProperty = properties[3].toLowerCase();
                        if (isValidProperty(firstProperty) && isValidProperty(secondProperty)) {
                            int counter = 0;
                            while (counter < amount) {
                                if (checkProperty(number, firstProperty)) {
                                    if (checkProperty(number, secondProperty)) {
                                        checkNumber(number);
                                        counter++;
                                    }
                                }
                                number++;
                            }
                        } else {
                            if (!isValidProperty(firstProperty) && !isValidProperty(secondProperty)) {
                                System.out.println("The properties [" + firstProperty.toUpperCase() + ", " + secondProperty.toUpperCase() +
                                        "] are wrong.");
                                System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]");
                            } else {
                                if (!isValidProperty(firstProperty)) {
                                    System.out.println("The property [" + firstProperty.toUpperCase() + "] is wrong.");
                                    System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]");
                                } else if (!isValidProperty(secondProperty)) {
                                    System.out.println("The property [" + secondProperty.toUpperCase() + "] is wrong.");
                                    System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]");
                                }
                            }
                        }
                    } else {
                        System.out.println("The request contains mutually exclusive properties: [" +
                                properties[2].toUpperCase() + ", " + properties[3].toUpperCase() + "]\n" +
                                "There are no numbers with these properties.");
                    }
                }
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
                "- two natural numbers and a property to search for;\n" +
                "- two natural numbers and two properties to search for;\n" +
                "- separate the parameters with one space;\n" +
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

    public static void checkNumbersWithSpecificProperty(String[] arguments) {
        long number = Long.parseLong(arguments[0]);
        long amount = Long.parseLong(arguments[1]);
        int counter = 0;
        outer:
        while (counter < amount) {
            switch (arguments[2].toLowerCase()) {
                case "even":
                    if (isEven(number)) {
                        checkNumber(number);
                        counter++;
                    }
                    number++;
                    break;
                case "odd":
                    if (isOdd(number)) {
                        checkNumber(number);
                        counter++;
                    }
                    number++;
                    break;
                case "buzz":
                    if (isBuzzNumber(number)) {
                        checkNumber(number);
                        counter++;
                    }
                    number++;
                    break;
                case "duck":
                    if (isDuckNumber(number)) {
                        checkNumber(number);
                        counter++;
                    }
                    number++;
                    break;
                case "palindromic":
                    if (isPalindrome(number)) {
                        checkNumber(number);
                        counter++;
                    }
                    number++;
                    break;
                case "gapful":
                    if (isGapfulNumber(number)) {
                        checkNumber(number);
                        counter++;
                    }
                    number++;
                    break;
                case "spy":
                    if (isSpyNumber(number)) {
                        checkNumber(number);
                        counter++;
                    }
                    number++;
                    break;
                case "square":
                    if (isSquare(number)) {
                        checkNumber(number);
                        counter++;
                    }
                    number++;
                    break;
                case "sunny":
                    if (isSunny(number)) {
                        checkNumber(number);
                        counter++;
                    }
                    number++;
                    break;
                default:
                    System.out.println("The property [" + arguments[2].toUpperCase() + "] is wrong.");
                    System.out.println("Available properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD]");
                    break outer;
            }
        }
    }

    public static void checkNumber(long n) {

        if (checkNaturalNumber(n)) {
            ArrayList<String> processingResult = new ArrayList<>();
            if (isBuzzNumber(n)) processingResult.add("buzz");
            if (isDuckNumber(n)) processingResult.add("duck");
            if (isPalindrome(n)) processingResult.add("palindromic");
            if (isGapfulNumber(n)) processingResult.add("gapful");
            if (isSpyNumber(n)) processingResult.add("spy");
            if (isSquare(n)) processingResult.add("square");
            if (isSunny(n)) processingResult.add("sunny");
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
            System.out.println("\tspy: " + isSpyNumber(n));
            System.out.println("\tsquare: " + isSquare(n));
            System.out.println("\tsunny: " + isSunny(n));
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

    public static boolean isSpyNumber(long n) {
        long sum = 0;
        long prod = 1;
        while (n > 0) {
            long temp = n % 10;
            sum += temp;
            prod *= temp;
            n /= 10;
        }
        return sum == prod;
    }

    public static boolean propertiesAreValid(String[] properties) {
        String firstProperty = properties[2].toLowerCase();
        String secondProperty = properties[3].toLowerCase();
        if ("even".equals(firstProperty) && "odd".equals(secondProperty)
                || "odd".equals(firstProperty) && "even".equals(secondProperty)) {
            return false;
        }
        if ("duck".equals(firstProperty) && "spy".equals(secondProperty)
                || "spy".equals(firstProperty) && "duck".equals(secondProperty)) {
            return false;
        }
        if ("sunny".equals(firstProperty) && "square".equals(secondProperty)
                || "square".equals(firstProperty) && "sunny".equals(secondProperty)) {
            return false;
        }
        return true;
    }

    public static boolean isSquare(long n) {
        double number = (double) n;

        double squareRoot = Math.sqrt(number);

        long roundedRoot = Math.round(squareRoot);

        if (Math.pow(squareRoot, 2) == (roundedRoot * roundedRoot)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isSunny(long n) {
        return isSquare(n + 1);
    }

    public static boolean checkProperty(long number, String property) {
        switch (property.toLowerCase()) {
            case "even":
                return isEven(number);
            case "odd":
                return isOdd(number);
            case "buzz":
                return isBuzzNumber(number);
            case "duck":
                return isDuckNumber(number);
            case "palindromic":
                return isPalindrome(number);
            case "gapful":
                return isGapfulNumber(number);
            case "spy":
                return isSpyNumber(number);
            case "square":
                return isSquare(number);
            case "sunny":
                return isSunny(number);
        }
        return false;
    }

    public static boolean isValidProperty(String property) {
        switch (property) {
            case "even":
            case "odd":
            case "sunny":
            case "square":
            case "spy":
            case "gapful":
            case "palindromic":
            case "duck":
            case "buzz":
                return true;
            default:
                return false;
        }
    }
}
