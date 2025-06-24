import java.util.Random;
import java.util.Scanner;

public class DiceDuel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int player1Score = 0;
        int player2Score = 0;
        int rounds = 5;

        System.out.println("🎲 Welcome to Dice Duel!");
        System.out.print("Enter Player 1 name: ");
        String player1 = scanner.nextLine();
        System.out.print("Enter Player 2 name (or type 'CPU' to play against computer): ");
        String player2 = scanner.nextLine();

        System.out.println("\nLet the duel begin! 🥊 Best of " + rounds + " rounds.\n");

        for (int round = 1; round <= rounds; round++) {
            System.out.println("🎯 ROUND " + round + " 🎯");

            int p1Roll1 = rand.nextInt(6) + 1;
            int p1Roll2 = rand.nextInt(6) + 1;
            int p1Total = p1Roll1 + p1Roll2;

            int p2Roll1 = rand.nextInt(6) + 1;
            int p2Roll2 = rand.nextInt(6) + 1;
            int p2Total = p2Roll1 + p2Roll2;

            System.out.println(player1 + " rolls: 🎲 " + p1Roll1 + " + " + p1Roll2 + " = " + p1Total);
            System.out.println(player2 + " rolls: 🎲 " + p2Roll1 + " + " + p2Roll2 + " = " + p2Total);

            if (p1Total > p2Total) {
                System.out.println("✅ " + player1 + " wins this round!\n");
                player1Score++;
            } else if (p2Total > p1Total) {
                System.out.println("✅ " + player2 + " wins this round!\n");
                player2Score++;
            } else {
                System.out.println("🤝 Draw! No points awarded.\n");
            }
        }

        System.out.println("🏁 FINAL SCORE:");
        System.out.println(player1 + ": " + player1Score);
        System.out.println(player2 + ": " + player2Score);

        if (player1Score > player2Score) {
            System.out.println("🎉 " + player1 + " wins the duel!");
        } else if (player2Score > player1Score) {
            System.out.println("🎉 " + player2 + " wins the duel!");
        } else {
            System.out.println("🔁 It's a tie! Duel again?");
        }

        scanner.close();
    }
}
