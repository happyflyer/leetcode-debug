package org.example.lang.singleton;

/**
 * @author lifei
 */
public class Person3 {
    private static volatile Person3 person;

    private Person3() {
        System.out.println(Thread.currentThread().getName() + " 执行了构造方法");
    }

    public static Person3 getPerson() {
        if (person == null) {
            synchronized (Person3.class) {
                if (person == null) {
                    person = new Person3();
                }
            }
        }
        return person;
    }

    @Override
    public String toString() {
        return "Person3{}@" + hashCode();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Person3.getPerson());
            }, "thread-" + i).start();
        }
    }
}
