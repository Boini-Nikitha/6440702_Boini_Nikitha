import java.util.HashMap;
import java.util.Scanner;

public class StudentMap {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            studentMap.put(id, name);
        }

        System.out.print("Enter ID to search: ");
        int searchId = scanner.nextInt();
        String result = studentMap.get(searchId);
        if (result != null)
            System.out.println("Name: " + result);
        else
            System.out.println("ID not found.");
    }
}
