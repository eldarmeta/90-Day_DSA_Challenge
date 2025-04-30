package extras;

public class DigitalAnalyzer {

    public static void main(String[] args) {
        int limit = 1000;

        for (int i = 1; i <= limit; i++) {
            int root = digitalRoot(i);
            int persistence = multiplicativePersistence(i);

            if (persistence >= 3 || root == 9) {
                System.out.printf("Number: %d -> Root: %d, Persistence: %d%n", i, root, persistence);
            }
        }
    }

    // Сумма цифр до одной цифры
    public static int digitalRoot(int n) {
        while (n >= 10) {
            n = digitSum(n);
        }
        return n;
    }

    public static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    // Перемножение цифр до одной цифры + количество шагов
    public static int multiplicativePersistence(int n) {
        int steps = 0;
        while (n >= 10) {
            n = digitProduct(n);
            steps++;
        }
        return steps;
    }

    public static int digitProduct(int n) {
        int product = 1;
        while (n > 0) {
            product *= n % 10;
            n /= 10;
        }
        return product;
    }
}