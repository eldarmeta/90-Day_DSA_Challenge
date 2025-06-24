import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--){
            reversed = reversed + input.charAt(i);
        }
if (input.equals(reversed)){
    System.out.println("Palindrome");
}else {
    System.out.println("Not palindrome");
}
    }

}

// Удалим пробелы и приведём к нижнему регистру
//input = input.replaceAll("\\s+", "").toLowerCase();