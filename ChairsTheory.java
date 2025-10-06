import java.util.*;
public class ChairsTheory {
    public static int minChairsTwoPointer(String[] arrive, String[] leave) {
        int n = arrive.length;
        int[] a = Arrays.stream(arrive).mapToInt(ChairsTheory::toMinutes).sorted().toArray();
        int[] d = Arrays.stream(leave).mapToInt(ChairsTheory::toMinutes).sorted().toArray();
        int i = 0, j = 0, used = 0, maxUsed = 0;
        while (i < n && j < n) {
            if (a[i] < d[j]) { used++; maxUsed = Math.max(maxUsed, used); i++; }
            else { used--; j++; }
        }
        return maxUsed;
    }
    public static int minChairsHeap(String[] arrive, String[] leave) {
        int n = arrive.length;
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = toMinutes(arrive[i]);
            intervals[i][1] = toMinutes(leave[i]);
        }
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;
        for (int[] it : intervals) {
            int s = it[0], e = it[1];
            while (!pq.isEmpty() && pq.peek() <= s) pq.poll();
            pq.offer(e);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
    private static int toMinutes(String hhmm) {
        int h = Integer.parseInt(hhmm.substring(0, 2));
        int m = Integer.parseInt(hhmm.substring(3, 5));
        return h * 60 + m;
    }
}