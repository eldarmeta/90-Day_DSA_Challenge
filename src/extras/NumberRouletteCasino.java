package extras;

import java.util.*;

public class NumberRouletteCasino {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secret = random.nextInt(100) + 1;  // Загаданное число [1–100]
        int balance = 100;                     // Начальный баланс
        int bet;
        int attempts = 0;

        System.out.println("🎰 WELCOME TO NUMBER ROULETTE!");
        System.out.println("Try to guess the secret number between 1 and 100.");
        System.out.println("💵 You start with $" + balance + ". Each wrong guess costs $5.");
        System.out.println("🔍 Type 'hint' for a clue ($10), or 'exit' to quit.\n");

        while (balance > 0) {
            System.out.print("Enter your guess (or 'hint'/'exit'): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("👋 Leaving the casino with $" + balance + ".");
                break;
            }

            if (input.equalsIgnoreCase("hint")) {
                if (balance >= 10) {
                    balance -= 10;
                    if (secret % 2 == 0) {
                        System.out.println("🧠 Hint: The number is EVEN.");
                    } else {
                        System.out.println("🧠 Hint: The number is ODD.");
                    }
                } else {
                    System.out.println("❌ Not enough money for a hint.");
                }
                continue;
            }

            try {
                bet = Integer.parseInt(input);
                attempts++;

                if (bet == secret) {
                    int win = 50 + (100 - attempts);
                    balance += win;
                    System.out.println("🎉 JACKPOT! You guessed it in " + attempts + " tries!");
                    System.out.println("💰 You won $" + win + ". Final balance: $" + balance);
                    break;
                } else {
                    balance -= 5;
                    if (bet < secret) {
                        System.out.println("📉 Too low!");
                    } else {
                        System.out.println("📈 Too high!");
                    }
                    System.out.println("💵 Balance: $" + balance);
                }

            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Try again.");
            }

            if (balance <= 0) {
                System.out.println("💀 You're out of cash! Game over.");
            }
        }

        scanner.close();
    }
}
