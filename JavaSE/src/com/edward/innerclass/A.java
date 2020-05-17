package com.edward.innerclass;

public class A {
    public int waibu = 12;
    public void say1() {
        System.out.println("这个外部类的方法"+waibu);
        System.out.println(new B().neibu);
    }
    class B{
        private int neibu = 13;
        public void say2(){
            System.out.println("这是外部类的方法");
            System.out.println("使用外部类和内部类的属性相加的结果是"+(waibu+neibu));
        }
    }
}
