package com.edward.iterface;

public class Computer implements USB {
    @Override
    public void read() {
        System.out.println("from computer read ...");
    }

    @Override
    public void write() {
        System.out.println("to computer write ....");
    }
}
