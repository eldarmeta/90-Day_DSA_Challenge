
import java.util.*;

// LeetCode 290: Word Pattern
public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> mapCharToWord = new HashMap<>();
        Map<String, Character> mapWordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if ((mapCharToWord.containsKey(c) && !mapCharToWord.get(c).equals(w)) ||
                    (mapWordToChar.containsKey(w) && mapWordToChar.get(w) != c)) {
                return false;
            }

            mapCharToWord.put(c, w);
            mapWordToChar.put(w, c);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog")); // true
        System.out.println(wordPattern("abba", "dog cat cat fish")); // false
    }
}
