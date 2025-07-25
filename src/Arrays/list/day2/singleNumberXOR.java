package Arrays.list.day2;

import java.util.Scanner;

public class singleNumberXOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int[] nums = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        int result = 0;
        for (int num : nums) {
            result ^= num;  // XOR-им каждый элемент
            //result = result ^ num;
        }

        System.out.println(result);  // выводим уникальное число
    }
}
