package com.edward.single;

public class Singleton2 {

    private static Singleton2 instance = new Singleton2();
    private static Singleton2 getInstance() {
        return instance;
    }
}

class Singleton3 {
    private static Singleton3 instance = null;
    private static Singleton3 getInstance(){
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }

}
