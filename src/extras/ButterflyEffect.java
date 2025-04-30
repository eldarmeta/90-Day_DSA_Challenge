package extras;

public class ButterflyEffect {

    public static void main(String[] args) {
        double initialCondition1 = 0.0001;
        double initialCondition2 = 0.0001001; // Разница в 0.0000001

        simulateChaos(initialCondition1, initialCondition2, 20);
    }

    public static void simulateChaos(double x, double y, int steps) {
        double r = 3.9; // Параметр для хаотичной системы (почти logistic map)

        System.out.printf("%-10s %-20s %-20s %-20s%n", "Step", "System A", "System B", "Difference");

        for (int i = 0; i < steps; i++) {
            x = r * x * (1 - x);
            y = r * y * (1 - y);
            double diff = Math.abs(x - y);

            System.out.printf("%-10d %-20f %-20f %-20f%n", i + 1, x, y, diff);
        }
    }
}
