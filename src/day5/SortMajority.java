package day5;

import java.util.Arrays;

public class
SortMajority {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement(nums);
        System.out.println("Мажоритарный элемент (Sort): " + result);
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n / 2];
    }
}
