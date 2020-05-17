package com.edward.iterface;

public class Mobile implements USB,Mp3 {
    @Override
    public void read() {
        System.out.println("from mobile read...");

    }
    @Override
    public void write() {
        System.out.println("to mobile write....");
    }
    @Override
    public void playMp3() {
        System.out.println("play Mp3 ...");
    }
}
