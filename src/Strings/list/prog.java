package Strings.list;

public class prog {
    public static int numbers(int a, int n, int d) {

        return a = a + (n - 1) * d;

    }

    //public static void main(String[] args) {
       // System.out.println(numbers(5, 17, 3));
    //}

    //5 8 11 14 17
//aₙ = a + (n-1)d
    public static double numbers2(int a, int r, int n) {

        return a * Math.pow(r, n - 1);

    }
    public static void main(String[] args) {
        System.out.println(numbers2(1, 2, 4));
    }
}
    //aₙ = a * r^(n-1)