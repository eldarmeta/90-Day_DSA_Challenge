package extras;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeZonesExample {

    public static void main(String[] args) {

        // Получаем текущее время в системе
        ZonedDateTime currentTime = ZonedDateTime.now();

        // Формат времени для вывода
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        // Список временных зон, которые хотим показать
        String[] zones = {
                "America/New_York",
                "Europe/London",
                "Asia/Tokyo",
                "Asia/Bishkek",
                "America/Los_Angeles"
        };

        // Печатаем время в каждой временной зоне
        System.out.println("Текущее время в разных часовых поясах:\n");

        for (String zone : zones) {
            ZonedDateTime timeInZone = currentTime.withZoneSameInstant(ZoneId.of(zone));
            System.out.println(zone + ": " + timeInZone.format(formatter));
        }
    }
}
