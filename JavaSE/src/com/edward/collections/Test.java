package com.edward.collections;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Integer[] arrNum = new Integer[]{2, 5, 6, 8, 1, 9, 7, 3, 4};
        List list = Arrays.asList(arrNum);
        //排序
        Collections.sort(list);
        System.out.println(list);

        //随机排列
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        int index = Collections.binarySearch(list, 2);
        System.out.println(index);
        int a = (int) Collections.max(list);
        int b = (int) Collections.min(list);
        System.out.println(a);
        System.out.println(b);
        Integer x = 1;
        int c = x.intValue();
        Object obj =2;
        int d = (int) obj;
        Collections.reverse(list);
        Collections.swap(list,1,3);
        System.out.println(list);

        mapTest();
        mapTest2();
    }

    static void mapTest(){
        Map map = new HashMap();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        System.out.println(map);
    }

    static void mapTest2(){
        List<Student> list = Arrays.asList(new Student("allen", 1), new Student("tom", 2));
        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Student::getSid, Student::getName));
        for (Map.Entry<Integer,String> m :map.entrySet()){
            System.out.println(m.getKey()+","+m.getValue());
        }
        map.keySet().forEach(key -> System.out.println("map.get(" + key + ") = " + map.get(key)));

        map.entrySet().forEach(entry -> System.out.println("key:value = " + entry.getKey() + ":" + entry.getValue()));
        //java8独有的写法
        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
    }
}
