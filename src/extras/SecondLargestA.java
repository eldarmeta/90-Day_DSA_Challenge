public class SecondLargestA {
    public static void main(String[] args) {

        int[] array = {10, 5, 20, 8, 17};  // Пример массива

        if (array.length < 2) {
            System.out.println("Недостаточно элементов");
            return;
        }

        int largest = Integer.MIN_VALUE;       // Самое большое
        int secondLargest = Integer.MIN_VALUE; // Второе по величине

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;       // Старое самое большое становится вторым
                largest = num;                 // Новое самое большое найдено
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;           // Обновляем второе
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("Нет второго уникального наибольшего числа");
        } else {
            System.out.println("Второе наибольшее: " + secondLargest);
        }}}
