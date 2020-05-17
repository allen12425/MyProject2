package com.edward.iterface;

import java.io.Serializable;

public class Test implements Serializable {
    public static void main(String[] args) {
        //多个类可以实现同一个接口
        Computer computer = new Computer();
        computer.read();
        computer.write();

        Mobile m = new Mobile();
        m.read();
        m.write();
        m.playMp3();
        USB u = new Computer();
        u.read();
        u.write();
        USB u2 = new Mobile();
        u2.write();
        u2.read();
    }
}

