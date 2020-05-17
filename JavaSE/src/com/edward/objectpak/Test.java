package com.edward.objectpak;

import com.sun.imageio.stream.StreamFinalizer;

import java.util.Objects;

public class Test {
    /**
     * Object
     * 1.1是Java中所有类的父类
     * 1.2常用方法
     * public boolean equals(Object obj)
     * protected void finalize throws Throwable
     * public final Class getClass
     * public int hashCode
     * public String toString
     */

    public static void main(String[] args) {
        Object obj = new Object();
        Person person = new Person(1, "tom");
        String str = person.toString();
        System.out.println(str);

        Person person1 = new Person(1, "tom");
        System.out.println(person == person1);
        boolean r = person.equals(person1);//自定义的类没有重写equals方法，默认的equals方法仍是==的比较
        System.out.println(r);

        Class cla = person.getClass();

        person = null;
        person1 = null;
        System.gc();

    }
}

class Person {
    //私有的属性
    //公共的方法
    private int pid;
    private String name;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        if (pid < 0) {
            this.pid = 0;
        }
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int pid, String name) {
        super();
        this.pid = pid;
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        Person person = (Person) o;
        return (this.pid == person.pid)&&this.name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pid, name);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize ...");
    }
}
