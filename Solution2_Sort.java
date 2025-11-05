
import java.util.Arrays;
public class Solution2_Sort {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n-1] * nums[n-2] - nums[0] * nums[1];
    }
    public static void main(String[] args) {
        int[] a = {5,6,2,7,4};
        System.out.println(new Solution2_Sort().maxProductDifference(a));
    }
}
