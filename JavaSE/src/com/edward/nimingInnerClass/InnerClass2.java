package com.edward.nimingInnerClass;

public class InnerClass2 {
    public static void main(String[] args) {
        System.out.println("下面是内部类的程序展示");
        //创建外部类和内部类的方法有点不同
        A2 a = new A2();
        A2.B b = a.new B();
        a.say2();
        b.sayit();

        Chouxiang2 chouxiang2 = new Chouxiang2() {
            String name = "Geek Song too";
            public void say3() {
                System.out.println("这是匿名内部类当中的方法，重写了抽象类的方法");
                System.out.println(name);
            }
        };

        chouxiang2.say3();
        System.out.println("我们来看看这个name到底是抽象类当中的name还是匿名内部类当中的" + chouxiang2.name);

        JieKou jieKou = new JieKou() {
            @Override
            public void say5() {
                System.out.println("这是继承重写了接口当中的方法");
            }
        };
        jieKou.say5();
    }
}
