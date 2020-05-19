package com.edward.thread;

public class TicketThread extends Thread {
    private static int ticket = 5;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出售第" + (ticket--) + "张票");
            }
        }
    }

    public static void main(String[] args) {
        TicketThread ticketThread1 = new TicketThread();
        TicketThread ticketThread2 = new TicketThread();
        TicketThread ticketThread3 = new TicketThread();
        TicketThread ticketThread4 = new TicketThread();
        ticketThread1.start();
        ticketThread2.start();
        ticketThread3.start();
        ticketThread4.start();
    }
}
