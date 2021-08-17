package org.example.reflect.singleton;

/**
 * @author lifei
 */
public class Person1 {
    private static final Person1 person = new Person1();

    private Person1() {
        System.out.println(Thread.currentThread().getName() + " 执行了构造方法");
    }

    public static Person1 getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Person1{}@" + hashCode();
    }

    public static void main(String[] args) {
        System.out.println(Person1.getPerson());
        System.out.println(Person1.getPerson());
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println(Person1.getPerson());
            }, "thread-" + i).start();
        }
    }
}
