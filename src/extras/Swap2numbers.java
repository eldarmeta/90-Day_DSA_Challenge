package extras;

public class Swap2numbers {
    public static void main(String[] args) {
        int a = 5; int b = 10;

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a + " " + b);
    }
}

/*
Что это показывает?
Умение работать с переменными без дополнительных ресурсов

Пример арифметического мышления

Это часто встречается на собеседованиях по Java или алгоритмам

Важно для обучения логике и оптимизации
 */