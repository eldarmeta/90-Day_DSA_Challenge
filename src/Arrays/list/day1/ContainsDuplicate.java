package Arrays.list.day1;

import java.util.Scanner;

public class ContainsDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Считываем строку чисел с пробелами
        String[] parts = scanner.nextLine().split(" ");
        int[] nums = new int[parts.length];

        // Преобразуем в массив int
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        boolean hasDuplicate = false;

        // Два вложенных цикла для поиска дубликатов
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    hasDuplicate = true;
                    break; // выйти из внутреннего цикла
                }
            }
            if (hasDuplicate) {
                break; // выйти из внешнего цикла
            }
        }

        // Вывод результата
        if (hasDuplicate) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
