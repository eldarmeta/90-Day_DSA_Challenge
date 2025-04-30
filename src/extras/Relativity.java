package extras;

public class Relativity {
    public static void main(String[] args) {

        double v = 100000; // скорость объекта (м/с)
        double c = 300000000; // скорость света (м/с)

        double timeEarth = 60; // 10 секунд на Земле
        double timeTraveler = timeEarth * Math.sqrt(1 - (v * v) / (c * c));

        System.out.printf("На Земле прошло: %.2f сек\n", timeEarth);
        System.out.printf("Для путешественника прошло: %.8f сек\n", timeTraveler);
    }
}

