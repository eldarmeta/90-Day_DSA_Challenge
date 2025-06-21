import java.util.*;

public class ChineseRemainderExplorer {

    public static void main(String[] args) {
        int limit = 1000;
        int[] mods = {3, 5, 7};
        int[] remainders = {2, 3, 2}; // x ≡ 2 mod 3, x ≡ 3 mod 5, x ≡ 2 mod 7

        System.out.println("Solutions to system:");
        for (int i = 0; i < mods.length; i++) {
            System.out.printf("x ≡ %d mod %d\n", remainders[i], mods[i]);
        }

        for (int x = 1; x <= limit; x++) {
            if (matchesModSystem(x, mods, remainders)) {
                System.out.println("✅ x = " + x);
            }
        }
    }

    public static boolean matchesModSystem(int x, int[] mods, int[] remainders) {
        for (int i = 0; i < mods.length; i++) {
            if (x % mods[i] != remainders[i]) return false;
        }
        return true;
    }
}