package org.example.thread.lesson7.stackclose;

/**
 * @author lifei
 */
public class Example {
    public void add100() {
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            cnt++;
        }
        System.out.println(cnt);
    }
}
