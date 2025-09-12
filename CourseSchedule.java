// CourseSchedule.java
// Graphs 101 on LeetCode: Course Schedule (LC 207)
// Build a directed graph (adjacency list) and use Kahn's BFS (topological sort) to detect cycles.
// If we can take all courses (i.e., process all nodes), there is no cycle.

import java.util.*;

public class CourseSchedule {

    // ----- LeetCode-ready solution class -----
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // adjacency list for directed graph: b -> a (to take a, you must first take b)
            List<List<Integer>> adj = new ArrayList<>(numCourses);
            for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

            // indegree[v] = number of prerequisites for course v
            int[] indegree = new int[numCourses];
            for (int[] edge : prerequisites) {
                int a = edge[0]; // course to take
                int b = edge[1]; // prerequisite
                adj.get(b).add(a);
                indegree[a]++;
            }

            // queue of nodes with no prerequisites
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) q.add(i);
            }

            int taken = 0;
            while (!q.isEmpty()) {
                int u = q.poll();
                taken++;
                for (int v : adj.get(u)) {
                    if (--indegree[v] == 0) q.add(v);
                }
            }

            // If we processed all courses, graph has no cycle → feasible schedule
            return taken == numCourses;
        }
    }

    // ----- Minimal local test runner (not needed on LeetCode) -----
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
            {1, 0}, // take 0 before 1
            {2, 1}, // take 1 before 2
            {3, 2}  // take 2 before 3
        };
        boolean ok = new Solution().canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses? " + ok); // expected: true

        int[][] prerequisitesCycle = {
            {1, 0},
            {0, 1} // 0 -> 1 -> 0 forms a cycle
        };
        boolean ok2 = new Solution().canFinish(2, prerequisitesCycle);
        System.out.println("Can finish all courses? " + ok2); // expected: false
    }
}
