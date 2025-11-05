
import java.util.*;
public class Solution4_Heaps {
    public int maxProductDifference(int[] nums) {
        PriorityQueue<Integer> top2 = new PriorityQueue<>(2);
        PriorityQueue<Integer> bot2 = new PriorityQueue<>(2, Collections.reverseOrder());
        for (int x : nums) {
            top2.offer(x);
            if (top2.size() > 2) top2.poll();
            bot2.offer(x);
            if (bot2.size() > 2) bot2.poll();
        }
        int max2 = top2.poll();
        int max1 = top2.poll();
        int min1 = bot2.poll();
        int min2 = bot2.poll();
        return max1 * max2 - min1 * min2;
    }
    public static void main(String[] args) {
        int[] a = {5,6,2,7,4};
        System.out.println(new Solution4_Heaps().maxProductDifference(a));
    }
}
