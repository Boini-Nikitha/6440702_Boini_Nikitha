import java.util.concurrent.*;
import java.util.*;

public class CallableDemo {
public static void main(String[] args) throws Exception {
int numTasks = 5;
    ExecutorService executor = Executors.newFixedThreadPool(3);
    List<Future<Integer>> futures = new ArrayList<>();

    for (int i = 1; i <= numTasks; i++) {
        int taskNum = i;
        Callable<Integer> task = () -> {
            System.out.println("Task " + taskNum + " running on thread " + Thread.currentThread().getName());
            Thread.sleep(1000);  // Simulate work
            return taskNum * taskNum;
        };
        futures.add(executor.submit(task));
    }

    for (Future<Integer> future : futures) {
        System.out.println("Result: " + future.get());
    }

    executor.shutdown();
}
}