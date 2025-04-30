package extras;

public class RippleEffect {

    public static void main(String[] args) {
        int waves = 14;

        for (int i = 1; i <= waves; i++) {
            System.out.println(" ".repeat(waves - i) + "*".repeat(i * 2 - 1));
            waitFor(500);
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
