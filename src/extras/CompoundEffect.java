public class CompoundEffect {

    public static void main(String[] args) {
        double value = 1;
        double growthRate = 0.01; // 1% роста
        int days = 100;

        for (int i = 1; i <= days; i++) {
            value += value * growthRate;
            System.out.printf("Day %d: %.4f%n", i, value);
            waitFor(100);
        }
    }

    public static void waitFor(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
