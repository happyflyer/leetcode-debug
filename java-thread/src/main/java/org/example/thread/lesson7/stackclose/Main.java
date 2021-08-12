package org.example.thread.lesson7.stackclose;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lifei
 */
public class Main {
    public static void main(String[] args) {
        Example example = new Example();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> example.add100());
        executorService.execute(() -> example.add100());
        executorService.shutdown();
    }
}
