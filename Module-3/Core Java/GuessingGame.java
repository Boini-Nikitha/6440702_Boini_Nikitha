import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int target = rand.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int guess;

        do {
            System.out.print("Guess a number between 1 and 100: ");
            guess = scanner.nextInt();
            if (guess > target) System.out.println("Too high!");
            else if (guess < target) System.out.println("Too low!");
        } while (guess != target);

        System.out.println("Correct! The number was " + target);
    }
}
