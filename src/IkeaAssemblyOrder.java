import java.util.*;

public class IkeaAssemblyOrder {
    public static List<Integer> buildOrder(int n, int[][] deps) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];

        for (int[] dep : deps) {
            graph.computeIfAbsent(dep[0], x -> new ArrayList<>()).add(dep[1]);
            indegree[dep[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int part = queue.poll();
            order.add(part);

            for (int neighbor : graph.getOrDefault(part, new ArrayList<>())) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        return order.size() == n ? order : null;
    }

    public static void main(String[] args) {
        int[][] dependencies = {
                {0, 1},
                {1, 2},
                {0, 3}
        };

        List<Integer> order = buildOrder(4, dependencies);
        if (order != null) {
            System.out.println("Assembly Order: " + order);
        } else {
            System.out.println("Error: Circular dependency");
        }
    }
}
