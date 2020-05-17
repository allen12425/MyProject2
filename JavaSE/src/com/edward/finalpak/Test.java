package com.edward.finalpak;

public class Test {
    /**
     * final的用法
     * 1.1在类前面，阻止继承
     * 1.2在方法前面，阻止方法覆盖
     * 1.3在属性前面，是常量
     */
    public static void main(String[] args) {

    }

    final class FinalClass{

    }

   /* class SubClass extends FinalClass{//final修饰的类不能被继承

    }*/

     class A{
        final void m(){
        }
        private final double PI = 3.14;
        void test(){
          //  PI = 3.1415926;//final修饰的变量不能被修改
        }
    }

    class A1 extends A{
     /*   void m(){//final修饰的方法不能被覆盖

        }*/
    }





}
