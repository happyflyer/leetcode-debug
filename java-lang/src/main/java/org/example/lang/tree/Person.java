package org.example.lang.tree;

/**
 * @author lifei
 */
public class Person implements Comparable<Person> {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        // return "Person{" +
        //         "name='" + name + '\'' +
        //         ", age=" + age +
        //         '}';
        return String.valueOf(age);
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}
