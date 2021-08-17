package org.example.reflect.singleton;

/**
 * @author lifei
 */
public class Person2 {
    private static Person2 person;

    private Person2() {
        System.out.println(Thread.currentThread().getName() + " 执行了构造方法");
    }

    public static Person2 getPerson() {
        if (person == null) {
            person = new Person2();
        }
        return person;
    }

    @Override
    public String toString() {
        return "Person2{}@" + hashCode();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Person2.getPerson());
            }, "thread-" + i).start();
        }
    }
}
