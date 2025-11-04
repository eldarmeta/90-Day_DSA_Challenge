import java.util.*;

public class MaxAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) sum += nums[i];
        long best = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > best) best = sum;
        }
        return best / (double) k;
    }

    public static void main(String[] args) {
        MaxAverageSubarray sol = new MaxAverageSubarray();
        System.out.println(sol.findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(sol.findMaxAverage(new int[]{5}, 1));
    }
}
