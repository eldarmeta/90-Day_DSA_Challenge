public class LeetCodeMaxSubarraySumLEK {
    public int solve(int[] nums, int targetSum) {
        int left = 0, currentSum = 0, ans = 0;
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            while (currentSum > targetSum && left <= right) {
                currentSum -= nums[left++];
            }
            ans = Math.max(ans, currentSum);
        }
        return ans;
    }
}