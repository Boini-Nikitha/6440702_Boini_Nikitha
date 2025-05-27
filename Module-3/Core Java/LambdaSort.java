import java.util.*;

public class LambdaSort {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Zara", "Alice", "Bob", "Charlie");

        Collections.sort(names, (a, b) -> a.compareTo(b));

        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
