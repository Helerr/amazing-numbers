package numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a natural number:");
        int n = scanner.nextInt();
        isBuzzNumber(n);
    }

    public static void isBuzzNumber(int n) {
        if (n > 0) {
            if (isEven(n)) {
                System.out.println("This number is Even.");
            } else {
                System.out.println("This number is Odd.");
            }
            if (isDivisibleBySeven(n) || lastDigitIsSeven(n)) {
                System.out.println("It is a Buzz number.");
                System.out.println("Explanation: ");
                if (isDivisibleBySeven(n) && lastDigitIsSeven(n)) {
                    System.out.println(n + " is divisible by 7 and ends with 7.");
                } else if (isDivisibleBySeven(n)) {
                    System.out.println(n + " is divisible by 7.");
                } else if (lastDigitIsSeven(n)) {
                    System.out.println(n + " ends with 7");
                }
            } else {
                System.out.println("It is not a Buzz number.");
                System.out.println("Explanation:");
                System.out.println(n + " is neither divisible by 7 nor does it end with 7.");
            }
        } else {
            System.out.println("This number is not natural!");
        }
    }

    public static boolean isEven(int n) {
        return n % 2 == 0;
    }

    public static boolean isDivisibleBySeven(int n) {
        return n % 7 == 0;
    }

    public static boolean lastDigitIsSeven(int n) {
        int temp = n % 10;
        return temp == 7;
    }
}
