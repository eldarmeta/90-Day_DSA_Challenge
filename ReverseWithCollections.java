import java.util.*;

public class ReverseWithCollections {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("Before: " + list);
        Collections.reverse(list);
        System.out.println("After:  " + list);
    }
}
