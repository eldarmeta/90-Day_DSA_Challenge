package extras;

import java.util.Random;

public class AvalancheEffect {

    public static void main(String[] args) {
        int input1 = 123456;
        int input2 = 123457; // Маленькое изменение

        int hash1 = simpleHash(input1);
        int hash2 = simpleHash(input2);

        System.out.println("Input1 Hash: " + hash1);
        System.out.println("Input2 Hash: " + hash2);
    }

    public static int simpleHash(int input) {
        Random random = new Random(input);
        return random.nextInt();
    }
}
