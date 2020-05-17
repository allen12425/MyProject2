package com.edward.exception;

public class MyException extends Exception {
    private String message;
    private Exception e;

    public MyException(String message,  Exception e) {
        super(e);
        this.message = message;
        this.e = e;
    }

    public MyException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Exception getE() {
        return e;
    }
}


class Person {
    int age ;

    public Person(int age) {
        this.age = age;
    }

    public void run () throws MyException{
        if(age > 80){
            throw new MyException("年龄大了跑不动");
        }
        System.out.println("运行正常");
    }
}
