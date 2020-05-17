package com.edward.sync;

public class Singleton {
    private static Singleton instance;

    private Singleton() {

    }


    /**
     * memory = allocate();　　// 1.分配对象的内存空间
     * ctorInstance(memory);　　// 2.初始化对象
     * sInstance = memory;　　// 3.设置sInstance指向刚分配的内存地址
     *
     * 上述伪代码中的2和3之间可能会发生重排序，重排序后的执行顺序如下
     *
     * memory = allocate();　　// 1.分配对象的内存空间
     * sInstance = memory;　　// 2.设置sInstance指向刚分配的内存地址，此时对象还没有被初始化
     * ctorInstance(memory);　　// 3.初始化对象
     *
     * 假设相乘A可能会先执行3再执行2，当执行3的时候线程B如果占用线程A就会认为instance非空，然后返回一个未初始化的对象
     * 然后线程再去执行步骤2执行构造函数并将引用返回给它，来完成对象的初始化
     * @return
     */
    public static Singleton getInstance() {
        if(instance == null){
            synchronized (Singleton.class){
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

}
