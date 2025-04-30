package extras;

import java.util.LinkedList;
import java.util.Queue;

public class PoincareSimplified {

    static int[][] grid = {
            {1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 1, 1, 1, 1}
    };
    // 1 — стена (граница)
    // 0 — пустое пространство

    static boolean[][] visited;

    public static void main(String[] args) {
        visited = new boolean[grid.length][grid[0].length];
        boolean hasHole = false;

        // Ищем замкнутую область, которую нельзя "стянуть" в точку (в нашем случае — дырка)
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (isEnclosedArea(i, j)) {
                        hasHole = true;
                        break;
                    }
                }
            }
        }

        if (hasHole) {
            System.out.println("Фигура содержит дыру — не стягиваемо.");
        } else {
            System.out.println("Фигура не содержит дыр — стягиваемо в точку.");
        }
    }

    // Проверяем, замкнута ли область (простейшая проверка)
    public static boolean isEnclosedArea(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        boolean touchesEdge = false;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int cx = cell[0];
            int cy = cell[1];

            // Если дошли до края — значит, область не замкнута
            if (cx == 0 || cy == 0 || cx == grid.length - 1 || cy == grid[0].length - 1) {
                touchesEdge = true;
            }

            for (int[] dir : directions) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length &&
                        grid[nx][ny] == 0 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return !touchesEdge; // Если не дошли до края — это замкнутая область (дыра)
    }
}
