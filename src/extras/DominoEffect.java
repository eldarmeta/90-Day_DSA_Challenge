package extras;

public class DominoEffect {

    public static void main(String[] args) {
        int n = 10; // Количество домино

        for (int i = 1; i <= n; i++) {
            System.out.println("Domino " + i + " fell.");
            waitFor(500); // Пауза, чтобы показать последовательность
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
