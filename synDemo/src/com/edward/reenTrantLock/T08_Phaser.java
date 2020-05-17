package com.edward.reenTrantLock;

import sun.security.timestamp.TSRequest;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class T08_Phaser {
    static Random r = new Random();
    static MarriagePhaser phaser = new MarriagePhaser();
    Phaser pha1 = new Phaser(7);
    static void milliSleep(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        phaser.bulkRegister(7);//7个客人
        Thread [] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] =  new Thread(new Person("p"+i));
        }
        for(Thread t :threads){
            t.start();
        }
        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();

    }


    static class MarriagePhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase){
                case 0:
                    System.out.println("所有人到齐了！" + registeredParties);
                    System.out.println();
                    return false;
                case 1:
                    System.out.println("所有人吃完了！" + registeredParties);
                    System.out.println();
                    return false;
                case 2:
                    System.out.println("所有人离开了！" + registeredParties);
                    System.out.println();
                    return false;
                case 3:
                    System.out.println("婚礼结束！新郎新娘抱抱！" + registeredParties);
                    System.out.println();
                    return true;
                default:
                    return true;
            }
        }
    }
    static class Person implements Runnable{
        String name;
        public Person(String name){this.name=name;}

        public void arrive(){
            milliSleep(r.nextInt(1000));
            System.out.printf("%s到达现场！\n",name);
            phaser.arriveAndAwaitAdvance();
        }
        public void eat(){
            milliSleep(r.nextInt(1000));
            System.out.printf("%s吃完！\n",name);
            phaser.arriveAndAwaitAdvance();
        }
        public void leave(){
            milliSleep(r.nextInt(1000));
            System.out.printf("%s离开！\n",name);
            phaser.arriveAndAwaitAdvance();
        }
        public void hug(){
            if("新郎".equals(name)||"新娘".equals(name)){
                milliSleep(r.nextInt(1000));
                System.out.printf("%s洞房！\n",name);
                phaser.arriveAndAwaitAdvance();
            }else{
                phaser.arriveAndDeregister();//不满足条件的人员退出
                //phaser.register();  加一个人的方法
            }
        }

        @Override
        public void run() {
            arrive();
            eat();
            leave();
            hug();
        }
    }
}

