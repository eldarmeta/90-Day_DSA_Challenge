
public class Solution1_BruteForce {
    public int maxProductDifference(int[] nums) {
        int n = nums.length;
        int best = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;
                    for (int l = k + 1; l < n; l++) {
                        if (l == i || l == j) continue;
                        int first = nums[i] * nums[j];
                        int second = nums[k] * nums[l];
                        best = Math.max(best, first - second);
                    }
                }
            }
        }
        return best;
    }
    public static void main(String[] args) {
        int[] a = {5,6,2,7,4};
        System.out.println(new Solution1_BruteForce().maxProductDifference(a));
    }
}
