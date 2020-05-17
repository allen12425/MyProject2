package com.edward.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
        //test7();
        test8();
    }

    static void test1() {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            System.out.println(clazz.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void test2() {
        try {
            Class<?> clazz = Student.class;
            System.out.println(clazz.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void test3() {
        try {
            Student stu = new Student();
            Class<?> clazz = stu.getClass();
            System.out.println(clazz.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取所有的方法
    static void test4() {
        try {
            Class<?> clazz = Student.class;
            System.out.println(clazz.getName());
            Method[] methods = clazz.getMethods();
            for (Method method:methods){
                System.out.println(method);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取构造方法
    static void test5() {
        try {
            Class<?> clazz = Student.class;
            System.out.println(clazz.getName());
            Constructor[] constructor = clazz.getConstructors();
            for (Constructor constructor1 :constructor){
                System.out.println(constructor1);
            }

            Constructor constructor1 =  clazz.getConstructor();
            System.out.println(constructor1);

            Constructor constructor2 =  clazz.getConstructor(int.class,String.class,int.class);
            System.out.println(constructor2+"====");
            Student student = (Student) constructor2.newInstance(1,"jim",23);
            System.out.println(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void test6(){
        try {
            Class<?> clazz = Student.class;
            System.out.println(clazz.getName());
            clazz.getSuperclass();//获取父类
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取当前类的所有方法和属性
    static void test7(){
        try {
            Class<?> clazz = Student.class;
            Method [] methods = clazz.getDeclaredMethods();
            Field [] fields = clazz.getDeclaredFields();
            Method method = clazz.getDeclaredMethod("getName");
            method.getName();

            Student student = (Student) clazz.newInstance();
            student.setAge(25);
            System.out.println(student.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void test8(){
        try {
            Class<?> clazz = Student.class;
            Student student = (Student) clazz.newInstance();
            Field field = clazz.getDeclaredField("age");
            field.setAccessible(true);
            field.set(student,24);
            System.out.println(student.getAge());

            Method method1 = clazz.getDeclaredMethod("getAge");
            System.out.println(method1.invoke(student)+"------------");
            Method method = clazz.getDeclaredMethod("setAge", int.class);
            Method method2 = clazz.getDeclaredMethod("setAge", new Class[]{int.class});
            method.invoke(student,28);
            System.out.println(student.getAge());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
