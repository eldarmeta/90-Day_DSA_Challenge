package Strings.list.day2;

import java.util.Scanner;

public class PalindromNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int x = sc.nextInt();

        boolean result = isPalindrome(x);
        System.out.println("Is palindrome? " + result);
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversed = 0;
        while (x > reversed) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }

        return (x == reversed) || (x == reversed / 10);
    }
}
