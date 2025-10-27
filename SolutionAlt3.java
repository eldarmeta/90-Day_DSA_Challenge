
import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];

        HashMap<Integer, Deque<Integer>> future = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                future.computeIfAbsent(rains[i], k -> new ArrayDeque<>()).addLast(i);
            }
        }

        HashSet<Integer> full = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                int lake = rains[i];
                Deque<Integer> q = future.get(lake);
                q.pollFirst();
                if (full.contains(lake)) return new int[0];
                full.add(lake);
                Integer nxt = q.peekFirst();
                if (nxt != null) pq.offer(new int[]{nxt, lake});
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
