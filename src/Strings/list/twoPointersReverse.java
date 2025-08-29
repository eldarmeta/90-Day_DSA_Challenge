package Strings.list;

import java.util.Scanner;

public class twoPointersReverse {

    // Реверс строки: O(n) по времени, O(n) по памяти (из-за char[])
    public static String reverse(String input) {
        if (input == null || input.length() <= 1) return input;

        char[] chars = input.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
        return new String(chars);
    }

    // Демонстрация чтения из консоли и печати результата
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverse(s));
        sc.close();
    }
}
