package com.edward.collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        test1();
        Set<Person> set = new HashSet<Person>();
        Person person = new Person(1, "tom", 20);
        Person person2 = new Person(1, "tom", 20);
        System.out.println(Objects.equals(person,person2));
        System.out.println(person.hashCode() == person2.hashCode());
        set.add(person);
        set.add(person2);

        System.out.println(set);
    }

    public static void test1(){
        HashSet<String> hs = new HashSet<String>();
        hs.add("A");
        hs.add("B");
        hs.add("C");
        System.out.println(hs);
    }
}

class Person {
    private int pid;
    private String name;
    private int age;

    public Person(int pid, String name, int age) {
        this.pid = pid;
        this.name = name;
        this.age = age;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return pid == person.pid &&
                age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, name, age);
    }*/

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
