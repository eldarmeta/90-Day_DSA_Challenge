import java.util.*;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        long prod = 1;
        int left = 0, count = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k && left <= right) {
                prod /= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK sol = new SubarrayProductLessThanK();
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
        System.out.println(sol.numSubarrayProductLessThanK(new int[]{1,1,1}, 2));
    }
}
