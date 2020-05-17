package com.edward.collections;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 5848318636153518278L;
    private String name;
    private Integer sid;


    public Student(String name, Integer sid) {
        this.name = name;
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sid=" + sid +
                '}';
    }
}
