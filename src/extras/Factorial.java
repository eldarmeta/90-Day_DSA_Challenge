package extras;

public class Factorial {
    public static void main(String[] args) {

        int num = 5;       // Число, для которого считаем факториал
        int fact = 1;      // Начинаем с 1 (потому что 0 умножит всё в 0)

        // Идём от 1 до num и умножаем fact на i
        for(int i = 1; i <= num; i++) {
            fact *= i;     // fact = fact * i
        }

        // Выводим результат
        System.out.println("Factorial: " + fact);
    }
}
