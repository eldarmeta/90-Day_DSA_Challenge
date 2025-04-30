package day4;

public class MissingNumberXOR {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 0, 5};
        int missing = missingNumber(nums);
        System.out.println("Missing number: " + missing);
    }

    public static int missingNumber(int[] nums) {
        int xor = 0;
        int n = nums.length;

        // XOR всех чисел от 0 до n
        for (int i = 0; i <= n; i++) {
            xor = xor ^ i;
        }

        // XOR всех элементов в массиве
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }

        return xor;
    }
}
