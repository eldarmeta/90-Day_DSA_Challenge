import java.util.*;                     // импорт сканера, списков и массивов


public class IntersectionOf2Arrays {    // 👈 имя класса совпадает с именем файла
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // создаём сканер

        // Ввод первой строки чисел → int[]
        int[] nums1 = Arrays.stream(sc.nextLine().split(" ")) // "1 2 2 1" → ["1","2","2","1"]
                .mapToInt(Integer::parseInt)                  // каждый элемент превращаем в int
                .toArray();                                   // собираем в массив

        // Ввод второй строки чисел → int[]
        int[] nums2 = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Вызываем метод пересечения массивов
        int[] result = intersect(nums1, nums2);

        // Печатаем результат
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // Метод пересечения без коллекций: только массивы + булевый флаг
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] temp = new int[Math.min(nums1.length, nums2.length)]; // временный массив под результат
        boolean[] used = new boolean[nums2.length];                 // отслеживаем, что из nums2 уже использовано
        int index = 0;

        // Внешний цикл по nums1
        for (int i = 0; i < nums1.length; i++) {
            // Внутренний цикл по nums2
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j] && !used[j]) {
                    temp[index++] = nums1[i];  // записываем результат
                    used[j] = true;            // помечаем элемент как использованный
                    break;                     // выходим, чтобы не добавить дубликат
                }
            }
        }

        return Arrays.copyOf(temp, index);     // обрезаем массив до нужной длины
    }
}
