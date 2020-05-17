package com.edward.volatile_pak;

public class Test {
private static volatile Test instance ;

    private Test() { }

    public static Test getInstance(){
        if (instance == null) {
            synchronized (Test.class){
                if (instance == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Test();
                }
            }
        }
        return instance;
    }
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Test.getInstance().hashCode());
            }).start();
        }
    }
}
