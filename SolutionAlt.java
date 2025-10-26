
import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        int[] next = new int[n];
        HashMap<Integer, Integer> last = new HashMap<>();

        Arrays.fill(next, -1);
        for (int i = n - 1; i >= 0; i--) {
            if (rains[i] > 0) {
                int lake = rains[i];
                if (last.containsKey(lake)) next[i] = last.get(lake);
                last.put(lake, i);
            }
        }

        HashSet<Integer> full = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                int lake = rains[i];
                if (full.contains(lake)) return new int[0];
                full.add(lake);
                if (next[i] != -1) pq.offer(new int[]{next[i], lake});
                ans[i] = -1;
            } else {
                if (!pq.isEmpty()) {
                    int[] x = pq.poll();
                    ans[i] = x[1];
                    full.remove(x[1]);
                } else {
                    ans[i] = 1;
                }
            }
        }
        return ans;
    }
}
