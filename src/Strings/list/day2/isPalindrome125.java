package Strings.list.day2;

public class isPalindrome125 {
    public static boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r++;

            char cl = Character.toLowerCase(s.charAt(l));
            char cr = Character.toLowerCase(s.charAt(r));

            if (cl != cr) return false;

            l++; r--;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] test = {
                "A man, a  plan, a canal: Panama",
                "race a car"
        };
        for (String t : test) {
            System.out.printf("\"%s\" -> %b%n", t, isPalindrome(t));
        }
    }
        }
