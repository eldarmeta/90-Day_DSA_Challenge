package extras;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String reversed = "";

        for(int i = str.length() - 1; i >= 0; i--){
            reversed = reversed + str.charAt(i);


        }
        System.out.println("Reversed: " + reversed);
    }
}
// +++ можно еще освоить StringBuilder — это класс для эффективного построения строк.
// Он позволяет добавлять символы и строки без создания новых объектов.

//StringBuilder reversed = new StringBuilder(); // создаём пустой буфер
//reversed.append(str.charAt(i));               // добавляем символ в конец

// В конце: .toString() — преобразует StringBuilder обратно в обычную строку
//      System.out.println(reversed.toString());
