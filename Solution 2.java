
import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        TreeSet<Integer> dry = new TreeSet<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dry.add(i);
                ans[i] = 1;
            } else {
                ans[i] = -1;
                int lake = rains[i];
                if (last.containsKey(lake)) {
                    Integer d = dry.ceiling(last.get(lake) + 1);
                    if (d == null || d >= i) return new int[0];
                    ans[d] = lake;
                    dry.remove(d);
                }
                last.put(lake, i);
            }
        }
        return ans;
    }
}
