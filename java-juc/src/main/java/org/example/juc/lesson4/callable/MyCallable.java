package org.example.juc.lesson4.callable;

import java.util.concurrent.Callable;

/**
 * @author lifei
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " call");
        Thread.sleep(3000);
        return 1;
    }
}
