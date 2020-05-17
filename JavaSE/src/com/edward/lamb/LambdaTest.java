package com.edward.lamb;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        test1();
        streamTest1();
        streamTest2();
        parallelStreamTest();
    }

    /**
     * 根据weight重量进行排序
     */
    public static void test1() {
        List<Apple> inventory = new ArrayList<Apple>();
        Apple a1 = new Apple(1.23, "black");
        Apple a2 = new Apple(1.50, "black");
        Apple a3 = new Apple(1.38, "white");
        inventory.add(a1);
        inventory.add(a2);
        inventory.add(a3);
        ///inventory.sort(Comparator.comparing(Apple::getWeight));
        //inventory.stream().filter((Apple apple) -> apple.getWeight() > 1.5).collect(Collectors.toList());
        inventory.forEach(e -> System.out.println(e.toString()));
        //inventory.stream().sorted().forEach(System.out::println);
        inventory.stream().sorted((x, y) -> {
            if (x.getColor().equals(y.getColor())) {
                return x.getWeight().compareTo(y.getWeight());
            } else {
                return y.getWeight().compareTo(x.getWeight());
            }
        }).forEach(e -> System.out.println(e.toString() + "--------------"));

        Collections.sort(inventory,(e1,e2)->{
            if (e1.getColor().equals(e2.getColor())) {
                return e1.getWeight().compareTo(e2.getWeight());
            }else{
                return e1.getWeight().compareTo(e2.getWeight());
            }
        });
        inventory.forEach(e-> System.out.println(e.toString()));
    }

    public static void streamTest1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream().forEach(num -> System.out.println(num));
    }

    /**
     * stream的强大之处在于其原型链的设计使得它可以对遍历处理后的数据进行再处理。
     */
    public static void streamTest2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> strs = numbers.stream().map(num -> Integer.toString(++num)).collect(Collectors.toList());
        strs.stream().forEach(e -> System.out.println(e));
    }
    /**
     * 并行流parallelStream
     */
    public static void parallelStreamTest(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.parallelStream().forEach(num-> System.out.println(Thread.currentThread().getName()+">>"+num));
    }


}
