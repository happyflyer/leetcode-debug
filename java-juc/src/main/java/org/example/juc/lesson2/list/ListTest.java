package org.example.juc.lesson2.list;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author lifei
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + " :: " + list);
            }, String.valueOf(i + 1)).start();
        }
    }
}
