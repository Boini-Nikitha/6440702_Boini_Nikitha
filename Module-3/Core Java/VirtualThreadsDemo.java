import java.time.Duration;
import java.time.Instant;

public class VirtualThreadsDemo {
public static void main(String[] args) throws InterruptedException {
int count = 100_000;
    Instant start = Instant.now();

    Thread[] threads = new Thread[count];

    for (int i = 0; i < count; i++) {
        threads[i] = Thread.startVirtualThread(() ->
            System.out.println("Hello from virtual thread: " + Thread.currentThread().threadId()));
    }

    for (Thread t : threads) {
        t.join();  // Wait for all threads to complete
    }

    Instant end = Instant.now();
    System.out.println("Completed in: " + Duration.between(start, end).toMillis() + " ms");
}
}