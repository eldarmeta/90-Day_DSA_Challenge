import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataProcessor {

    public static void main(String[] args) {
        String filePath = "data.txt"; // Путь к файлу с данными

        try {
            List<Integer> data = readDataFromFile(filePath);
            if (data.isEmpty()) {
                System.out.println("Файл пуст или данные не найдены.");
                return;
            }

            Collections.sort(data);
            System.out.println("Отсортированные данные: " + data);

            double average = calculateAverage(data);
            System.out.println("Среднее значение: " + average);

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Чтение данных из файла
    private static List<Integer> readDataFromFile(String filePath) throws IOException {
        List<Integer> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    data.add(number);
                } catch (NumberFormatException e) {
                    System.err.println("Пропущена некорректная строка: " + line);
                }
            }
        }
        return data;
    }

    // Вычисление среднего значения
    private static double calculateAverage(List<Integer> data) {
        int sum = 0;
        for (int number : data) {
            sum += number;
        }
        return (double) sum / data.size();
    }
}
