package com.edward.collections;

import java.util.*;

public class MapTest {

    public static void main(String[] args) {
        Map<Long, Student> map = new HashMap<Long, Student>();

        Map<Long, Student> studentMap = Collections.synchronizedMap(new HashMap<Long,Student>());

        List<Student> list = new ArrayList<>(studentMap.values());

        System.out.println(list.toString());

    }

}
