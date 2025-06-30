import java.util.Random;

public class BlackSwan {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 1; i <= 100; i++) {
            int event = rand.nextInt(100);
            if (event == 77) { // супер редкое событие
                System.out.println("Черный лебедь произошёл на шаге: " + i);
                break;
            }
            System.out.println("Обычный день: " + i);
        }
    }
}
