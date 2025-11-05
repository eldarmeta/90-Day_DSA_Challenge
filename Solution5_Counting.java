
public class Solution5_Counting {
    public int maxProductDifference(int[] nums) {
        int MAXV = 10000;
        int[] cnt = new int[MAXV + 1];
        for (int x : nums) cnt[x]++;
        int min1 = -1, min2 = -1;
        for (int v = 1; v <= MAXV && (min1 == -1 || min2 == -1); v++) {
            while (cnt[v] > 0 && (min1 == -1 || min2 == -1)) {
                if (min1 == -1) min1 = v;
                else min2 = v;
                cnt[v]--;
            }
        }
        int max1 = -1, max2 = -1;
        for (int v = MAXV; v >= 1 && (max1 == -1 || max2 == -1); v--) {
            while (cnt[v] > 0 && (max1 == -1 || max2 == -1)) {
                if (max1 == -1) max1 = v;
                else max2 = v;
                cnt[v]--;
            }
        }
        return max1 * max2 - min1 * min2;
    }
    public static void main(String[] args) {
        int[] a = {5,6,2,7,4};
        System.out.println(new Solution5_Counting().maxProductDifference(a));
    }
}
