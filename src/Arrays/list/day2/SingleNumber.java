package Arrays.list.day2;

import java.util.Scanner;

public class SingleNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        // Outer loop: мы перебираем каждый элемент массива
        for (int i = 0; i < nums.length; i++) {
            boolean isDuplicate = false; // флаг: является ли дубликатом

            // Inner loop: сравниваем текущий элемент с остальными
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j]) {
                    isDuplicate = true; // найден дубликат
                    break;
                }
            }

            // Если не нашли дубликатов, значит это уникальное число
            if (!isDuplicate) {
                System.out.println(nums[i]); // ✅ выводим результат
                return; // выходим из метода
            }
        }

        System.out.println(-1); // если не найдено
    }
}
