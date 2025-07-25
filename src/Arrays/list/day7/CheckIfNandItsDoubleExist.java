package Arrays.list.day7;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNandItsDoubleExist {
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();

        for (int n : arr) {
            if (seen.contains(2 * n) || (n % 2 == 0 && seen.contains(n / 2))) {
                return true;
            }
            seen.add(n);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] test1 = {10, 2, 5, 3};      // true
        int[] test2 = {3, 1, 7, 11};      // false
        int[] test3 = {0, 0};             // true

        System.out.println(checkIfExist(test1));
        System.out.println(checkIfExist(test2));
        System.out.println(checkIfExist(test3));
    }
}
