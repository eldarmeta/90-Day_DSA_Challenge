package Arrays.list.day1;

import java.util.Scanner;

public class Stock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] parts = scanner.nextLine().split(" ");
        int[] prices = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            prices[i] = Integer.parseInt(parts[i]);
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        System.out.println(maxProfit);    }
}