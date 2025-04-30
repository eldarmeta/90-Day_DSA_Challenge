package extras;

import java.util.Scanner;
import java.util.HashMap;

public class CharFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        input = input.toLowerCase();

        HashMap<Character, Integer> charFreq = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (!Character.isLetter(ch)) {
                continue;
            }

            if (charFreq.containsKey(ch)) {
                charFreq.put(ch, charFreq.get(ch) + 1);
            } else {
                charFreq.put(ch, 1);
            }
        }

        System.out.println("\nЧастота символов:");
        System.out.println("+---------+---------+");
        System.out.println("| Символ  | Кол-во  |");
        System.out.println("+---------+---------+");

        for (Character key : charFreq.keySet()) {
            System.out.printf("|    %c    |    %d    |\n", key, charFreq.get(key));
        }

        System.out.println("+---------+---------+");

        scanner.close();
    }
}

/*
Полезные детали:
charFreq.containsKey(ch) — проверяет, существует ли символ.

charFreq.put(ch, ...) — либо создаёт новый ключ, либо обновляет.

Character.isLetter(ch) — позволяет оставить только буквы (пробелы, цифры, знаки — отфильтруются).
 */