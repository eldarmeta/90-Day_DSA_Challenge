
import java.util.HashMap;
import java.util.Map;

// LeetCode 205: Isomorphic Strings
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if ((mapST.containsKey(cs) && mapST.get(cs) != ct) ||
                    (mapTS.containsKey(ct) && mapTS.get(ct) != cs)) {
                return false;
            }

            mapST.put(cs, ct);
            mapTS.put(ct, cs);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add")); // true
        System.out.println(isIsomorphic("foo", "bar")); // false
    }
}
