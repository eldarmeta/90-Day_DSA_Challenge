
import java.util.*;

/**
 * LeetCode 30. Substring with Concatenation of All Words
 *
 * Sliding window by word-length steps.
 * Time: O(n), where n = s.length() (each index is visited at most once per offset).
 * Space: O(k), where k = number of distinct words.
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return res;

        int wordLen = words[0].length();
        if (wordLen == 0) return res; // undefined case

        int wordCount = words.length;
        int windowLen = wordLen * wordCount;
        if (s.length() < windowLen) return res;

        // Build required frequency map
        Map<String, Integer> need = new HashMap<>();
        for (String w : words) need.merge(w, 1, Integer::sum);

        // We will start windows at each possible offset modulo wordLen
        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, right = offset;
            Map<String, Integer> have = new HashMap<>();
            int matched = 0; // number of words matched (count of tokens in current window)

            while (right + wordLen <= s.length()) {
                String token = s.substring(right, right + wordLen);
                right += wordLen;

                if (need.containsKey(token)) {
                    have.merge(token, 1, Integer::sum);
                    int h = have.get(token);
                    int n = need.get(token);

                    if (h <= n) {
                        matched++; // good token within required bound
                    } else {
                        // too many of this token -> shrink from left until valid
                        while (h > n) {
                            String drop = s.substring(left, left + wordLen);
                            left += wordLen;
                            int hd = have.merge(drop, -1, Integer::sum);
                            if (hd == 0) have.remove(drop);
                            if (need.containsKey(drop) && hd < need.get(drop)) {
                                matched--; // we dropped a needed token
                            }
                            h = have.getOrDefault(token, 0);
                        }
                    }

                    // if we matched exactly wordCount tokens, record answer and shrink by one token
                    if (matched == wordCount) {
                        res.add(left);
                        // pop one token from left to continue searching
                        String drop = s.substring(left, left + wordLen);
                        left += wordLen;
                        int hd = have.merge(drop, -1, Integer::sum);
                        if (hd == 0) have.remove(drop);
                        if (need.containsKey(drop) && hd < need.get(drop)) {
                            matched--;
                        }
                    }
                } else {
                    // token not in need -> reset window
                    have.clear();
                    matched = 0;
                    left = right;
                }
            }
        }
        return res;
    }
}
