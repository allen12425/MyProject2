package com.edward.nimingInnerClass;

public class A2 {
    int waibu = 12;
    public void say2(){
        System.out.println("这是外部类当中的方法");
    }

    class B{
        int neibu = 13;

        public void sayit() {
            System.out.println("这是内部类里面的方法");
            System.out.println("使用内部类和外部类当中的数值相加的结果是" + (waibu + neibu));
        }
    }
}
