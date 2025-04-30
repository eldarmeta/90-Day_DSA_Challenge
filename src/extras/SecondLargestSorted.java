package extras;

import java.util.Arrays;

public class SecondLargestSorted {
    public static void main(String[] args) {
        int[] array = {10, 5, 20, 20, 8, 17};

        Arrays.sort(array); // Сортирует по возрастанию

        int largest = array[array.length - 1];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] != largest) {
                secondLargest = array[i];
                break;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Нет второго уникального наибольшего числа");
        } else {
            System.out.println("Второе наибольшее: " + secondLargest);
        }
    }
}
