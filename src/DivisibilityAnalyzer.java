import java.util.*;

public class DivisibilityAnalyzer {

    public static void main(String[] args) {
        int limit = 1000;
        Map<Integer, List<Integer>> divisibleMap = new HashMap<>();

        int[] divisors = {2, 3, 4, 5, 6, 8, 9, 10, 11};

        for (int d : divisors) {
            divisibleMap.put(d, new ArrayList<>());
        }

        for (int i = 1; i <= limit; i++) {
            for (int d : divisors) {
                if (isDivisible(i, d)) {
                    divisibleMap.get(d).add(i);
                }
            }
        }

        for (int d : divisors) {
            System.out.println("Divisible by " + d + " (" + divisibleMap.get(d).size() + " numbers):");
            System.out.println(divisibleMap.get(d));
            System.out.println();
        }

        // Optional: Show numbers divisible by 3 and 9 and why
        System.out.println("Numbers divisible by 3 and 9 (using digit sum logic):");
        for (int i = 1; i <= limit; i++) {
            int digitSum = digitSum(i);
            if (digitSum % 3 == 0 || digitSum % 9 == 0) {
                System.out.printf("Number %d -> Digit sum = %d => ", i, digitSum);
                if (digitSum % 9 == 0) System.out.println("Divisible by 9");
                else System.out.println("Divisible by 3");
            }
        }
    }

    public static boolean isDivisible(int number, int divisor) {
        switch (divisor) {
            case 2: return number % 2 == 0;
            case 3: return digitSum(number) % 3 == 0;
            case 4: return number % 100 % 4 == 0;
            case 5: return number % 10 == 0 || number % 10 == 5;
            case 6: return isDivisible(number, 2) && isDivisible(number, 3);
            case 8: return number % 1000 % 8 == 0;
            case 9: return digitSum(number) % 9 == 0;
            case 10: return number % 10 == 0;
            case 11: return isDivisibleBy11(number);
            default: return number % divisor == 0;
        }
    }

    public static int digitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static boolean isDivisibleBy11(int number) {
        String s = Integer.toString(number);
        int altSum = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            altSum += (i % 2 == 0) ? digit : -digit;
        }
        return altSum % 11 == 0;
    }
}