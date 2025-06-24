import java.util.*;

public class Blackjack {
    static Random rand = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("🂡 Welcome to Java Blackjack!");

        List<String> deck = createDeck();
        Collections.shuffle(deck);

        List<String> playerHand = new ArrayList<>();
        List<String> dealerHand = new ArrayList<>();

        // Первая раздача
        playerHand.add(drawCard(deck));
        playerHand.add(drawCard(deck));
        dealerHand.add(drawCard(deck));
        dealerHand.add(drawCard(deck));

        boolean playerTurn = true;
        while (playerTurn) {
            System.out.println("\nYour hand: " + playerHand + " → " + handValue(playerHand));
            System.out.println("Dealer shows: " + dealerHand.get(0) + " [?]");
            System.out.print("Hit or Stand? (h/s): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("h")) {
                playerHand.add(drawCard(deck));
                if (handValue(playerHand) > 21) {
                    System.out.println("💥 You busted! Final hand: " + playerHand + " → " + handValue(playerHand));
                    return;
                }
            } else if (choice.equalsIgnoreCase("s")) {
                playerTurn = false;
            } else {
                System.out.println("Invalid input.");
            }
        }

        // Ход дилера
        System.out.println("\nDealer's hand: " + dealerHand + " → " + handValue(dealerHand));
        while (handValue(dealerHand) < 17) {
            dealerHand.add(drawCard(deck));
            System.out.println("Dealer hits: " + dealerHand + " → " + handValue(dealerHand));
        }

        int playerScore = handValue(playerHand);
        int dealerScore = handValue(dealerHand);

        System.out.println("\nFinal hands:");
        System.out.println("You:    " + playerHand + " → " + playerScore);
        System.out.println("Dealer: " + dealerHand + " → " + dealerScore);

        if (dealerScore > 21 || playerScore > dealerScore) {
            System.out.println("🎉 You win!");
        } else if (playerScore == dealerScore) {
            System.out.println("🤝 It's a draw!");
        } else {
            System.out.println("😢 Dealer wins!");
        }
    }

    static List<String> createDeck() {
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        List<String> deck = new ArrayList<>();
        for (String rank : ranks) {
            for (int i = 0; i < 4; i++) {  // 4 масти, но нам важен только номинал
                deck.add(rank);
            }
        }
        return deck;
    }

    static String drawCard(List<String> deck) {
        return deck.remove(0);
    }

    static int handValue(List<String> hand) {
        int sum = 0;
        int aceCount = 0;

        for (String card : hand) {
            if (card.equals("A")) {
                aceCount++;
                sum += 11;
            } else if (card.equals("K") || card.equals("Q") || card.equals("J")) {
                sum += 10;
            } else {
                sum += Integer.parseInt(card);
            }
        }

        // Если перебор из-за туза → считаем туз как 1
        while (sum > 21 && aceCount > 0) {
            sum -= 10;
            aceCount--;
        }

        return sum;
    }
}
