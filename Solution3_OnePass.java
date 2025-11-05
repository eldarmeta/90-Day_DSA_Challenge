
public class Solution3_OnePass {
    public int maxProductDifference(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int x : nums) {
            if (x <= min1) { min2 = min1; min1 = x; }
            else if (x < min2) { min2 = x; }
            if (x >= max1) { max2 = max1; max1 = x; }
            else if (x > max2) { max2 = x; }
        }
        return max1 * max2 - min1 * min2;
    }
    public static void main(String[] args) {
        int[] a = {5,6,2,7,4};
        System.out.println(new Solution3_OnePass().maxProductDifference(a));
    }
}
