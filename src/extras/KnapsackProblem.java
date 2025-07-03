public class KnapsackProblem {

    public static void main(String[] args) {

        int[] weights = {2, 3, 4, 5}; // Вес товаров
        int[] values = {3, 4, 5, 6};  // Ценность товаров
        int capacity = 5;             // Максимальный вес рюкзака

        int maxProfit = knapsack(weights, values, capacity);

        System.out.println("Максимальная прибыль: " + maxProfit);
    }

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // Заполняем таблицу динамического программирования
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            values[i - 1] + dp[i - 1][w - weights[i - 1]],
                            dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }
}
