package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int n = scanner.nextInt();

        if (n > 0) {
            System.out.println("Properties of " + n);
            System.out.println("\teven: " + isEven(n));
            System.out.println("\todd: " + isOdd(n));
            System.out.println("\tbuzz: " + isBuzzNumber(n));
            System.out.println("\tduck: " + isDuckNumber(n));
        } else {
            System.out.println("This number is not natural!");
        }
    }

    public static boolean isBuzzNumber(int n) {
        if (isDivisibleBySeven(n) || lastDigitIsSeven(n)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static boolean isDivisibleBySeven(int n) {
        return n % 7 == 0;
    }

    public static boolean lastDigitIsSeven(int n) {
        int temp = n % 10;
        return temp == 7;
    }

    public static boolean isDuckNumber(int n) {
        String number = n + "";
        if (number.contains("0")) {
            return true;
        } else {
            return false;
        }
    }
}
