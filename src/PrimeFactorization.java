import java.util.Scanner;

public class PrimeFactorization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();  // Число может быть до 10^9, поэтому long

        StringBuilder result = new StringBuilder();

        for (long i = 2; i * i <= n; i++) {
            int count = 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }
            if (count > 0) {
                if (result.length() > 0) result.append("*");
                result.append(i);
                if (count > 1) {
                    result.append("^").append(count);
                }
            }
        }

        // Если после цикла n > 1 — значит это простое число > sqrt(n)
        if (n > 1) {
            if (result.length() > 0) result.append("*");
            result.append(n);
        }

        System.out.println(result.toString());
        scanner.close();
    }
}
