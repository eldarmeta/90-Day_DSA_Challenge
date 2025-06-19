import java.util.Scanner;

public class DivisibleByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();   // читаем большое число как строку
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';    // превращаем символ в цифру
        }

        if (sum % 3 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
