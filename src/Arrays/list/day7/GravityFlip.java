package Arrays.list.day7;

import java.util.*;

public class GravityFlip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();         // Кол-во башен
        int[] arr = new int[n];       // Массив башен

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();    // Чтение входа
        }

        Arrays.sort(arr);             // Сортировка башен

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");  // Вывод результата
        }
    }
}
