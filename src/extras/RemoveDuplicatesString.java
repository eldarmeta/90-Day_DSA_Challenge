import java.util.Scanner;

public class RemoveDuplicatesString {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String result = "";

        for(int i = 0; i < input.length(); i++){
            if(!result.contains(String.valueOf(input.charAt(i)))){
                result = result + input.charAt(i);
            }
        }
        System.out.println(result);
    }
}
