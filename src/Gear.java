import java.util.Scanner;

public class Gear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int gcd = findGCD(n, k);
        long lcm = (1L * n * k) / gcd; // long — чтобы не было переполнения

        System.out.println(lcm);
        scanner.close();
    }

    // Алгоритм Евклида
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
